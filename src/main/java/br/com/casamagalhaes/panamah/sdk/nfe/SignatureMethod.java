package br.com.casamagalhaes.panamah.sdk.nfe;

public class SignatureMethod {

	private String algorithm = "http://www.w3.org/2000/09/xmldsig#rsa-sha1";

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}

}
