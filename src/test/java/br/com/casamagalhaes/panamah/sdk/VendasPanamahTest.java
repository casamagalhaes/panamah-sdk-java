package br.com.casamagalhaes.panamah.sdk;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.ArrayList;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import br.com.casamagalhaes.panamah.sdk.model.PanamahVenda;

public class VendasPanamahTest {

  private String r(String json) throws Exception {
    StringWriter w = new StringWriter();
    try (Reader reader = new InputStreamReader(
        VendasPanamahTest.class.getResourceAsStream("resources/" + json + ".json"))) {
      IOUtils.copy(reader, w);
    }
    return w.toString();
  }

  public class CenariosVendas {
    public ArrayList<PanamahVenda>vendas;
  }

  @Test
  public void deveCarregarVendas() throws Exception {
    CenariosVendas cenarios = PanamahUtil.buildGson().fromJson(r("cenarios-vendas"), CenariosVendas.class);
    System.out.println(cenarios);
  }
}