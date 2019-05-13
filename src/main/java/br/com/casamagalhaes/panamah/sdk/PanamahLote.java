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

	private List<PanamahOperacao> operacoes;

	public boolean isVelho(PanamahConfig config) {
		return new Date().getTime() > criacao.getTime() + config.getTtl();
	}

	public PanamahStatusLote getStatus() {
		return status;
	}

	public void setStatus(PanamahStatusLote status) {
		this.status = status;
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
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.SAVE);
		op.setCliente(cliente);
	}

	public void del(PanamahCliente cliente) throws Exception {
		if (cliente == null)
			throw new RuntimeException("cliente não pode ser nulo!");
		cliente.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.DELETE);
		op.setCliente(cliente);
	}

	public void save(PanamahCompra compra) throws Exception {
		if (compra == null)
			throw new RuntimeException("compra não pode ser nulo!");
		compra.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.SAVE);
		op.setCompra(compra);
	}

	public void del(PanamahCompra compra) throws Exception {
		if (compra == null)
			throw new RuntimeException("compra não pode ser nulo!");
		compra.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.DELETE);
		op.setCompra(compra);
	}

	public void save(PanamahAssinante assinante) throws Exception {
		if (assinante == null)
			throw new RuntimeException("assinante não pode ser nulo!");
		assinante.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.SAVE);
		op.setAssinante(assinante);
	}

	public void del(PanamahAssinante assinante) throws Exception {
		if (assinante == null)
			throw new RuntimeException("assinante não pode ser nulo!");
		assinante.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.DELETE);
		op.setAssinante(assinante);
	}

	public void save(PanamahAcesso acesso) throws Exception {
		if (acesso == null)
			throw new RuntimeException("acesso não pode ser nulo!");
		acesso.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.SAVE);
		op.setAcesso(acesso);
	}

	public void del(PanamahAcesso acesso) throws Exception {
		if (acesso == null)
			throw new RuntimeException("acesso não pode ser nulo!");
		acesso.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.DELETE);
		op.setAcesso(acesso);
	}

	public void save(PanamahEan ean) throws Exception {
		if (ean == null)
			throw new RuntimeException("ean não pode ser nulo!");
		ean.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.SAVE);
		op.setEan(ean);
	}

	public void del(PanamahEan ean) throws Exception {
		if (ean == null)
			throw new RuntimeException("ean não pode ser nulo!");
		ean.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.DELETE);
		op.setEan(ean);

	}

	public void save(PanamahEstoqueMovimentacao estoqueMovimentacao) throws Exception {
		if (estoqueMovimentacao == null)
			throw new RuntimeException("estoqueMovimentacao não pode ser nulo!");
		estoqueMovimentacao.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.SAVE);
		op.setEstoqueMovimentacao(estoqueMovimentacao);
	}

	public void del(PanamahEstoqueMovimentacao estoqueMovimentacao) throws Exception {
		if (estoqueMovimentacao == null)
			throw new RuntimeException("estoqueMovimentacao não pode ser nulo!");
		estoqueMovimentacao.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.DELETE);
		op.setEstoqueMovimentacao(estoqueMovimentacao);
	}

	public void save(PanamahEventoCaixa eventoCaixa) throws Exception {
		if (eventoCaixa == null)
			throw new RuntimeException("eventoCaixa não pode ser nulo!");
		eventoCaixa.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.SAVE);
		op.setEventoCaixa(eventoCaixa);
	}

	public void del(PanamahEventoCaixa eventoCaixa) throws Exception {
		if (eventoCaixa == null)
			throw new RuntimeException("eventoCaixa não pode ser nulo!");
		eventoCaixa.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.DELETE);
		op.setEventoCaixa(eventoCaixa);
	}

	public void save(PanamahFormaPagamento formaPagamento) throws Exception {
		if (formaPagamento == null)
			throw new RuntimeException("formaPagamento não pode ser nulo!");
		formaPagamento.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.SAVE);
		op.setFormaPagamento(formaPagamento);
	}

	public void del(PanamahFormaPagamento formaPagamento) throws Exception {
		if (formaPagamento == null)
			throw new RuntimeException("formaPagamento não pode ser nulo!");
		formaPagamento.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.DELETE);
		op.setFormaPagamento(formaPagamento);
	}

	public void save(PanamahFornecedor fornecedor) throws Exception {
		if (fornecedor == null)
			throw new RuntimeException("fornecedor não pode ser nulo!");
		fornecedor.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.SAVE);
		op.setFornecedor(fornecedor);
	}

	public void del(PanamahFornecedor fornecedor) throws Exception {
		if (fornecedor == null)
			throw new RuntimeException("fornecedor não pode ser nulo!");
		fornecedor.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.DELETE);
		op.setFornecedor(fornecedor);

	}

	public void save(PanamahFuncionario funcionario) throws Exception {
		if (funcionario == null)
			throw new RuntimeException("funcionario não pode ser nulo!");
		funcionario.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.SAVE);
		op.setFuncionario(funcionario);
	}

	public void del(PanamahFuncionario funcionario) throws Exception {
		if (funcionario == null)
			throw new RuntimeException("funcionario não pode ser nulo!");
		funcionario.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.DELETE);
		op.setFuncionario(funcionario);
	}

	public void save(PanamahGrupo grupo) throws Exception {
		if (grupo == null)
			throw new RuntimeException("grupo não pode ser nulo!");
		grupo.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.SAVE);
		op.setGrupo(grupo);
	}

	public void del(PanamahGrupo grupo) throws Exception {
		if (grupo == null)
			throw new RuntimeException("grupo não pode ser nulo!");
		grupo.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.DELETE);
		op.setGrupo(grupo);
	}

	public void save(PanamahHolding holding) throws Exception {
		if (holding == null)
			throw new RuntimeException("holding não pode ser nulo!");
		holding.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.SAVE);
		op.setHolding(holding);
	}

	public void del(PanamahHolding holding) throws Exception {
		if (holding == null)
			throw new RuntimeException("holding não pode ser nulo!");
		holding.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.DELETE);
		op.setHolding(holding);
	}

	public void save(PanamahLocalEstoque localEstoque) throws Exception {
		if (localEstoque == null)
			throw new RuntimeException("localEstoque não pode ser nulo!");
		localEstoque.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.SAVE);
		op.setLocalEstoque(localEstoque);
	}

	public void del(PanamahLocalEstoque localEstoque) throws Exception {
		if (localEstoque == null)
			throw new RuntimeException("localEstoque não pode ser nulo!");
		localEstoque.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.DELETE);
		op.setLocalEstoque(localEstoque);
	}

	public void save(PanamahLoja loja) throws Exception {
		if (loja == null)
			throw new RuntimeException("loja não pode ser nulo!");
		loja.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.SAVE);
		op.setLoja(loja);
	}

	public void del(PanamahLoja loja) throws Exception {
		if (loja == null)
			throw new RuntimeException("loja não pode ser nulo!");
		loja.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.DELETE);
		op.setLoja(loja);
	}

	public void save(PanamahMeta meta) throws Exception {
		if (meta == null)
			throw new RuntimeException("meta não pode ser nulo!");
		meta.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.SAVE);
		op.setMeta(meta);

	}

	public void del(PanamahMeta meta) throws Exception {
		if (meta == null)
			throw new RuntimeException("meta não pode ser nulo!");
		meta.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.DELETE);
		op.setMeta(meta);

	}

	public void save(PanamahProduto produto) throws Exception {
		if (produto == null)
			throw new RuntimeException("produto não pode ser nulo!");
		produto.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.SAVE);
		op.setProduto(produto);

	}

	public void del(PanamahProduto produto) throws Exception {
		if (produto == null)
			throw new RuntimeException("produto não pode ser nulo!");
		produto.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.DELETE);
		op.setProduto(produto);

	}

	public void save(PanamahRevenda revenda) throws Exception {
		if (revenda == null)
			throw new RuntimeException("revenda não pode ser nulo!");
		revenda.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.SAVE);
		op.setRevenda(revenda);

	}

	public void del(PanamahRevenda revenda) throws Exception {
		if (revenda == null)
			throw new RuntimeException("revenda não pode ser nulo!");
		revenda.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.DELETE);
		op.setRevenda(revenda);

	}

	public void save(PanamahSecao secao) throws Exception {
		if (secao == null)
			throw new RuntimeException("secao não pode ser nulo!");
		secao.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.SAVE);
		op.setSecao(secao);

	}

	public void del(PanamahSecao secao) throws Exception {
		if (secao == null)
			throw new RuntimeException("secao não pode ser nulo!");
		secao.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.DELETE);
		op.setSecao(secao);

	}

	public void save(PanamahSubgrupo subgrupo) throws Exception {
		if (subgrupo == null)
			throw new RuntimeException("subgrupo não pode ser nulo!");
		subgrupo.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.SAVE);
		op.setSubgrupo(subgrupo);

	}

	public void del(PanamahSubgrupo subgrupo) throws Exception {
		if (subgrupo == null)
			throw new RuntimeException("subgrupo não pode ser nulo!");
		subgrupo.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.DELETE);
		op.setSubgrupo(subgrupo);

	}

	public void save(PanamahTituloPagar tituloPagar) throws Exception {
		if (tituloPagar == null)
			throw new RuntimeException("tituloPagar não pode ser nulo!");
		tituloPagar.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.SAVE);
		op.setTituloPagar(tituloPagar);

	}

	public void del(PanamahTituloPagar tituloPagar) throws Exception {
		if (tituloPagar == null)
			throw new RuntimeException("tituloPagar não pode ser nulo!");
		tituloPagar.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.DELETE);
		op.setTituloPagar(tituloPagar);

	}

	public void save(PanamahTituloReceber tituloReceber) throws Exception {
		if (tituloReceber == null)
			throw new RuntimeException("tituloReceber não pode ser nulo!");
		tituloReceber.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.SAVE);
		op.setTituloReceber(tituloReceber);

	}

	public void del(PanamahTituloReceber tituloReceber) throws Exception {
		if (tituloReceber == null)
			throw new RuntimeException("tituloReceber não pode ser nulo!");
		tituloReceber.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.DELETE);
		op.setTituloReceber(tituloReceber);

	}

	public void save(PanamahTrocaDevolucao trocaDevolucao) throws Exception {
		if (trocaDevolucao == null)
			throw new RuntimeException("trocaDevolucao não pode ser nulo!");
		trocaDevolucao.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.SAVE);
		op.setTrocaDevolucao(trocaDevolucao);

	}

	public void del(PanamahTrocaDevolucao trocaDevolucao) throws Exception {
		if (trocaDevolucao == null)
			throw new RuntimeException("trocaDevolucao não pode ser nulo!");
		trocaDevolucao.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.DELETE);
		op.setTrocaDevolucao(trocaDevolucao);

	}

	public void save(PanamahTrocaFormaPagamento trocaFormaPagamento) throws Exception {
		if (trocaFormaPagamento == null)
			throw new RuntimeException("trocaFormaPagamento não pode ser nulo!");
		trocaFormaPagamento.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.SAVE);
		op.setTrocaFormaPagamento(trocaFormaPagamento);

	}

	public void del(PanamahTrocaFormaPagamento trocaFormaPagamento) throws Exception {
		if (trocaFormaPagamento == null)
			throw new RuntimeException("trocaFormaPagamento não pode ser nulo!");
		trocaFormaPagamento.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.DELETE);
		op.setTrocaFormaPagamento(trocaFormaPagamento);

	}

	public void save(PanamahVenda venda) throws Exception {
		if (venda == null)
			throw new RuntimeException("venda não pode ser nulo!");
		venda.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.SAVE);
		op.setVenda(venda);

	}

	public void del(PanamahVenda venda) throws Exception {
		if (venda == null)
			throw new RuntimeException("venda não pode ser nulo!");
		venda.validate();
		if (operacoes == null)
			operacoes = new ArrayList<PanamahOperacao>();
		PanamahOperacao op = new PanamahOperacao();
		op.setTipo(PanamahTipoOperacao.DELETE);
		op.setVenda(venda);
	}

}
