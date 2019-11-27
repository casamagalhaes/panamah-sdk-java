package br.com.casamagalhaes.panamah.sdk;

import java.io.InputStream;
import java.util.Properties;

public class PanamahConfig {

    private String env;
    private String addr;
    private long delay = 5000;
    private String basePath = ".";
    private long ttl = 5 * 60 * 1000;
    private long maxBytes = 300 * 1024;
    private int maxItens = 300;
    private long maxAgeSent = 86400000;
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
        if(addr == null || addr.isEmpty()) return "https://panamah.io/api/v2";
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

    public int getMaxItens() {
        return maxItens;
    }

    public void setMaxItens(int maxItens) {
        this.maxItens = maxItens;
    }

    public long getMaxAgeSent() {
        return maxAgeSent;
    }

    public void setMaxAgeSent(long maxAgeSent) {
        this.maxAgeSent = maxAgeSent;
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
        String prefix = "";
        switch (env) {
            case "development":
                prefix = "DEV_";
                break;
            case "staging":
                prefix = "HOM_";
                break;
        }

        c.addr = System.getenv(prefix + "PANAMAH_ADDR");
        c.basePath = System.getenv(prefix + "PANAMAH_BASE_PATH");

        c.auth.setKey(System.getenv(prefix + "PANAMAH_SECRET"));
        c.auth.setAuthorizationToken(System.getenv(prefix + "PANAMAH_AUTHORIZATION_TOKEN"));
        c.auth.getAssinante().setId(System.getenv(prefix + "PANAMAH_ASSINANTE_ID"));
        return c;
    }

    public static PanamahConfig fromProperties() throws Exception {
        return fromProperties("application");
    }

    public static PanamahConfig fromProperties(String prop) throws Exception {
        PanamahConfig c = new PanamahConfig();
        Properties p = new Properties();
        try (InputStream in = PanamahConfig.class.getClassLoader().getResourceAsStream(prop + ".properties")) {
            p.load(in);
            c.env = p.getProperty("panamah.env");
            c.addr = p.getProperty("panamah." + c.env + ".addr");
            c.basePath = p.getProperty("panamah." + c.env + ".basepath");
            c.auth.setKey(p.getProperty("panamah." + c.env + ".secret"));
            c.auth.setAuthorizationToken(p.getProperty("panamah." + c.env + ".token"));
            c.auth.getAssinante().setId(p.getProperty("panamah." + c.env + ".assinanteid"));
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Arquivo " + prop + ".properties não encontrado!");
        }
        return c;
    }

    public static PanamahConfig fromVM() throws Exception {
        PanamahConfig c = new PanamahConfig();
        c.env = System.getProperty("panamah.env");
        c.addr = System.getProperty("panamah.addr");
        c.basePath = System.getProperty("panamah.basepath");
        c.auth.setKey(System.getProperty("panamah.secret"));
        c.auth.setAuthorizationToken(System.getProperty("panamah.token"));
        c.auth.getAssinante().setId(System.getProperty("panamah.assinanteid"));
        return c;
    }

    private PanamahConfig merge(PanamahConfig c) {
        if (c != null) {
            if (c.env != null)
                env = c.env;
            if (c.addr != null)
                addr = c.addr;
            if (c.basePath != null)
                basePath = c.basePath;
            if (c.auth.getKey() != null)
                auth.setKey(c.auth.getKey());
            if (c.auth.getAuthorizationToken() != null)
                auth.setAuthorizationToken(c.auth.getAuthorizationToken());
            if (c.auth.getAssinante().getId() != null)
                auth.getAssinante().setId(c.auth.getAssinante().getId());
        }
        return this;
    }

    public static PanamahConfig autoConfigure() throws Exception {
        PanamahConfig c1 = fromVM();
        PanamahConfig c2 = null;
        // special check, this JVM prop is the prop file name
        String prop = System.getProperty("panamah.config");
        // yet the file might not exists
        if (prop != null)
            c2 = fromProperties(prop);
        else
            c2 = fromProperties();
        PanamahConfig c3 = fromEnv();
        // JVM prop > prop file > env var
        return c1.merge(c2).merge(c3);
    }
}
