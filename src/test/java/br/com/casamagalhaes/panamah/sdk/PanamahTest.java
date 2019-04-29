package br.com.casamagalhaes.panamah.sdk;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PanamahTest {

    @Test
    public void shouldSayHello() {
        System.out.println("hello");
        assertTrue(true);
    }

    @Test
    public void shouldInitClient() {
        Panamah p = Panamah.init();
        assertNotNull(p);
    }

    @Test
    public void shouldFlushClient() {
        Panamah p = Panamah.init();
        p.flush();
        assertNotNull(p);
    }

    @Test
    public void shouldProgressClient() {
        Panamah p = Panamah.init();
        p.progress();
        assertNotNull(p);
    }

    @Test
    public void shouldSendVenda() {
        
        PanamahVenda venda = new PanamahVenda();

        Panamah p = Panamah.init();
        p.send(venda);
        assertTrue(true);
    }

    
}