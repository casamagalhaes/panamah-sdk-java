package br.com.casamagalhaes.panamah.sdk.nfe;

public class Imposto {

	private java.math.BigDecimal vTotTrib;
	private Icms icms;

	public java.math.BigDecimal getvTotTrib() {
		return vTotTrib;
	}

	public void setvTotTrib(java.math.BigDecimal vTotTrib) {
		this.vTotTrib = vTotTrib;
	}

	public Icms getIcms() {
		return icms;
	}

	public void setIcms(Icms icms) {
		this.icms = icms;
	}

}
