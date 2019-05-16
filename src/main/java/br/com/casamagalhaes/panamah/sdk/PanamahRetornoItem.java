package br.com.casamagalhaes.panamah.sdk;

public class PanamahRetornoItem {

	private PanamahTipoModel tipo;
	private PanamahTipoOperacao op;
	private String id;

	public PanamahTipoModel getTipo() {
		return tipo;
	}

	public void setTipo(PanamahTipoModel tipo) {
		this.tipo = tipo;
	}

	public PanamahTipoOperacao getOp() {
		return op;
	}

	public void setOp(PanamahTipoOperacao op) {
		this.op = op;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
