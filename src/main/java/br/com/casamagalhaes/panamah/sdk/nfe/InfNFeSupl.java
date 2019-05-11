package br.com.casamagalhaes.panamah.sdk.nfe;

public class InfNFeSupl {

	private String qrCode;
	private String urlChave = "http://www.sefaz.am.gov.br/nfce/consulta";

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	public String getUrlChave() {
		return urlChave;
	}

	public void setUrlChave(String urlChave) {
		this.urlChave = urlChave;
	}

}
