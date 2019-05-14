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

	public PanamahConfig createAssinante(PanamahConfig config) throws Exception {
		PanamahUtil.create(config);
		return config;
	}
}
