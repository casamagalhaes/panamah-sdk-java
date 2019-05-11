package br.com.casamagalhaes.panamah.sdk.nfe;

import java.util.Date;

public class InfProt {

	private Integer tpAmb;// <tpAmb>2</tpAmb>
	private String verAplic;// <verAplic>AM3.10-NAC</verAplic>
	private String chNFe;// <chNFe>13190507128945000132652340000000109000000088</chNFe>
	private Date dhRecbto;// <dhRecbto>2019-05-03T17:56:51-04:00</dhRecbto>
	private String nProt;// <nProt>113190007099826</nProt>
	private String digVal;// <digVal>qA3l0roJC4w9VHSgbgL/5zmfCRY=</digVal>
	private Integer cStat;// <cStat>100</cStat>
	private String xMotivo;// <xMotivo>Autorizado o uso da NF-e</xMotivo>

	public Integer getTpAmb() {
		return tpAmb;
	}

	public void setTpAmb(Integer tpAmb) {
		this.tpAmb = tpAmb;
	}

	public String getVerAplic() {
		return verAplic;
	}

	public void setVerAplic(String verAplic) {
		this.verAplic = verAplic;
	}

	public String getChNFe() {
		return chNFe;
	}

	public void setChNFe(String chNFe) {
		this.chNFe = chNFe;
	}

	public Date getDhRecbto() {
		return dhRecbto;
	}

	public void setDhRecbto(Date dhRecbto) {
		this.dhRecbto = dhRecbto;
	}

	public String getnProt() {
		return nProt;
	}

	public void setnProt(String nProt) {
		this.nProt = nProt;
	}

	public String getDigVal() {
		return digVal;
	}

	public void setDigVal(String digVal) {
		this.digVal = digVal;
	}

	public Integer getcStat() {
		return cStat;
	}

	public void setcStat(Integer cStat) {
		this.cStat = cStat;
	}

	public String getxMotivo() {
		return xMotivo;
	}

	public void setxMotivo(String xMotivo) {
		this.xMotivo = xMotivo;
	}

}
