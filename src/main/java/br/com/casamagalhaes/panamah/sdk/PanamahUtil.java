package br.com.casamagalhaes.panamah.sdk;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;

import br.com.casamagalhaes.panamah.sdk.nfe.Det;
import br.com.casamagalhaes.panamah.sdk.nfe.Emit;
import br.com.casamagalhaes.panamah.sdk.nfe.Evento;
import br.com.casamagalhaes.panamah.sdk.nfe.Icms;
import br.com.casamagalhaes.panamah.sdk.nfe.IcmsSn102;
import br.com.casamagalhaes.panamah.sdk.nfe.Imposto;
import br.com.casamagalhaes.panamah.sdk.nfe.InfEvento;
import br.com.casamagalhaes.panamah.sdk.nfe.KeyInfo;
import br.com.casamagalhaes.panamah.sdk.nfe.NFe;
import br.com.casamagalhaes.panamah.sdk.nfe.NFeProc;
import br.com.casamagalhaes.panamah.sdk.nfe.Reference;
import br.com.casamagalhaes.panamah.sdk.nfe.Signature;
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
		String res = Request.Post(config.getAddr())//
				.bodyString(buildGson().toJson(lote), ContentType.APPLICATION_JSON)//
				.addHeader("x-api-key", config.getApiKey())//
				.addHeader("x-api-access-token", config.getAccessToken())//
				.execute().returnContent().asString();
		return res;
	}

	public static void auth(PanamahConfig config) throws ClientProtocolException, IOException {
		String res = Request.Post(config.getAuthAddr())//
				.bodyString("{\"apiKey\":\"" + config.getApiKey() + "\"}", ContentType.APPLICATION_JSON)//
				.execute().returnContent().asString();
		PanamahAuth auth = buildGson().fromJson(res, PanamahAuth.class);
		config.setAccessToken(auth.getAccessToken());
		config.setRefreshToken(auth.getRefreshToken());
	}

	public static XStream buildXStream() throws Exception {
		XStream x = new XStream();
		// NFe
		x.alias("NFe", NFe.class);
		// NFeProc
		x.alias("nfeProc", NFeProc.class);
		x.aliasField("NFe", NFeProc.class, "nfe");
		x.aliasField("CNPJ", Emit.class, "cnpj");
		x.aliasField("IE", Emit.class, "ie");
		x.aliasField("IM", Emit.class, "im");
		x.aliasField("CRT", Emit.class, "crt");
		x.alias("det", Det.class);
		x.addImplicitCollection(Det.class, "det");
		x.useAttributeFor(Det.class, "nItem");
		x.aliasField("ICMS", Imposto.class, "icms");
		x.aliasField("ICMSSN102", Icms.class, "icmsSn102");
		x.aliasField("CSOSN", IcmsSn102.class, "csosn");
		x.aliasField("ICMSTot", Total.class, "icmsTot");
		x.aliasField("Signature", NFe.class, "signature");
		x.aliasField("SignedInfo", Signature.class, "signedInfo");
		x.aliasField("CanonicalizationMethod", SignedInfo.class, "canonicalizationMethod");
		x.aliasField("SignatureMethod", SignedInfo.class, "signatureMethod");
		x.aliasField("Reference", SignedInfo.class, "reference");
		x.aliasField("Transforms", Reference.class, "transforms");
		x.addImplicitCollection(Transforms.class, "transform", "Transform", Transform.class);
		x.aliasField("DigestMethod", Reference.class, "digestMethod");
		x.aliasField("DigestValue", Reference.class, "digestValue");
		x.aliasField("SignatureValue", Signature.class, "signatureValue");
		x.aliasField("KeyInfo", Signature.class, "keyInfo");
		x.aliasField("X509Data", KeyInfo.class, "x509Data");
		x.aliasField("X509Certificate", X509Data.class, "x509Certificate");

		// evento
		x.alias("evento", Evento.class);
		x.useAttributeFor(InfEvento.class, "id");
		x.aliasAttribute(InfEvento.class, "id", "Id");
		x.registerConverter(new XStreamISODateConverter());
		return x;
	}
}
