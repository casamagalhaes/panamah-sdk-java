package br.com.casamagalhaes.panamah.sdk.nfe;

public class Dest {

	private String cnpj;
	private String cpf;
	private String xNome;
	private EnderDest enderDest;
	private Integer indIEDest;

	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getxNome() {
		return xNome;
	}

	public void setxNome(String xNome) {
		this.xNome = xNome;
	}

	public EnderDest getEnderDest() {
		return enderDest;
	}

	public void setEnderDest(EnderDest enderDest) {
		this.enderDest = enderDest;
	}

	public Integer getIndIEDest() {
		return indIEDest;
	}

	public void setIndIEDest(Integer indIEDest) {
		this.indIEDest = indIEDest;
	}

}
