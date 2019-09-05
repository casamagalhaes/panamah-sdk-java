package br.com.casamagalhaes.panamah.sdk.model;

public class PanamahProdutoComposicaoItens {

    private String produtoId;
    private java.math.BigDecimal quantidade;

    public PanamahProdutoComposicaoItens() {
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

    public void validate() throws Exception {
        if (this.produtoId == null)
            throw new Exception("produtoId não pode ser nulo!");
        if (this.quantidade == null)
            throw new Exception("quantidade não pode ser nulo!");
    }
}
