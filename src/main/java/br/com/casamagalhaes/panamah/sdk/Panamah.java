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
import br.com.casamagalhaes.panamah.sdk.model.PanamahTrocaFormaPagamento;
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
		PanamahUtil.auth(config);
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
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public void flush() throws FileNotFoundException, IOException {
		task.fechaLoteAtual();
		task.enviaLote();
		timer.cancel();
		Panamah.instance = null;
	}

	PanamahTask getTask() {
		return this.task;
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
	 * @throws IOException 
	 */
	public void send(PanamahAcesso acesso) throws IOException {
		task.getLoteAtual().add(acesso);
		task.persisteLoteAtual();
	}

	/**
	 * enviar assinante para o lote
	 *
	 * @param assinante assinante
	 * @throws IOException 
	 */
	public void send(PanamahAssinante assinante) throws IOException {
		task.getLoteAtual().add(assinante);
		task.persisteLoteAtual();
	}

	/**
	 * enviar cliente para o lote
	 *
	 * @param cliente cliente
	 * @throws IOException 
	 */
	public void send(PanamahCliente cliente) throws IOException {
		task.getLoteAtual().add(cliente);
		task.persisteLoteAtual();
	}

	/**
	 * enviar compra para o lote
	 *
	 * @param compra compra
	 * @throws IOException 
	 */
	public void send(PanamahCompra compra) throws IOException {
		task.getLoteAtual().add(compra);
		task.persisteLoteAtual();
	}

	/**
	 * enviar ean para o lote
	 *
	 * @param ean ean
	 * @throws IOException 
	 */
	public void send(PanamahEan ean) throws IOException {
		task.getLoteAtual().add(ean);
		task.persisteLoteAtual();
	}

	/**
	 * enviar movimentação de estoque para o lote
	 *
	 * @param estoqueMovimentacao estoqueMovimentacao
	 * @throws IOException 
	 */
	public void send(PanamahEstoqueMovimentacao estoqueMovimentacao) throws IOException {
		task.getLoteAtual().add(estoqueMovimentacao);
		task.persisteLoteAtual();
	}

	/**
	 * enviar evento de caixa para o lote
	 *
	 * @param eventoCaixa eventoCaixa
	 * @throws IOException 
	 */
	public void send(PanamahEventoCaixa eventoCaixa) throws IOException {
		task.getLoteAtual().add(eventoCaixa);
		task.persisteLoteAtual();
	}

	/**
	 * enviar formaPagamento para o lote
	 *
	 * @param formaPagamento formaPagamento
	 * @throws IOException 
	 */
	public void send(PanamahFormaPagamento formaPagamento) throws IOException {
		task.getLoteAtual().add(formaPagamento);
		task.persisteLoteAtual();
	}

	/**
	 * enviar fornecedor para o lote
	 *
	 * @param fornecedor fornecedor
	 * @throws IOException 
	 */
	public void send(PanamahFornecedor fornecedor) throws IOException {
		task.getLoteAtual().add(fornecedor);
		task.persisteLoteAtual();
	}

	/**
	 * enviar funcionario para o lote
	 *
	 * @param funcionario funcionario
	 * @throws IOException 
	 */
	public void send(PanamahFuncionario funcionario) throws IOException {
		task.getLoteAtual().add(funcionario);
		task.persisteLoteAtual();
	}

	/**
	 * enviar grupo para o lote
	 *
	 * @param grupo grupo
	 * @throws IOException 
	 */
	public void send(PanamahGrupo grupo) throws IOException {
		task.getLoteAtual().add(grupo);
		task.persisteLoteAtual();
	}

	/**
	 * enviar holding para o lote
	 *
	 * @param holding holding
	 * @throws IOException 
	 */
	public void send(PanamahHolding holding) throws IOException {
		task.getLoteAtual().add(holding);
		task.persisteLoteAtual();
	}

	/**
	 * enviar localEstoque para o lote
	 *
	 * @param localEstoque localEstoque
	 * @throws IOException 
	 */
	public void send(PanamahLocalEstoque localEstoque) throws IOException {
		task.getLoteAtual().add(localEstoque);
		task.persisteLoteAtual();
	}

	/**
	 * enviar loja para o lote
	 *
	 * @param loja loja
	 * @throws IOException 
	 */
	public void send(PanamahLoja loja) throws IOException {
		task.getLoteAtual().add(loja);
		task.persisteLoteAtual();
	}

	/**
	 * enviar meta para o lote
	 *
	 * @param meta meta
	 * @throws IOException 
	 */
	public void send(PanamahMeta meta) throws IOException {
		task.getLoteAtual().add(meta);
		task.persisteLoteAtual();
	}

	/**
	 * enviar produto para o lote
	 *
	 * @param produto produto
	 * @throws IOException 
	 */
	public void send(PanamahProduto produto) throws IOException {
		task.getLoteAtual().add(produto);
		task.persisteLoteAtual();
	}

	/**
	 * enviar revenda para o lote
	 *
	 * @param revenda revenda
	 * @throws IOException 
	 */
	public void send(PanamahRevenda revenda) throws IOException {
		task.getLoteAtual().add(revenda);
		task.persisteLoteAtual();
	}

	/**
	 * enviar secao para o lote
	 *
	 * @param secao secao
	 * @throws IOException 
	 */
	public void send(PanamahSecao secao) throws IOException {
		task.getLoteAtual().add(secao);
		task.persisteLoteAtual();
	}

	/**
	 * enviar subgrupo para o lote
	 *
	 * @param subgrupo subgrupo
	 * @throws IOException 
	 */
	public void send(PanamahSubgrupo subgrupo) throws IOException {
		task.getLoteAtual().add(subgrupo);
		task.persisteLoteAtual();
	}

	/**
	 * enviar tituloPagar para o lote
	 *
	 * @param tituloPagar tituloPagar
	 * @throws IOException 
	 */
	public void send(PanamahTituloPagar tituloPagar) throws IOException {
		task.getLoteAtual().add(tituloPagar);
		task.persisteLoteAtual();
	}

	/**
	 * enviar tituloReceber para o lote
	 *
	 * @param tituloReceber tituloReceber
	 * @throws IOException 
	 */
	public void send(PanamahTituloReceber tituloReceber) throws IOException {
		task.getLoteAtual().add(tituloReceber);
		task.persisteLoteAtual();
	}

	/**
	 * enviar trocaDevolucao para o lote
	 *
	 * @param trocaDevolucao trocaDevolucao
	 * @throws IOException 
	 */
	public void send(PanamahTrocaDevolucao trocaDevolucao) throws IOException {
		task.getLoteAtual().add(trocaDevolucao);
		task.persisteLoteAtual();
	}

	/**
	 * enviar trocaFormaPagamento para o lote
	 *
	 * @param trocaFormaPagamento trocaFormaPagamento
	 * @throws IOException 
	 */
	public void send(PanamahTrocaFormaPagamento trocaFormaPagamento) throws IOException {
		task.getLoteAtual().add(trocaFormaPagamento);
		task.persisteLoteAtual();
	}

	/**
	 * enviar venda para o lote
	 *
	 * @param venda venda
	 * @throws IOException 
	 */
	public void send(PanamahVenda venda) throws IOException {
		task.getLoteAtual().add(venda);
		task.persisteLoteAtual();
	}
}
