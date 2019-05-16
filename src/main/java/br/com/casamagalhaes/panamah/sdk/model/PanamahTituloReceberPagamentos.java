
package br.com.casamagalhaes.panamah.sdk.model;

public class PanamahTituloReceberPagamentos {

	public PanamahTituloReceberPagamentos() {
	}

	private java.util.Date dataHora;

	public java.util.Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(java.util.Date dataHora) {
		this.dataHora = dataHora;
	}

	private Double valor;

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public void validate() throws Exception {
		if (this.dataHora == null)
			throw new Exception("dataHora não pode ser nulo!");
		if (this.valor == null)
			throw new Exception("valor não pode ser nulo!");
	}
}
