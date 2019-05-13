package br.com.casamagalhaes.panamah.sdk;

public class PanamahAuth {

	private String accessToken;
	private String refreshToken;
	private String asinanteId;
	private String key;
	private long ts = System.currentTimeMillis();

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

	public String getAsinanteId() {
		return asinanteId;
	}

	public void setAsinanteId(String asinanteId) {
		this.asinanteId = asinanteId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public long getTs() {
		return ts;
	}

	public void setTs(long ts) {
		this.ts = ts;
	}

}
