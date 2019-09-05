package br.com.casamagalhaes.panamah.sdk.model;

public class PanamahCompraItens {

    private java.math.BigDecimal acrescimo;
    private java.math.BigDecimal desconto;
    private String produtoId;
    private java.math.BigDecimal quantidade;
    private java.math.BigDecimal valorTotal;
    private java.math.BigDecimal valorUnitario;

    public PanamahCompraItens() {
    }

    public java.math.BigDecimal getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(java.math.BigDecimal acrescimo) {
        this.acrescimo = acrescimo;
    }

    public java.math.BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(java.math.BigDecimal desconto) {
        this.desconto = desconto;
    }

    public String getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(String produtoId) {
        this.produtoId = produtoId;
    }

    public java.math.BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(java.math.BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public java.math.BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(java.math.BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

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
