
package br.com.casamagalhaes.panamah.sdk;

public class PanamahVendaPagamentos {

    private String formaPagamentoId;

    public String getFormaPagamentoId() {
        return formaPagamentoId;
    }

    public void setFormaPagamentoId(String formaPagamentoId) {
        this.formaPagamentoId = formaPagamentoId;
    }

    private String sequencial;

    public String getSequencial() {
        return sequencial;
    }

    public void setSequencial(String sequencial) {
        this.sequencial = sequencial;
    }

    private Double valor;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}