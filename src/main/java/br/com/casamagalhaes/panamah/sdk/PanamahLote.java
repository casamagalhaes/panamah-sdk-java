package br.com.casamagalhaes.panamah.sdk;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

public class PanamahLote {

	private PanamahStatusLote status = PanamahStatusLote.ABERTO;
	private Date criacao = new Date();
	private Date ultimaAtualizacao = new Date();

	private List<PanamahOperacao<?>> operacoes;

	public boolean isVelho(PanamahConfig config) {
		return new Date().getTime() > criacao.getTime() + config.getTtl();
	}

	public PanamahStatusLote getStatus() {
		return status;
	}

	public void setStatus(PanamahStatusLote status) {
		this.status = status;
	}

	public List<PanamahOperacao<?>> getOperacoes() {
		return operacoes;
	}

	public void setOperacoes(List<PanamahOperacao<?>> operacoes) {
		this.operacoes = operacoes;
	}

	public Date getCriacao() {
		return criacao;
	}

	public void setCriacao(Date criacao) {
		this.criacao = criacao;
	}

	public Date getUltimaAtualizacao() {
		return ultimaAtualizacao;
	}

	public void setUltimaAtualizacao(Date ultimaAtualizacao) {
		this.ultimaAtualizacao = ultimaAtualizacao;
	}

	public void save(PanamahCliente cliente) throws Exception {
		if (cliente == null)
			throw new RuntimeException("cliente não pode ser nulo!");
		cliente.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();
		PanamahOperacao<PanamahCliente> op = new PanamahOperacao<PanamahCliente>();
		op.setOp(PanamahTipoOperacao.SAVE);
		op.setTipoIdentificador("cliente".toUpperCase());
		op.setData(cliente);
		operacoes.add(op);
	}

	public void del(PanamahCliente cliente) throws Exception {
		if (cliente == null)
			throw new RuntimeException("cliente não pode ser nulo!");
		cliente.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();
		PanamahOperacao<PanamahCliente> op = new PanamahOperacao<PanamahCliente>();
		op.setOp(PanamahTipoOperacao.DELETE);
		op.setTipoIdentificador("cliente".toUpperCase());
		op.setData(cliente);
		operacoes.add(op);
	}

	public void save(PanamahCompra compra) throws Exception {
		if (compra == null)
			throw new RuntimeException("compra não pode ser nulo!");
		compra.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();
		PanamahOperacao<PanamahCompra> op = new PanamahOperacao<PanamahCompra>();
		op.setOp(PanamahTipoOperacao.SAVE);
		op.setTipoIdentificador("compra".toUpperCase());
		op.setData(compra);
		operacoes.add(op);
	}

	public void del(PanamahCompra compra) throws Exception {
		if (compra == null)
			throw new RuntimeException("compra não pode ser nulo!");
		compra.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();
		PanamahOperacao<PanamahCompra> op = new PanamahOperacao<PanamahCompra>();
		op.setOp(PanamahTipoOperacao.DELETE);
		op.setTipoIdentificador("compra".toUpperCase());
		op.setData(compra);
		operacoes.add(op);
	}

	public void save(PanamahAssinante assinante) throws Exception {
		if (assinante == null)
			throw new RuntimeException("assinante não pode ser nulo!");
		assinante.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();
		PanamahOperacao<PanamahAssinante> op = new PanamahOperacao<PanamahAssinante>();
		op.setOp(PanamahTipoOperacao.SAVE);
		op.setTipoIdentificador("assinante".toUpperCase());
		op.setData(assinante);
		operacoes.add(op);
	}

	public void del(PanamahAssinante assinante) throws Exception {
		if (assinante == null)
			throw new RuntimeException("assinante não pode ser nulo!");
		assinante.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();
		PanamahOperacao<PanamahAssinante> op = new PanamahOperacao<PanamahAssinante>();
		op.setOp(PanamahTipoOperacao.DELETE);
		op.setTipoIdentificador("assinante".toUpperCase());
		op.setData(assinante);
		operacoes.add(op);
	}

