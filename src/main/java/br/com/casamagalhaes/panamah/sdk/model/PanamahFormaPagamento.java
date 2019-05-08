
package br.com.casamagalhaes.panamah.sdk.model;

public class PanamahFormaPagamento {

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void validate() throws Exception {
		if (this.id == null)
			throw new Exception("id não pode ser nulo!");
		if (this.descricao == null)
			throw new Exception("descricao não pode ser nulo!");
	}
}
