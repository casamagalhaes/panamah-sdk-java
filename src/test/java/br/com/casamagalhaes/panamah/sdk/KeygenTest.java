package br.com.casamagalhaes.panamah.sdk;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KeygenTest {

	String expected = "{\"assinanteId\":\"1234567890\", \"key\":\"zIT6WjYfhqWJFp/eHk5tYrx4bmw=\", \"ts\":1234567890 }";

	@Test
	public void shouldGenerateCorrectKey() {
		PanamahAuth auth = new PanamahAuth();
		auth.setTs(1234567890);
		auth.setAccessToken("1234567890");
		auth.setKey("1234567890");
		auth.getAssinante().setId("1234567890");
		String b = auth.buildAuth(false);
		System.out.println(b);
		assertEquals(expected, b);
	}
}
