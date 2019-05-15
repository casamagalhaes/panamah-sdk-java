package br.com.casamagalhaes.panamah.sdk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import br.com.casamagalhaes.panamah.sdk.nfe.CanonicalizationMethod;
import br.com.casamagalhaes.panamah.sdk.nfe.Det;
import br.com.casamagalhaes.panamah.sdk.nfe.DetPag;
import br.com.casamagalhaes.panamah.sdk.nfe.DigestMethod;
import br.com.casamagalhaes.panamah.sdk.nfe.Emit;
import br.com.casamagalhaes.panamah.sdk.nfe.EnderEmit;
import br.com.casamagalhaes.panamah.sdk.nfe.Evento;
import br.com.casamagalhaes.panamah.sdk.nfe.Icms;
import br.com.casamagalhaes.panamah.sdk.nfe.IcmsSn102;
import br.com.casamagalhaes.panamah.sdk.nfe.IcmsTot;
import br.com.casamagalhaes.panamah.sdk.nfe.Ide;
import br.com.casamagalhaes.panamah.sdk.nfe.Imposto;
import br.com.casamagalhaes.panamah.sdk.nfe.InfEvento;
import br.com.casamagalhaes.panamah.sdk.nfe.InfNFe;
import br.com.casamagalhaes.panamah.sdk.nfe.InfNFeSupl;
import br.com.casamagalhaes.panamah.sdk.nfe.InfProt;
import br.com.casamagalhaes.panamah.sdk.nfe.KeyInfo;
import br.com.casamagalhaes.panamah.sdk.nfe.NFe;
import br.com.casamagalhaes.panamah.sdk.nfe.NFeProc;
import br.com.casamagalhaes.panamah.sdk.nfe.Pag;
import br.com.casamagalhaes.panamah.sdk.nfe.Prod;
import br.com.casamagalhaes.panamah.sdk.nfe.ProtNFe;
import br.com.casamagalhaes.panamah.sdk.nfe.Reference;
import br.com.casamagalhaes.panamah.sdk.nfe.Signature;
import br.com.casamagalhaes.panamah.sdk.nfe.SignatureMethod;
import br.com.casamagalhaes.panamah.sdk.nfe.SignedInfo;
import br.com.casamagalhaes.panamah.sdk.nfe.Total;
import br.com.casamagalhaes.panamah.sdk.nfe.Transform;
import br.com.casamagalhaes.panamah.sdk.nfe.Transforms;
import br.com.casamagalhaes.panamah.sdk.nfe.Transp;
import br.com.casamagalhaes.panamah.sdk.nfe.X509Data;

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
		p.getNfe().getInfNFe().getDet().get(1).setImposto(new Imposto());
		p.getNfe().getInfNFe().getDet().get(1).getImposto().setvTotTrib(1.2);
		p.getNfe().getInfNFe().getDet().get(1).getImposto().setIcms(new Icms());
		p.getNfe().getInfNFe().getDet().get(1).getImposto().getIcms().setIcmsSn102(new IcmsSn102());
		p.getNfe().getInfNFe().getDet().get(1).getImposto().getIcms().getIcmsSn102().setCsosn(1);
		p.getNfe().getInfNFe().getDet().get(1).getImposto().getIcms().getIcmsSn102().setOrig(1);
		p.getNfe().getInfNFe().setTotal(new Total());
		p.getNfe().getInfNFe().getTotal().setIcmsTot(new IcmsTot());
		p.getNfe().getInfNFe().getTotal().getIcmsTot().setvBCST(1.1);
		p.getNfe().getInfNFe().setTransp(new Transp());
		p.getNfe().getInfNFe().getTransp().setModFrete(1);
		p.getNfe().getInfNFe().setPag(new Pag());
		p.getNfe().getInfNFe().getPag().setvTroco(1.1);
		p.getNfe().getInfNFe().getPag().setDetPag(new DetPag());
		p.getNfe().getInfNFe().getPag().getDetPag().settPag("aaa");
		p.getNfe().getInfNFe().getPag().getDetPag().setvPag(1.1);
		p.getNfe().setInfNFeSupl(new InfNFeSupl());
		p.getNfe().getInfNFeSupl().setQrCode("");
		p.getNfe().setSignature(new Signature());
		p.getNfe().getSignature().setSignedInfo(new SignedInfo());
		p.getNfe().getSignature().getSignedInfo().setCanonicalizationMethod(new CanonicalizationMethod());
		p.getNfe().getSignature().getSignedInfo().setSignatureMethod(new SignatureMethod());
		p.getNfe().getSignature().getSignedInfo().setReference(new Reference());
		p.getNfe().getSignature().getSignedInfo().getReference()
				.setUri("#NFe13190507128945000132652340000000099000000079");
		p.getNfe().getSignature().getSignedInfo().getReference().setTransforms(new Transforms());
		p.getNfe().getSignature().getSignedInfo().getReference().getTransforms()
				.setTransform(new ArrayList<Transform>());
		p.getNfe().getSignature().getSignedInfo().getReference().getTransforms().getTransform().add(new Transform());
		p.getNfe().getSignature().getSignedInfo().getReference().getTransforms().getTransform().get(0)
				.setAlgorithm("http://www.w3.org/2000/09/xmldsig#enveloped-signature");
		p.getNfe().getSignature().getSignedInfo().getReference().setDigestMethod(new DigestMethod());
		p.getNfe().getSignature().getSignedInfo().getReference().getDigestMethod()
				.setAlgorithm("http://www.w3.org/2000/09/xmldsig#sha1");
		p.getNfe().getSignature().getSignedInfo().getReference().setDigestValue("asdfsgsdgds");
		p.getNfe().getSignature().setSignatureValue("dsafsdsdfgadsfsadf");
		p.getNfe().getSignature().setKeyInfo(new KeyInfo());
		p.getNfe().getSignature().getKeyInfo().setX509Data(new X509Data());
		p.getNfe().getSignature().getKeyInfo().getX509Data().setX509Certificate("ssdfgsgsdgsdg");
		p.setProtNFe(new ProtNFe());
		p.getProtNFe().setInfProt(new InfProt());
		p.getProtNFe().getInfProt().setcStat(3);

		XStream x = PanamahUtil.buildXStream();
		String xml = x.toXML(p);
		assertNotNull(xml);
