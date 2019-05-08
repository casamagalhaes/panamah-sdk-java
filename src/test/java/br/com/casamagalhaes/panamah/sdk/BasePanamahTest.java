package br.com.casamagalhaes.panamah.sdk;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.Date;

import org.apache.commons.io.IOUtils;
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

	private String r(String json) throws Exception {
		StringWriter w = new StringWriter();
		try (Reader reader = new InputStreamReader(
				BasePanamahTest.class.getResourceAsStream("resources/" + json + ".json"))) {
			IOUtils.copy(reader, w);
		}
		return w.toString();
	}

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
		PanamahAcesso model = PanamahUtil.buildGson().fromJson(r("acesso"), PanamahAcesso.class);
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendAssinante() throws Exception {
		PanamahAssinante model = PanamahUtil.buildGson().fromJson(r("assinante"), PanamahAssinante.class);
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendCliente() throws Exception {
		PanamahCliente model = PanamahUtil.buildGson().fromJson(r("cliente"), PanamahCliente.class);
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendCompra() throws Exception {
		PanamahCompra model = PanamahUtil.buildGson().fromJson(r("compra"), PanamahCompra.class);
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendEan() throws Exception {
		PanamahEan model = PanamahUtil.buildGson().fromJson(r("ean"), PanamahEan.class);
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendEstoqueMovimentacao() throws Exception {
		PanamahEstoqueMovimentacao model = PanamahUtil.buildGson().fromJson(r("estoque-movimentacao"),
				PanamahEstoqueMovimentacao.class);
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
		PanamahEventoCaixa model = PanamahUtil.buildGson().fromJson(r("evento-caixa"), PanamahEventoCaixa.class);
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendFormaPagamento() throws Exception {
		PanamahFormaPagamento model = PanamahUtil.buildGson().fromJson(r("forma-pagamento"), PanamahFormaPagamento.class);
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendFornecedor() throws Exception {
		PanamahFornecedor model = PanamahUtil.buildGson().fromJson(r("fornecedor"), PanamahFornecedor.class);
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendFuncionario() throws Exception {
		PanamahFuncionario model = PanamahUtil.buildGson().fromJson(r("funcionario"), PanamahFuncionario.class);
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendGrupo() throws Exception {
		PanamahGrupo model = PanamahUtil.buildGson().fromJson(r("grupo"), PanamahGrupo.class);
		Panamah p = Panamah.init(c);
		p.send(model);
		assertTrue(true);
	}

	@Test
	public void shouldSendHolding() throws Exception {
		PanamahHolding model = PanamahUtil.buildGson().fromJson(r("holding"), PanamahHolding.class);
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendLocalEstoque() throws Exception {
		PanamahLocalEstoque model = PanamahUtil.buildGson().fromJson(r("local-estoque"), PanamahLocalEstoque.class);
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendLoja() throws Exception {
		PanamahLoja model = PanamahUtil.buildGson().fromJson(r("loja"), PanamahLoja.class);
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendMeta() throws Exception {
		PanamahMeta model = PanamahUtil.buildGson().fromJson(r("meta"), PanamahMeta.class);
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendProduto() throws Exception {
		PanamahProduto model = PanamahUtil.buildGson().fromJson(r("produto"), PanamahProduto.class);
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendRevenda() throws Exception {
		PanamahRevenda model = PanamahUtil.buildGson().fromJson(r("revenda"), PanamahRevenda.class);
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendSecao() throws Exception {
		PanamahSecao model = PanamahUtil.buildGson().fromJson(r("secao"), PanamahSecao.class);
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendSubgrupo() throws Exception {
		PanamahSubgrupo model = PanamahUtil.buildGson().fromJson(r("subgrupo"), PanamahSubgrupo.class);
		Panamah p = Panamah.init(c);
		p.send(model);
		p.flush();
		assertTrue(true);
	}

	@Test
	public void shouldSendTituloPagar() throws Exception {
		PanamahTituloPagar model = PanamahUtil.buildGson().fromJson(r("titulo-pagar"), PanamahTituloPagar.class);
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