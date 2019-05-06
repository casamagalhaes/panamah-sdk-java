package br.com.casamagalhaes.panamah.sdk;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Paths;
import java.util.TimerTask;

public class PanamahTask extends TimerTask {

	private PanamahConfig config;
	private PanamahLote loteAtual = new PanamahLote();

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

	public void verificaEnvio() {

	}

	public void verificaFechamento() throws FileNotFoundException, IOException {
		if (loteAtual.isCheio(config) || loteAtual.isVelho(config)) {
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

	public void enviaLote() {
		if (!Paths.get(config.getBasePath(), "lotes", "enviados").toFile().exists())
			Paths.get(config.getBasePath(), "lotes", "enviados").toFile().mkdirs();
		File[] files = Paths.get(config.getBasePath(), "lotes", "fechados").toFile().listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return false;
			}
		});
	}

	public PanamahLote getLoteAtual() {
		return loteAtual;
	}

}
