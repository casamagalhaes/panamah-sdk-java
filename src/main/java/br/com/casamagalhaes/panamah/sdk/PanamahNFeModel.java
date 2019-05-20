package br.com.casamagalhaes.panamah.sdk;

import br.com.casamagalhaes.panamah.sdk.model.PanamahCliente;
import br.com.casamagalhaes.panamah.sdk.model.PanamahLoja;
import br.com.casamagalhaes.panamah.sdk.model.PanamahVenda;

public class PanamahNFeModel {

	private PanamahLoja loja;
	private PanamahVenda venda;
	private PanamahCliente cliente;

	public PanamahLoja getLoja() {
		return loja;
	}

	public void setLoja(PanamahLoja loja) {
		this.loja = loja;
	}

	public PanamahVenda getVenda() {
		return venda;
	}

	public void setVenda(PanamahVenda venda) {
		this.venda = venda;
	}

	public PanamahCliente getCliente() {
		return cliente;
	}

	public void setCliente(PanamahCliente cliente) {
		this.cliente = cliente;
	}

}
