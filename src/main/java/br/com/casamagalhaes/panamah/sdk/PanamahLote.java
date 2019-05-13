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

	public void save(PanamahCompra compra) throws Exception {
		// TODO Auto-generated method stub

	}

	public void save(PanamahAssinante assinante) throws Exception {
		// TODO Auto-generated method stub

	}

	public void save(PanamahAcesso acesso) throws Exception {
		// TODO Auto-generated method stub

	}

	public void save(PanamahEan ean) throws Exception {
		// TODO Auto-generated method stub

	}

	public void save(PanamahEstoqueMovimentacao estoqueMovimentacao) throws Exception {
		// TODO Auto-generated method stub

	}

	public void save(PanamahEventoCaixa eventoCaixa) throws Exception {
		// TODO Auto-generated method stub

	}

	public void save(PanamahFormaPagamento formaPagamento) throws Exception {
		// TODO Auto-generated method stub

	}

	public void save(PanamahFornecedor fornecedor) throws Exception {
		// TODO Auto-generated method stub

	}

	public void save(PanamahFuncionario funcionario) throws Exception {
		// TODO Auto-generated method stub

	}

	public void save(PanamahGrupo grupo) throws Exception {
		// TODO Auto-generated method stub

	}

	public void save(PanamahHolding holding) throws Exception {
		// TODO Auto-generated method stub

	}

	public void save(PanamahLocalEstoque localEstoque) throws Exception {
		// TODO Auto-generated method stub

	}

	public void save(PanamahLoja loja) throws Exception {
		// TODO Auto-generated method stub

	}

	public void save(PanamahMeta meta) throws Exception {
		// TODO Auto-generated method stub

	}

	public void save(PanamahProduto produto) throws Exception {
		// TODO Auto-generated method stub

	}

	public void save(PanamahRevenda revenda) throws Exception {
		// TODO Auto-generated method stub

	}

	public void save(PanamahSecao secao) throws Exception {
		// TODO Auto-generated method stub

	}

	public void save(PanamahSubgrupo subgrupo) throws Exception {
		// TODO Auto-generated method stub

	}

	public void save(PanamahTituloPagar tituloPagar) throws Exception {
		// TODO Auto-generated method stub

	}

	public void save(PanamahTituloReceber tituloReceber) throws Exception {
		// TODO Auto-generated method stub

	}

	public void save(PanamahTrocaDevolucao trocaDevolucao) throws Exception {
		// TODO Auto-generated method stub

	}

	public void save(PanamahTrocaFormaPagamento trocaFormaPagamento) throws Exception {
		// TODO Auto-generated method stub

	}

	public void save(PanamahVenda venda) throws Exception {
		// TODO Auto-generated method stub

	}

	public void del(PanamahCliente cliente) throws Exception {
		// TODO Auto-generated method stub

	}

	public void del(PanamahCompra compra) throws Exception {
		// TODO Auto-generated method stub

	}

	public void del(PanamahAssinante assinante) throws Exception {
		// TODO Auto-generated method stub

	}

	public void del(PanamahAcesso acesso) throws Exception {
		// TODO Auto-generated method stub

	}

	public void del(PanamahEan ean) throws Exception {
		// TODO Auto-generated method stub

	}

	public void del(PanamahEstoqueMovimentacao estoqueMovimentacao) throws Exception {
		// TODO Auto-generated method stub

	}

	public void del(PanamahEventoCaixa eventoCaixa) throws Exception {
		// TODO Auto-generated method stub

	}

	public void del(PanamahFormaPagamento formaPagamento) throws Exception {
		// TODO Auto-generated method stub

	}

	public void del(PanamahFornecedor fornecedor) throws Exception {
		// TODO Auto-generated method stub

	}

	public void del(PanamahFuncionario funcionario) throws Exception {
		// TODO Auto-generated method stub

	}

	public void del(PanamahGrupo grupo) throws Exception {
		// TODO Auto-generated method stub

	}

	public void del(PanamahHolding holding) throws Exception {
		// TODO Auto-generated method stub

	}

	public void del(PanamahLocalEstoque localEstoque) throws Exception {
		// TODO Auto-generated method stub

	}

	public void del(PanamahLoja loja) throws Exception {
		// TODO Auto-generated method stub

	}

	public void del(PanamahMeta meta) throws Exception {
		// TODO Auto-generated method stub

	}

	public void del(PanamahProduto produto) throws Exception {
		// TODO Auto-generated method stub

	}

	public void del(PanamahRevenda revenda) throws Exception {
		// TODO Auto-generated method stub

	}

	public void del(PanamahSecao secao) throws Exception {
		// TODO Auto-generated method stub

	}

	public void del(PanamahSubgrupo subgrupo) throws Exception {
		// TODO Auto-generated method stub

	}

	public void del(PanamahTituloPagar tituloPagar) throws Exception {
		// TODO Auto-generated method stub

	}

	public void del(PanamahTituloReceber tituloReceber) throws Exception {
		// TODO Auto-generated method stub

	}

	public void del(PanamahTrocaDevolucao trocaDevolucao) throws Exception {
		// TODO Auto-generated method stub

	}

	public void del(PanamahTrocaFormaPagamento trocaFormaPagamento) throws Exception {
		// TODO Auto-generated method stub

	}

	public void del(PanamahVenda venda) throws Exception {
		// TODO Auto-generated method stub

	}

}
