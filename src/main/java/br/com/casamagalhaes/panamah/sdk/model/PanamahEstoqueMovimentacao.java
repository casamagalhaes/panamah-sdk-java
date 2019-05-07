
package br.com.casamagalhaes.panamah.sdk.model;

public class PanamahEstoqueMovimentacao {

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String localEstoqueId;

	public String getLocalEstoqueId() {
		return localEstoqueId;
	}

	public void setLocalEstoqueId(String localEstoqueId) {
		this.localEstoqueId = localEstoqueId;
	}

	private java.util.Date dataHora;

	public java.util.Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(java.util.Date dataHora) {
		this.dataHora = dataHora;
	}

	private String produtoId;

	public String getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(String produtoId) {
		this.produtoId = produtoId;
	}

	private Double quantidade;

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	private Double custo;

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	private Double preco;

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	private Double markup;

	public Double getMarkup() {
		return markup;
	}

	public void setMarkup(Double markup) {
		this.markup = markup;
	}

	public void validate() throws Exception {
		if (this.id == null)
			throw new Exception("id não pode ser nulo!");
		if (this.localEstoqueId == null)
			throw new Exception("localEstoqueId não pode ser nulo!");
		if (this.dataHora == null)
			throw new Exception("dataHora não pode ser nulo!");
		if (this.produtoId == null)
			throw new Exception("produtoId não pode ser nulo!");
		if (this.quantidade == null)
			throw new Exception("quantidade não pode ser nulo!");
		if (this.custo == null)
			throw new Exception("custo não pode ser nulo!");
		if (this.preco == null)
			throw new Exception("preco não pode ser nulo!");
	}
}
