package br.com.casamagalhaes.panamah.sdk.model;

import br.com.casamagalhaes.panamah.sdk.IPanamahModel;

public class PanamahTrocaDevolucao implements IPanamahModel {

    private String autorizadorId;
    private java.util.Date data;
    private String vendaId;
    private String id;
    private java.util.List<PanamahTrocaDevolucaoItens> itens;
    private String lojaId;
    private String numeroCaixa;
    private String operadorId;
    private String sequencial;
    private java.math.BigDecimal valor;
    private String vendedorId;

    public PanamahTrocaDevolucao() {
    }

    public PanamahTrocaDevolucao(String id) {
        this.id = id;
    }

    public String getAutorizadorId() {
        return autorizadorId;
    }

    public void setAutorizadorId(String autorizadorId) {
        this.autorizadorId = autorizadorId;
    }

    public java.util.Date getData() {
        return data;
    }

    public void setData(java.util.Date data) {
        this.data = data;
    }

    public String getVendaId() {
        return vendaId;
    }

    public void setVendaId(String vendaId) {
        this.vendaId = vendaId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public java.util.List<PanamahTrocaDevolucaoItens> getItens() {
        return itens;
    }

    public void setItens(java.util.List<PanamahTrocaDevolucaoItens> itens) {
        this.itens = itens;
    }

    public String getLojaId() {
        return lojaId;
    }

    public void setLojaId(String lojaId) {
        this.lojaId = lojaId;
    }

    public String getNumeroCaixa() {
        return numeroCaixa;
    }

    public void setNumeroCaixa(String numeroCaixa) {
        this.numeroCaixa = numeroCaixa;
    }

    public String getOperadorId() {
        return operadorId;
    }

    public void setOperadorId(String operadorId) {
        this.operadorId = operadorId;
    }

    public String getSequencial() {
        return sequencial;
    }

    public void setSequencial(String sequencial) {
        this.sequencial = sequencial;
    }

    public java.math.BigDecimal getValor() {
        return valor;
    }

    public void setValor(java.math.BigDecimal valor) {
        this.valor = valor;
    }

    public String getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(String vendedorId) {
        this.vendedorId = vendedorId;
    }


    public void validate() throws Exception {
        if (this.data == null) throw new Exception("data não pode ser nulo!");
        if (this.id == null) throw new Exception("id não pode ser nulo!");
        if (this.itens == null) throw new Exception("itens não pode ser nulo!");
        if (this.lojaId == null) throw new Exception("lojaId não pode ser nulo!");
        if (this.valor == null) throw new Exception("valor não pode ser nulo!");
    }
}
  