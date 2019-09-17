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
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.LinkedBlockingQueue;

import com.google.gson.internal.LinkedTreeMap;

import br.com.casamagalhaes.panamah.sdk.model.PanamahCliente;
import br.com.casamagalhaes.panamah.sdk.model.PanamahLoja;
import br.com.casamagalhaes.panamah.sdk.model.PanamahVenda;
import br.com.casamagalhaes.panamah.sdk.model.PanamahVendaItens;
import br.com.casamagalhaes.panamah.sdk.model.PanamahVendaPagamentos;
import br.com.casamagalhaes.panamah.sdk.nfe.Det;
import br.com.casamagalhaes.panamah.sdk.nfe.NFe;
import br.com.casamagalhaes.panamah.sdk.nfe.NFeProc;

public class PanamahTask extends TimerTask {

    private PanamahConfig config;
    private PanamahLote loteAtual = new PanamahLote();
    private long ultimoEnvio = new Date().getTime();
    private PanamahListener onSendSuccess;
    private PanamahListener onError;
    private boolean fechandoLote;

    public PanamahTask(PanamahConfig config) throws IOException {
        this.config = config;
        restauraLoteAtual();
    }

    @Override
    public void run() {
        verificaFechamento();
        verificaEnvio();
        removeAntigos();
    }

    public void removeAntigos() {
		// TODO Auto-generated method stub
		
	}

	public boolean isFechandoLote() {
        return fechandoLote;
    }

    public PanamahListener getOnSendSuccess() {
        return onSendSuccess;
    }

    public void setOnSendSuccess(PanamahListener onSendSuccess) {
        this.onSendSuccess = onSendSuccess;
    }

    public PanamahListener getOnError() {
        return onError;
    }

    public void setOnError(PanamahListener onError) {
        this.onError = onError;
    }

    public void verificaEnvio() {
        try {
            if (new Date().getTime() > ultimoEnvio / 2 + config.getTtl()) {
                // System.out.println("verificaEnvio");
                enviaLote();
            }
        } catch (Exception e) {
            if (onError != null)
                onError.notify(new PanamahEvent(config, loteAtual, e));
            e.printStackTrace();
        }
    }

    public void verificaFechamento() {
        try {
            if (loteAtual.isVelho(config) || isLoteAtualCheio()) {
                // System.out.println("verificaFechamento");
                fechaLoteAtual();
            }
        } catch (Exception e) {
            if (onError != null) {
                PanamahEvent ev = new PanamahEvent(config, loteAtual, e);
                onError.notify(ev);
                e.printStackTrace();
            }
        }
    }