	public void save(PanamahAcesso acesso) throws Exception {
		if (acesso == null)
			throw new RuntimeException("acesso não pode ser nulo!");
		acesso.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();
		PanamahOperacao<PanamahAcesso> op = new PanamahOperacao<PanamahAcesso>();
		op.setOp(PanamahTipoOperacao.SAVE);
		op.setTipoIdentificador("acesso".toUpperCase());
		op.setData(acesso);
		operacoes.add(op);
	}

	public void del(PanamahAcesso acesso) throws Exception {
		if (acesso == null)
			throw new RuntimeException("acesso não pode ser nulo!");
		acesso.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();
		PanamahOperacao<PanamahAcesso> op = new PanamahOperacao<PanamahAcesso>();
		op.setOp(PanamahTipoOperacao.DELETE);
		op.setTipoIdentificador("acesso".toUpperCase());
		op.setData(acesso);
		operacoes.add(op);
	}

	public void save(PanamahEan ean) throws Exception {
		if (ean == null)
			throw new RuntimeException("ean não pode ser nulo!");
		ean.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();
		PanamahOperacao<PanamahEan> op = new PanamahOperacao<PanamahEan>();
		op.setOp(PanamahTipoOperacao.SAVE);
		op.setTipoIdentificador("ean".toUpperCase());
		op.setData(ean);
		operacoes.add(op);
	}

	public void del(PanamahEan ean) throws Exception {
		if (ean == null)
			throw new RuntimeException("ean não pode ser nulo!");
		ean.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();
		PanamahOperacao<PanamahEan> op = new PanamahOperacao<PanamahEan>();
		op.setOp(PanamahTipoOperacao.DELETE);
		op.setTipoIdentificador("ean".toUpperCase());
		op.setData(ean);
		operacoes.add(op);

	}

	public void save(PanamahEstoqueMovimentacao estoqueMovimentacao) throws Exception {
		if (estoqueMovimentacao == null)
			throw new RuntimeException("estoqueMovimentacao não pode ser nulo!");
		estoqueMovimentacao.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();
		PanamahOperacao<PanamahEstoqueMovimentacao> op = new PanamahOperacao<PanamahEstoqueMovimentacao>();
		op.setOp(PanamahTipoOperacao.SAVE);
		op.setTipoIdentificador("estoqueMovimentacao".toUpperCase());
		op.setData(estoqueMovimentacao);
		operacoes.add(op);
	}

	public void del(PanamahEstoqueMovimentacao estoqueMovimentacao) throws Exception {
		if (estoqueMovimentacao == null)
			throw new RuntimeException("estoqueMovimentacao não pode ser nulo!");
		estoqueMovimentacao.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();
		PanamahOperacao<PanamahEstoqueMovimentacao> op = new PanamahOperacao<PanamahEstoqueMovimentacao>();
		op.setOp(PanamahTipoOperacao.DELETE);
		op.setTipoIdentificador("estoqueMovimentacao".toUpperCase());
		op.setData(estoqueMovimentacao);
		operacoes.add(op);
	}

	public void save(PanamahEventoCaixa eventoCaixa) throws Exception {
		if (eventoCaixa == null)
			throw new RuntimeException("eventoCaixa não pode ser nulo!");
		eventoCaixa.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();
		PanamahOperacao<PanamahEventoCaixa> op = new PanamahOperacao<PanamahEventoCaixa>();
		op.setOp(PanamahTipoOperacao.SAVE);
		op.setTipoIdentificador("eventoCaixa".toUpperCase());
		op.setData(eventoCaixa);
		operacoes.add(op);
	}

	public void del(PanamahEventoCaixa eventoCaixa) throws Exception {
		if (eventoCaixa == null)
			throw new RuntimeException("eventoCaixa não pode ser nulo!");
		eventoCaixa.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();
		PanamahOperacao<PanamahEventoCaixa> op = new PanamahOperacao<PanamahEventoCaixa>();
		op.setOp(PanamahTipoOperacao.DELETE);
		op.setTipoIdentificador("eventoCaixa".toUpperCase());
		op.setData(eventoCaixa);
		operacoes.add(op);
	}

