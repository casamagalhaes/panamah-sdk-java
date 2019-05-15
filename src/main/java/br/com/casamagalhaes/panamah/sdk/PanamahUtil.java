package br.com.casamagalhaes.panamah.sdk;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;

import br.com.casamagalhaes.panamah.sdk.model.PanamahAssinante;
import br.com.casamagalhaes.panamah.sdk.nfe.CanonicalizationMethod;
import br.com.casamagalhaes.panamah.sdk.nfe.Dest;
import br.com.casamagalhaes.panamah.sdk.nfe.Det;
import br.com.casamagalhaes.panamah.sdk.nfe.DigestMethod;
import br.com.casamagalhaes.panamah.sdk.nfe.Emit;
import br.com.casamagalhaes.panamah.sdk.nfe.EnderDest;
import br.com.casamagalhaes.panamah.sdk.nfe.Evento;
import br.com.casamagalhaes.panamah.sdk.nfe.Icms;
import br.com.casamagalhaes.panamah.sdk.nfe.IcmsSn102;
import br.com.casamagalhaes.panamah.sdk.nfe.Imposto;
import br.com.casamagalhaes.panamah.sdk.nfe.InfEvento;
import br.com.casamagalhaes.panamah.sdk.nfe.InfNFe;
import br.com.casamagalhaes.panamah.sdk.nfe.KeyInfo;
import br.com.casamagalhaes.panamah.sdk.nfe.NFe;
import br.com.casamagalhaes.panamah.sdk.nfe.NFeProc;
import br.com.casamagalhaes.panamah.sdk.nfe.Prod;
import br.com.casamagalhaes.panamah.sdk.nfe.Reference;
import br.com.casamagalhaes.panamah.sdk.nfe.Signature;
import br.com.casamagalhaes.panamah.sdk.nfe.SignatureMethod;
import br.com.casamagalhaes.panamah.sdk.nfe.SignedInfo;
import br.com.casamagalhaes.panamah.sdk.nfe.Total;
import br.com.casamagalhaes.panamah.sdk.nfe.Transform;
import br.com.casamagalhaes.panamah.sdk.nfe.Transforms;
import br.com.casamagalhaes.panamah.sdk.nfe.X509Data;

public class PanamahUtil {

	public static String stamp(Date d) {
		return new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS").format(d);
	}

	public static Gson buildGson() {
		return new GsonBuilder().registerTypeAdapter(Date.class, new GsonUTCDateAdapter()).create();
	}

	// https://hc.apache.org/httpcomponents-client-ga/tutorial/html/fluent.html
	public static String send(PanamahConfig config, PanamahLote lote) throws ClientProtocolException, IOException {
		String req = buildGson().toJson(lote.getOperacoes());
		String res = Request.Post(config.getAddr() + "/stream/data")//
				.bodyString(req, ContentType.APPLICATION_JSON)//
//				.addHeader("x-api-key", config.getAuth().getKey())//
//				.addHeader("x-api-access-token", config.getAuth().getAccessToken())//
				.addHeader("Authorization", config.getAuth().getAuthorizationToken())//
				.execute().returnContent().asString();
		return res;
	}

	public static void auth(PanamahConfig config) throws ClientProtocolException, IOException, PanamahException {
		String req = buildGson().toJson(config.getAuth());

		HttpResponse re = Request.Post(config.getAddr() + "/stream/auth")//
				.bodyString(req, ContentType.APPLICATION_JSON)//
				.addHeader("Authorization", config.getAuth().getAuthorizationToken())//
				.execute().returnResponse();

		String res = null;
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
			re.getEntity().writeTo(baos);
			res = baos.toString();
		}
		int status = re.getStatusLine().getStatusCode();
		if (status >= 400)
			throw new PanamahException(status, res);

