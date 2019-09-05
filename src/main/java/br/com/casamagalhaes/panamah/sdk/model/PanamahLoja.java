package br.com.casamagalhaes.panamah.sdk.model;

import br.com.casamagalhaes.panamah.sdk.IPanamahModel;

public class PanamahLoja implements IPanamahModel {

    private Boolean ativa;
    private String id;
    private String descricao;
    private String numeroDocumento;
    private Boolean matriz;
    private String holdingId;
    private String ramo;
    private String logradouro;
    private String numero;
    private String uf;
    private String cidade;
    private String bairro;
    private String cep;
    private String distrito;
    private String complemento;
    private String telefone;
    private java.math.BigDecimal qtdCheckouts;
    private java.math.BigDecimal areaM2;
    private java.math.BigDecimal qtdFuncionarios;

    public PanamahLoja() {
    }

    public PanamahLoja(String id) {
        this.id = id;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Boolean getMatriz() {
        return matriz;
    }

    public void setMatriz(Boolean matriz) {
        this.matriz = matriz;
    }

    public String getHoldingId() {
        return holdingId;
    }

    public void setHoldingId(String holdingId) {
        this.holdingId = holdingId;
    }

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public java.math.BigDecimal getQtdCheckouts() {
        return qtdCheckouts;
    }

    public void setQtdCheckouts(java.math.BigDecimal qtdCheckouts) {
        this.qtdCheckouts = qtdCheckouts;
    }

    public java.math.BigDecimal getAreaM2() {
        return areaM2;
    }

    public void setAreaM2(java.math.BigDecimal areaM2) {
        this.areaM2 = areaM2;
    }

    public java.math.BigDecimal getQtdFuncionarios() {
        return qtdFuncionarios;
    }

    public void setQtdFuncionarios(java.math.BigDecimal qtdFuncionarios) {
        this.qtdFuncionarios = qtdFuncionarios;
    }


    public void validate() throws Exception {
        if (this.ativa == null) throw new Exception("ativa não pode ser nulo!");
        if (this.id == null) throw new Exception("id não pode ser nulo!");
        if (this.descricao == null) throw new Exception("descricao não pode ser nulo!");
        if (this.numeroDocumento == null) throw new Exception("numeroDocumento não pode ser nulo!");
        if (this.matriz == null) throw new Exception("matriz não pode ser nulo!");
        if (this.holdingId == null) throw new Exception("holdingId não pode ser nulo!");
        if (this.ramo == null) throw new Exception("ramo não pode ser nulo!");
        if (this.uf == null) throw new Exception("uf não pode ser nulo!");
        if (this.cidade == null) throw new Exception("cidade não pode ser nulo!");
        if (this.bairro == null) throw new Exception("bairro não pode ser nulo!");
    }
}
  