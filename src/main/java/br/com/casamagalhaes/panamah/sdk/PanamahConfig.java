package br.com.casamagalhaes.panamah.sdk;

public class PanamahConfig {

	private String basePath;
	private long delay;

	public PanamahConfig() {
		this.basePath = ".";
		this.delay = 5000;
	}

	public PanamahConfig(String basePath) {
		this.basePath = basePath;
	}

	public PanamahConfig(String basePath, long delay) {
		this.basePath = basePath;
		this.delay = delay;
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
