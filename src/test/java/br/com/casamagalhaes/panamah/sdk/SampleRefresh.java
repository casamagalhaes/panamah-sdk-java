package br.com.casamagalhaes.panamah.sdk;

public class SampleRefresh {

	public static void main(String[] args) throws Exception {
		PanamahConfig config = PanamahConfig.fromProperties("teste");
		config.setDelay(100);
		PanamahStream.init(config);
		System.out.println(("pressione qualquer tecla para encerrar"));
		System.in.read();
	}

}
