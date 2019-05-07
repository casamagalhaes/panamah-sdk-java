package br.com.casamagalhaes.panamah.sdk;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import br.com.casamagalhaes.panamah.sdk.model.PanamahAcesso;
import br.com.casamagalhaes.panamah.sdk.model.PanamahAssinante;
import br.com.casamagalhaes.panamah.sdk.model.PanamahCliente;
import br.com.casamagalhaes.panamah.sdk.model.PanamahCompra;
import br.com.casamagalhaes.panamah.sdk.model.PanamahEan;
import br.com.casamagalhaes.panamah.sdk.model.PanamahEstoqueMovimentacao;
import br.com.casamagalhaes.panamah.sdk.model.PanamahEventoCaixa;
import br.com.casamagalhaes.panamah.sdk.model.PanamahFormaPagamento;
import br.com.casamagalhaes.panamah.sdk.model.PanamahFornecedor;
import br.com.casamagalhaes.panamah.sdk.model.PanamahFuncionario;
import br.com.casamagalhaes.panamah.sdk.model.PanamahGrupo;
import br.com.casamagalhaes.panamah.sdk.model.PanamahHolding;
import br.com.casamagalhaes.panamah.sdk.model.PanamahLocalEstoque;
import br.com.casamagalhaes.panamah.sdk.model.PanamahLoja;
import br.com.casamagalhaes.panamah.sdk.model.PanamahMeta;
import br.com.casamagalhaes.panamah.sdk.model.PanamahProduto;
import br.com.casamagalhaes.panamah.sdk.model.PanamahRevenda;
import br.com.casamagalhaes.panamah.sdk.model.PanamahSecao;
import br.com.casamagalhaes.panamah.sdk.model.PanamahSubgrupo;
import br.com.casamagalhaes.panamah.sdk.model.PanamahTituloPagar;
import br.com.casamagalhaes.panamah.sdk.model.PanamahTituloReceber;
import br.com.casamagalhaes.panamah.sdk.model.PanamahTrocaDevolucao;
import br.com.casamagalhaes.panamah.sdk.model.PanamahTrocaFormaPagamento;
import br.com.casamagalhaes.panamah.sdk.model.PanamahVenda;

public class BasePanamahTest {

	private PanamahConfig c = new PanamahConfig();

	@Test
	public void shouldInit() throws Exception {
		Panamah p = Panamah.init(c);
		p.flush();
		assertNotNull(p);
	}

	@Test
	public void shouldProgress() throws Exception {
		Panamah p = Panamah.init(c);
		p.progress();
		p.flush();
		assertNotNull(p);
	}

	@Test
	public void shouldVerifyFechamento() throws Exception {
		Panamah p = Panamah.init(c);
		p.getTask().verificaFechamento();
		p.flush();
		assertNotNull(p);
	}

	@Test
	public void shouldRun() throws Exception {
		Panamah p = Panamah.init(c);
		p.getTask().run();
		p.flush();
		assertNotNull(p);
	}

	@Test
	public void shouldSendAcesso() throws Exception {
		PanamahAcesso model = new PanamahAcesso();
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendAssinante() throws Exception {
		PanamahAssinante model = new PanamahAssinante();
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendCliente() throws Exception {
		PanamahCliente model = new PanamahCliente();
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendCompra() throws Exception {
		PanamahCompra model = new PanamahCompra();
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendEan() throws Exception {
		PanamahEan model = new PanamahEan();
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendEstoqueMovimentacao() throws Exception {
		PanamahEstoqueMovimentacao model = new PanamahEstoqueMovimentacao();
		model.setId("teste");
		model.setLocalEstoqueId("teste");
		model.setDataHora(new Date());
		model.setProdutoId("teste");
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendEventoCaixa() throws Exception {
		PanamahEventoCaixa model = new PanamahEventoCaixa();
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendFormaPagamento() throws Exception {
		PanamahFormaPagamento model = new PanamahFormaPagamento();
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendFornecedor() throws Exception {
		PanamahFornecedor model = new PanamahFornecedor();
		model.setId("teste");
		model.setNome("teste");
		model.setNumeroDocumento("teste");
		model.setRamo("teste");
		model.setUf("teste");
		model.setCidade("teste");
		model.setBairro("teste");
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendFuncionario() throws Exception {
		PanamahFuncionario model = new PanamahFuncionario();
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendGrupo() throws Exception {
		PanamahGrupo model = new PanamahGrupo();
		Panamah p = Panamah.init(c);
		p.send(model);
		assertTrue(true);
	}

	@Test
	public void shouldSendHolding() throws Exception {
		PanamahHolding model = new PanamahHolding();
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendLocalEstoque() throws Exception {
		PanamahLocalEstoque model = new PanamahLocalEstoque();
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendLoja() throws Exception {
		PanamahLoja model = new PanamahLoja();
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendMeta() throws Exception {
		PanamahMeta model = new PanamahMeta();
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendProduto() throws Exception {
		PanamahProduto model = new PanamahProduto();
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendRevenda() throws Exception {
		PanamahRevenda model = new PanamahRevenda();
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendSecao() throws Exception {
		PanamahSecao model = new PanamahSecao();
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendSubgrupo() throws Exception {
		PanamahSubgrupo model = new PanamahSubgrupo();
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendTituloPagar() throws Exception {
		PanamahTituloPagar model = new PanamahTituloPagar();
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendTituloReceber() throws Exception {
		PanamahTituloReceber model = new PanamahTituloReceber();
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendTrocaDevolucao() throws Exception {
		PanamahTrocaDevolucao model = new PanamahTrocaDevolucao();
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendTrocaFormaPagamento() throws Exception {
		PanamahTrocaFormaPagamento model = new PanamahTrocaFormaPagamento();
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendVenda() throws Exception {
		PanamahVenda model = new PanamahVenda();
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

}