//		System.out.println(xml);
	}

	@Test
	public void shouldReadNfe() throws Exception {

		NFe n = new NFe();
		n.setInfNFe(new InfNFe());
		n.getInfNFe().setId("NFe13190507128945000132652340000000099000000079");
		n.getInfNFe().setVersao("4.00");
		n.getInfNFe().setIde(new Ide());
		n.getInfNFe().getIde().setcDV(9);
		n.getInfNFe().getIde().setcUF(13);
		n.getInfNFe().setEmit(new Emit());
		n.getInfNFe().getEmit().setCnpj("07128945000132");
		n.getInfNFe().getEmit().setEnderEmit(new EnderEmit());
		n.getInfNFe().getEmit().getEnderEmit().setUF("AM");
		n.getInfNFe().getEmit().getEnderEmit().setCEP("69028302");
		n.getInfNFe().getEmit().setCrt("1");
		n.getInfNFe().setDet(new ArrayList<Det>());
		n.getInfNFe().getDet().add(new Det());
		n.getInfNFe().getDet().get(0).setnItem(1);
		n.getInfNFe().getDet().add(new Det());
		n.getInfNFe().getDet().get(1).setnItem(2);
		n.getInfNFe().getDet().get(1).setProd(new Prod());
		n.getInfNFe().getDet().get(1).getProd().setcEAN("SEM GTIN");
		n.getInfNFe().getDet().get(1).setImposto(new Imposto());
		n.getInfNFe().getDet().get(1).getImposto().setvTotTrib(1.2);
		n.getInfNFe().getDet().get(1).getImposto().setIcms(new Icms());
		n.getInfNFe().getDet().get(1).getImposto().getIcms().setIcmsSn102(new IcmsSn102());
		n.getInfNFe().getDet().get(1).getImposto().getIcms().getIcmsSn102().setCsosn(1);
		n.getInfNFe().getDet().get(1).getImposto().getIcms().getIcmsSn102().setOrig(1);
		n.getInfNFe().setTotal(new Total());
		n.getInfNFe().getTotal().setIcmsTot(new IcmsTot());
		n.getInfNFe().getTotal().getIcmsTot().setvBCST(1.1);
		n.getInfNFe().setTransp(new Transp());
		n.getInfNFe().getTransp().setModFrete(1);
		n.getInfNFe().setPag(new Pag());
		n.getInfNFe().getPag().setvTroco(1.1);
		n.getInfNFe().getPag().setDetPag(new DetPag());
		n.getInfNFe().getPag().getDetPag().settPag("aaa");
		n.getInfNFe().getPag().getDetPag().setvPag(1.1);
		n.setInfNFeSupl(new InfNFeSupl());
		n.getInfNFeSupl().setQrCode("");
		n.setSignature(new Signature());
		n.getSignature().setSignedInfo(new SignedInfo());
		n.getSignature().getSignedInfo().setCanonicalizationMethod(new CanonicalizationMethod());
		n.getSignature().getSignedInfo().setSignatureMethod(new SignatureMethod());
		n.getSignature().getSignedInfo().setReference(new Reference());
		n.getSignature().getSignedInfo().getReference().setUri("#NFe13190507128945000132652340000000099000000079");
		n.getSignature().getSignedInfo().getReference().setTransforms(new Transforms());
		n.getSignature().getSignedInfo().getReference().getTransforms().setTransform(new ArrayList<Transform>());
		n.getSignature().getSignedInfo().getReference().getTransforms().getTransform().add(new Transform());
		n.getSignature().getSignedInfo().getReference().getTransforms().getTransform().get(0)
				.setAlgorithm("http://www.w3.org/2000/09/xmldsig#enveloped-signature");
		n.getSignature().getSignedInfo().getReference().setDigestMethod(new DigestMethod());
		n.getSignature().getSignedInfo().getReference().getDigestMethod()
				.setAlgorithm("http://www.w3.org/2000/09/xmldsig#sha1");
		n.getSignature().getSignedInfo().getReference().setDigestValue("asdfsgsdgds");
		n.getSignature().setSignatureValue("dsafsdsdfgadsfsadf");
		n.getSignature().setKeyInfo(new KeyInfo());
		n.getSignature().getKeyInfo().setX509Data(new X509Data());
		n.getSignature().getKeyInfo().getX509Data().setX509Certificate("ssdfgsgsdgsdg");

		XStream x = PanamahUtil.buildXStream();
		String xml = x.toXML(n);
		assertNotNull(xml);
//		System.out.println(xml);
	}
}
