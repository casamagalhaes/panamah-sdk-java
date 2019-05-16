package br.com.casamagalhaes.panamah.sdk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import br.com.casamagalhaes.panamah.sdk.model.PanamahCliente;

public class EventsPanamahTest {

	private PanamahConfig config = PanamahConfig.fromEnv("staging");

	private String r(String json) throws Exception {
		StringWriter w = new StringWriter();
		try (Reader reader = new InputStreamReader(
				BasePanamahTest.class.getResourceAsStream("resources/" + json + ".json"))) {
			IOUtils.copy(reader, w);
		}
		return w.toString();
	}

	@Test
	public void deveriaEspionarUmSalvamento() throws Exception {

		PanamahStream p = PanamahStream.init(config);
		p.setOnSave(new PanamahListener() {

			@Override
			public void notify(PanamahEvent panamahEvent) {
				assertEquals(panamahEvent, null);
			}
		});
		PanamahCliente model = PanamahUtil.buildGson().fromJson(r("cliente"), PanamahCliente.class);
		p.save(model);

		p.flush(true);

	}

	@Test
	public void deveriaCancelarUmSalvamento() throws Exception {

		PanamahStream p = PanamahStream.init(config);
		p.setOnSave(new PanamahListener() {

			@Override
			public void notify(PanamahEvent panamahEvent) {
				panamahEvent.setCancelled(true);
			}
		});
		PanamahCliente model = PanamahUtil.buildGson().fromJson(r("cliente"), PanamahCliente.class);
		p.save(model);
		assertNull(p.getTask().getLoteAtual());
		p.flush();

	}
}
