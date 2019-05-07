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
	private List<PanamahTrocaFormaPagamento> trocaFormasPagamentos;
	private List<PanamahVenda> vendas;

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
	public List<PanamahTrocaFormaPagamento> getTrocaFormasPagamentos() {
		return trocaFormasPagamentos;
	}

	/**
	 * @param formasPagamentos the formasPagamentos to set
	 */
	public void setTrocaFormasPagamentos(List<PanamahTrocaFormaPagamento> trocaFormasPagamentos) {
		this.trocaFormasPagamentos = trocaFormasPagamentos;
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

	/**
	 * enviar acesso para o lote
	 *
	 * @param acesso acesso
	 */
	public void add(PanamahAcesso acesso) throws Exception {
		if (this.acessos == null) {
			this.acessos = new ArrayList<PanamahAcesso>();
		}
		if (acesso == null)
			throw new NullPointerException("acesso não pode ser nulo");
		acesso.validate();
		this.acessos.add(acesso);
		this.ultimaAtualizacao = new Date();
	}

	/**
	 * enviar assinante para o lote
	 *
	 * @param assinante assinante
	 */
	public void add(PanamahAssinante assinante) throws Exception {
		if (this.assinantes == null) {
			this.assinantes = new ArrayList<PanamahAssinante>();
		}
		if (assinante == null)
			throw new NullPointerException("acesso não pode ser nulo");
		assinante.validate();
		this.assinantes.add(assinante);
		this.ultimaAtualizacao = new Date();
	}

	/**
	 * enviar cliente para o lote
	 *
	 * @param cliente cliente
	 */
	public void add(PanamahCliente cliente) throws Exception {
		if (this.clientes == null) {
			this.clientes = new ArrayList<PanamahCliente>();
		}
		if (cliente == null)
			throw new NullPointerException("cliente não pode ser nulo");
		cliente.validate();
		this.clientes.add(cliente);
		this.ultimaAtualizacao = new Date();
	}

	/**
	 * enviar compra para o lote
	 *
	 * @param compra compra
	 */
	public void add(PanamahCompra compra) throws Exception {
		if (this.compras == null) {
			this.compras = new ArrayList<PanamahCompra>();
		}
		if (compra == null)
			throw new NullPointerException("compra não pode ser nulo");
		compra.validate();
		this.compras.add(compra);
		this.ultimaAtualizacao = new Date();
	}

	/**
	 * enviar ean para o lote
	 *
	 * @param ean ean
	 */
	public void add(PanamahEan ean) throws Exception {
		if (this.eans == null) {
			this.eans = new ArrayList<PanamahEan>();
		}
		if (ean == null)
			throw new NullPointerException("ean não pode ser nulo");
		ean.validate();
		this.eans.add(ean);
		this.ultimaAtualizacao = new Date();
	}

	/**
	 * enviar movimentação de estoque para o lote
	 *
	 * @param estoqueMovimentacao estoqueMovimentacao
	 */
	public void add(PanamahEstoqueMovimentacao estoqueMovimentacao) throws Exception {
		if (this.estoqueMovimentacoes == null) {
			this.estoqueMovimentacoes = new ArrayList<PanamahEstoqueMovimentacao>();
		}
		if (estoqueMovimentacao == null)
			throw new NullPointerException("estoqueMovimentacao não pode ser nulo");
		estoqueMovimentacao.validate();
		this.estoqueMovimentacoes.add(estoqueMovimentacao);
		this.ultimaAtualizacao = new Date();
	}

	/**
	 * enviar evento de caixa para o lote
	 *
	 * @param eventoCaixa eventoCaixa
	 */
	public void add(PanamahEventoCaixa eventoCaixa) throws Exception {
		if (this.eventosCaixa == null) {
			this.eventosCaixa = new ArrayList<PanamahEventoCaixa>();
		}
		if (eventoCaixa == null)
			throw new NullPointerException("eventoCaixa não pode ser nulo");
		eventoCaixa.validate();
		this.eventosCaixa.add(eventoCaixa);
		this.ultimaAtualizacao = new Date();
	}

	/**
	 * enviar formaPagamento para o lote
	 *
	 * @param formaPagamento formaPagamento
	 */
	public void add(PanamahFormaPagamento formaPagamento) throws Exception {
		if (this.formasPagamento == null) {
			this.formasPagamento = new ArrayList<PanamahFormaPagamento>();
		}
		if (formaPagamento == null)
			throw new NullPointerException("formaPagamento não pode ser nulo");
		formaPagamento.validate();
		this.formasPagamento.add(formaPagamento);
		this.ultimaAtualizacao = new Date();
	}

	/**
	 * enviar fornecedor para o lote
	 *
	 * @param fornecedor fornecedor
	 */
	public void add(PanamahFornecedor fornecedor) throws Exception {
		if (this.fornecedores == null) {
			this.fornecedores = new ArrayList<PanamahFornecedor>();
		}
		if (fornecedor == null)
			throw new NullPointerException("fornecedor não pode ser nulo");
		fornecedor.validate();
		this.fornecedores.add(fornecedor);
		this.ultimaAtualizacao = new Date();
	}

	/**
	 * enviar funcionario para o lote
	 *
	 * @param funcionario funcionario
	 */
	public void add(PanamahFuncionario funcionario) throws Exception {
		if (this.funcionarios == null) {
			this.funcionarios = new ArrayList<PanamahFuncionario>();
		}
		if (funcionario == null)
			throw new NullPointerException("funcionario não pode ser nulo");
		funcionario.validate();
		this.funcionarios.add(funcionario);
		this.ultimaAtualizacao = new Date();
	}

	/**
	 * enviar grupo para o lote
	 *
	 * @param grupo grupo
	 */
	public void add(PanamahGrupo grupo) throws Exception {
		if (this.grupos == null) {
			this.grupos = new ArrayList<PanamahGrupo>();
		}
		if (grupo == null)
			throw new NullPointerException("grupo não pode ser nulo");
		grupo.validate();
		this.grupos.add(grupo);
		this.ultimaAtualizacao = new Date();
	}

	/**
	 * enviar holding para o lote
	 *
	 * @param holding holding
	 */
	public void add(PanamahHolding holding) throws Exception {
		if (this.holdings == null) {
			this.holdings = new ArrayList<PanamahHolding>();
		}
		if (holding == null)
			throw new NullPointerException("holding não pode ser nulo");
		holding.validate();
		this.holdings.add(holding);
		this.ultimaAtualizacao = new Date();
	}

	/**
	 * enviar localEstoque para o lote
	 *
	 * @param localEstoque localEstoque
	 */
	public void add(PanamahLocalEstoque localEstoque) throws Exception {
		if (this.locaisEstoque == null) {
			this.locaisEstoque = new ArrayList<PanamahLocalEstoque>();
		}
		if (localEstoque == null)
			throw new NullPointerException("localEstoque não pode ser nulo");
		localEstoque.validate();
		this.locaisEstoque.add(localEstoque);
		this.ultimaAtualizacao = new Date();
	}

	/**
	 * enviar loja para o lote
	 *
	 * @param loja loja
	 */
	public void add(PanamahLoja loja) throws Exception {
		if (this.lojas == null) {
			this.lojas = new ArrayList<PanamahLoja>();
		}
		if (loja == null)
			throw new NullPointerException("loja não pode ser nulo");
		loja.validate();
		this.lojas.add(loja);
		this.ultimaAtualizacao = new Date();

	}

	/**
	 * enviar meta para o lote
	 *
	 * @param meta meta
	 */
	public void add(PanamahMeta meta) throws Exception {
		if (this.metas == null) {
			this.metas = new ArrayList<PanamahMeta>();
		}
		if (meta == null)
			throw new NullPointerException("meta não pode ser nulo");
		meta.validate();
		this.metas.add(meta);
		this.ultimaAtualizacao = new Date();

	}

	/**
	 * enviar produto para o lote
	 *
	 * @param produto produto
	 */
	public void add(PanamahProduto produto) throws Exception {
		if (this.produtos == null) {
			this.produtos = new ArrayList<PanamahProduto>();
		}
		if (produto == null)
			throw new NullPointerException("produto não pode ser nulo");
		produto.validate();
		this.produtos.add(produto);
		this.ultimaAtualizacao = new Date();

	}

	/**
	 * enviar revenda para o lote
	 *
	 * @param revenda revenda
	 */
	public void add(PanamahRevenda revenda) throws Exception {
		if (this.revendas == null) {
			this.revendas = new ArrayList<PanamahRevenda>();
		}
		if (revenda == null)
			throw new NullPointerException("revenda não pode ser nulo");
		revenda.validate();
		this.revendas.add(revenda);
		this.ultimaAtualizacao = new Date();

	}

	/**
	 * enviar secao para o lote
	 *
	 * @param secao secao
	 */
	public void add(PanamahSecao secao) throws Exception {
		if (this.secoes == null) {
			this.secoes = new ArrayList<PanamahSecao>();
		}
		if (secao == null)
			throw new NullPointerException("secao não pode ser nulo");
		secao.validate();
		this.secoes.add(secao);
		this.ultimaAtualizacao = new Date();

	}

	/**
	 * enviar subgrupo para o lote
	 *
	 * @param subgrupo subgrupo
	 */
	public void add(PanamahSubgrupo subgrupo) throws Exception {
		if (this.subgrupos == null) {
			this.subgrupos = new ArrayList<PanamahSubgrupo>();
		}
		if (subgrupo == null)
			throw new NullPointerException("subgrupo não pode ser nulo");
		subgrupo.validate();
		this.subgrupos.add(subgrupo);
		this.ultimaAtualizacao = new Date();

	}

	/**
	 * enviar tituloPagar para o lote
	 *
	 * @param tituloPagar tituloPagar
	 */
	public void add(PanamahTituloPagar tituloPagar) throws Exception {
		if (this.titulosPagar == null) {
			this.titulosPagar = new ArrayList<PanamahTituloPagar>();
		}
		if (tituloPagar == null)
			throw new NullPointerException("tituloPagar não pode ser nulo");
		tituloPagar.validate();
		this.titulosPagar.add(tituloPagar);
		this.ultimaAtualizacao = new Date();

	}

	/**
	 * enviar tituloReceber para o lote
	 *
	 * @param tituloReceber tituloReceber
	 */
	public void add(PanamahTituloReceber tituloReceber) throws Exception {
		if (this.titulosReceber == null) {
			this.titulosReceber = new ArrayList<PanamahTituloReceber>();
		}
		if (tituloReceber == null)
			throw new NullPointerException("tituloReceber não pode ser nulo");
		tituloReceber.validate();
		this.titulosReceber.add(tituloReceber);
		this.ultimaAtualizacao = new Date();

	}

	/**
	 * enviar trocaDevolucao para o lote
	 *
	 * @param trocaDevolucao trocaDevolucao
	 */
	public void add(PanamahTrocaDevolucao trocaDevolucao) throws Exception {
		if (this.trocasDevolucoes == null) {
			this.trocasDevolucoes = new ArrayList<PanamahTrocaDevolucao>();
		}
		if (trocaDevolucao == null)
			throw new NullPointerException("trocaDevolucao não pode ser nulo");
		trocaDevolucao.validate();
		this.trocasDevolucoes.add(trocaDevolucao);
		this.ultimaAtualizacao = new Date();

	}

	/**
	 * enviar trocaFormaPagamento para o lote
	 *
	 * @param trocaFormaPagamento trocaFormaPagamento
	 */
	public void add(PanamahTrocaFormaPagamento trocaFormaPagamento) throws Exception {
		if (this.trocaFormasPagamentos == null) {
			this.trocaFormasPagamentos = new ArrayList<PanamahTrocaFormaPagamento>();
		}
		if (trocaFormaPagamento == null)
			throw new NullPointerException("trocaFormaPagamento não pode ser nulo");
		trocaFormaPagamento.validate();
		this.trocaFormasPagamentos.add(trocaFormaPagamento);
		this.ultimaAtualizacao = new Date();

	}

	/**
	 * enviar venda para o lote
	 *
	 * @param venda venda
	 * @throws Exception
	 */
	public void add(PanamahVenda venda) throws Exception {
		if (this.vendas == null) {
			this.vendas = new ArrayList<PanamahVenda>();
		}
		if (venda == null)
			throw new NullPointerException("venda não pode ser nulo");
		venda.validate();
		this.vendas.add(venda);
		this.ultimaAtualizacao = new Date();

	}

}
