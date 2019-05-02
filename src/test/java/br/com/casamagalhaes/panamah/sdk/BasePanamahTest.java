package br.com.casamagalhaes.panamah.sdk;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BasePanamahTest {

    @Test
    public void shouldSayHello() {
        System.out.println("hello");
        assertTrue(true);
    }

    @Test
    public void shouldInit() {
        Panamah p = Panamah.init();
        assertNotNull(p);
    }

    @Test
    public void shouldFlush() {
        Panamah p = Panamah.init();
        p.flush();
        assertNotNull(p);
    }

    @Test
    public void shouldProgress() {
        Panamah p = Panamah.init();
        p.progress();
        assertNotNull(p);
    }

    @Test
    public void shouldSendAcesso() {
        
    	PanamahAcesso model = new PanamahAcesso();

        Panamah p = Panamah.init();
        p.send(model);
        assertTrue(true);
    }

    @Test
    public void shouldSendAssinante() {
        
    	PanamahAssinante model = new PanamahAssinante();

        Panamah p = Panamah.init();
        p.send(model);
        assertTrue(true);
    }

    @Test
    public void shouldSendCliente() {
        
    	PanamahCliente model = new PanamahCliente();

        Panamah p = Panamah.init();
        p.send(model);
        assertTrue(true);
    }

    @Test
    public void shouldSendCompra() {
        
    	PanamahCompra model = new PanamahCompra();

        Panamah p = Panamah.init();
        p.send(model);
        assertTrue(true);
    }

    @Test
    public void shouldSendEan() {
        
    	PanamahEan model = new PanamahEan();

        Panamah p = Panamah.init();
        p.send(model);
        assertTrue(true);
    }

    @Test
    public void shouldSendEstoqueMovimentacao() {
        
    	PanamahEstoqueMovimentacao model = new PanamahEstoqueMovimentacao();

        Panamah p = Panamah.init();
        p.send(model);
        assertTrue(true);
    }

    @Test
    public void shouldSendEventoCaixa() {
        
    	PanamahEventoCaixa model = new PanamahEventoCaixa();

        Panamah p = Panamah.init();
        p.send(model);
        assertTrue(true);
    }

    @Test
    public void shouldSendFormaPagamento() {
        
    	PanamahFormaPagamento model = new PanamahFormaPagamento();

        Panamah p = Panamah.init();
        p.send(model);
        assertTrue(true);
    }

    @Test
    public void shouldSendFornecedor() {
        
    	PanamahFornecedor model = new PanamahFornecedor();

        Panamah p = Panamah.init();
        p.send(model);
        assertTrue(true);
    }

    @Test
    public void shouldSendFuncionario() {
        
    	PanamahFuncionario model = new PanamahFuncionario();

        Panamah p = Panamah.init();
        p.send(model);
        assertTrue(true);
    }

    @Test
    public void shouldSendGrupo() {
        
    	PanamahGrupo model = new PanamahGrupo();

        Panamah p = Panamah.init();
        p.send(model);
        assertTrue(true);
    }

    @Test
    public void shouldSendHolding() {
        
    	PanamahHolding model = new PanamahHolding();

        Panamah p = Panamah.init();
        p.send(model);
        assertTrue(true);
    }

    @Test
    public void shouldSendLocalEstoque() {
        
    	PanamahLocalEstoque model = new PanamahLocalEstoque();

        Panamah p = Panamah.init();
        p.send(model);
        assertTrue(true);
    }

    @Test
    public void shouldSendLoja() {
        
    	PanamahLoja model = new PanamahLoja();

        Panamah p = Panamah.init();
        p.send(model);
        assertTrue(true);
    }

    @Test
    public void shouldSendMeta() {
        
    	PanamahMeta model = new PanamahMeta();

        Panamah p = Panamah.init();
        p.send(model);
        assertTrue(true);
    }

    @Test
    public void shouldSendProduto() {
        
    	PanamahProduto model = new PanamahProduto();

        Panamah p = Panamah.init();
        p.send(model);
        assertTrue(true);
    }

    @Test
    public void shouldSendRevenda() {
        
    	PanamahRevenda model = new PanamahRevenda();

        Panamah p = Panamah.init();
        p.send(model);
        assertTrue(true);
    }

    @Test
    public void shouldSendSecao() {
        
    	PanamahSecao model = new PanamahSecao();

        Panamah p = Panamah.init();
        p.send(model);
        assertTrue(true);
    }

    @Test
    public void shouldSendSubgrupo() {
        
    	PanamahSubgrupo model = new PanamahSubgrupo();

        Panamah p = Panamah.init();
        p.send(model);
        assertTrue(true);
    }

    @Test
    public void shouldSendTituloPagar() {
        
        PanamahTituloPagar model = new PanamahTituloPagar();

        Panamah p = Panamah.init();
        p.send(model);
        assertTrue(true);
    }

    @Test
    public void shouldSendTituloReceber() {
        
        PanamahTituloReceber model = new PanamahTituloReceber();

        Panamah p = Panamah.init();
        p.send(model);
        assertTrue(true);
    }

    @Test
    public void shouldSendTrocaDevolucao() {
        
        PanamahTrocaDevolucao model = new PanamahTrocaDevolucao();

        Panamah p = Panamah.init();
        p.send(model);
        assertTrue(true);
    }

    @Test
    public void shouldSendVenda() {
        
        PanamahVenda model = new PanamahVenda();

        Panamah p = Panamah.init();
        p.send(model);
        assertTrue(true);
    }

    
}