package br.com.casamagalhaes.panamah.sdk.model;

import br.com.casamagalhaes.panamah.sdk.IPanamahModel;

public class PanamahFornecedor implements IPanamahModel {

    private String id;
    private String nome;
    private String numeroDocumento;
    private String ramo;
    private String uf;
    private String cidade;
    private String bairro;

    public PanamahFornecedor() {
    }

    public PanamahFornecedor(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }


    public void validate() throws Exception {
        if (this.id == null) throw new Exception("id não pode ser nulo!");
        if (this.nome == null) throw new Exception("nome não pode ser nulo!");
        if (this.numeroDocumento == null) throw new Exception("numeroDocumento não pode ser nulo!");
        if (this.ramo == null) throw new Exception("ramo não pode ser nulo!");
        if (this.uf == null) throw new Exception("uf não pode ser nulo!");
        if (this.cidade == null) throw new Exception("cidade não pode ser nulo!");
        if (this.bairro == null) throw new Exception("bairro não pode ser nulo!");
    }
}
  