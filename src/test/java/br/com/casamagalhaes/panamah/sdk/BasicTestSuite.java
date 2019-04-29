package br.com.casamagalhaes.panamah.sdk;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BasicTestSuite {

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
}