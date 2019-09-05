package br.com.casamagalhaes.panamah.sdk.model;

import br.com.casamagalhaes.panamah.sdk.IPanamahModel;

public class PanamahEstoqueMovimentacao implements IPanamahModel {

    private String id;
    private String localEstoqueId;
    private java.util.Date dataHora;
    private String produtoId;
    private java.math.BigDecimal quantidade;
    private java.math.BigDecimal custo;
    private java.math.BigDecimal preco;
    private java.math.BigDecimal markup;

    public PanamahEstoqueMovimentacao() {
    }

    public PanamahEstoqueMovimentacao(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocalEstoqueId() {
        return localEstoqueId;
    }

    public void setLocalEstoqueId(String localEstoqueId) {
        this.localEstoqueId = localEstoqueId;
    }

    public java.util.Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(java.util.Date dataHora) {
        this.dataHora = dataHora;
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

    public java.math.BigDecimal getCusto() {
        return custo;
    }

    public void setCusto(java.math.BigDecimal custo) {
        this.custo = custo;
    }

    public java.math.BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(java.math.BigDecimal preco) {
        this.preco = preco;
    }

    public java.math.BigDecimal getMarkup() {
        return markup;
    }

    public void setMarkup(java.math.BigDecimal markup) {
        this.markup = markup;
    }


    public void validate() throws Exception {
        if (this.id == null) throw new Exception("id não pode ser nulo!");
        if (this.localEstoqueId == null) throw new Exception("localEstoqueId não pode ser nulo!");
        if (this.dataHora == null) throw new Exception("dataHora não pode ser nulo!");
        if (this.produtoId == null) throw new Exception("produtoId não pode ser nulo!");
        if (this.quantidade == null) throw new Exception("quantidade não pode ser nulo!");
        if (this.custo == null) throw new Exception("custo não pode ser nulo!");
        if (this.preco == null) throw new Exception("preco não pode ser nulo!");
    }
}
  