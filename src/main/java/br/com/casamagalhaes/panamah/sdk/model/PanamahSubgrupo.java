package br.com.casamagalhaes.panamah.sdk.model;

import br.com.casamagalhaes.panamah.sdk.IPanamahModel;

public class PanamahSubgrupo implements IPanamahModel {

    private String id;
    private String codigo;
    private String descricao;
    private String secaoId;
    private String grupoId;

    public PanamahSubgrupo() {
    }

    public PanamahSubgrupo(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSecaoId() {
        return secaoId;
    }

    public void setSecaoId(String secaoId) {
        this.secaoId = secaoId;
    }

    public String getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(String grupoId) {
        this.grupoId = grupoId;
    }


    public void validate() throws Exception {
        if (this.id == null) throw new Exception("id não pode ser nulo!");
        if (this.codigo == null) throw new Exception("codigo não pode ser nulo!");
        if (this.descricao == null) throw new Exception("descricao não pode ser nulo!");
        if (this.secaoId == null) throw new Exception("secaoId não pode ser nulo!");
        if (this.grupoId == null) throw new Exception("grupoId não pode ser nulo!");
    }
}
  