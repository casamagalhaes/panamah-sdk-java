package br.com.casamagalhaes.panamah.sdk.nfe;

import java.util.List;

public class DetEvento {

	private String descEvento;
	private String nProt;
	private String xJust;
	private List<Det> det;

	public String getDescEvento() {
		return descEvento;
	}

	public void setDescEvento(String descEvento) {
		this.descEvento = descEvento;
	}

	public String getnProt() {
		return nProt;
	}

	public void setnProt(String nProt) {
		this.nProt = nProt;
	}

	public String getxJust() {
		return xJust;
	}

	public void setxJust(String xJust) {
		this.xJust = xJust;
	}

	public List<Det> getDet() {
		return det;
	}

	public void setDet(List<Det> det) {
		this.det = det;
	}

}
