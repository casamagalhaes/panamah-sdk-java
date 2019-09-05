package br.com.casamagalhaes.panamah.sdk.model;

import br.com.casamagalhaes.panamah.sdk.IPanamahModel;

public class PanamahLocalEstoque implements IPanamahModel {

    private String id;
    private String lojaId;
    private String descricao;
    private Boolean disponivelParaVenda;

    public PanamahLocalEstoque() {
    }

    public PanamahLocalEstoque(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLojaId() {
        return lojaId;
    }

    public void setLojaId(String lojaId) {
        this.lojaId = lojaId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getDisponivelParaVenda() {
        return disponivelParaVenda;
    }

    public void setDisponivelParaVenda(Boolean disponivelParaVenda) {
        this.disponivelParaVenda = disponivelParaVenda;
    }


    public void validate() throws Exception {
        if (this.id == null) throw new Exception("id não pode ser nulo!");
        if (this.lojaId == null) throw new Exception("lojaId não pode ser nulo!");
        if (this.descricao == null) throw new Exception("descricao não pode ser nulo!");
        if (this.disponivelParaVenda == null) throw new Exception("disponivelParaVenda não pode ser nulo!");
    }
}
  