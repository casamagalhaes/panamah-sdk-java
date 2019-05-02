package br.com.casamagalhaes.panamah.sdk;

public class PanamahConfig {

	private String basePath;
	private long delay;

	public PanamahConfig() {
		this.basePath = "./panamah";
		this.delay = 5000;
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
	
	public long getDelay() {
		return delay;
	}
	
	public void setDelay(long delay) {
		this.delay = delay;
	}
}
