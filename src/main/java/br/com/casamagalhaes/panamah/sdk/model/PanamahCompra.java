package br.com.casamagalhaes.panamah.sdk.model;

import br.com.casamagalhaes.panamah.sdk.IPanamahModel;

public class PanamahCompra implements IPanamahModel {

    private String id;
    private String lojaId;
    private String fornecedorId;
    private String funcionarioId;
    private java.util.Date dataEntrada;
    private java.util.Date dataEmissao;
    private java.util.Date dataHoraCompra;
    private java.math.BigDecimal desconto;
    private Boolean efetiva = true;
    private java.math.BigDecimal quantidadeItens;
    private String tipoDesconto;
    private java.math.BigDecimal valor;
    private java.math.BigDecimal acrescimo;
    private java.util.List<PanamahCompraItens> itens;

    public PanamahCompra() {
    }

    public PanamahCompra(String id) {
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

    public String getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(String funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public java.util.Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(java.util.Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public java.util.Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(java.util.Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public java.util.Date getDataHoraCompra() {
        return dataHoraCompra;
    }

    public void setDataHoraCompra(java.util.Date dataHoraCompra) {
        this.dataHoraCompra = dataHoraCompra;
    }

    public java.math.BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(java.math.BigDecimal desconto) {
        this.desconto = desconto;
    }

    public Boolean getEfetiva() {
        return efetiva;
    }

    public void setEfetiva(Boolean efetiva) {
        this.efetiva = efetiva;
    }

    public java.math.BigDecimal getQuantidadeItens() {
        return quantidadeItens;
    }

    public void setQuantidadeItens(java.math.BigDecimal quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }

    public String getTipoDesconto() {
        return tipoDesconto;
    }

    public void setTipoDesconto(String tipoDesconto) {
        this.tipoDesconto = tipoDesconto;
    }

    public java.math.BigDecimal getValor() {
        return valor;
    }

    public void setValor(java.math.BigDecimal valor) {
        this.valor = valor;
    }

    public java.math.BigDecimal getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(java.math.BigDecimal acrescimo) {
        this.acrescimo = acrescimo;
    }

    public java.util.List<PanamahCompraItens> getItens() {
        return itens;
    }

    public void setItens(java.util.List<PanamahCompraItens> itens) {
        this.itens = itens;
    }


    public void validate() throws Exception {
        if (this.id == null) throw new Exception("id não pode ser nulo!");
        if (this.lojaId == null) throw new Exception("lojaId não pode ser nulo!");
        if (this.dataEntrada == null) throw new Exception("dataEntrada não pode ser nulo!");
        if (this.dataEmissao == null) throw new Exception("dataEmissao não pode ser nulo!");
        if (this.dataHoraCompra == null) throw new Exception("dataHoraCompra não pode ser nulo!");
        if (this.efetiva == null) throw new Exception("efetiva não pode ser nulo!");
        if (this.quantidadeItens == null) throw new Exception("quantidadeItens não pode ser nulo!");
        if (this.valor == null) throw new Exception("valor não pode ser nulo!");
        if (this.itens == null) throw new Exception("itens não pode ser nulo!");
    }
}
  