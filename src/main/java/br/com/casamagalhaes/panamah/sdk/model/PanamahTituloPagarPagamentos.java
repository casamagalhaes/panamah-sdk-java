package br.com.casamagalhaes.panamah.sdk.model;

public class PanamahTituloPagarPagamentos {

    private java.util.Date dataHora;
    private java.math.BigDecimal valor;

    public PanamahTituloPagarPagamentos() {
    }

    public java.util.Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(java.util.Date dataHora) {
        this.dataHora = dataHora;
    }

    public java.math.BigDecimal getValor() {
        return valor;
    }

    public void setValor(java.math.BigDecimal valor) {
        this.valor = valor;
    }

    public void validate() throws Exception {
        if (this.dataHora == null)
            throw new Exception("dataHora não pode ser nulo!");
        if (this.valor == null)
            throw new Exception("valor não pode ser nulo!");
    }
}
