package br.com.casamagalhaes.panamah.sdk;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class PendingPanamahTest {

	private String s = "{"//
			+ "\"00934509022\":{"//
				+ "\"LOJA\":[\"111\"],"//
				+ "\"PRODUTO\":[\"1\"],"//
				+ "\"SECAO\":[\"xxxx\"]"//
			+ "},"//
			+ "\"00004577011\":{"//
				+ "\"LOJA\":[\"222\"],"//
				+ "\"SECAO\":[\"yyy\"]"//
			+ "}"//
		+ "}";//

	private PanamahConfig c = PanamahConfig.fromEnv("staging");

	@Test
	public void shouldListPendingResources() throws Exception {
		PanamahUtil.auth(c);
		HashMap<String, PanamahPendencias> s = PanamahUtil.pending(c, 1, 10);
		assertNotNull(s);
	}

	@Test
	public void shouldBuildPanamahPendencias() throws Exception {
		Map<String,PanamahPendencias> p = PanamahUtil.convertMap(s);
		System.out.println(p);
	}
}
