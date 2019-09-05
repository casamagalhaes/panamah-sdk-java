package br.com.casamagalhaes.panamah.sdk.model;

import br.com.casamagalhaes.panamah.sdk.IPanamahModel;

public class PanamahTrocaFormaPagamento implements IPanamahModel {

    private String autorizadorId;
    private java.util.Date data;
    private String formaPagamentoDestinoId;
    private String formaPagamentoOrigemId;
    private String id;
    private String lojaId;
    private String vendaId;
    private String operadorId;
    private String sequencialPagamento;
    private java.math.BigDecimal valor;
    private java.math.BigDecimal valorContraValeOuTroco;

    public PanamahTrocaFormaPagamento() {
    }

    public PanamahTrocaFormaPagamento(String id) {
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

    public String getFormaPagamentoDestinoId() {
        return formaPagamentoDestinoId;
    }

    public void setFormaPagamentoDestinoId(String formaPagamentoDestinoId) {
        this.formaPagamentoDestinoId = formaPagamentoDestinoId;
    }

    public String getFormaPagamentoOrigemId() {
        return formaPagamentoOrigemId;
    }

    public void setFormaPagamentoOrigemId(String formaPagamentoOrigemId) {
        this.formaPagamentoOrigemId = formaPagamentoOrigemId;
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

    public String getVendaId() {
        return vendaId;
    }

    public void setVendaId(String vendaId) {
        this.vendaId = vendaId;
    }

    public String getOperadorId() {
        return operadorId;
    }

    public void setOperadorId(String operadorId) {
        this.operadorId = operadorId;
    }

    public String getSequencialPagamento() {
        return sequencialPagamento;
    }

    public void setSequencialPagamento(String sequencialPagamento) {
        this.sequencialPagamento = sequencialPagamento;
    }

    public java.math.BigDecimal getValor() {
        return valor;
    }

    public void setValor(java.math.BigDecimal valor) {
        this.valor = valor;
    }

    public java.math.BigDecimal getValorContraValeOuTroco() {
        return valorContraValeOuTroco;
    }

    public void setValorContraValeOuTroco(java.math.BigDecimal valorContraValeOuTroco) {
        this.valorContraValeOuTroco = valorContraValeOuTroco;
    }


    public void validate() throws Exception {
        if (this.data == null) throw new Exception("data não pode ser nulo!");
        if (this.formaPagamentoDestinoId == null) throw new Exception("formaPagamentoDestinoId não pode ser nulo!");
        if (this.formaPagamentoOrigemId == null) throw new Exception("formaPagamentoOrigemId não pode ser nulo!");
        if (this.id == null) throw new Exception("id não pode ser nulo!");
        if (this.lojaId == null) throw new Exception("lojaId não pode ser nulo!");
        if (this.sequencialPagamento == null) throw new Exception("sequencialPagamento não pode ser nulo!");
        if (this.valor == null) throw new Exception("valor não pode ser nulo!");
    }
}
  