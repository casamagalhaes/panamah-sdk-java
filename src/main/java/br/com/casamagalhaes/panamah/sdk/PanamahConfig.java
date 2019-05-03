package br.com.casamagalhaes.panamah.sdk;

public class PanamahConfig {

	private String basePath;
	private long delay;
	private long maxAge;

	public PanamahConfig() {
		this(".", 5000, 5 * 60 * 1000);
	}

	public PanamahConfig(String basePath) {
		this(basePath, 5000, 5 * 60 * 1000);
	}

	public PanamahConfig(String basePath, long delay) {
		this(basePath, delay, 5 * 60 * 1000);
	}

	public PanamahConfig(String basePath, long delay, long maxAge) {
		this.basePath = basePath;
		this.delay = delay;
		this.maxAge = maxAge;
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

	public long getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(long maxAge) {
		this.maxAge = maxAge;
	}
}
