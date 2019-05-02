
package br.com.casamagalhaes.panamah.sdk.model;

public class PanamahEventoCaixa {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String lojaId;

    public String getLojaId() {
        return lojaId;
    }

    public void setLojaId(String lojaId) {
        this.lojaId = lojaId;
    }

    private String numeroCaixa;

    public String getNumeroCaixa() {
        return numeroCaixa;
    }

    public void setNumeroCaixa(String numeroCaixa) {
        this.numeroCaixa = numeroCaixa;
    }

    private String funcionarioId;

    public String getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(String funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    private java.util.Date dataHora;

    public java.util.Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(java.util.Date dataHora) {
        this.dataHora = dataHora;
    }

    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    private java.util.List<PanamahEventoCaixaValoresDeclarados> valoresDeclarados;

    public java.util.List<PanamahEventoCaixaValoresDeclarados> getValoresDeclarados() {
        return valoresDeclarados;
    }

    public void setValoresDeclarados(java.util.List<PanamahEventoCaixaValoresDeclarados> valoresDeclarados) {
        this.valoresDeclarados = valoresDeclarados;
    }

}
