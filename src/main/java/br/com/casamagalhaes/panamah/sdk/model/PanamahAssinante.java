
package br.com.casamagalhaes.panamah.sdk.model;

public class PanamahAssinante {

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	private String fantasia;

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	private String ramo;

	public String getRamo() {
		return ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

	private String uf;

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	private String cidade;

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	private String revendaId;

	public String getRevendaId() {
		return revendaId;
	}

	public void setRevendaId(String revendaId) {
		this.revendaId = revendaId;
	}

	private String bairro;

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	private java.util.List<PanamahAssinanteSoftwaresAtivos> softwaresAtivos;

	public java.util.List<PanamahAssinanteSoftwaresAtivos> getSoftwaresAtivos() {
		return softwaresAtivos;
	}

	public void setSoftwaresAtivos(java.util.List<PanamahAssinanteSoftwaresAtivos> softwaresAtivos) {
		this.softwaresAtivos = softwaresAtivos;
	}

	private java.util.List<PanamahAssinanteSoftwaresEmContratosDeManutencao> softwaresEmContratosDeManutencao;

	public java.util.List<PanamahAssinanteSoftwaresEmContratosDeManutencao> getSoftwaresEmContratosDeManutencao() {
		return softwaresEmContratosDeManutencao;
	}

	public void setSoftwaresEmContratosDeManutencao(
			java.util.List<PanamahAssinanteSoftwaresEmContratosDeManutencao> softwaresEmContratosDeManutencao) {
		this.softwaresEmContratosDeManutencao = softwaresEmContratosDeManutencao;
	}

	private java.util.List<String> series;

	public java.util.List<String> getSeries() {
		return series;
	}

	public void setSeries(java.util.List<String> series) {
		this.series = series;
	}

	private Boolean ativo;

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public boolean isValid() {
		return this.id != null && this.nome != null && this.fantasia != null && this.ramo != null && this.uf != null
				&& this.cidade != null && this.bairro != null && this.softwaresAtivos != null
				&& this.softwaresEmContratosDeManutencao != null && this.ativo != null;
	}
}
