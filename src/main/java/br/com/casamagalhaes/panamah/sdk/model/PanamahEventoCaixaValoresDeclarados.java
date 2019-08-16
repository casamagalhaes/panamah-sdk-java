
package br.com.casamagalhaes.panamah.sdk.model;

public class PanamahEventoCaixaValoresDeclarados {

	public PanamahEventoCaixaValoresDeclarados() {
	}

	private String formaPagamentoId;

	public String getFormaPagamentoId() {
		return formaPagamentoId;
	}

	public void setFormaPagamentoId(String formaPagamentoId) {
		this.formaPagamentoId = formaPagamentoId;
	}

	private java.math.BigDecimal valor;

	public java.math.BigDecimal getValor() {
		return valor;
	}

	public void setValor(java.math.BigDecimal valor) {
		this.valor = valor;
	}

	public void validate() throws Exception {
		if (this.formaPagamentoId == null)
			throw new Exception("formaPagamentoId não pode ser nulo!");
		if (this.valor == null)
			throw new Exception("valor não pode ser nulo!");
	}
}
