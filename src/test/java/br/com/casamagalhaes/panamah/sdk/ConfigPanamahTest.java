package br.com.casamagalhaes.panamah.sdk;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ConfigPanamahTest {

	@Test
	public void shouldLoadFromEnv() throws Exception {
		PanamahConfig c = PanamahConfig.fromEnv();
		assertNotNull(c.getEnv());
	}
	
	@Test
	public void shouldLoadFromProps() throws Exception {
		PanamahConfig c = PanamahConfig.fromProperties("application-sample");
		assertNotNull(c.getEnv());
	}
	
	@Test
	public void shouldAutoConfigure() throws Exception {
		PanamahConfig c = PanamahConfig.autoConfigure();
		assertNotNull(c.getEnv());
	}
}
