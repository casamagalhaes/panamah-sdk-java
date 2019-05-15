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

	public void createAssinante(PanamahConfig config) throws Exception {
		PanamahUtil.createAssinante(config);
	}

	public void retrieveAssinante(PanamahConfig config, String assinanteId) throws Exception {
		PanamahUtil.retrieveAssinante(config, assinanteId);
	}
}
