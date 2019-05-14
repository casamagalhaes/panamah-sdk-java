package br.com.casamagalhaes.panamah.sdk;

public class PanamahConfig {

	private String basePath;
	private String addr;
	private long delay;
	private long ttl;
	private String apiKey = "xpto";
	private String accessToken;
	private String refreshToken;
	private String authAddr;
	private long maxBytes;
	
	private PanamahAuth auth = new PanamahAuth();

	public PanamahConfig() {
		this(".");
	}

	public PanamahConfig(String basePath) {
		this(basePath, 5000);
	}

	public PanamahConfig(String basePath, long delay) {
		this(basePath, delay, 5 * 60 * 1000);
	}

	public PanamahConfig(String basePath, long delay, long ttl) {
		this(basePath, delay, ttl, "http://127.0.0.1:7780/stream/data");
	}

	public PanamahConfig(String basePath, long delay, long ttl, String addr) {
		this(basePath, delay, ttl, addr, "http://127.0.0.1:7780/stream/auth");
	}

	public PanamahConfig(String basePath, long delay, long ttl, String addr, String authAddr) {
		this(basePath, delay, ttl, addr, authAddr, 500 * 1024);
	}

	public PanamahConfig(String basePath, long delay, long ttl, String addr, String authAddr, int maxBytes) {
		this.basePath = basePath;
		this.delay = delay;
		this.ttl = ttl;
		this.addr = addr;
		this.authAddr = authAddr;
		this.maxBytes = maxBytes;
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

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getAuthAddr() {
		return authAddr;
	}

	public void setAuthAddr(String authAddr) {
		this.authAddr = authAddr;
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
}
