package br.com.casamagalhaes.panamah.sdk.nfe;

public class NFeProc {

	private String versao;
	private NFe nfe;
	private ProtNFe protNFe;

	public String getVersao() {
		return versao;
	}
	
	public void setVersao(String versao) {
		this.versao = versao;
	}
	
	public NFe getNfe() {
		return nfe;
	}

	public void setNfe(NFe nfe) {
		this.nfe = nfe;
	}

	public ProtNFe getProtNFe() {
		return protNFe;
	}

	public void setProtNFe(ProtNFe protNFe) {
		this.protNFe = protNFe;
	}

}
