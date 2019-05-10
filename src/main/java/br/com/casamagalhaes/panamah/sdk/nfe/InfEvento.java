package br.com.casamagalhaes.panamah.sdk.nfe;

import java.util.Date;

public class InfEvento {
	
	private Integer cOrgao;
	private Integer tpAmb;
	private String CNPJ;
	private String chNFe;
	private Date dhEvento;
	private Integer tpEvento;
	private Integer nSeqEvento;
	private Double verEvento;
	private DetEvento detEvento;
	
	/**
	 * @return the cOrgao
	 */
	public Integer getcOrgao() {
		return cOrgao;
	}
	/**
	 * @param cOrgao the cOrgao to set
	 */
	public void setcOrgao(Integer cOrgao) {
		this.cOrgao = cOrgao;
	}
	/**
	 * @return the tpAmb
	 */
	public Integer getTpAmb() {
		return tpAmb;
	}
	/**
	 * @param tpAmb the tpAmb to set
	 */
	public void setTpAmb(Integer tpAmb) {
		this.tpAmb = tpAmb;
	}
	/**
	 * @return the cNPJ
	 */
	public String getCNPJ() {
		return CNPJ;
	}
	/**
	 * @param cNPJ the cNPJ to set
	 */
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	/**
	 * @return the chNFe
	 */
	public String getChNFe() {
		return chNFe;
	}
	/**
	 * @param chNFe the chNFe to set
	 */
	public void setChNFe(String chNFe) {
		this.chNFe = chNFe;
	}
	/**
	 * @return the dhEvento
	 */
	public Date getDhEvento() {
		return dhEvento;
	}
	/**
	 * @param dhEvento the dhEvento to set
	 */
	public void setDhEvento(Date dhEvento) {
		this.dhEvento = dhEvento;
	}
	/**
	 * @return the tpEvento
	 */
	public Integer getTpEvento() {
		return tpEvento;
	}
	/**
	 * @param tpEvento the tpEvento to set
	 */
	public void setTpEvento(Integer tpEvento) {
		this.tpEvento = tpEvento;
	}
	/**
	 * @return the nSeqEvento
	 */
	public Integer getnSeqEvento() {
		return nSeqEvento;
	}
	/**
	 * @param nSeqEvento the nSeqEvento to set
	 */
	public void setnSeqEvento(Integer nSeqEvento) {
		this.nSeqEvento = nSeqEvento;
	}
	/**
	 * @return the verEvento
	 */
	public Double getVerEvento() {
		return verEvento;
	}
	/**
	 * @param verEvento the verEvento to set
	 */
	public void setVerEvento(Double verEvento) {
		this.verEvento = verEvento;
	}
	
	public DetEvento getDetEvento() {
		return detEvento;
	}
	
	public void setDetEvento(DetEvento detEvento) {
		this.detEvento = detEvento;
	}
	
}
