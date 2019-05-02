package br.com.casamagalhaes.panamah.sdk;

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
	private Date ultimaAtualizacao = new Date();

	private List<PanamahAcesso> acessos;
	private List<PanamahAssinante> assinantes;
	private List<PanamahCliente> clientes;
	private List<PanamahCompra> compras;
	private List<PanamahEan> eans;
	private List<PanamahEstoqueMovimentacao> estoqueMovimentacoes;
	private List<PanamahEventoCaixa> eventosCaixa;
	private List<PanamahFormaPagamento> formasPagamento;
	private List<PanamahFornecedor> fornecedores;
	private List<PanamahFuncionario> funcionarios;
	private List<PanamahGrupo> grupos;
	private List<PanamahHolding> holdings;
	private List<PanamahLocalEstoque> locaisEstoque;
	private List<PanamahLoja> lojas;
	private List<PanamahMeta> metas;
	private List<PanamahProduto> produtos;
	private List<PanamahRevenda> revendas;
	private List<PanamahSecao> secoes;
	private List<PanamahSubgrupo> subgrupos;
	private List<PanamahTituloPagar> titulosPagar;
	private List<PanamahTituloReceber> titulosReceber;
	private List<PanamahTrocaDevolucao> trocasDevolucoes;
	private List<PanamahTrocaFormaPagamento> formasPagamentos;
	private List<PanamahVenda> vendas;

	public PanamahStatusLote getStatus() {
		return status;
	}
	
	public void setStatus(PanamahStatusLote status) {
		this.status = status;
	}
	
	public Date getUltimaAtualizacao() {
		return ultimaAtualizacao;
	}
	
	public void setUltimaAtualizacao(Date ultimaAtualizacao) {
		this.ultimaAtualizacao = ultimaAtualizacao;
	}
	
	/**
	 * @return the acessos
	 */
	public List<PanamahAcesso> getAcessos() {
		return acessos;
	}

	/**
	 * @param acessos the acessos to set
	 */
	public void setAcessos(List<PanamahAcesso> acessos) {
		this.acessos = acessos;
	}

	/**
	 * @return the assinantes
	 */
	public List<PanamahAssinante> getAssinantes() {
		return assinantes;
	}

	/**
	 * @param assinantes the assinantes to set
	 */
	public void setAssinantes(List<PanamahAssinante> assinantes) {
		this.assinantes = assinantes;
	}

	/**
	 * @return the clientes
	 */
	public List<PanamahCliente> getClientes() {
		return clientes;
	}

	/**
	 * @param clientes the clientes to set
	 */
	public void setClientes(List<PanamahCliente> clientes) {
		this.clientes = clientes;
	}

	/**
	 * @return the compras
	 */
	public List<PanamahCompra> getCompras() {
		return compras;
	}

	/**
	 * @param compras the compras to set
	 */
	public void setCompras(List<PanamahCompra> compras) {
		this.compras = compras;
	}

	/**
	 * @return the eans
	 */
	public List<PanamahEan> getEans() {
		return eans;
	}

	/**
	 * @param eans the eans to set
	 */
	public void setEans(List<PanamahEan> eans) {
		this.eans = eans;
	}

	/**
	 * @return the estoqueMovimentacoes
	 */
	public List<PanamahEstoqueMovimentacao> getEstoqueMovimentacoes() {
		return estoqueMovimentacoes;
	}

	/**
	 * @param estoqueMovimentacoes the estoqueMovimentacoes to set
	 */
	public void setEstoqueMovimentacoes(List<PanamahEstoqueMovimentacao> estoqueMovimentacoes) {
		this.estoqueMovimentacoes = estoqueMovimentacoes;
	}

	/**
	 * @return the eventosCaixa
	 */
	public List<PanamahEventoCaixa> getEventosCaixa() {
		return eventosCaixa;
	}

	/**
	 * @param eventosCaixa the eventosCaixa to set
	 */
	public void setEventosCaixa(List<PanamahEventoCaixa> eventosCaixa) {
		this.eventosCaixa = eventosCaixa;
	}

	/**
	 * @return the formasPagamento
	 */
	public List<PanamahFormaPagamento> getFormasPagamento() {
		return formasPagamento;
	}

	/**
	 * @param formasPagamento the formasPagamento to set
	 */
	public void setFormasPagamento(List<PanamahFormaPagamento> formasPagamento) {
		this.formasPagamento = formasPagamento;
	}

	/**
	 * @return the fornecedores
	 */
	public List<PanamahFornecedor> getFornecedores() {
		return fornecedores;
	}

	/**
	 * @param fornecedores the fornecedores to set
	 */
	public void setFornecedores(List<PanamahFornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	/**
	 * @return the funcionarios
	 */
	public List<PanamahFuncionario> getFuncionarios() {
		return funcionarios;
	}

	/**
	 * @param funcionarios the funcionarios to set
	 */
	public void setFuncionarios(List<PanamahFuncionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	/**
	 * @return the grupos
	 */
	public List<PanamahGrupo> getGrupos() {
		return grupos;
	}

	/**
	 * @param grupos the grupos to set
	 */
	public void setGrupos(List<PanamahGrupo> grupos) {
		this.grupos = grupos;
	}

	/**
	 * @return the holdings
	 */
	public List<PanamahHolding> getHoldings() {
		return holdings;
	}

	/**
	 * @param holdings the holdings to set
	 */
	public void setHoldings(List<PanamahHolding> holdings) {
		this.holdings = holdings;
	}

	/**
	 * @return the locaisEstoque
	 */
	public List<PanamahLocalEstoque> getLocaisEstoque() {
		return locaisEstoque;
	}

	/**
	 * @param locaisEstoque the locaisEstoque to set
	 */
	public void setLocaisEstoque(List<PanamahLocalEstoque> locaisEstoque) {
		this.locaisEstoque = locaisEstoque;
	}

	/**
	 * @return the lojas
	 */
	public List<PanamahLoja> getLojas() {
		return lojas;
	}

	/**
	 * @param lojas the lojas to set
	 */
	public void setLojas(List<PanamahLoja> lojas) {
		this.lojas = lojas;
	}

	/**
	 * @return the metas
	 */
	public List<PanamahMeta> getMetas() {
		return metas;
	}

	/**
	 * @param metas the metas to set
	 */
	public void setMetas(List<PanamahMeta> metas) {
		this.metas = metas;
	}

	/**
	 * @return the produtos
	 */
	public List<PanamahProduto> getProdutos() {
		return produtos;
	}

	/**
	 * @param produtos the produtos to set
	 */
	public void setProdutos(List<PanamahProduto> produtos) {
		this.produtos = produtos;
	}

	/**
	 * @return the revendas
	 */
	public List<PanamahRevenda> getRevendas() {
		return revendas;
	}

	/**
	 * @param revendas the revendas to set
	 */
	public void setRevendas(List<PanamahRevenda> revendas) {
		this.revendas = revendas;
	}

	/**
	 * @return the secoes
	 */
	public List<PanamahSecao> getSecoes() {
		return secoes;
	}

	/**
	 * @param secoes the secoes to set
	 */
	public void setSecoes(List<PanamahSecao> secoes) {
		this.secoes = secoes;
	}

	/**
	 * @return the subgrupos
	 */
	public List<PanamahSubgrupo> getSubgrupos() {
		return subgrupos;
	}

	/**
	 * @param subgrupos the subgrupos to set
	 */
	public void setSubgrupos(List<PanamahSubgrupo> subgrupos) {
		this.subgrupos = subgrupos;
	}

	/**
	 * @return the titulosPagar
	 */
	public List<PanamahTituloPagar> getTitulosPagar() {
		return titulosPagar;
	}

	/**
	 * @param titulosPagar the titulosPagar to set
	 */
	public void setTitulosPagar(List<PanamahTituloPagar> titulosPagar) {
		this.titulosPagar = titulosPagar;
	}

	/**
	 * @return the titulosReceber
	 */
	public List<PanamahTituloReceber> getTitulosReceber() {
		return titulosReceber;
	}

	/**
	 * @param titulosReceber the titulosReceber to set
	 */
	public void setTitulosReceber(List<PanamahTituloReceber> titulosReceber) {
		this.titulosReceber = titulosReceber;
	}

	/**
	 * @return the trocasDevolucoes
	 */
	public List<PanamahTrocaDevolucao> getTrocasDevolucoes() {
		return trocasDevolucoes;
	}

	/**
	 * @param trocasDevolucoes the trocasDevolucoes to set
	 */
	public void setTrocasDevolucoes(List<PanamahTrocaDevolucao> trocasDevolucoes) {
		this.trocasDevolucoes = trocasDevolucoes;
	}

	/**
	 * @return the formasPagamentos
	 */
	public List<PanamahTrocaFormaPagamento> getFormasPagamentos() {
		return formasPagamentos;
	}

	/**
	 * @param formasPagamentos the formasPagamentos to set
	 */
	public void setFormasPagamentos(List<PanamahTrocaFormaPagamento> formasPagamentos) {
		this.formasPagamentos = formasPagamentos;
	}

	/**
	 * @return the vendas
	 */
	public List<PanamahVenda> getVendas() {
		return vendas;
	}

	/**
	 * @param vendas the vendas to set
	 */
	public void setVendas(List<PanamahVenda> vendas) {
		this.vendas = vendas;
	}

}
