package br.com.casamagalhaes.panamah.sdk.nfe;

public class Reference {

	private String uri;
	private Transforms transforms;
	private DigestMethod digestMethod;
	private String digestValue;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Transforms getTransforms() {
		return transforms;
	}

	public void setTransforms(Transforms transforms) {
		this.transforms = transforms;
	}

	public DigestMethod getDigestMethod() {
		return digestMethod;
	}

	public void setDigestMethod(DigestMethod digestMethod) {
		this.digestMethod = digestMethod;
	}

	public String getDigestValue() {
		return digestValue;
	}

	public void setDigestValue(String digestValue) {
		this.digestValue = digestValue;
	}

}
