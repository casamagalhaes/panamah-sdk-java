package br.com.casamagalhaes.panamah.sdk.model;

import br.com.casamagalhaes.panamah.sdk.IPanamahModel;

public class PanamahVenda implements IPanamahModel {

    private String id;
    private String lojaId;
    private String clienteId;
    private String funcionarioId;
    private java.util.Date data;
    private java.util.Date dataHoraInicio;
    private java.util.Date dataHoraFim;
    private java.util.Date dataHoraVenda;
    private java.math.BigDecimal desconto;
    private Boolean efetiva = true;
    private java.math.BigDecimal quantidadeItens;
    private java.math.BigDecimal quantidadeItensCancelados;
    private String sequencial;
    private java.math.BigDecimal servico;
    private String tipoDesconto;
    private String tipoPreco;
    private java.math.BigDecimal valor;
    private java.math.BigDecimal valorItensCancelados;
    private java.math.BigDecimal acrescimo;
    private String numeroCaixa;
    private java.util.List<PanamahVendaItens> itens;
    private java.util.List<PanamahVendaPagamentos> pagamentos;

    public PanamahVenda() {
    }

    public PanamahVenda(String id) {
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

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(String funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public java.util.Date getData() {
        return data;
    }

    public void setData(java.util.Date data) {
        this.data = data;
    }

    public java.util.Date getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(java.util.Date dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public java.util.Date getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(java.util.Date dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public java.util.Date getDataHoraVenda() {
        return dataHoraVenda;
    }

    public void setDataHoraVenda(java.util.Date dataHoraVenda) {
        this.dataHoraVenda = dataHoraVenda;
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

    public java.math.BigDecimal getQuantidadeItensCancelados() {
        return quantidadeItensCancelados;
    }

    public void setQuantidadeItensCancelados(java.math.BigDecimal quantidadeItensCancelados) {
        this.quantidadeItensCancelados = quantidadeItensCancelados;
    }

    public String getSequencial() {
        return sequencial;
    }

    public void setSequencial(String sequencial) {
        this.sequencial = sequencial;
    }

    public java.math.BigDecimal getServico() {
        return servico;
    }

    public void setServico(java.math.BigDecimal servico) {
        this.servico = servico;
    }

    public String getTipoDesconto() {
        return tipoDesconto;
    }

    public void setTipoDesconto(String tipoDesconto) {
        this.tipoDesconto = tipoDesconto;
    }

    public String getTipoPreco() {
        return tipoPreco;
    }

    public void setTipoPreco(String tipoPreco) {
        this.tipoPreco = tipoPreco;
    }

    public java.math.BigDecimal getValor() {
        return valor;
    }

    public void setValor(java.math.BigDecimal valor) {
        this.valor = valor;
    }

    public java.math.BigDecimal getValorItensCancelados() {
        return valorItensCancelados;
    }

    public void setValorItensCancelados(java.math.BigDecimal valorItensCancelados) {
        this.valorItensCancelados = valorItensCancelados;
    }

    public java.math.BigDecimal getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(java.math.BigDecimal acrescimo) {
        this.acrescimo = acrescimo;
    }

    public String getNumeroCaixa() {
        return numeroCaixa;
    }

    public void setNumeroCaixa(String numeroCaixa) {
        this.numeroCaixa = numeroCaixa;
    }

    public java.util.List<PanamahVendaItens> getItens() {
        return itens;
    }

    public void setItens(java.util.List<PanamahVendaItens> itens) {
        this.itens = itens;
    }

    public java.util.List<PanamahVendaPagamentos> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(java.util.List<PanamahVendaPagamentos> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public void validate() throws Exception {
        if (this.id == null)
            throw new Exception("id não pode ser nulo!");
        if (this.lojaId == null)
            throw new Exception("lojaId não pode ser nulo!");
        if (this.data == null)
            throw new Exception("data não pode ser nulo!");
        if (this.dataHoraVenda == null)
            throw new Exception("dataHoraVenda não pode ser nulo!");
        if (this.efetiva == null)
            throw new Exception("efetiva não pode ser nulo!");
        if (this.quantidadeItens == null)
            throw new Exception("quantidadeItens não pode ser nulo!");
        if (this.sequencial == null)
            throw new Exception("sequencial não pode ser nulo!");
        if (this.tipoPreco == null)
            throw new Exception("tipoPreco não pode ser nulo!");
        if (this.valor == null)
            throw new Exception("valor não pode ser nulo!");
        if (this.itens == null)
            throw new Exception("itens não pode ser nulo!");
        if (this.pagamentos == null)
            throw new Exception("pagamentos não pode ser nulo!");
    }
}
