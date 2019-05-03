package br.com.casamagalhaes.panamah.sdk;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Timer;

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
import br.com.casamagalhaes.panamah.sdk.model.PanamahVenda;

/**
 * Panamah client
 *
 * @author Casa Magalhães
 *
 */
public class Panamah {

	private static Panamah instance;
	private Timer timer;
	private PanamahTask task;

	private Panamah(PanamahConfig config) throws FileNotFoundException, IOException {
		timer = new Timer("Panamah", true);
		task = new PanamahTask(config);
		timer.schedule(task, config.getDelay());
	}

	/**
	 * configuração inicial
	 *
	 * @return instância singleton
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public synchronized static Panamah init(PanamahConfig config) throws FileNotFoundException, IOException {
		if (instance == null) {
			instance = new Panamah(config);
		}
		return instance;
	}

	/**
	 * chamada para forçar o fechamento e envio do lote atual
	 */
	public void flush() {
		task.fechaLoteAtual();
		task.enviaLote();
		timer.cancel();
	}

	/**
	 * chamada para saber o status geral dos lotes
	 */
	public void progress() {

	}

	/**
	 * enviar acesso para o lote
	 *
	 * @param acesso acesso
	 */
	public void send(PanamahAcesso acesso) {

	}

	/**
	 * enviar assinante para o lote
	 *
	 * @param assinante assinante
	 */
	public void send(PanamahAssinante assinante) {

	}

	/**
	 * enviar cliente para o lote
	 *
	 * @param cliente cliente
	 */
	public void send(PanamahCliente cliente) {

	}

	/**
	 * enviar compra para o lote
	 *
	 * @param compra compra
	 */
	public void send(PanamahCompra compra) {

	}

	/**
	 * enviar ean para o lote
	 *
	 * @param ean ean
	 */
	public void send(PanamahEan ean) {

	}

	/**
	 * enviar movimentação de estoque para o lote
	 *
	 * @param estoqueMovimentacao estoqueMovimentacao
	 */
	public void send(PanamahEstoqueMovimentacao estoqueMovimentacao) {

	}

	/**
	 * enviar evento de caixa para o lote
	 *
	 * @param eventoCaixa eventoCaixa
	 */
	public void send(PanamahEventoCaixa eventoCaixa) {

	}

	/**
	 * enviar formaPagamento para o lote
	 *
	 * @param formaPagamento formaPagamento
	 */
	public void send(PanamahFormaPagamento formaPagamento) {

	}

	/**
	 * enviar fornecedor para o lote
	 *
	 * @param fornecedor fornecedor
	 */
	public void send(PanamahFornecedor fornecedor) {

	}

	/**
	 * enviar funcionario para o lote
	 *
	 * @param funcionario funcionario
	 */
	public void send(PanamahFuncionario funcionario) {

	}

	/**
	 * enviar grupo para o lote
	 *
	 * @param grupo grupo
	 */
	public void send(PanamahGrupo grupo) {

	}

	/**
	 * enviar holding para o lote
	 *
	 * @param holding holding
	 */
	public void send(PanamahHolding holding) {

	}

	/**
	 * enviar localEstoque para o lote
	 *
	 * @param localEstoque localEstoque
	 */
	public void send(PanamahLocalEstoque localEstoque) {

	}

	/**
	 * enviar loja para o lote
	 *
	 * @param loja loja
	 */
	public void send(PanamahLoja loja) {

	}

	/**
	 * enviar meta para o lote
	 *
	 * @param meta meta
	 */
	public void send(PanamahMeta meta) {

	}

	/**
	 * enviar produto para o lote
	 *
	 * @param produto produto
	 */
	public void send(PanamahProduto produto) {

	}

	/**
	 * enviar revenda para o lote
	 *
	 * @param revenda revenda
	 */
	public void send(PanamahRevenda revenda) {

	}

	/**
	 * enviar secao para o lote
	 *
	 * @param secao secao
	 */
	public void send(PanamahSecao secao) {

	}

	/**
	 * enviar subgrupo para o lote
	 *
	 * @param subgrupo subgrupo
	 */
	public void send(PanamahSubgrupo subgrupo) {

	}

	/**
	 * enviar tituloPagar para o lote
	 *
	 * @param tituloPagar tituloPagar
	 */
	public void send(PanamahTituloPagar tituloPagar) {

	}

	/**
	 * enviar tituloReceber para o lote
	 *
	 * @param tituloReceber tituloReceber
	 */
	public void send(PanamahTituloReceber tituloReceber) {

	}

	/**
	 * enviar trocaDevolucao para o lote
	 *
	 * @param trocaDevolucao trocaDevolucao
	 */
	public void send(PanamahTrocaDevolucao trocaDevolucao) {

	}

	/**
	 * enviar venda para o lote
	 *
	 * @param venda venda
	 */
	public void send(PanamahVenda venda) {

	}
}
