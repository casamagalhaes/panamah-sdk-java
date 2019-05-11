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

	public void update(PanamahCliente cliente) {
		// TODO Auto-generated method stub

	}

	public void update(PanamahCompra compra) {
		// TODO Auto-generated method stub

	}

	public void update(PanamahAssinante assinante) {
		// TODO Auto-generated method stub

	}

	public void update(PanamahAcesso acesso) {
		// TODO Auto-generated method stub

	}

	public void update(PanamahEan ean) {
		// TODO Auto-generated method stub

	}

	public void update(PanamahEstoqueMovimentacao estoqueMovimentacao) {
		// TODO Auto-generated method stub

	}

	public void update(PanamahEventoCaixa eventoCaixa) {
		// TODO Auto-generated method stub

	}

	public void update(PanamahFormaPagamento formaPagamento) {
		// TODO Auto-generated method stub

	}

	public void update(PanamahFornecedor fornecedor) {
		// TODO Auto-generated method stub

	}

	public void update(PanamahFuncionario funcionario) {
		// TODO Auto-generated method stub

	}

	public void update(PanamahGrupo grupo) {
		// TODO Auto-generated method stub

	}

	public void update(PanamahHolding holding) {
		// TODO Auto-generated method stub

	}

	public void update(PanamahLocalEstoque localEstoque) {
		// TODO Auto-generated method stub

	}

	public void update(PanamahLoja loja) {
		// TODO Auto-generated method stub

	}

	public void update(PanamahMeta meta) {
		// TODO Auto-generated method stub

	}

	public void update(PanamahProduto produto) {
		// TODO Auto-generated method stub

	}

	public void update(PanamahRevenda revenda) {
		// TODO Auto-generated method stub

	}

	public void update(PanamahSecao secao) {
		// TODO Auto-generated method stub

	}

	public void update(PanamahSubgrupo subgrupo) {
		// TODO Auto-generated method stub

	}

	public void update(PanamahTituloPagar tituloPagar) {
		// TODO Auto-generated method stub

	}

	public void update(PanamahTituloReceber tituloReceber) {
		// TODO Auto-generated method stub

	}

	public void update(PanamahTrocaDevolucao trocaDevolucao) {
		// TODO Auto-generated method stub

	}

	public void update(PanamahTrocaFormaPagamento trocaFormaPagamento) {
		// TODO Auto-generated method stub

	}

	public void update(PanamahVenda venda) {
		// TODO Auto-generated method stub

	}

	public void del(PanamahCliente cliente) {
		// TODO Auto-generated method stub

	}

	public void del(PanamahCompra compra) {
		// TODO Auto-generated method stub

	}

	public void del(PanamahAssinante assinante) {
		// TODO Auto-generated method stub

	}

	public void del(PanamahAcesso acesso) {
		// TODO Auto-generated method stub

	}

	public void del(PanamahEan ean) {
		// TODO Auto-generated method stub

	}

	public void del(PanamahEstoqueMovimentacao estoqueMovimentacao) {
		// TODO Auto-generated method stub

	}

	public void del(PanamahEventoCaixa eventoCaixa) {
		// TODO Auto-generated method stub

	}

	public void del(PanamahFormaPagamento formaPagamento) {
		// TODO Auto-generated method stub

	}

	public void del(PanamahFornecedor fornecedor) {
		// TODO Auto-generated method stub

	}

	public void del(PanamahFuncionario funcionario) {
		// TODO Auto-generated method stub

	}

	public void del(PanamahGrupo grupo) {
		// TODO Auto-generated method stub

	}

	public void del(PanamahHolding holding) {
		// TODO Auto-generated method stub

	}

	public void del(PanamahLocalEstoque localEstoque) {
		// TODO Auto-generated method stub

	}

	public void del(PanamahLoja loja) {
		// TODO Auto-generated method stub

	}

	public void del(PanamahMeta meta) {
		// TODO Auto-generated method stub

	}

	public void del(PanamahProduto produto) {
		// TODO Auto-generated method stub

	}

	public void del(PanamahRevenda revenda) {
		// TODO Auto-generated method stub

	}

	public void del(PanamahSecao secao) {
		// TODO Auto-generated method stub

	}

	public void del(PanamahSubgrupo subgrupo) {
		// TODO Auto-generated method stub

	}

	public void del(PanamahTituloPagar tituloPagar) {
		// TODO Auto-generated method stub

	}

	public void del(PanamahTituloReceber tituloReceber) {
		// TODO Auto-generated method stub

	}

	public void del(PanamahTrocaDevolucao trocaDevolucao) {
		// TODO Auto-generated method stub

	}

	public void del(PanamahTrocaFormaPagamento trocaFormaPagamento) {
		// TODO Auto-generated method stub

	}

	public void del(PanamahVenda venda) {
		// TODO Auto-generated method stub

	}

}
