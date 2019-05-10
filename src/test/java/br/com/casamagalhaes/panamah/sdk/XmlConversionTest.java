package br.com.casamagalhaes.panamah.sdk;

import java.io.InputStream;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import br.com.casamagalhaes.panamah.sdk.nfe.Evento;

public class XmlConversionTest {

	private InputStream x(String res) throws Exception {
		return XmlConversionTest.class.getResourceAsStream("resources/xml/" + res + ".xml");
	}

	@Test
	public void shouldWriteEvento() throws Exception {
		Evento e = new Evento();
		XStream x = PanamahUtil.buildXStream();
		String xml = x.toXML(e);
		System.out.println(xml);
	}

	@Test
	public void shoudReadEvento() throws Exception {
		try (InputStream in = x("ID1101111319050712894500013265508100000090100000004001")) {
			XStream x = PanamahUtil.buildXStream();
			Evento e = (Evento) x.fromXML(in);
			System.out.println(e);
		}
	}
}
