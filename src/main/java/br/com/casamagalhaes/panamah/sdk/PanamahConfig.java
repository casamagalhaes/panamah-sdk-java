package br.com.casamagalhaes.panamah.sdk;

public class PanamahConfig {

	private String basePath;

	public PanamahConfig() {
	}

	public PanamahConfig(String basePath) {
		this.basePath = basePath;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
}