		PanamahAuth auth = buildGson().fromJson(res, PanamahAuth.class);
		config.setAuth(auth);
	}

	public static void createAssinante(PanamahConfig config) throws ClientProtocolException, IOException {
		String req = buildGson().toJson(config.getAuth().getAssinante());
		String res = Request.Post(config.getAddr() + "/admin/assinantes")//
				.bodyString(req, ContentType.APPLICATION_JSON)//
				.addHeader("Authorization", config.getAuth().getAuthorizationToken())//
				.execute().returnContent().asString();
		PanamahAssinante assinante = buildGson().fromJson(res, PanamahAssinante.class);
		config.getAuth().setAssinante(assinante);
	}

	public static void retrieveAssinante(PanamahConfig config, String assinanteId)
			throws ClientProtocolException, IOException {
		String res = Request.Get(config.getAddr() + "/admin/assinantes/" + assinanteId)//
				.addHeader("Authorization", config.getAuth().getAuthorizationToken())//
				.execute().returnContent().asString();
		PanamahAssinante assinante = buildGson().fromJson(res, PanamahAssinante.class);
		config.getAuth().setAssinante(assinante);
	}

	public static XStream buildXStream() throws Exception {
		XStream x = new XStream();
		// NFeProc
		x.alias("NFe", NFe.class);
		x.useAttributeFor(NFeProc.class, "versao");
		x.useAttributeFor(NFeProc.class, "xmlns");
		x.alias("nfeProc", NFeProc.class);
		x.aliasField("NFe", NFeProc.class, "nfe");
		x.useAttributeFor(NFe.class, "xmlns");
		x.useAttributeFor(InfNFe.class, "id");
		x.aliasAttribute(InfNFe.class, "id", "Id");
		x.useAttributeFor(InfNFe.class, "versao");
		x.aliasField("CNPJ", Emit.class, "cnpj");
		x.aliasField("CPF", Emit.class, "cpf");
		x.aliasField("IE", Emit.class, "ie");
		x.aliasField("IM", Emit.class, "im");
		x.aliasField("CRT", Emit.class, "crt");
		x.aliasField("CNPJ", Dest.class, "cnpj");
		x.aliasField("CPF", Dest.class, "cpf");
		x.aliasField("UF", EnderDest.class, "uf");
		x.addImplicitCollection(InfNFe.class, "det");
		x.alias("det", Det.class);
		x.alias("prod", Prod.class);
		x.alias("imposto", Imposto.class);
		x.useAttributeFor(Det.class, "nItem");
		x.aliasField("ICMS", Imposto.class, "icms");
		x.aliasField("ICMSSN102", Icms.class, "icmsSn102");
		x.aliasField("CSOSN", IcmsSn102.class, "csosn");
		x.aliasField("ICMSTot", Total.class, "icmsTot");
		x.aliasField("Signature", NFe.class, "signature");
		x.useAttributeFor(Signature.class, "xmlns");
		x.aliasField("SignedInfo", Signature.class, "signedInfo");
		x.aliasField("CanonicalizationMethod", SignedInfo.class, "canonicalizationMethod");
		x.useAttributeFor(CanonicalizationMethod.class, "algorithm");
		x.aliasAttribute(CanonicalizationMethod.class, "algorithm", "Algorithm");
		x.aliasField("SignatureMethod", SignedInfo.class, "signatureMethod");
		x.useAttributeFor(SignatureMethod.class, "algorithm");
		x.aliasAttribute(SignatureMethod.class, "algorithm", "Algorithm");
		x.aliasField("Reference", SignedInfo.class, "reference");
		x.useAttributeFor(Reference.class, "uri");
		x.aliasAttribute(Reference.class, "uri", "URI");
		x.aliasField("Transforms", Reference.class, "transforms");
		x.addImplicitCollection(Transforms.class, "transform", "Transform", Transform.class);
		x.useAttributeFor(Transform.class, "algorithm");
		x.aliasAttribute(Transform.class, "algorithm", "Algorithm");
		x.aliasField("DigestMethod", Reference.class, "digestMethod");
		x.useAttributeFor(DigestMethod.class, "algorithm");
		x.aliasAttribute(DigestMethod.class, "algorithm", "Algorithm");
		x.aliasField("DigestValue", Reference.class, "digestValue");
		x.aliasField("SignatureValue", Signature.class, "signatureValue");
		x.aliasField("KeyInfo", Signature.class, "keyInfo");
		x.aliasField("X509Data", KeyInfo.class, "x509Data");
		x.aliasField("X509Certificate", X509Data.class, "x509Certificate");

		// evento
		x.alias("evento", Evento.class);
		x.useAttributeFor(InfEvento.class, "id");
		x.aliasAttribute(InfEvento.class, "id", "Id");
//		x.aliasField("detEvento", InfEvento.class,"detEvento");
		x.registerConverter(new XStreamISODateConverter());
		return x;
	}
}
