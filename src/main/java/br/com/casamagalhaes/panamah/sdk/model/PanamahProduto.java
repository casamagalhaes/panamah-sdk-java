
package br.com.casamagalhaes.panamah.sdk.model;

public class PanamahProduto {

	private PanamahProdutoComposicao composicao;

	public PanamahProdutoComposicao getComposicao() {
		return composicao;
	}

	public void setComposicao(PanamahProdutoComposicao composicao) {
		this.composicao = composicao;
	}

	private String tipoComposicao;

	public String getTipoComposicao() {
		return tipoComposicao;
	}

	public void setTipoComposicao(String tipoComposicao) {
		this.tipoComposicao = tipoComposicao;
	}

	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	private java.util.Date dataInclusao;

	public java.util.Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(java.util.Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	private String finalidade;

	public String getFinalidade() {
		return finalidade;
	}

	public void setFinalidade(String finalidade) {
		this.finalidade = finalidade;
	}

	private Boolean ativo;

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	private String grupoId;

	public String getGrupoId() {
		return grupoId;
	}

	public void setGrupoId(String grupoId) {
		this.grupoId = grupoId;
	}

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private Boolean pesoVariavel;

	public Boolean getPesoVariavel() {
		return pesoVariavel;
	}

	public void setPesoVariavel(Boolean pesoVariavel) {
		this.pesoVariavel = pesoVariavel;
	}

	private Double quantidadeItensEmbalagem;

	public Double getQuantidadeItensEmbalagem() {
		return quantidadeItensEmbalagem;
	}

	public void setQuantidadeItensEmbalagem(Double quantidadeItensEmbalagem) {
		this.quantidadeItensEmbalagem = quantidadeItensEmbalagem;
	}

	private String secaoId;

	public String getSecaoId() {
		return secaoId;
	}

	public void setSecaoId(String secaoId) {
		this.secaoId = secaoId;
	}

	private String subgrupoId;

	public String getSubgrupoId() {
		return subgrupoId;
	}

	public void setSubgrupoId(String subgrupoId) {
		this.subgrupoId = subgrupoId;
	}

	private java.util.List<PanamahProdutoFornecedores> fornecedores;

	public java.util.List<PanamahProdutoFornecedores> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(java.util.List<PanamahProdutoFornecedores> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public void validate() throws Exception {
		if (this.descricao == null)
			throw new Exception("descricao não pode ser nulo!");
		if (this.id == null)
			throw new Exception("id não pode ser nulo!");
		if (this.secaoId == null)
			throw new Exception("secaoId não pode ser nulo!");
	}
}
