package br.com.casamagalhaes.panamah.sdk;

import br.com.casamagalhaes.panamah.sdk.model.PanamahEan;

public class SampleRefresh {

	public static void main(String[] args) throws Exception {
		// System.out.println("Teste de refresh de conexão");
		PanamahConfig config = PanamahConfig.fromEnv("staging");
		config.setTtl(15000);
		PanamahStream p = PanamahStream.init(config);
		int i = 1000000;
		while (i-->0) {
			PanamahEan ean = new PanamahEan();
			ean.setId("1");
			ean.setProdutoId("1");
			p.save(ean);
//			Thread.sleep(1);
		}
	}

}
