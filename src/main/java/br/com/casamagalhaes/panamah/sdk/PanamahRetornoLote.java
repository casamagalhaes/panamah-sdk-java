package br.com.casamagalhaes.panamah.sdk;

public class PanamahRetornoLote {

	private PanamahResults sucessos;
	private PanamahResults falhas;

	public PanamahResults getSucessos() {
		return sucessos;
	}

	public void setSucessos(PanamahResults sucessos) {
		this.sucessos = sucessos;
	}
	
	public PanamahResults getFalhas() {
		return falhas;
	}
	
	public void setFalhas(PanamahResults falhas) {
		this.falhas = falhas;
	}

}
