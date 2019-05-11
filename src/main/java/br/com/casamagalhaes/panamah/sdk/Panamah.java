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
	public void send(PanamahAcesso acesso) throws Exception {
		task.getLoteAtual().update(acesso);
		task.persisteLoteAtual();
		if (task.isLoteAtualCheio()) {
			task.fechaLoteAtual();
			task.verificaEnvio();
		}
	}

	/**
	 * enviar assinante para o lote
	 *
	 * @param assinante assinante
	 * @throws IOException
	 */
	public void send(PanamahAssinante assinante) throws Exception {
		task.getLoteAtual().update(assinante);
		task.persisteLoteAtual();
		if (task.isLoteAtualCheio()) {
			task.fechaLoteAtual();
			task.verificaEnvio();
		}
	}

	/**
	 * enviar cliente para o lote
	 *
	 * @param cliente cliente
	 * @throws IOException
	 */
	public void send(PanamahCliente cliente) throws Exception {
		task.getLoteAtual().update(cliente);
		task.persisteLoteAtual();
		if (task.isLoteAtualCheio()) {
			task.fechaLoteAtual();
			task.verificaEnvio();
		}
	}

	/**
	 * enviar compra para o lote
	 *
	 * @param compra compra
	 * @throws IOException
	 */
	public void send(PanamahCompra compra) throws Exception {
		task.getLoteAtual().update(compra);
		task.persisteLoteAtual();
		if (task.isLoteAtualCheio()) {
			task.fechaLoteAtual();
			task.verificaEnvio();
		}
	}

	/**
	 * enviar ean para o lote
	 *
	 * @param ean ean
	 * @throws IOException
	 */
	public void send(PanamahEan ean) throws Exception {
		task.getLoteAtual().update(ean);
		task.persisteLoteAtual();
		if (task.isLoteAtualCheio()) {
			task.fechaLoteAtual();
			task.verificaEnvio();
		}
	}

	/**
	 * enviar movimentação de estoque para o lote
	 *
	 * @param estoqueMovimentacao estoqueMovimentacao
	 * @throws IOException
	 */
	public void send(PanamahEstoqueMovimentacao estoqueMovimentacao) throws Exception {
		task.getLoteAtual().update(estoqueMovimentacao);
		task.persisteLoteAtual();
		if (task.isLoteAtualCheio()) {
			task.fechaLoteAtual();
			task.verificaEnvio();
		}
	}

	/**
	 * enviar evento de caixa para o lote
	 *
	 * @param eventoCaixa eventoCaixa
	 * @throws IOException
	 */
	public void send(PanamahEventoCaixa eventoCaixa) throws Exception {
		task.getLoteAtual().update(eventoCaixa);
		task.persisteLoteAtual();
		if (task.isLoteAtualCheio()) {
			task.fechaLoteAtual();
			task.verificaEnvio();
		}
	}

	/**
	 * enviar formaPagamento para o lote
	 *
	 * @param formaPagamento formaPagamento
	 * @throws IOException
	 */
	public void send(PanamahFormaPagamento formaPagamento) throws Exception {
		task.getLoteAtual().update(formaPagamento);
		task.persisteLoteAtual();
		if (task.isLoteAtualCheio()) {
			task.fechaLoteAtual();
			task.verificaEnvio();
		}
	}

	/**
	 * enviar fornecedor para o lote
	 *
	 * @param fornecedor fornecedor
	 * @throws IOException
	 */
	public void send(PanamahFornecedor fornecedor) throws Exception {
		task.getLoteAtual().update(fornecedor);
		task.persisteLoteAtual();
		if (task.isLoteAtualCheio()) {
			task.fechaLoteAtual();
			task.verificaEnvio();
		}
	}

	/**
	 * enviar funcionario para o lote
	 *
	 * @param funcionario funcionario
	 * @throws IOException
	 */
	public void send(PanamahFuncionario funcionario) throws Exception {
		task.getLoteAtual().update(funcionario);
		task.persisteLoteAtual();
		if (task.isLoteAtualCheio()) {
			task.fechaLoteAtual();
			task.verificaEnvio();
		}
	}

	/**
	 * enviar grupo para o lote
	 *
	 * @param grupo grupo
	 * @throws IOException
	 */
	public void send(PanamahGrupo grupo) throws Exception {
		task.getLoteAtual().update(grupo);
		task.persisteLoteAtual();
		if (task.isLoteAtualCheio()) {
			task.fechaLoteAtual();
			task.verificaEnvio();
		}
	}

	/**
	 * enviar holding para o lote
	 *
	 * @param holding holding
	 * @throws IOException
	 */
	public void send(PanamahHolding holding) throws Exception {
		task.getLoteAtual().update(holding);
		task.persisteLoteAtual();
		if (task.isLoteAtualCheio()) {
			task.fechaLoteAtual();
			task.verificaEnvio();
		}
	}

	/**
	 * enviar localEstoque para o lote
	 *
	 * @param localEstoque localEstoque
	 * @throws IOException
	 */
	public void send(PanamahLocalEstoque localEstoque) throws Exception {
		task.getLoteAtual().update(localEstoque);
		task.persisteLoteAtual();
		if (task.isLoteAtualCheio()) {
			task.fechaLoteAtual();
			task.verificaEnvio();
		}
	}

	/**
	 * enviar loja para o lote
	 *
	 * @param loja loja
	 * @throws IOException
	 */
	public void send(PanamahLoja loja) throws Exception {
		task.getLoteAtual().update(loja);
		task.persisteLoteAtual();
		if (task.isLoteAtualCheio()) {
			task.fechaLoteAtual();
			task.verificaEnvio();
		}
	}

	/**
	 * enviar meta para o lote
	 *
	 * @param meta meta
	 * @throws IOException
	 */
	public void send(PanamahMeta meta) throws Exception {
		task.getLoteAtual().update(meta);
		task.persisteLoteAtual();
		if (task.isLoteAtualCheio()) {
			task.fechaLoteAtual();
			task.verificaEnvio();
		}
	}

	/**
	 * enviar produto para o lote
	 *
	 * @param produto produto
	 * @throws IOException
	 */
	public void send(PanamahProduto produto) throws Exception {
		task.getLoteAtual().update(produto);
		task.persisteLoteAtual();
		if (task.isLoteAtualCheio()) {
			task.fechaLoteAtual();
			task.verificaEnvio();
		}
	}

	/**
	 * enviar revenda para o lote
	 *
	 * @param revenda revenda
	 * @throws IOException
	 */
	public void send(PanamahRevenda revenda) throws Exception {
		task.getLoteAtual().update(revenda);
		task.persisteLoteAtual();
		if (task.isLoteAtualCheio()) {
			task.fechaLoteAtual();
			task.verificaEnvio();
		}
	}

	/**
	 * enviar secao para o lote
	 *
	 * @param secao secao
	 * @throws IOException
	 */
	public void send(PanamahSecao secao) throws Exception {
		task.getLoteAtual().update(secao);
		task.persisteLoteAtual();
		if (task.isLoteAtualCheio()) {
			task.fechaLoteAtual();
			task.verificaEnvio();
		}
	}

	/**
	 * enviar subgrupo para o lote
	 *
	 * @param subgrupo subgrupo
	 * @throws IOException
	 */
	public void send(PanamahSubgrupo subgrupo) throws Exception {
		task.getLoteAtual().update(subgrupo);
		task.persisteLoteAtual();
		if (task.isLoteAtualCheio()) {
			task.fechaLoteAtual();
			task.verificaEnvio();
		}
	}

	/**
	 * enviar tituloPagar para o lote
	 *
	 * @param tituloPagar tituloPagar
	 * @throws IOException
	 */
	public void send(PanamahTituloPagar tituloPagar) throws Exception {
		task.getLoteAtual().update(tituloPagar);
		task.persisteLoteAtual();
		if (task.isLoteAtualCheio()) {
			task.fechaLoteAtual();
			task.verificaEnvio();
		}
	}

	/**
	 * enviar tituloReceber para o lote
	 *
	 * @param tituloReceber tituloReceber
	 * @throws IOException
	 */
	public void send(PanamahTituloReceber tituloReceber) throws Exception {
		task.getLoteAtual().update(tituloReceber);
		task.persisteLoteAtual();
		if (task.isLoteAtualCheio()) {
			task.fechaLoteAtual();
			task.verificaEnvio();
		}
	}

	/**
	 * enviar trocaDevolucao para o lote
	 *
	 * @param trocaDevolucao trocaDevolucao
	 * @throws Exception
	 */
	public void send(PanamahTrocaDevolucao trocaDevolucao) throws Exception {
		task.getLoteAtual().update(trocaDevolucao);
		task.persisteLoteAtual();
		if (task.isLoteAtualCheio()) {
			task.fechaLoteAtual();
			task.verificaEnvio();
		}
	}

	/**
	 * enviar trocaFormaPagamento para o lote
	 *
	 * @param trocaFormaPagamento trocaFormaPagamento
	 * @throws IOException
	 */
	public void send(PanamahTrocaFormaPagamento trocaFormaPagamento) throws Exception {
		task.getLoteAtual().update(trocaFormaPagamento);
		task.persisteLoteAtual();
		if (task.isLoteAtualCheio()) {
			task.fechaLoteAtual();
			task.verificaEnvio();
		}
	}

	/**
	 * enviar venda para o lote
	 *
	 * @param venda venda
	 * @throws IOException
	 */
	public void send(PanamahVenda venda) throws Exception {
		task.getLoteAtual().update(venda);
		task.persisteLoteAtual();
		if (task.isLoteAtualCheio()) {
			task.fechaLoteAtual();
			task.verificaEnvio();
		}
	}
}
