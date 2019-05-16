package br.com.casamagalhaes.panamah.sdk;

import br.com.casamagalhaes.panamah.sdk.model.PanamahEan;

public class SampleRefresh {

	public static void main(String[] args) throws Exception {
		System.out.println("Teste de refresh de conexão");
		PanamahConfig config = PanamahConfig.fromEnv("staging");
		config.setTtl(10000);
		PanamahStream p = PanamahStream.init(config);
		int i = 0;
		while (i != 113) {
			System.out.println("pressione q para sair");
			System.out.println("pressione qualquer outra tecla para adicionar modelo ao lote");
			i = System.in.read();
			if (i != 113) {
				PanamahEan ean = new PanamahEan();
				ean.setId("1");
				ean.setProdutoId("1");
				p.save(ean);
			}
		}
	}

}
