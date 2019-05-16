package br.com.casamagalhaes.panamah.sdk;

import java.util.ResourceBundle;

public class PanamahConfig {

	private String env;
	private String addr;
	private long delay = 5000;
	private String basePath = ".";
	private long ttl = 5 * 60 * 1000;
	private long maxBytes = 500 * 1024;
	private PanamahAuth auth = new PanamahAuth();

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
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

	public static PanamahConfig fromEnv() {
		return fromEnv(System.getenv("PANAMAH_ENV"));
	}

	public static PanamahConfig fromEnv(String env) {
		PanamahConfig c = new PanamahConfig();
		c.env = env;
		switch (env) {
		case "development":
			c.basePath = System.getenv("DEV_PANAMAH_BASE_PATH");
//			c.addr = "http://127.0.0.1:7780";
			c.addr = System.getenv("DEV_PANAMAH_ADDR");
			c.auth.setAuthorizationToken(System.getenv("DEV_PANAMAH_AUTHORIZATION_TOKEN"));
			c.auth.getAssinante().setId(System.getenv("DEV_PANAMAH_ASSINANTE_ID"));
			c.auth.setKey(System.getenv("DEV_PANAMAH_KEY"));
			break;
		case "staging":
			c.basePath = System.getenv("HOM_PANAMAH_BASE_PATH");
//			c.addr = "https://panamah.io/api/v2";
			c.addr = System.getenv("HOM_PANAMAH_ADDR");
			c.auth.setAuthorizationToken(System.getenv("HOM_PANAMAH_AUTHORIZATION_TOKEN"));
			c.auth.getAssinante().setId(System.getenv("HOM_PANAMAH_ASSINANTE_ID"));
			c.auth.setKey(System.getenv("HOM_PANAMAH_KEY"));
			break;
		case "production":
			c.basePath = System.getenv("PANAMAH_BASE_PATH");
//			c.addr = "https://panamah.io/api/v2";
			c.addr = System.getenv("PANAMAH_ADDR");
			c.auth.setAuthorizationToken(System.getenv("PANAMAH_AUTHORIZATION_TOKEN"));
			c.auth.getAssinante().setId(System.getenv("PANAMAH_ASSINANTE_ID"));
			c.auth.setKey(System.getenv("PANAMAH_KEY"));
			break;
		}
		return c;
	}

	public static PanamahConfig fromProperties() throws Exception {
		return fromProperties("application");
	}

	public static PanamahConfig fromProperties(String prop) throws Exception {
		PanamahConfig c = new PanamahConfig();
		ResourceBundle b = ResourceBundle.getBundle(prop);
		c.env = b.getString("panamah.env");
		c.basePath = b.getString("panamah." + c.env + ".basepath");
		c.addr = b.getString("panamah." + c.env + ".addr");
		c.auth.setAuthorizationToken(b.getString("panamah." + c.env + ".token"));
		c.auth.getAssinante().setId(b.getString("panamah." + c.env + ".assinanteid"));
		c.auth.setKey(b.getString("panamah." + c.env + ".key"));
		return c;
	}

	public static PanamahConfig autoConfigure() throws Exception {
		PanamahConfig c = new PanamahConfig();

		// special check, JVM prop is the prop file name
		String prop = System.getProperty("panamah.config");
		try {
			if (prop != null)
				c = fromProperties(prop);
			else
				c = fromProperties();
		} catch (Exception e) {
			e.printStackTrace();
			c.env = "production";
		}

		// JVM prop > prop file > env var

		String basePath = System.getenv("PANAMAH_BASE_PATH");
		if (c.basePath == null)
			c.basePath = basePath;
		basePath = System.getProperty("panamah.basepath");
		if (basePath != null)
			c.basePath = basePath;

		String addr = System.getenv("PANAMAH_ADDR");
		if (c.addr == null)
			c.addr = addr;
		addr = System.getProperty("panamah.addr");
		if (addr != null)
			c.addr = addr;

		String authToken = System.getenv("PANAMAH_AUTHORIZATION_TOKEN");
		if (c.auth.getAuthorizationToken() == null)
			c.auth.setAuthorizationToken(authToken);
		authToken = System.getProperty("panamah.authorization.token");
		if (authToken != null)
			c.auth.setAuthorizationToken(authToken);

		String key = System.getenv("PANAMAH_KEY");
		if (c.auth.getAuthorizationToken() == null)
			c.auth.setAuthorizationToken(key);
		key = System.getProperty("panamah.key");
		if (key != null)
			c.auth.setKey(key);

		String asinanteId = System.getenv("PANAMAH_ASSINANTE_ID");
		if (c.auth.getAssinante().getId() == null)
			c.auth.getAssinante().setId(asinanteId);
		asinanteId = System.getProperty("panamah.asinanteid");
		if (asinanteId != null)
			c.auth.getAssinante().setId(asinanteId);

		return c;
	}
}
