package br.com.casamagalhaes.panamah.sdk;

import br.com.casamagalhaes.panamah.sdk.model.PanamahVenda;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertTrue;

public class DateConversionTest {

    @Test
    public void shouldConvertDateWithoutTimezone() throws Exception {
        PanamahVenda venda = new PanamahVenda();
        Date d = new Date(1577467650567L);// 2019-12-27T17:27:30.567Z // 2019-12-27T17:27:30.567-0300
        venda.setDataHoraVenda(d);
        String result = PanamahUtil.buildGson().toJson(venda);
        assertTrue(result.contains("14:27:30"));
    }
}
