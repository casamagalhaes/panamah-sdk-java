package br.com.casamagalhaes.panamah.sdk.nfe;

public class Imposto {

	private Double vTotTrib;
	private Icms icms;

	public Double getvTotTrib() {
		return vTotTrib;
	}

	public void setvTotTrib(Double vTotTrib) {
		this.vTotTrib = vTotTrib;
	}

	public Icms getIcms() {
		return icms;
	}

	public void setIcms(Icms icms) {
		this.icms = icms;
	}

}
