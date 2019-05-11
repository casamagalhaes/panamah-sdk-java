package br.com.casamagalhaes.panamah.sdk;

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

public class PanamahOperacao {

	private PanamahAcesso acesso;
	private PanamahAssinante assinante;
	private PanamahCliente cliente;
	private PanamahCompra compra;
	private PanamahEan ean;
	private PanamahEstoqueMovimentacao estoqueMovimentacao;
	private PanamahEventoCaixa eventoCaixa;
	private PanamahFormaPagamento formaPagamento;
	private PanamahFornecedor fornecedor;
	private PanamahFuncionario funcionario;
	private PanamahGrupo grupo;
	private PanamahHolding holding;
	private PanamahLocalEstoque localEstoque;
	private PanamahLoja loja;
	private PanamahMeta meta;
	private PanamahProduto produto;
	private PanamahRevenda revenda;
	private PanamahSecao secao;
	private PanamahSubgrupo subgrupo;
	private PanamahTituloPagar tituloPagar;
	private PanamahTituloReceber tituloReceber;
	private PanamahTrocaDevolucao trocasDevolucao;
	private PanamahTrocaFormaPagamento trocaFormasPagamento;
	private PanamahVenda venda;

	private PanamahTipoOperacao tipo;

	public PanamahAcesso getAcesso() {
		return acesso;
	}

	public void setAcesso(PanamahAcesso acesso) {
		this.acesso = acesso;
	}

	public PanamahAssinante getAssinante() {
		return assinante;
	}

	public void setAssinante(PanamahAssinante assinante) {
		this.assinante = assinante;
	}

	public PanamahCliente getCliente() {
		return cliente;
	}

	public void setCliente(PanamahCliente cliente) {
		this.cliente = cliente;
	}

	public PanamahCompra getCompra() {
		return compra;
	}

	public void setCompra(PanamahCompra compra) {
		this.compra = compra;
	}

	public PanamahEan getEan() {
		return ean;
	}

	public void setEan(PanamahEan ean) {
		this.ean = ean;
	}

	public PanamahEstoqueMovimentacao getEstoqueMovimentacao() {
		return estoqueMovimentacao;
	}

	public void setEstoqueMovimentacao(PanamahEstoqueMovimentacao estoqueMovimentacao) {
		this.estoqueMovimentacao = estoqueMovimentacao;
	}

	public PanamahEventoCaixa getEventoCaixa() {
		return eventoCaixa;
	}

	public void setEventoCaixa(PanamahEventoCaixa eventoCaixa) {
		this.eventoCaixa = eventoCaixa;
	}

	public PanamahFormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(PanamahFormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public PanamahFornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(PanamahFornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public PanamahFuncionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(PanamahFuncionario funcionario) {
		this.funcionario = funcionario;
	}

	public PanamahGrupo getGrupo() {
		return grupo;
	}

	public void setGrupo(PanamahGrupo grupo) {
		this.grupo = grupo;
	}

	public PanamahHolding getHolding() {
		return holding;
	}

	public void setHolding(PanamahHolding holding) {
		this.holding = holding;
	}

	public PanamahLocalEstoque getLocalEstoque() {
		return localEstoque;
	}

	public void setLocalEstoque(PanamahLocalEstoque localEstoque) {
		this.localEstoque = localEstoque;
	}

	public PanamahLoja getLoja() {
		return loja;
	}

	public void setLoja(PanamahLoja loja) {
		this.loja = loja;
	}

	public PanamahMeta getMeta() {
		return meta;
	}

	public void setMeta(PanamahMeta meta) {
		this.meta = meta;
	}

	public PanamahProduto getProduto() {
		return produto;
	}

	public void setProduto(PanamahProduto produto) {
		this.produto = produto;
	}

	public PanamahRevenda getRevenda() {
		return revenda;
	}

	public void setRevenda(PanamahRevenda revenda) {
		this.revenda = revenda;
	}

	public PanamahSecao getSecao() {
		return secao;
	}

	public void setSecao(PanamahSecao secao) {
		this.secao = secao;
	}

	public PanamahSubgrupo getSubgrupo() {
		return subgrupo;
	}

	public void setSubgrupo(PanamahSubgrupo subgrupo) {
		this.subgrupo = subgrupo;
	}

	public PanamahTituloPagar getTituloPagar() {
		return tituloPagar;
	}

	public void setTituloPagar(PanamahTituloPagar tituloPagar) {
		this.tituloPagar = tituloPagar;
	}

	public PanamahTituloReceber getTituloReceber() {
		return tituloReceber;
	}

	public void setTituloReceber(PanamahTituloReceber tituloReceber) {
		this.tituloReceber = tituloReceber;
	}

	public PanamahTrocaDevolucao getTrocasDevolucao() {
		return trocasDevolucao;
	}

	public void setTrocasDevolucao(PanamahTrocaDevolucao trocasDevolucao) {
		this.trocasDevolucao = trocasDevolucao;
	}

	public PanamahTrocaFormaPagamento getTrocaFormasPagamento() {
		return trocaFormasPagamento;
	}

	public void setTrocaFormasPagamento(PanamahTrocaFormaPagamento trocaFormasPagamento) {
		this.trocaFormasPagamento = trocaFormasPagamento;
	}

	public PanamahVenda getVenda() {
		return venda;
	}

	public void setVenda(PanamahVenda venda) {
		this.venda = venda;
	}

	public PanamahTipoOperacao getTipo() {
		return tipo;
	}

	public void setTipo(PanamahTipoOperacao tipo) {
		this.tipo = tipo;
	}

}
