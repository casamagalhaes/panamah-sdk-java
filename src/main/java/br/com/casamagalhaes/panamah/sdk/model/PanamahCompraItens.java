
package br.com.casamagalhaes.panamah.sdk.model;

public class PanamahCompraItens {

	public PanamahCompraItens() {
	}

	private java.math.BigDecimal acrescimo;

	public java.math.BigDecimal getAcrescimo() {
		return acrescimo;
	}

	public void setAcrescimo(java.math.BigDecimal acrescimo) {
		this.acrescimo = acrescimo;
	}

	private java.math.BigDecimal desconto;

	public java.math.BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(java.math.BigDecimal desconto) {
		this.desconto = desconto;
	}

	private String produtoId;

	public String getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(String produtoId) {
		this.produtoId = produtoId;
	}

	private java.math.BigDecimal quantidade;

	public java.math.BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(java.math.BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	private java.math.BigDecimal valorTotal;

	public java.math.BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(java.math.BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	private java.math.BigDecimal valorUnitario;

	public java.math.BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(java.math.BigDecimal valorUnitario) {
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
