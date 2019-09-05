package br.com.casamagalhaes.panamah.sdk.model;

import br.com.casamagalhaes.panamah.sdk.IPanamahModel;

public class PanamahProdutoFornecedores implements IPanamahModel {

    private String id;
    private Boolean principal;


    public PanamahProdutoFornecedores() {
    }

    public PanamahProdutoFornecedores(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }


    public void validate() throws Exception {
        if (this.id == null) throw new Exception("id não pode ser nulo!");
        if (this.principal == null) throw new Exception("principal não pode ser nulo!");
    }
}
  