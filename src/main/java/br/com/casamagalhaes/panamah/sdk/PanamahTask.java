package br.com.casamagalhaes.panamah.sdk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.TimerTask;

import br.com.casamagalhaes.panamah.sdk.model.PanamahCliente;
import br.com.casamagalhaes.panamah.sdk.model.PanamahFornecedor;
import br.com.casamagalhaes.panamah.sdk.model.PanamahLoja;
import br.com.casamagalhaes.panamah.sdk.nfe.NFe;
import br.com.casamagalhaes.panamah.sdk.nfe.NFeProc;

public class PanamahTask extends TimerTask {

	private PanamahConfig config;
	private PanamahLote loteAtual = new PanamahLote();
	private long ultimoEnvio = new Date().getTime();

	public PanamahTask(PanamahConfig config) throws FileNotFoundException, IOException {
		this.config = config;
		restauraLoteAtual();
	}

	@Override
	public void run() {
		try {
			verificaFechamento();
			verificaEnvio();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void verificaEnvio() throws IOException {
		if (new Date().getTime() > ultimoEnvio + config.getTtl()) {
			enviaLote();
		}
	}

	public void verificaFechamento() throws FileNotFoundException, IOException {
		if (loteAtual.isVelho(config)) {
			fechaLoteAtual();
			abreNovoLote();
		}
	}

	public void restauraLoteAtual() throws FileNotFoundException, IOException {
		if (!Paths.get(config.getBasePath(), "lotes").toFile().exists())
			Paths.get(config.getBasePath(), "lotes").toFile().mkdirs();
		File f = Paths.get(config.getBasePath(), "lotes", "loteatual.json").toFile();
		if (f.exists()) {
			try (Reader r = new FileReader(f)) {
				loteAtual = PanamahUtil.buildGson().fromJson(r, PanamahLote.class);
			}
		} else {
			try (Writer w = new BufferedWriter(new FileWriter(f))) {
				w.write(PanamahUtil.buildGson().toJson(loteAtual));
			}
		}
	}

	public void persisteLoteAtual() throws IOException {
		if (!Paths.get(config.getBasePath(), "lotes").toFile().exists())
			Paths.get(config.getBasePath(), "lotes").toFile().mkdirs();
		File f = Paths.get(config.getBasePath(), "lotes", "loteatual.json").toFile();
		try (Writer w = new BufferedWriter(new FileWriter(f))) {
			w.write(PanamahUtil.buildGson().toJson(loteAtual));
		}
	}

	public void fechaLoteAtual() throws FileNotFoundException, IOException {
		loteAtual.setStatus(PanamahStatusLote.FECHADO);
		String fileName = "lote-" + PanamahUtil.stamp(loteAtual.getUltimaAtualizacao()) + ".json";
		if (!Paths.get(config.getBasePath(), "lotes", "fechados").toFile().exists())
			Paths.get(config.getBasePath(), "lotes", "fechados").toFile().mkdirs();
		File f = Paths.get(config.getBasePath(), "lotes", "fechados", fileName).toFile();
		try (Writer w = new BufferedWriter(new FileWriter(f))) {
			w.write(PanamahUtil.buildGson().toJson(loteAtual));
		}
	}

	private void abreNovoLote() throws IOException {
		loteAtual = new PanamahLote();
		File f = Paths.get(config.getBasePath(), "lotes", "loteatual.json").toFile();
		try (Writer w = new BufferedWriter(new FileWriter(f))) {
			w.write(PanamahUtil.buildGson().toJson(loteAtual));
		}
	}

	public void enviaLote() throws IOException {
		// atualiza primeiro pra não ficar jogando erros o tempo todo
		ultimoEnvio = new Date().getTime();
		if (!Paths.get(config.getBasePath(), "lotes", "enviados").toFile().exists())
			Paths.get(config.getBasePath(), "lotes", "enviados").toFile().mkdirs();
		File[] files = Paths.get(config.getBasePath(), "lotes", "fechados").toFile()//
				.listFiles(new FilenameFilter() {
					@Override
					public boolean accept(File dir, String name) {
						return name.startsWith("lote-") && name.endsWith(".json");
					}
				});
		// send the last one only
		if (files.length > 0) {
			File toSend = files[files.length - 1];
			try (Reader r = new BufferedReader(new FileReader(toSend))) {
				PanamahLote lote = PanamahUtil.buildGson().fromJson(r, PanamahLote.class);
				PanamahUtil.send(config, lote);
				lote.setStatus(PanamahStatusLote.ENVIADO);
				File toWrite = Paths.get(config.getBasePath(), "lotes", "enviados", toSend.getName()).toFile();
				try (Writer w = new BufferedWriter(new FileWriter(toWrite))) {
					w.write(PanamahUtil.buildGson().toJson(lote));
				}
				toSend.delete();
			}

		}
	}

	public PanamahLote getLoteAtual() {
		return loteAtual;
	}

	public boolean isLoteAtualCheio() {
		int len = PanamahUtil.buildGson().toJson(loteAtual).getBytes().length;
		return len >= config.getMaxBytes();
	}

	public void readNFe(String filePath) throws Exception {
		String s = new String(Files.readAllBytes(Paths.get(filePath)));
		if (s == null || "".equals(s))
			throw new Exception("invalid filePath");
		if (s.indexOf("nfeProc") > -1)
			processNFeProc(s);
		else if (s.indexOf("NFe") > -1)
			processNFe(s);

	}

	private void processNFe(String s) throws Exception {
		NFe nfe = (NFe) PanamahUtil.buildXStream().fromXML(s);
		// Loja a partir do emitente
		PanamahLoja loja = new PanamahLoja();
		loja.setId(nfe.getInfNFe().getEmit().getCnpj());
		loja.setNumeroDocumento(nfe.getInfNFe().getEmit().getCnpj());
		loja.setDescricao(nfe.getInfNFe().getEmit().getxNome());
		loja.setBairro(nfe.getInfNFe().getEmit().getEnderEmit().getxBairro());
		loja.setCidade(nfe.getInfNFe().getEmit().getEnderEmit().getxMun());
		loja.setUf(nfe.getInfNFe().getEmit().getEnderEmit().getUF());
		loja.setLogradouro(nfe.getInfNFe().getEmit().getEnderEmit().getxLgr());
		loja.setNumero("" + nfe.getInfNFe().getEmit().getEnderEmit().getNro());
		loja.setComplemento(nfe.getInfNFe().getEmit().getEnderEmit().getxCpl());
		loja.setAtiva(true);
		loja.setMatriz(true);
		loja.setHoldingId("");
		loja.setRamo("");
		loteAtual.save(loja);

		// Cliente
		PanamahCliente cliente = new PanamahCliente();
		cliente.setId(nfe.getInfNFe().getDest().getCpf());
		cliente.setNome(nfe.getInfNFe().getDest().getxNome());
		loteAtual.save(cliente);
		
		// Fornecedor
//		PanamahFornecedor fornecedor = new PanamahFornecedor();
//		fornecedor.setId(nfe.getInfNFe().g);
		
		// Produto
		// Venda
	}

	private void processNFeProc(String s) throws Exception {
		NFeProc proc = (NFeProc) PanamahUtil.buildXStream().fromXML(s);
//		NFe nfe = 
	}

}
