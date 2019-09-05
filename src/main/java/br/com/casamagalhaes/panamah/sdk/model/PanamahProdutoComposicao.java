package br.com.casamagalhaes.panamah.sdk.model;

public class PanamahProdutoComposicao {

    private java.util.List<PanamahProdutoComposicaoItens> itens;
    private java.math.BigDecimal quantidade;

    public PanamahProdutoComposicao() {
    }

    public java.util.List<PanamahProdutoComposicaoItens> getItens() {
        return itens;
    }

    public void setItens(java.util.List<PanamahProdutoComposicaoItens> itens) {
        this.itens = itens;
    }

    public java.math.BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(java.math.BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public void validate() throws Exception {
        if (this.quantidade == null)
            throw new Exception("quantidade não pode ser nulo!");
    }
}