    public void restauraLoteAtual() throws FileNotFoundException, IOException {
        if (!Paths.get(config.getBasePath(), "lotes").toFile().exists())
            Paths.get(config.getBasePath(), "lotes").toFile().mkdirs();
        File f = Paths.get(config.getBasePath(), "lotes", "loteatual.json").toFile();
        if (f.exists()) {
            try (Reader r = new FileReader(f)) {
                loteAtual = PanamahUtil.buildGson().fromJson(r, PanamahLote.class);
                if (loteAtual == null)
                    loteAtual = new PanamahLote(); // paranoia
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
        if (isLoteAtualCheio()) {
            fechaLoteAtual();
            verificaEnvio();
        }
    }

    public synchronized void fechaLoteAtual() throws FileNotFoundException, IOException {
        fechandoLote = true;
        loteAtual.setStatus(PanamahStatusLote.FECHADO);
        String fileName = "lote-" + PanamahUtil.stamp(loteAtual.getUltimaAtualizacao()) + ".json";
        if (!Paths.get(config.getBasePath(), "lotes", "fechados").toFile().exists())
            Paths.get(config.getBasePath(), "lotes", "fechados").toFile().mkdirs();
        File f = Paths.get(config.getBasePath(), "lotes", "fechados", fileName).toFile();
        LinkedBlockingQueue<PanamahOperacao<?>> restante = loteAtual.removeExcedente();
        try (Writer w = new BufferedWriter(new FileWriter(f))) {
            w.write(PanamahUtil.buildGson().toJson(loteAtual));
        }
        abreNovoLote(restante);
        fechandoLote = false;
    }

    private void abreNovoLote(LinkedBlockingQueue<PanamahOperacao<?>> restante) throws IOException {
        loteAtual = new PanamahLote();
        if (restante != null)
            loteAtual.getOperacoes().addAll(restante);
        File f = Paths.get(config.getBasePath(), "lotes", "loteatual.json").toFile();
        try (Writer w = new BufferedWriter(new FileWriter(f))) {
            w.write(PanamahUtil.buildGson().toJson(loteAtual));
        }
    }

    public void enviaLote() throws Exception {
        // atualiza primeiro pra não ficar jogando erros o tempo inteiro
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
        if (files != null && files.length > 0) {
            File toSend = files[0];
            try (Reader r = new BufferedReader(new FileReader(toSend))) {
                PanamahLote lote = PanamahUtil.buildGson().fromJson(r, PanamahLote.class);
                // não envia lote vazio
                if (lote != null && lote.getOperacoes() != null && lote.getOperacoes().size() > 0) {
                    PanamahRetornoLote ret = PanamahUtil.buildGson()//
                            .fromJson(PanamahUtil.send(config, lote), PanamahRetornoLote.class);

                    lote.setStatus(PanamahStatusLote.ENVIADO);

                    File toWrite = Paths.get(config.getBasePath(), "lotes", "enviados", toSend.getName()).toFile();

                    // System.out.println("lote enviado: "+toWrite);

                    try (Writer w = new BufferedWriter(new FileWriter(toWrite))) {
                        w.write(PanamahUtil.buildGson().toJson(lote));
                    }

                    if (ret != null && ret.getFalhas() != null)
                        trataFalhas(lote, ret);

                    if (onSendSuccess != null) {
                        PanamahEvent e = new PanamahEvent(config, lote, ret);
                        onSendSuccess.notify(e);
                    }
                }
                // sempre deleta
                toSend.delete();
            }
        }
    }

    private void trataFalhas(PanamahLote lote, PanamahRetornoLote ret) {
        ArrayList<String> idsfalhas = new ArrayList<String>();
        for (PanamahRetornoItem item : ret.getFalhas().getItens())
            idsfalhas.add(item.getId());

        ArrayList<PanamahOperacao<?>> ops = new ArrayList<PanamahOperacao<?>>();
        for (PanamahOperacao<?> op : lote.getOperacoes()) {
            @SuppressWarnings("unchecked")
            LinkedTreeMap<String, String> m = (LinkedTreeMap<String, String>) op.getData();
            String id = (String) m.get("id");
            if (idsfalhas.indexOf(id) > -1)
                ops.add(op);
        }
        loteAtual.addFalhas(ops);
    }

    public PanamahLote getLoteAtual() {
        return loteAtual;
    }

    public synchronized boolean isLoteAtualCheio() {
        int len = PanamahUtil.buildGson().toJson(loteAtual).getBytes().length;
        return len >= config.getMaxBytes() || loteAtual.getOperacoes().size() > 499;
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

    private void processNFeProc(String s) throws Exception {
        NFeProc proc = (NFeProc) PanamahUtil.buildXStream().fromXML(s);
        proccessNFe(proc.getNfe());
    }

    private void processNFe(String s) throws Exception {
        NFe nfe = (NFe) PanamahUtil.buildXStream().fromXML(s);
        proccessNFe(nfe);
    }

    private PanamahNFeModel proccessNFe(NFe nfe) throws Exception {
        PanamahNFeModel model = new PanamahNFeModel();
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
        loja.setHoldingId(nfe.getInfNFe().getEmit().getCnpj());
        loja.setRamo(nfe.getInfNFe().getEmit().getCnpj());

        model.setLoja(loja);

        // Cliente
        if (nfe.getInfNFe().getDest() != null) {

            PanamahCliente cliente = new PanamahCliente();
            cliente.setId(nfe.getInfNFe().getDest().getCpf());
            String doc = nfe.getInfNFe().getDest().getCpf();
            if (doc == null)
                doc = nfe.getInfNFe().getDest().getCnpj();
            cliente.setNumeroDocumento(doc);
            cliente.setNome(nfe.getInfNFe().getDest().getxNome());
            cliente.setRamo("");
            cliente.setUf(nfe.getInfNFe().getDest().getEnderDest().getUf());
            cliente.setCidade(nfe.getInfNFe().getDest().getEnderDest().getxMun());
            cliente.setBairro(nfe.getInfNFe().getDest().getEnderDest().getxBairro());

            model.setCliente(cliente);

        }

        // Fornecedor
        // PanamahFornecedor fornecedor = new PanamahFornecedor();
        // fornecedor.setId(nfe.getInfNFe().g);

        // Produto

        // Venda
        if (nfe.getInfNFe().getDet() != null) {
            PanamahVenda venda = new PanamahVenda();
            venda.setId(nfe.getInfNFe().getId());
            venda.setLojaId(nfe.getInfNFe().getEmit().getCnpj());
            // venda.setClienteId(nfe.getInfNFe().getDest().getCpf());
            venda.setData(nfe.getInfNFe().getIde().getDhEmi());
            venda.setDataHoraVenda(nfe.getInfNFe().getIde().getDhEmi());
            venda.setItens(new ArrayList<PanamahVendaItens>());
            venda.setEfetiva(true);
            venda.setSequencial("" + nfe.getInfNFe().getIde().getSerie());
            venda.setTipoPreco("" + nfe.getInfNFe().getIde().getMod());
            venda.setValor(nfe.getInfNFe().getTotal().getIcmsTot().getvNF());
            venda.setPagamentos(new ArrayList<PanamahVendaPagamentos>());

            for (Det d : nfe.getInfNFe().getDet()) {
                PanamahVendaItens i = new PanamahVendaItens();
                i.setPreco(d.getProd().getvProd());
                i.setQuantidade(new BigDecimal(1.0 * d.getnItem()));
                venda.getItens().add(i);
            }
            venda.setQuantidadeItens(new BigDecimal(1.0 * nfe.getInfNFe().getDet().size()));

            model.setVenda(venda);
        }
        return model;
    }

    public void deletaLoteAtual() throws Exception {
        Path p = Paths.get(config.getBasePath(), "loteatual.json");
        if (Files.exists(p))
            Files.delete(p);
        loteAtual = new PanamahLote();

    }

    public PanamahConfig getConfig() {
        return config;
    }

    public HashMap<String, PanamahPendencias> pending(int start, int count) throws Exception {
        return PanamahUtil.pending(config, start, count);
    }

}
