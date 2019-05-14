package br.com.casamagalhaes.panamah.sdk;

import br.com.casamagalhaes.panamah.sdk.model.PanamahAssinante;

public class PanamahAuth {

	private String accessToken;
	private String refreshToken;
	private String authorizationToken;
	private PanamahAssinante assinante;
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

	
	public String getAuthorizationToken() {
		return authorizationToken;
	}
	
	public void setAuthorizationToken(String authorizationToken) {
		this.authorizationToken = authorizationToken;
	}

	public PanamahAssinante getAssinante() {
		return assinante;
	}
	
	public void setAssinante(PanamahAssinante assinante) {
		this.assinante = assinante;
	}
	
	public long getTs() {
		return ts;
	}

	public void setTs(long ts) {
		this.ts = ts;
	}

}
