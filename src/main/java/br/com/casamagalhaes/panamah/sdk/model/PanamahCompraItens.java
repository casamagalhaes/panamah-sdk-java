
package br.com.casamagalhaes.panamah.sdk.model;

public class PanamahCompraItens {

	public PanamahCompraItens() {
	}

	private Double acrescimo;

	public Double getAcrescimo() {
		return acrescimo;
	}

	public void setAcrescimo(Double acrescimo) {
		this.acrescimo = acrescimo;
	}

	private Double desconto;

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
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

	private Double valorTotal;

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	private Double valorUnitario;

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public void validate() throws Exception {
		if (this.produtoId == null)
			throw new Exception("produtoId não pode ser nulo!");
		if (this.quantidade == null)
			throw new Exception("quantidade não pode ser nulo!");
		if (this.valorTotal == null)
			throw new Exception("valorTotal não pode ser nulo!");
		if (this.valorUnitario == null)
			throw new Exception("valorUnitario não pode ser nulo!");
	}
}
