package br.com.casamagalhaes.panamah.sdk.nfe;

public class NFe {

	private String xmlns = "http://www.portalfiscal.inf.br/nfe";
	private InfNFe infNFe;
	private InfNFeSupl infNFeSupl;
	private Signature signature;

	public String getXmlns() {
		return xmlns;
	}
	
	public void setXmlns(String xmlns) {
		this.xmlns = xmlns;
	}
	
	public InfNFe getInfNFe() {
		return infNFe;
	}

	public void setInfNFe(InfNFe infNFe) {
		this.infNFe = infNFe;
	}

	public InfNFeSupl getInfNFeSupl() {
		return infNFeSupl;
	}

	public void setInfNFeSupl(InfNFeSupl infNFeSupl) {
		this.infNFeSupl = infNFeSupl;
	}

	public Signature getSignature() {
		return signature;
	}

	public void setSignature(Signature signature) {
		this.signature = signature;
	}

}
