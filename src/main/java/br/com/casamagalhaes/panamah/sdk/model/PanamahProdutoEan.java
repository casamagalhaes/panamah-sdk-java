package br.com.casamagalhaes.panamah.sdk.model;

import br.com.casamagalhaes.panamah.sdk.IPanamahModel;

public class PanamahProdutoEan implements IPanamahModel {

    private String id;
    private Boolean tributado;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getTributado() {
        return tributado;
    }

    public void setTributado(Boolean tributado) {
        this.tributado = tributado;
    }

    @Override
    public void validate() throws Exception {
        if (id == null || "".equals(id.trim())) throw new Exception("id não pode ser nulo ou vazio!");
    }
}
