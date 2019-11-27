package br.com.casamagalhaes.panamah.sdk;

import br.com.casamagalhaes.panamah.sdk.model.PanamahVenda;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;

public class VendasPanamahTest {

    private static PanamahConfig c = PanamahConfig.fromEnv("staging");

    private String r(String json) throws Exception {
        StringWriter w = new StringWriter();
        try (Reader reader = new InputStreamReader(
                VendasPanamahTest.class.getResourceAsStream("resources/" + json + ".json"))) {
            IOUtils.copy(reader, w);
        }
        return w.toString();
    }

    public class CenariosVendas {
        public ArrayList<PanamahVenda> vendas;
    }

    @Test
    public void deveCarregarVendas() throws Exception {
        CenariosVendas cenarios = PanamahUtil.buildGson().fromJson(r("cenarios-vendas"), CenariosVendas.class);
        Assert.assertNotNull(cenarios.vendas);
    }

    @Test
    public void deveEnviar10Vendas() throws Exception {
        CenariosVendas cenarios = PanamahUtil.buildGson().fromJson(r("cenarios-vendas"), CenariosVendas.class);

        PanamahStream p = PanamahStream.init(c);

        // hello java7
        for (PanamahVenda venda : cenarios.vendas) p.save(venda);

        p.flush(true);
    }

    @Test
    public void deveEnviar100Vendas() throws Exception {
        CenariosVendas cenarios = PanamahUtil.buildGson().fromJson(r("cenarios-vendas"), CenariosVendas.class);

        PanamahStream p = PanamahStream.init(c);

        int i = 10;
        while (i-- > 0) for (PanamahVenda venda : cenarios.vendas) p.save(venda);

        p.flush(true);
    }

    @Test
    public void deveEnviar1000Vendas() throws Exception {
        CenariosVendas cenarios = PanamahUtil.buildGson().fromJson(r("cenarios-vendas"), CenariosVendas.class);

        PanamahStream p = PanamahStream.init(c);

        int i = 100;
        while (i-- > 0) for (PanamahVenda venda : cenarios.vendas) p.save(venda);

        p.flush(true);
    }
}