	public void save(PanamahFormaPagamento formaPagamento) throws Exception {
		if (formaPagamento == null)
			throw new RuntimeException("formaPagamento não pode ser nulo!");
		formaPagamento.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();
		PanamahOperacao<PanamahFormaPagamento> op = new PanamahOperacao<PanamahFormaPagamento>();
		op.setOp(PanamahTipoOperacao.SAVE);
		op.setTipoIdentificador("formaPagamento".toUpperCase());
		op.setData(formaPagamento);
		operacoes.add(op);
	}

	public void del(PanamahFormaPagamento formaPagamento) throws Exception {
		if (formaPagamento == null)
			throw new RuntimeException("formaPagamento não pode ser nulo!");
		formaPagamento.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();
		PanamahOperacao<PanamahFormaPagamento> op = new PanamahOperacao<PanamahFormaPagamento>();
		op.setOp(PanamahTipoOperacao.DELETE);
		op.setTipoIdentificador("formaPagamento".toUpperCase());
		op.setData(formaPagamento);
		operacoes.add(op);
	}

	public void save(PanamahFornecedor fornecedor) throws Exception {
		if (fornecedor == null)
			throw new RuntimeException("fornecedor não pode ser nulo!");
		fornecedor.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();
		PanamahOperacao<PanamahFornecedor> op = new PanamahOperacao<PanamahFornecedor>();
		op.setOp(PanamahTipoOperacao.SAVE);
		op.setTipoIdentificador("fornecedor".toUpperCase());
		op.setData(fornecedor);
		operacoes.add(op);
	}

	public void del(PanamahFornecedor fornecedor) throws Exception {
		if (fornecedor == null)
			throw new RuntimeException("fornecedor não pode ser nulo!");
		fornecedor.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();
		PanamahOperacao<PanamahFornecedor> op = new PanamahOperacao<PanamahFornecedor>();
		op.setOp(PanamahTipoOperacao.DELETE);
		op.setTipoIdentificador("fornecedor".toUpperCase());
		op.setData(fornecedor);
		operacoes.add(op);

	}

	public void save(PanamahFuncionario funcionario) throws Exception {
		if (funcionario == null)
			throw new RuntimeException("funcionario não pode ser nulo!");
		funcionario.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();
		PanamahOperacao<PanamahFuncionario> op = new PanamahOperacao<PanamahFuncionario>();
		op.setOp(PanamahTipoOperacao.SAVE);
		op.setTipoIdentificador("funcionario".toUpperCase());
		op.setData(funcionario);
		operacoes.add(op);
	}

	public void del(PanamahFuncionario funcionario) throws Exception {
		if (funcionario == null)
			throw new RuntimeException("funcionario não pode ser nulo!");
		funcionario.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();
		PanamahOperacao<PanamahFuncionario> op = new PanamahOperacao<PanamahFuncionario>();
		op.setOp(PanamahTipoOperacao.DELETE);
		op.setTipoIdentificador("funcionario".toUpperCase());
		op.setData(funcionario);
		operacoes.add(op);
	}

	public void save(PanamahGrupo grupo) throws Exception {
		if (grupo == null)
			throw new RuntimeException("grupo não pode ser nulo!");
		grupo.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();
		PanamahOperacao<PanamahGrupo> op = new PanamahOperacao<PanamahGrupo>();
		op.setOp(PanamahTipoOperacao.SAVE);
		op.setTipoIdentificador("grupo".toUpperCase());
		op.setData(grupo);
		operacoes.add(op);
	}

	public void del(PanamahGrupo grupo) throws Exception {
		if (grupo == null)
			throw new RuntimeException("grupo não pode ser nulo!");
		grupo.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();

		PanamahOperacao<PanamahGrupo> op = new PanamahOperacao<PanamahGrupo>();
		op.setOp(PanamahTipoOperacao.DELETE);
		op.setTipoIdentificador("grupo".toUpperCase());
		op.setData(grupo);
		operacoes.add(op);
	}

	public void save(PanamahHolding holding) throws Exception {
		if (holding == null)
			throw new RuntimeException("holding não pode ser nulo!");
		holding.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();

		PanamahOperacao<PanamahHolding> op = new PanamahOperacao<PanamahHolding>();
		op.setOp(PanamahTipoOperacao.SAVE);
		op.setTipoIdentificador("holding".toUpperCase());
		op.setData(holding);
		operacoes.add(op);
	}

