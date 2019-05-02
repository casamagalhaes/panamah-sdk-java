package br.com.casamagalhaes.panamah.sdk;

import java.io.File;
import java.nio.file.Paths;
import java.util.TimerTask;

public class PanamahTask extends TimerTask {

	private PanamahConfig config;

	public PanamahTask(PanamahConfig config) {
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

	public void restauraLoteAtual() {
		File f = Paths.get(config.getBasePath(), "loteatual.json").toFile();
		if(f.exists()) {
			
		}
	}

}
