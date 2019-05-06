package br.com.casamagalhaes.panamah.sdk;

public class PanamahConfig {

	private String basePath;
	private String addr;
	private long delay;
	private long maxAge;
	private String apiKey;

	public PanamahConfig() {
		this(".");
	}

	public PanamahConfig(String basePath) {
		this(basePath, 5000);
	}

	public PanamahConfig(String basePath, long delay) {
		this(basePath, delay, 5 * 60 * 1000);
	}

	public PanamahConfig(String basePath, long delay, long maxAge) {
		this(basePath, delay, maxAge, "http://127.0.0.1:7780/record");
	}

	public PanamahConfig(String basePath, long delay, long maxAge, String addr) {
		this.basePath = basePath;
		this.delay = delay;
		this.maxAge = maxAge;
		this.addr = addr;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
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
	
	public String getApiKey() {
		return apiKey;
	}
	
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
}
