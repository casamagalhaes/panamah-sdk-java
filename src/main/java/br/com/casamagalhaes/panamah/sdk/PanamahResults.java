package br.com.casamagalhaes.panamah.sdk;

import java.util.List;

public class PanamahResults {

	private Integer total;
	private List<PanamahRetornoItem> itens;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<PanamahRetornoItem> getItens() {
		return itens;
	}

	public void setItens(List<PanamahRetornoItem> itens) {
		this.itens = itens;
	}

}
