package br.com.casamagalhaes.panamah.sdk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import br.com.casamagalhaes.panamah.sdk.nfe.Det;
import br.com.casamagalhaes.panamah.sdk.nfe.Emit;
import br.com.casamagalhaes.panamah.sdk.nfe.EnderEmit;
import br.com.casamagalhaes.panamah.sdk.nfe.Evento;
import br.com.casamagalhaes.panamah.sdk.nfe.Ide;
import br.com.casamagalhaes.panamah.sdk.nfe.InfEvento;
import br.com.casamagalhaes.panamah.sdk.nfe.InfNFe;
import br.com.casamagalhaes.panamah.sdk.nfe.NFe;
import br.com.casamagalhaes.panamah.sdk.nfe.NFeProc;
import br.com.casamagalhaes.panamah.sdk.nfe.Prod;

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
			assertEquals("07128945000132", procNfe.getNfe().getInfNFe().getEmit().getCnpj());
		}
	}

	@Test
	public void shouldWriteNfeProc() throws Exception {
		NFeProc p = new NFeProc();
		p.setVersao("4.00");
		p.setNfe(new NFe());
		p.getNfe().setInfNFe(new InfNFe());
		p.getNfe().getInfNFe().setId("NFe13190507128945000132652340000000099000000079");
		p.getNfe().getInfNFe().setVersao("4.00");
		p.getNfe().getInfNFe().setIde(new Ide());
		p.getNfe().getInfNFe().getIde().setcDV(9);
		p.getNfe().getInfNFe().getIde().setcUF(13);
		p.getNfe().getInfNFe().setEmit(new Emit());
		p.getNfe().getInfNFe().getEmit().setCnpj("07128945000132");
		p.getNfe().getInfNFe().getEmit().setEnderEmit(new EnderEmit());
		p.getNfe().getInfNFe().getEmit().getEnderEmit().setUF("AM");
		p.getNfe().getInfNFe().getEmit().getEnderEmit().setCEP("69028302");
		p.getNfe().getInfNFe().getEmit().setCrt("1");
		p.getNfe().getInfNFe().setDet(new ArrayList<Det>());
		p.getNfe().getInfNFe().getDet().add(new Det());
		p.getNfe().getInfNFe().getDet().get(0).setnItem(1);
		p.getNfe().getInfNFe().getDet().add(new Det());
		p.getNfe().getInfNFe().getDet().get(1).setnItem(2);
		p.getNfe().getInfNFe().getDet().get(1).setProd(new Prod());
		p.getNfe().getInfNFe().getDet().get(1).getProd().setcEAN("SEM GTIN");

		XStream x = PanamahUtil.buildXStream();
		String xml = x.toXML(p);
		assertNotNull(xml);
		System.out.println(xml);
	}
	
	@Test
	public void shouldReadNfe() throws Exception {
		
	}
}
