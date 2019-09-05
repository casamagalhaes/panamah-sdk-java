package br.com.casamagalhaes.panamah.sdk.model;

import br.com.casamagalhaes.panamah.sdk.IPanamahModel;

public class PanamahFuncionario implements IPanamahModel {

    private java.util.Date dataNascimento;
    private String id;
    private String login;
    private String nome;
    private String numeroDocumento;
    private Boolean ativo;
    private String senha;
    private java.util.List<String> lojaIds;

    public PanamahFuncionario() {
    }

    public PanamahFuncionario(String id) {
        this.id = id;
    }

    public java.util.Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(java.util.Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public java.util.List<String> getLojaIds() {
        return lojaIds;
    }

    public void setLojaIds(java.util.List<String> lojaIds) {
        this.lojaIds = lojaIds;
    }


    public void validate() throws Exception {
        if (this.id == null) throw new Exception("id não pode ser nulo!");
        if (this.nome == null) throw new Exception("nome não pode ser nulo!");
        if (this.ativo == null) throw new Exception("ativo não pode ser nulo!");
    }
}
  