package br.com.casamagalhaes.panamah.sdk;

import br.com.casamagalhaes.panamah.sdk.model.PanamahEan;

public class SampleRefresh {

	public static void main(String[] args) throws Exception {
		PanamahConfig config = PanamahConfig.fromEnv("staging");
		config.setMaxAgeSent(60000);
		config.setTtl(15000);
		PanamahStream p = PanamahStream.init(config);
		int i = 1000000;
		while (i-->0) {
			PanamahEan ean = new PanamahEan();
			ean.setId("1");
			ean.setProdutoId("1");
			p.save(ean);
			Thread.sleep(1000);
		}
	}

}
