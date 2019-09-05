package br.com.casamagalhaes.panamah.sdk.model;

import br.com.casamagalhaes.panamah.sdk.IPanamahModel;

public class PanamahMeta implements IPanamahModel {

    private String id;
    private java.math.BigDecimal mes;
    private java.math.BigDecimal ano;
    private String lojaId;
    private String secaoId;
    private java.math.BigDecimal valor;

    public PanamahMeta() {
    }

    public PanamahMeta(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public java.math.BigDecimal getMes() {
        return mes;
    }

    public void setMes(java.math.BigDecimal mes) {
        this.mes = mes;
    }

    public java.math.BigDecimal getAno() {
        return ano;
    }

    public void setAno(java.math.BigDecimal ano) {
        this.ano = ano;
    }

    public String getLojaId() {
        return lojaId;
    }

    public void setLojaId(String lojaId) {
        this.lojaId = lojaId;
    }

    public String getSecaoId() {
        return secaoId;
    }

    public void setSecaoId(String secaoId) {
        this.secaoId = secaoId;
    }

    public java.math.BigDecimal getValor() {
        return valor;
    }

    public void setValor(java.math.BigDecimal valor) {
        this.valor = valor;
    }


    public void validate() throws Exception {
        if (this.id == null) throw new Exception("id não pode ser nulo!");
        if (this.mes == null) throw new Exception("mes não pode ser nulo!");
        if (this.ano == null) throw new Exception("ano não pode ser nulo!");
        if (this.lojaId == null) throw new Exception("lojaId não pode ser nulo!");
        if (this.secaoId == null) throw new Exception("secaoId não pode ser nulo!");
        if (this.valor == null) throw new Exception("valor não pode ser nulo!");
    }
}
  