	public void del(PanamahHolding holding) throws Exception {
		if (holding == null)
			throw new RuntimeException("holding não pode ser nulo!");
		holding.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();

		PanamahOperacao<PanamahHolding> op = new PanamahOperacao<PanamahHolding>();
		op.setOp(PanamahTipoOperacao.DELETE);
		op.setTipoIdentificador("holding".toUpperCase());
		op.setData(holding);
		operacoes.add(op);
	}

	public void save(PanamahLocalEstoque localEstoque) throws Exception {
		if (localEstoque == null)
			throw new RuntimeException("localEstoque não pode ser nulo!");
		localEstoque.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();

		PanamahOperacao<PanamahLocalEstoque> op = new PanamahOperacao<PanamahLocalEstoque>();
		op.setOp(PanamahTipoOperacao.SAVE);
		op.setTipoIdentificador("localEstoque".toUpperCase());
		op.setData(localEstoque);
		operacoes.add(op);
	}

	public void del(PanamahLocalEstoque localEstoque) throws Exception {
		if (localEstoque == null)
			throw new RuntimeException("localEstoque não pode ser nulo!");
		localEstoque.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();

		PanamahOperacao<PanamahLocalEstoque> op = new PanamahOperacao<PanamahLocalEstoque>();
		op.setOp(PanamahTipoOperacao.DELETE);
		op.setTipoIdentificador("localEstoque".toUpperCase());
		op.setData(localEstoque);
		operacoes.add(op);
	}

	public void save(PanamahLoja loja) throws Exception {
		if (loja == null)
			throw new RuntimeException("loja não pode ser nulo!");
		loja.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();

		PanamahOperacao<PanamahLoja> op = new PanamahOperacao<PanamahLoja>();
		op.setOp(PanamahTipoOperacao.SAVE);
		op.setTipoIdentificador("loja".toUpperCase());
		op.setData(loja);
		operacoes.add(op);
	}

	public void del(PanamahLoja loja) throws Exception {
		if (loja == null)
			throw new RuntimeException("loja não pode ser nulo!");
		loja.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();

		PanamahOperacao<PanamahLoja> op = new PanamahOperacao<PanamahLoja>();
		op.setOp(PanamahTipoOperacao.DELETE);
		op.setTipoIdentificador("loja".toUpperCase());
		op.setData(loja);
		operacoes.add(op);
	}

	public void save(PanamahMeta meta) throws Exception {
		if (meta == null)
			throw new RuntimeException("meta não pode ser nulo!");
		meta.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();

		PanamahOperacao<PanamahMeta> op = new PanamahOperacao<PanamahMeta>();
		op.setOp(PanamahTipoOperacao.SAVE);
		op.setTipoIdentificador("meta".toUpperCase());
		op.setData(meta);
		operacoes.add(op);

	}

	public void del(PanamahMeta meta) throws Exception {
		if (meta == null)
			throw new RuntimeException("meta não pode ser nulo!");
		meta.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();

		PanamahOperacao<PanamahMeta> op = new PanamahOperacao<PanamahMeta>();
		op.setOp(PanamahTipoOperacao.DELETE);
		op.setTipoIdentificador("meta".toUpperCase());
		op.setData(meta);
		operacoes.add(op);

	}

	public void save(PanamahProduto produto) throws Exception {
		if (produto == null)
			throw new RuntimeException("produto não pode ser nulo!");
		produto.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();

		PanamahOperacao<PanamahProduto> op = new PanamahOperacao<PanamahProduto>();
		op.setOp(PanamahTipoOperacao.SAVE);
		op.setTipoIdentificador("produto".toUpperCase());
		op.setData(produto);
		operacoes.add(op);

	}

	public void del(PanamahProduto produto) throws Exception {
		if (produto == null)
			throw new RuntimeException("produto não pode ser nulo!");
		produto.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();

		PanamahOperacao<PanamahProduto> op = new PanamahOperacao<PanamahProduto>();
		op.setOp(PanamahTipoOperacao.DELETE);
		op.setTipoIdentificador("produto".toUpperCase());
		op.setData(produto);
		operacoes.add(op);

	}

