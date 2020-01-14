package br.com.casamagalhaes.panamah.sdk;

import br.com.casamagalhaes.panamah.sdk.model.PanamahVenda;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;

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


    @Test
    public void deveEnviar100VendasDeAgoraMeioDia() throws Exception {
        CenariosVendas cenarios = PanamahUtil.buildGson().fromJson(r("cenarios-vendas"), CenariosVendas.class);

        PanamahStream p = PanamahStream.init(c);

        int i = 10;
        while (i-- > 0) for (PanamahVenda venda : cenarios.vendas) {
            PanamahVenda v = copyPraHora(venda, 12);
            p.save(v);
        }

        p.flush(true);
    }

    @Test
    public void deveEnviar300VendasDe11horas12horase13horas() throws Exception {
        CenariosVendas cenarios = PanamahUtil.buildGson().fromJson(r("cenarios-vendas"), CenariosVendas.class);

        PanamahStream p = PanamahStream.init(c);
        int i = 14;
        while(i-->11){
            int j = 10;
            while(j-->0) for (PanamahVenda venda : cenarios.vendas) {
                PanamahVenda v = copyPraHora(venda, i);
                p.save(v);
            }
        }
        p.flush(true);
    }

    private PanamahVenda copyPraHora(PanamahVenda venda, int horaDoDia) {
        Date inicio = new Date();
        inicio.setHours(horaDoDia);
        String s = PanamahUtil.buildGson().toJson(venda);
        PanamahVenda v = PanamahUtil.buildGson().fromJson(s, PanamahVenda.class);
        String id = "021795-006-9-"+System.nanoTime();
        Date fim = new Date(inicio.getTime());
        v.setId(id);
        v.setDataHoraInicio(inicio);
        v.setData(fim);
        v.setDataHoraVenda(fim);
        v.setDataHoraFim(fim);
        s = PanamahUtil.buildGson().toJson(v);
        System.out.println(s);
        return v;
    }
}