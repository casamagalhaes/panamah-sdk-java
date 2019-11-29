package br.com.casamagalhaes.panamah.sdk;

import br.com.casamagalhaes.panamah.sdk.model.PanamahEan;

public class SampleRefresh {

	public static void main(String[] args) throws Exception {
		PanamahConfig config = PanamahConfig.fromProperties("teste");
		
		PanamahStream p = PanamahStream.init(config);
	
		System.out.println(("pressione qualquer tecla para encerrar"));

		config.setDelay(100);

		System.in.read();
	}

}
