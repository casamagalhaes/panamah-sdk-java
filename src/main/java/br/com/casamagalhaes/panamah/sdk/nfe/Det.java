package br.com.casamagalhaes.panamah.sdk.nfe;

public class Det {

	private Integer nItem;
	private Prod prod;
	private Imposto imposto;

	public Integer getnItem() {
		return nItem;
	}

	public void setnItem(Integer nItem) {
		this.nItem = nItem;
	}

	public Prod getProd() {
		return prod;
	}

	public void setProd(Prod prod) {
		this.prod = prod;
	}

	public Imposto getImposto() {
		return imposto;
	}

	public void setImposto(Imposto imposto) {
		this.imposto = imposto;
	}

}
