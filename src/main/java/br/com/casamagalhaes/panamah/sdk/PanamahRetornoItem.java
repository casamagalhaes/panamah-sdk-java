package br.com.casamagalhaes.panamah.sdk;

public class PanamahRetornoItem {

	private PanamahTipoModel tipo;
	private String op;
	private String id;

	public PanamahTipoModel getTipo() {
		return tipo;
	}

	public void setTipo(PanamahTipoModel tipo) {
		this.tipo = tipo;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
