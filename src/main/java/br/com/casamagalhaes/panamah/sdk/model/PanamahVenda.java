
package br.com.casamagalhaes.panamah.sdk.model;

public class PanamahVenda {

	public PanamahVenda() {
	}

	public PanamahVenda(String id) {
		this.id = id;
	}

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

	private String clienteId;

	public String getClienteId() {
		return clienteId;
	}

	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	private String funcionarioId;

	public String getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(String funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	private java.util.Date data;

	public java.util.Date getData() {
		return data;
	}

	public void setData(java.util.Date data) {
		this.data = data;
	}

	private java.util.Date dataHoraInicio;

	public java.util.Date getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(java.util.Date dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	private java.util.Date dataHoraFim;

	public java.util.Date getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(java.util.Date dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}

	private java.util.Date dataHoraVenda;

	public java.util.Date getDataHoraVenda() {
		return dataHoraVenda;
	}

	public void setDataHoraVenda(java.util.Date dataHoraVenda) {
		this.dataHoraVenda = dataHoraVenda;
	}

	private Double desconto;

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	private Boolean efetiva;

	public Boolean getEfetiva() {
		return efetiva;
	}

	public void setEfetiva(Boolean efetiva) {
		this.efetiva = efetiva;
	}

	private Double quantidadeItens;

	public Double getQuantidadeItens() {
		return quantidadeItens;
	}

	public void setQuantidadeItens(Double quantidadeItens) {
		this.quantidadeItens = quantidadeItens;
	}

	private Double quantidadeItensCancelados;

	public Double getQuantidadeItensCancelados() {
		return quantidadeItensCancelados;
	}

	public void setQuantidadeItensCancelados(Double quantidadeItensCancelados) {
		this.quantidadeItensCancelados = quantidadeItensCancelados;
	}

	private String sequencial;

	public String getSequencial() {
		return sequencial;
	}

	public void setSequencial(String sequencial) {
		this.sequencial = sequencial;
	}

	private Double servico;

	public Double getServico() {
		return servico;
	}

	public void setServico(Double servico) {
		this.servico = servico;
	}

	private String tipoDesconto;

	public String getTipoDesconto() {
		return tipoDesconto;
	}

	public void setTipoDesconto(String tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}

	private String tipoPreco;

	public String getTipoPreco() {
		return tipoPreco;
	}

	public void setTipoPreco(String tipoPreco) {
		this.tipoPreco = tipoPreco;
	}

	private Double valor;

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	private Double valorItensCancelados;

	public Double getValorItensCancelados() {
		return valorItensCancelados;
	}

	public void setValorItensCancelados(Double valorItensCancelados) {
		this.valorItensCancelados = valorItensCancelados;
	}

	private Double acrescimo;

	public Double getAcrescimo() {
		return acrescimo;
	}

	public void setAcrescimo(Double acrescimo) {
		this.acrescimo = acrescimo;
	}

	private String numeroCaixa;

	public String getNumeroCaixa() {
		return numeroCaixa;
	}

	public void setNumeroCaixa(String numeroCaixa) {
		this.numeroCaixa = numeroCaixa;
	}

	private java.util.List<PanamahVendaItens> itens;

	public java.util.List<PanamahVendaItens> getItens() {
		return itens;
	}

	public void setItens(java.util.List<PanamahVendaItens> itens) {
		this.itens = itens;
	}

	private java.util.List<PanamahVendaPagamentos> pagamentos;

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
