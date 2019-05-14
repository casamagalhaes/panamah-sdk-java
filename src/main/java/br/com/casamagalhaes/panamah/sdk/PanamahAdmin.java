package br.com.casamagalhaes.panamah.sdk;

public class PanamahAdmin {

	private PanamahAdmin() {
	}

	private static PanamahAdmin instance;

	public synchronized static PanamahAdmin getInstance() {
		if (instance == null)
			instance = new PanamahAdmin();
		return instance;
	}

	public PanamahConfig saveAssinante(PanamahConfig config) {
		PanamahUtil.create(config);
		return config;
	}
}
