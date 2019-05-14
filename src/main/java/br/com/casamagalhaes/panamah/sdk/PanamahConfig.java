package br.com.casamagalhaes.panamah.sdk;

public class PanamahConfig {

	private String addr;
	private long delay = 5000;
	private String basePath = ".";
	private long ttl = 5 * 60 * 1000;;
	private String apiKey = "xpto";
	private long maxBytes = 500 * 1024;
	private PanamahAuth auth = new PanamahAuth();

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

	public long getTtl() {
		return ttl;
	}

	public void setTtl(long maxAge) {
		this.ttl = maxAge;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public long getMaxBytes() {
		return maxBytes;
	}

	public void setMaxBytes(long maxBytes) {
		this.maxBytes = maxBytes;
	}

	public PanamahAuth getAuth() {
		return auth;
	}

	public void setAuth(PanamahAuth auth) {
		this.auth = auth;
	}

	public static PanamahConfig fromEnv(String env) {
		PanamahConfig c = new PanamahConfig();
		switch (env) {
		case "development":
			c.addr = "http://127.0.0.1:7780";
			c.auth.setAuthorizationToken(System.getenv("DEV_PANAMAH_AUTHORIZATION_TOKEN"));
			break;
		case "staging":
			c.addr = "https://panamah.io/api/v2";
			c.auth.setAuthorizationToken(System.getenv("HOM_PANAMAH_AUTHORIZATION_TOKEN"));
			break;
		default: // production
			c.basePath = System.getenv("PANAMAH_ENV_BASE_PATH");
			c.addr = System.getenv("PANAMAH_ENV_ADDR");
			c.auth.setAuthorizationToken(System.getenv("HOM_PANAMAH_AUTHORIZATION_TOKEN"));
			break;
		}
		return c;
	}
}