	public void save(PanamahRevenda revenda) throws Exception {
		if (revenda == null)
			throw new RuntimeException("revenda não pode ser nulo!");
		revenda.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();

		PanamahOperacao<PanamahRevenda> op = new PanamahOperacao<PanamahRevenda>();
		op.setOp(PanamahTipoOperacao.SAVE);
		op.setTipoIdentificador("revenda".toUpperCase());
		op.setData(revenda);
		operacoes.add(op);

	}

	public void del(PanamahRevenda revenda) throws Exception {
		if (revenda == null)
			throw new RuntimeException("revenda não pode ser nulo!");
		revenda.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();

		PanamahOperacao<PanamahRevenda> op = new PanamahOperacao<PanamahRevenda>();
		op.setOp(PanamahTipoOperacao.DELETE);
		op.setTipoIdentificador("revenda".toUpperCase());
		op.setData(revenda);
		operacoes.add(op);

	}

	public void save(PanamahSecao secao) throws Exception {
		if (secao == null)
			throw new RuntimeException("secao não pode ser nulo!");
		secao.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();

		PanamahOperacao<PanamahSecao> op = new PanamahOperacao<PanamahSecao>();
		op.setOp(PanamahTipoOperacao.SAVE);
		op.setTipoIdentificador("secao".toUpperCase());
		op.setData(secao);
		operacoes.add(op);

	}

	public void del(PanamahSecao secao) throws Exception {
		if (secao == null)
			throw new RuntimeException("secao não pode ser nulo!");
		secao.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();

		PanamahOperacao<PanamahSecao> op = new PanamahOperacao<PanamahSecao>();
		op.setOp(PanamahTipoOperacao.DELETE);
		op.setTipoIdentificador("secao".toUpperCase());
		op.setData(secao);
		operacoes.add(op);

	}

	public void save(PanamahSubgrupo subgrupo) throws Exception {
		if (subgrupo == null)
			throw new RuntimeException("subgrupo não pode ser nulo!");
		subgrupo.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();

		PanamahOperacao<PanamahSubgrupo> op = new PanamahOperacao<PanamahSubgrupo>();
		op.setOp(PanamahTipoOperacao.SAVE);
		op.setTipoIdentificador("subgrupo".toUpperCase());
		op.setData(subgrupo);
		operacoes.add(op);

	}

	public void del(PanamahSubgrupo subgrupo) throws Exception {
		if (subgrupo == null)
			throw new RuntimeException("subgrupo não pode ser nulo!");
		subgrupo.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();

		PanamahOperacao<PanamahSubgrupo> op = new PanamahOperacao<PanamahSubgrupo>();
		op.setOp(PanamahTipoOperacao.DELETE);
		op.setTipoIdentificador("subgrupo".toUpperCase());
		op.setData(subgrupo);
		operacoes.add(op);

	}

	public void save(PanamahTituloPagar tituloPagar) throws Exception {
		if (tituloPagar == null)
			throw new RuntimeException("tituloPagar não pode ser nulo!");
		tituloPagar.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();

		PanamahOperacao<PanamahTituloPagar> op = new PanamahOperacao<PanamahTituloPagar>();
		op.setOp(PanamahTipoOperacao.SAVE);
		op.setTipoIdentificador("tituloPagar".toUpperCase());
		op.setData(tituloPagar);
		operacoes.add(op);

	}

	public void del(PanamahTituloPagar tituloPagar) throws Exception {
		if (tituloPagar == null)
			throw new RuntimeException("tituloPagar não pode ser nulo!");
		tituloPagar.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();

		PanamahOperacao<PanamahTituloPagar> op = new PanamahOperacao<PanamahTituloPagar>();
		op.setOp(PanamahTipoOperacao.DELETE);
		op.setTipoIdentificador("tituloPagar".toUpperCase());
		op.setData(tituloPagar);
		operacoes.add(op);
	}

