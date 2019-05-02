
package br.com.casamagalhaes.panamah.sdk.model;

public class PanamahEan {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String produtoId;

    public String getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(String produtoId) {
        this.produtoId = produtoId;
    }

    private Boolean tributado;

    public Boolean getTributado() {
        return tributado;
    }

    public void setTributado(Boolean tributado) {
        this.tributado = tributado;
    }

}