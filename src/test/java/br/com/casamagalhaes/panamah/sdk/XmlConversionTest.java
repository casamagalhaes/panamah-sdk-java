package br.com.casamagalhaes.panamah.sdk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.InputStream;
import java.util.Date;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import br.com.casamagalhaes.panamah.sdk.nfe.Evento;
import br.com.casamagalhaes.panamah.sdk.nfe.InfEvento;
import br.com.casamagalhaes.panamah.sdk.nfe.NFeProc;

public class XmlConversionTest {

	private InputStream x(String res) throws Exception {
		return XmlConversionTest.class.getResourceAsStream("resources/xml/" + res + ".xml");
	}

	@Test
	public void shoudReadEvento() throws Exception {
		String id = "ID1101111319050712894500013265508100000090100000004001";
		try (InputStream in = x(id)) {
			XStream x = PanamahUtil.buildXStream();
			Evento e = (Evento) x.fromXML(in);
			assertEquals(id, e.getInfEvento().getId());
		}
	}

	@Test
	public void shouldWriteEvento() throws Exception {
		Evento e = new Evento();
		InfEvento infEvento = new InfEvento();
		infEvento.setDhEvento(new Date());
		infEvento.setId("ID1101111319050712894500013265508100000090100000004001");
		e.setInfEvento(infEvento);
		XStream x = PanamahUtil.buildXStream();
		String xml = x.toXML(e);
		assertNotNull(xml);
	}
	
	@Test
	public void shouldReadNfeProc() throws Exception {
		String proc = "NFe13190507128945000132652340000000099000000079";
		try (InputStream in = x(proc)) {
			XStream x = PanamahUtil.buildXStream();
			NFeProc procNfe = (NFeProc) x.fromXML(in);
			
		}
	}
}
