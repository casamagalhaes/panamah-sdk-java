package br.com.casamagalhaes.panamah.sdk.model;

import br.com.casamagalhaes.panamah.sdk.IPanamahModel;

public class PanamahTituloPagar implements IPanamahModel {

    private String id;
    private String lojaId;
    private String fornecedorId;
    private String documento;
    private java.math.BigDecimal valorNominal;
    private java.math.BigDecimal valorJuros;
    private java.math.BigDecimal valorMulta;
    private java.math.BigDecimal valorDevido;
    private java.math.BigDecimal valorPago;
    private java.util.Date dataEmissao;
    private java.util.Date dataVencimento;
    private java.util.List<PanamahTituloPagarPagamentos> pagamentos;

    public PanamahTituloPagar() {
    }

    public PanamahTituloPagar(String id) {
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

    public String getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(String fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public java.math.BigDecimal getValorNominal() {
        return valorNominal;
    }

    public void setValorNominal(java.math.BigDecimal valorNominal) {
        this.valorNominal = valorNominal;
    }

    public java.math.BigDecimal getValorJuros() {
        return valorJuros;
    }

    public void setValorJuros(java.math.BigDecimal valorJuros) {
        this.valorJuros = valorJuros;
    }

    public java.math.BigDecimal getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(java.math.BigDecimal valorMulta) {
        this.valorMulta = valorMulta;
    }

    public java.math.BigDecimal getValorDevido() {
        return valorDevido;
    }

    public void setValorDevido(java.math.BigDecimal valorDevido) {
        this.valorDevido = valorDevido;
    }

    public java.math.BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(java.math.BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public java.util.Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(java.util.Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public java.util.Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(java.util.Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public java.util.List<PanamahTituloPagarPagamentos> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(java.util.List<PanamahTituloPagarPagamentos> pagamentos) {
        this.pagamentos = pagamentos;
    }


    public void validate() throws Exception {
        if (this.id == null) throw new Exception("id não pode ser nulo!");
        if (this.lojaId == null) throw new Exception("lojaId não pode ser nulo!");
        if (this.fornecedorId == null) throw new Exception("fornecedorId não pode ser nulo!");
        if (this.documento == null) throw new Exception("documento não pode ser nulo!");
        if (this.valorNominal == null) throw new Exception("valorNominal não pode ser nulo!");
        if (this.valorJuros == null) throw new Exception("valorJuros não pode ser nulo!");
        if (this.valorMulta == null) throw new Exception("valorMulta não pode ser nulo!");
        if (this.valorDevido == null) throw new Exception("valorDevido não pode ser nulo!");
        if (this.valorPago == null) throw new Exception("valorPago não pode ser nulo!");
        if (this.dataEmissao == null) throw new Exception("dataEmissao não pode ser nulo!");
        if (this.dataVencimento == null) throw new Exception("dataVencimento não pode ser nulo!");
        if (this.pagamentos == null) throw new Exception("pagamentos não pode ser nulo!");
    }
}
  