	public void save(PanamahTituloReceber tituloReceber) throws Exception {
		if (tituloReceber == null)
			throw new RuntimeException("tituloReceber não pode ser nulo!");
		tituloReceber.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();

		PanamahOperacao<PanamahTituloReceber> op = new PanamahOperacao<PanamahTituloReceber>();
		op.setOp(PanamahTipoOperacao.SAVE);
		op.setTipoIdentificador("tituloReceber".toUpperCase());
		op.setData(tituloReceber);
		operacoes.add(op);
	}

	public void del(PanamahTituloReceber tituloReceber) throws Exception {
		if (tituloReceber == null)
			throw new RuntimeException("tituloReceber não pode ser nulo!");
		tituloReceber.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();

		PanamahOperacao<PanamahTituloReceber> op = new PanamahOperacao<PanamahTituloReceber>();
		op.setOp(PanamahTipoOperacao.DELETE);
		op.setTipoIdentificador("tituloReceber".toUpperCase());
		op.setData(tituloReceber);
		operacoes.add(op);
	}

	public void save(PanamahTrocaDevolucao trocaDevolucao) throws Exception {
		if (trocaDevolucao == null)
			throw new RuntimeException("trocaDevolucao não pode ser nulo!");
		trocaDevolucao.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();
		PanamahOperacao<PanamahTrocaDevolucao> op = new PanamahOperacao<PanamahTrocaDevolucao>();
		op.setOp(PanamahTipoOperacao.SAVE);
		op.setTipoIdentificador("trocaDevolucao".toUpperCase());
		op.setData(trocaDevolucao);
		operacoes.add(op);
	}

	public void del(PanamahTrocaDevolucao trocaDevolucao) throws Exception {
		if (trocaDevolucao == null)
			throw new RuntimeException("trocaDevolucao não pode ser nulo!");
		trocaDevolucao.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();
		PanamahOperacao<PanamahTrocaDevolucao> op = new PanamahOperacao<PanamahTrocaDevolucao>();
		op.setOp(PanamahTipoOperacao.DELETE);
		op.setTipoIdentificador("trocaDevolucao".toUpperCase());
		op.setData(trocaDevolucao);
		operacoes.add(op);
	}

	public void save(PanamahTrocaFormaPagamento trocaFormaPagamento) throws Exception {
		if (trocaFormaPagamento == null)
			throw new RuntimeException("trocaFormaPagamento não pode ser nulo!");
		trocaFormaPagamento.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();
		PanamahOperacao<PanamahTrocaFormaPagamento> op = new PanamahOperacao<PanamahTrocaFormaPagamento>();
		op.setOp(PanamahTipoOperacao.SAVE);
		op.setTipoIdentificador("trocaFormaPagamento".toUpperCase());
		op.setData(trocaFormaPagamento);
		operacoes.add(op);
	}

	public void del(PanamahTrocaFormaPagamento trocaFormaPagamento) throws Exception {
		if (trocaFormaPagamento == null)
			throw new RuntimeException("trocaFormaPagamento não pode ser nulo!");
		trocaFormaPagamento.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();
		PanamahOperacao<PanamahTrocaFormaPagamento> op = new PanamahOperacao<PanamahTrocaFormaPagamento>();
		op.setOp(PanamahTipoOperacao.DELETE);
		op.setTipoIdentificador("trocaFormaPagamento".toUpperCase());
		op.setData(trocaFormaPagamento);
		operacoes.add(op);
	}

	public void save(PanamahVenda venda) throws Exception {
		if (venda == null)
			throw new RuntimeException("venda não pode ser nulo!");
		venda.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();
		PanamahOperacao<PanamahVenda> op = new PanamahOperacao<PanamahVenda>();
		op.setOp(PanamahTipoOperacao.SAVE);
		op.setTipoIdentificador("venda".toUpperCase());
		op.setData(venda);
		operacoes.add(op);
	}

	public void del(PanamahVenda venda) throws Exception {
		if (venda == null)
			throw new RuntimeException("venda não pode ser nulo!");
		venda.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao<?>>();
		PanamahOperacao<PanamahVenda> op = new PanamahOperacao<PanamahVenda>();
		op.setOp(PanamahTipoOperacao.DELETE);
		op.setTipoIdentificador("venda".toUpperCase());
		op.setData(venda);
		operacoes.add(op);
	}

}
