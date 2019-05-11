package br.com.casamagalhaes.panamah.sdk.nfe;

public class Signature {

	private String xmlns = "http://www.w3.org/2000/09/xmldsig#";
	private SignedInfo signedInfo;
	private String signatureValue;
	private KeyInfo keyInfo;

	public String getXmlns() {
		return xmlns;
	}
	
	public void setXmlns(String xmlns) {
		this.xmlns = xmlns;
	}
	
	public SignedInfo getSignedInfo() {
		return signedInfo;
	}

	public void setSignedInfo(SignedInfo signedInfo) {
		this.signedInfo = signedInfo;
	}

	public String getSignatureValue() {
		return signatureValue;
	}

	public void setSignatureValue(String signatureValue) {
		this.signatureValue = signatureValue;
	}

	public KeyInfo getKeyInfo() {
		return keyInfo;
	}

	public void setKeyInfo(KeyInfo keyInfo) {
		this.keyInfo = keyInfo;
	}

}
