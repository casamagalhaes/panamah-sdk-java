package br.com.casamagalhaes.panamah.sdk.model;

import br.com.casamagalhaes.panamah.sdk.IPanamahModel;

public class PanamahEventoCaixa implements IPanamahModel {

    private String id;
    private String lojaId;
    private String numeroCaixa;
    private String funcionarioId;
    private java.util.Date dataHora;
    private String tipo;
    private java.util.List<PanamahEventoCaixaValoresDeclarados> valoresDeclarados;

    public PanamahEventoCaixa() {
    }

    public PanamahEventoCaixa(String id) {
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

    public String getNumeroCaixa() {
        return numeroCaixa;
    }

    public void setNumeroCaixa(String numeroCaixa) {
        this.numeroCaixa = numeroCaixa;
    }

    public String getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(String funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public java.util.Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(java.util.Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public java.util.List<PanamahEventoCaixaValoresDeclarados> getValoresDeclarados() {
        return valoresDeclarados;
    }

    public void setValoresDeclarados(java.util.List<PanamahEventoCaixaValoresDeclarados> valoresDeclarados) {
        this.valoresDeclarados = valoresDeclarados;
    }


    public void validate() throws Exception {
        if (this.id == null) throw new Exception("id não pode ser nulo!");
        if (this.lojaId == null) throw new Exception("lojaId não pode ser nulo!");
        if (this.numeroCaixa == null) throw new Exception("numeroCaixa não pode ser nulo!");
        if (this.dataHora == null) throw new Exception("dataHora não pode ser nulo!");
        if (this.tipo == null) throw new Exception("tipo não pode ser nulo!");
    }
}
  