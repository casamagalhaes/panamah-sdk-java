package br.com.casamagalhaes.panamah.sdk;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;

import org.junit.Test;

import br.com.casamagalhaes.panamah.sdk.nfe.TNfeProc;

public class XmlConversionTest {

	private InputStream x(String res) throws Exception {
		return XmlConversionTest.class.getResourceAsStream("resources/xml/" + res + ".xml");
	}

	@Test
	@SuppressWarnings("unchecked")
	public void shouldReadNfeProc() throws Exception {
		JAXBContext ctx = JAXBContext.newInstance(TNfeProc.class);
		try (InputStream in = x("NFe13190507128945000132650340000000131000000115")) {
			JAXBElement<TNfeProc> o = (JAXBElement<TNfeProc>) ctx.createUnmarshaller().unmarshal(in);
			TNfeProc nfe = o.getValue();
			assertEquals("07128945000132", nfe.getNFe().getInfNFe().getEmit().getCNPJ());
		}
	}
}
