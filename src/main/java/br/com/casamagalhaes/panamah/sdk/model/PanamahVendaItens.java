
package br.com.casamagalhaes.panamah.sdk.model;

public class PanamahVendaItens {

	public PanamahVendaItens() {
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

	private Boolean efetivo;

	public Boolean getEfetivo() {
		return efetivo;
	}

	public void setEfetivo(Boolean efetivo) {
		this.efetivo = efetivo;
	}

	private String funcionarioId;

	public String getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(String funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	private java.math.BigDecimal preco;

	public java.math.BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(java.math.BigDecimal preco) {
		this.preco = preco;
	}

	private String produtoId;

	public String getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(String produtoId) {
		this.produtoId = produtoId;
	}

	private String codigoRegistrado;

	public String getCodigoRegistrado() {
		return codigoRegistrado;
	}

	public void setCodigoRegistrado(String codigoRegistrado) {
		this.codigoRegistrado = codigoRegistrado;
	}

	private Boolean promocao;

	public Boolean getPromocao() {
		return promocao;
	}

	public void setPromocao(Boolean promocao) {
		this.promocao = promocao;
	}

	private java.math.BigDecimal quantidade;

	public java.math.BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(java.math.BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	private java.math.BigDecimal servico;

	public java.math.BigDecimal getServico() {
		return servico;
	}

	public void setServico(java.math.BigDecimal servico) {
		this.servico = servico;
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

	private String tipoPreco;

	public String getTipoPreco() {
		return tipoPreco;
	}

	public void setTipoPreco(String tipoPreco) {
		this.tipoPreco = tipoPreco;
	}

	private java.math.BigDecimal custo;

	public java.math.BigDecimal getCusto() {
		return custo;
	}

	public void setCusto(java.math.BigDecimal custo) {
		this.custo = custo;
	}

	private java.math.BigDecimal markup;

	public java.math.BigDecimal getMarkup() {
		return markup;
	}

	public void setMarkup(java.math.BigDecimal markup) {
		this.markup = markup;
	}

	private java.math.BigDecimal lucro;

	public java.math.BigDecimal getLucro() {
		return lucro;
	}

	public void setLucro(java.math.BigDecimal lucro) {
		this.lucro = lucro;
	}

	public void validate() throws Exception {
		if (this.efetivo == null)
			throw new Exception("efetivo não pode ser nulo!");
		if (this.preco == null)
			throw new Exception("preco não pode ser nulo!");
		if (this.produtoId == null)
			throw new Exception("produtoId não pode ser nulo!");
		if (this.quantidade == null)
			throw new Exception("quantidade não pode ser nulo!");
		if (this.valorTotal == null)
			throw new Exception("valorTotal não pode ser nulo!");
		if (this.valorUnitario == null)
			throw new Exception("valorUnitario não pode ser nulo!");
		if (this.tipoPreco == null)
			throw new Exception("tipoPreco não pode ser nulo!");
	}
}
