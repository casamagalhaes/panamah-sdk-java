package br.com.casamagalhaes.panamah.sdk;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
		verificaFechamento();
		verificaEnvio();
	}

	public void verificaEnvio() {

	}

	public void verificaFechamento() {

	}

	public void restauraLoteAtual() throws FileNotFoundException, IOException {
		File f = Paths.get(config.getBasePath(), "loteatual.json").toFile();
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

	public void fechaLoteAtual() {
		// TODO Auto-generated method stub

	}

	public void enviaLote() {
		// TODO Auto-generated method stub

	}

}
