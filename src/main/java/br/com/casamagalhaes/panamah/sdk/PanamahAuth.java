package br.com.casamagalhaes.panamah.sdk;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import br.com.casamagalhaes.panamah.sdk.model.PanamahAssinante;

public class PanamahAuth {

	private String key;
	private String accessToken;
	private String refreshToken;
	private String authorizationToken;
	private PanamahAssinante assinante = new PanamahAssinante();

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
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

	public String buildAuth() {
		return buildAuth(System.currentTimeMillis() / 1000);
	}

	public String buildAuth(long ts) {
		String k = Base64.encodeBase64String(DigestUtils.sha1(key + assinante.getId() + ts));
		String ret = String.format("{\"assinanteId\": \"%s\", \"key\":\"%s\", \"ts\":%d }", assinante.getId(), k, ts);
		return ret;
	}

}
