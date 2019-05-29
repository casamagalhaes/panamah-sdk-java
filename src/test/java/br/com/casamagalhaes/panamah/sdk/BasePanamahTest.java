package br.com.casamagalhaes.panamah.sdk;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import br.com.casamagalhaes.panamah.sdk.model.PanamahAcesso;
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

	private PanamahConfig c = PanamahConfig.fromEnv("staging");

	private String r(String json) throws Exception {
		StringWriter w = new StringWriter();
		try (Reader reader = new InputStreamReader(
				BasePanamahTest.class.getResourceAsStream("resources/" + json + ".json"))) {
			IOUtils.copy(reader, w);
		}
		return w.toString();
	}

	@Test
	public void shouldSaveAcesso() throws Exception {
		PanamahAcesso model = PanamahUtil.buildGson().fromJson(r("acesso"), PanamahAcesso.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.save(model,c);
		PanamahUtil.send(c, lote);
	}

	// @Test
	// public void shouldSaveAssinante() throws Exception {
	// PanamahAssinante model = PanamahUtil.buildGson().fromJson(r("assinante"),
	// PanamahAssinante.class);
	// PanamahUtil.auth(c);
	// PanamahLote lote = new PanamahLote();
	// lote.save(model,c);
	// PanamahUtil.send(c, lote);
	// }

	@Test
	public void shouldSaveCliente() throws Exception {
		PanamahCliente model = PanamahUtil.buildGson().fromJson(r("cliente"), PanamahCliente.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.save(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldSaveCompra() throws Exception {
		PanamahCompra model = PanamahUtil.buildGson().fromJson(r("compra"), PanamahCompra.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.save(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldSaveEan() throws Exception {
		PanamahEan model = PanamahUtil.buildGson().fromJson(r("ean"), PanamahEan.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.save(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldSaveEstoqueMovimentacao() throws Exception {
		PanamahEstoqueMovimentacao model = PanamahUtil.buildGson().fromJson(r("estoque-movimentacao"),
				PanamahEstoqueMovimentacao.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.save(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldSaveEventoCaixa() throws Exception {
		PanamahEventoCaixa model = PanamahUtil.buildGson().fromJson(r("evento-caixa"), PanamahEventoCaixa.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.save(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldSaveFormaPagamento() throws Exception {
		PanamahFormaPagamento model = PanamahUtil.buildGson().fromJson(r("forma-pagamento"),
				PanamahFormaPagamento.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.save(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldSaveFornecedor() throws Exception {
		PanamahFornecedor model = PanamahUtil.buildGson().fromJson(r("fornecedor"), PanamahFornecedor.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.save(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldSaveFuncionario() throws Exception {
		PanamahFuncionario model = PanamahUtil.buildGson().fromJson(r("funcionario"), PanamahFuncionario.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.save(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldSaveGrupo() throws Exception {
		PanamahGrupo model = PanamahUtil.buildGson().fromJson(r("grupo"), PanamahGrupo.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.save(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldSaveHolding() throws Exception {
		PanamahHolding model = PanamahUtil.buildGson().fromJson(r("holding"), PanamahHolding.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.save(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldSaveLocalEstoque() throws Exception {
		PanamahLocalEstoque model = PanamahUtil.buildGson().fromJson(r("local-estoque"), PanamahLocalEstoque.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.save(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldSaveLoja() throws Exception {
		PanamahLoja model = PanamahUtil.buildGson().fromJson(r("loja"), PanamahLoja.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.save(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldSaveMeta() throws Exception {
		PanamahMeta model = PanamahUtil.buildGson().fromJson(r("meta"), PanamahMeta.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.save(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldSaveProduto() throws Exception {
		PanamahProduto model = PanamahUtil.buildGson().fromJson(r("produto"), PanamahProduto.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.save(model, c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldSaveRevenda() throws Exception {
		PanamahRevenda model = PanamahUtil.buildGson().fromJson(r("revenda"), PanamahRevenda.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.save(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldSaveSecao() throws Exception {
		PanamahSecao model = PanamahUtil.buildGson().fromJson(r("secao"), PanamahSecao.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.save(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldSaveSubgrupo() throws Exception {
		PanamahSubgrupo model = PanamahUtil.buildGson().fromJson(r("subgrupo"), PanamahSubgrupo.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.save(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldSaveTituloPagar() throws Exception {
		PanamahTituloPagar model = PanamahUtil.buildGson().fromJson(r("titulo-pagar"), PanamahTituloPagar.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.save(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldSaveTituloReceber() throws Exception {
		PanamahTituloReceber model = PanamahUtil.buildGson().fromJson(r("titulo-receber"), PanamahTituloReceber.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.save(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldSaveTrocaDevolucao() throws Exception {
		PanamahTrocaDevolucao model = PanamahUtil.buildGson().fromJson(r("troca-devolucao"),
				PanamahTrocaDevolucao.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.save(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldSaveTrocaFormaPagamento() throws Exception {
		PanamahTrocaFormaPagamento model = PanamahUtil.buildGson().fromJson(r("troca-forma-pagamento"),
				PanamahTrocaFormaPagamento.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.save(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldSaveVenda() throws Exception {
		PanamahVenda model = PanamahUtil.buildGson().fromJson(r("venda"), PanamahVenda.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.save(model, c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldReadNFeProc() throws Exception {
		PanamahStream p = PanamahStream.init(c);
		String path = "src/test/resources/br/com/casamagalhaes/";
		path += "panamah/sdk/resources/xml/";
		path += "NFe13190507128945000132652340000000129000000104.xml";
		p.readNFe(path);
		p.flush(true);
		assertTrue(true);
	}

	@Test
	public void shouldReadNFe() throws Exception {
		PanamahConfig config = PanamahConfig.fromEnv("staging");
		PanamahStream p = PanamahStream.init(config);
		String path = "src/test/resources/br/com/casamagalhaes/";
		path += "panamah/sdk/resources/xml/";
		path += "NFe13190507128945000132655081000000901000000040.xml";
		p.readNFe(path);
		p.flush(true);
		assertTrue(true);
	}

	@Test(expected = Exception.class)
	public void shouldSaveAssinanteTeste() throws Exception {
		PanamahConfig config = PanamahConfig.fromEnv("staging");
		config.getAuth().getAssinante().setId("00934509022");
		config.getAuth().getAssinante().setNome("teste assinante");
		config.getAuth().getAssinante().setFantasia("teste assinante");
		config.getAuth().getAssinante().setBairro("Benfica");
		config.getAuth().getAssinante().setCidade("Fortaleza");
		config.getAuth().getAssinante().setRamo("");
		config.getAuth().getAssinante().setUf("CE");
		PanamahAdmin.getInstance().createAssinante(config);
	}

	@Test
	public void shouldGetAssinanteTeste() throws Exception {
		PanamahConfig config = PanamahConfig.fromEnv("staging");
		PanamahAdmin.getInstance().retrieveAssinante(config, "00934509022");
		assertNotNull(config.getAuth().getAssinante().getNome());
	}

	@Test
	public void shouldLoginStream() throws Exception {
		PanamahConfig config = PanamahConfig.fromEnv("staging");
		PanamahUtil.auth(config);
	}

	@Test
	public void shouldDelAcesso() throws Exception {
		PanamahAcesso model = PanamahUtil.buildGson().fromJson(r("acesso"), PanamahAcesso.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.delete(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldDelCliente() throws Exception {
		PanamahCliente model = PanamahUtil.buildGson().fromJson(r("cliente"), PanamahCliente.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.delete(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldDelCompra() throws Exception {
		PanamahCompra model = PanamahUtil.buildGson().fromJson(r("compra"), PanamahCompra.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.delete(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldDelEan() throws Exception {
		PanamahEan model = PanamahUtil.buildGson().fromJson(r("ean"), PanamahEan.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.delete(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldDelEstoqueMovimentacao() throws Exception {
		PanamahEstoqueMovimentacao model = PanamahUtil.buildGson().fromJson(r("estoque-movimentacao"),
				PanamahEstoqueMovimentacao.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.delete(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldDelEventoCaixa() throws Exception {
		PanamahEventoCaixa model = PanamahUtil.buildGson().fromJson(r("evento-caixa"), PanamahEventoCaixa.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.delete(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldDelFormaPagamento() throws Exception {
		PanamahFormaPagamento model = PanamahUtil.buildGson().fromJson(r("forma-pagamento"),
				PanamahFormaPagamento.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.delete(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldDelFornecedor() throws Exception {
		PanamahFornecedor model = PanamahUtil.buildGson().fromJson(r("fornecedor"), PanamahFornecedor.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.delete(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldDelFuncionario() throws Exception {
		PanamahFuncionario model = PanamahUtil.buildGson().fromJson(r("funcionario"), PanamahFuncionario.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.delete(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldDelGrupo() throws Exception {
		PanamahGrupo model = PanamahUtil.buildGson().fromJson(r("grupo"), PanamahGrupo.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.delete(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldDelHolding() throws Exception {
		PanamahHolding model = PanamahUtil.buildGson().fromJson(r("holding"), PanamahHolding.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.delete(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldDelLocalEstoque() throws Exception {
		PanamahLocalEstoque model = PanamahUtil.buildGson().fromJson(r("local-estoque"), PanamahLocalEstoque.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.delete(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldDelLoja() throws Exception {
		PanamahLoja model = PanamahUtil.buildGson().fromJson(r("loja"), PanamahLoja.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.delete(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldDelMeta() throws Exception {
		PanamahMeta model = PanamahUtil.buildGson().fromJson(r("meta"), PanamahMeta.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.delete(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldDelProduto() throws Exception {
		PanamahProduto model = PanamahUtil.buildGson().fromJson(r("produto"), PanamahProduto.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.delete(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldDelRevenda() throws Exception {
		PanamahRevenda model = PanamahUtil.buildGson().fromJson(r("revenda"), PanamahRevenda.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.delete(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldDelSecao() throws Exception {
		PanamahSecao model = PanamahUtil.buildGson().fromJson(r("secao"), PanamahSecao.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.delete(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldDelSubgrupo() throws Exception {
		PanamahSubgrupo model = PanamahUtil.buildGson().fromJson(r("subgrupo"), PanamahSubgrupo.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.delete(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldDelTituloPagar() throws Exception {
		PanamahTituloPagar model = PanamahUtil.buildGson().fromJson(r("titulo-pagar"), PanamahTituloPagar.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.delete(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldDelTituloReceber() throws Exception {
		PanamahTituloReceber model = PanamahUtil.buildGson().fromJson(r("titulo-receber"), PanamahTituloReceber.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.delete(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldDelTrocaDevolucao() throws Exception {
		PanamahTrocaDevolucao model = PanamahUtil.buildGson().fromJson(r("troca-devolucao"),
				PanamahTrocaDevolucao.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.delete(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldDelTrocaFormaPagamento() throws Exception {
		PanamahTrocaFormaPagamento model = PanamahUtil.buildGson().fromJson(r("troca-forma-pagamento"),
				PanamahTrocaFormaPagamento.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.delete(model,c);
		PanamahUtil.send(c, lote);
	}

	@Test
	public void shouldDelVenda() throws Exception {
		PanamahVenda model = PanamahUtil.buildGson().fromJson(r("venda"), PanamahVenda.class);
		PanamahUtil.auth(c);
		PanamahLote lote = new PanamahLote();
		lote.delete(model,c);
		PanamahUtil.send(c, lote);
	}

}