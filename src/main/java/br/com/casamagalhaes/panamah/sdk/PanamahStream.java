package br.com.casamagalhaes.panamah.sdk;

import java.io.IOException;
import java.util.Date;
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
 * PanamahStream client
 *
 * @author Casa Magalhães
 *
 */
public class PanamahStream {

	private static PanamahStream instance;
	private Timer timer;
	private PanamahTask task;
	private PanamahListener onSave;
	private PanamahListener onDel;
	
	private PanamahStream(PanamahConfig config) throws Exception {
		PanamahUtil.auth(config);
		timer = new Timer("PanamahStream", true);
		task = new PanamahTask(config);
		timer.scheduleAtFixedRate(task, new Date(), config.getDelay());
	}

	public synchronized static PanamahStream init(PanamahConfig config) throws Exception {
		if (instance == null) {
			instance = new PanamahStream(config);
		}
		return instance;
	}

	public void flush(boolean dispose) throws Exception {
		task.fechaLoteAtual();
		task.enviaLote();
		timer.cancel();
		PanamahStream.instance = null;
		if (dispose) {
			task.deletaLoteAtual();
		}
	}

	public void flush() throws Exception {
		flush(false);
	}

	public PanamahTask getTask() {
		return this.task;
	}

	public void progress() {

	}

	public PanamahPendencias pending(int start,int count) throws Exception {
		return this.task.pending(start, count);
	}
	
	public PanamahListener getOnSave() {
		return onSave;
	}

	public void setOnSave(PanamahListener onSave) {
		this.onSave = onSave;
	}

	public PanamahListener getOnDel() {
		return onDel;
	}

	public void setOnDel(PanamahListener onDel) {
		this.onDel = onDel;
	}

	/**
	 * enviar acesso para o lote
	 *
	 * @param acesso acesso
	 * @throws IOException
	 */
	public void save(PanamahAcesso model) throws Exception {
		PanamahEvent ev = null;
		if (onSave != null) {
			PanamahOperacao<PanamahAcesso> op = new PanamahOperacao<PanamahAcesso>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.ACESSO);
			op.setOp(PanamahTipoOperacao.UPDATE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onSave.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().save(model);
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
	public void save(PanamahAssinante model) throws Exception {
		PanamahEvent ev = null;
		if (onSave != null) {
			PanamahOperacao<PanamahAssinante> op = new PanamahOperacao<PanamahAssinante>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.ASSINANTE);
			op.setOp(PanamahTipoOperacao.UPDATE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onSave.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().save(model);
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
	public void save(PanamahCliente model) throws Exception {
		PanamahEvent ev = null;
		if (onSave != null) {
			PanamahOperacao<PanamahCliente> op = new PanamahOperacao<PanamahCliente>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.CLIENTE);
			op.setOp(PanamahTipoOperacao.UPDATE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onSave.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().save(model);
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
	public void save(PanamahCompra model) throws Exception {
		PanamahEvent ev = null;
		if (onSave != null) {
			PanamahOperacao<PanamahCompra> op = new PanamahOperacao<PanamahCompra>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.COMPRA);
			op.setOp(PanamahTipoOperacao.UPDATE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onSave.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().save(model);
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
	public void save(PanamahEan model) throws Exception {
		PanamahEvent ev = null;
		if (onSave != null) {
			PanamahOperacao<PanamahEan> op = new PanamahOperacao<PanamahEan>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.EAN);
			op.setOp(PanamahTipoOperacao.UPDATE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onSave.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().save(model);
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
	public void save(PanamahEstoqueMovimentacao model) throws Exception {
		PanamahEvent ev = null;
		if (onSave != null) {
			PanamahOperacao<PanamahEstoqueMovimentacao> op = new PanamahOperacao<PanamahEstoqueMovimentacao>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.ESTOQUE_MOVIMENTACAO);
			op.setOp(PanamahTipoOperacao.UPDATE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onSave.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().save(model);
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
	public void save(PanamahEventoCaixa model) throws Exception {
		PanamahEvent ev = null;
		if (onSave != null) {
			PanamahOperacao<PanamahEventoCaixa> op = new PanamahOperacao<PanamahEventoCaixa>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.EVENTO_CAIXA);
			op.setOp(PanamahTipoOperacao.UPDATE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onSave.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().save(model);
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
	public void save(PanamahFormaPagamento model) throws Exception {
		PanamahEvent ev = null;
		if (onSave != null) {
			PanamahOperacao<PanamahFormaPagamento> op = new PanamahOperacao<PanamahFormaPagamento>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.FORMA_PAGAMENTO);
			op.setOp(PanamahTipoOperacao.UPDATE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onSave.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().save(model);
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
	public void save(PanamahFornecedor model) throws Exception {
		PanamahEvent ev = null;
		if (onSave != null) {
			PanamahOperacao<PanamahFornecedor> op = new PanamahOperacao<PanamahFornecedor>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.FORNECEDOR);
			op.setOp(PanamahTipoOperacao.UPDATE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onSave.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().save(model);
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
	public void save(PanamahFuncionario model) throws Exception {
		PanamahEvent ev = null;
		if (onSave != null) {
			PanamahOperacao<PanamahFuncionario> op = new PanamahOperacao<PanamahFuncionario>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.FUNCIONARIO);
			op.setOp(PanamahTipoOperacao.UPDATE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onSave.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().save(model);
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
	public void save(PanamahGrupo model) throws Exception {
		PanamahEvent ev = null;
		if (onSave != null) {
			PanamahOperacao<PanamahGrupo> op = new PanamahOperacao<PanamahGrupo>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.GRUPO);
			op.setOp(PanamahTipoOperacao.UPDATE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onSave.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().save(model);
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
	public void save(PanamahHolding model) throws Exception {
		PanamahEvent ev = null;
		if (onSave != null) {
			PanamahOperacao<PanamahHolding> op = new PanamahOperacao<PanamahHolding>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.HOLDING);
			op.setOp(PanamahTipoOperacao.UPDATE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onSave.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().save(model);
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
	public void save(PanamahLocalEstoque model) throws Exception {
		PanamahEvent ev = null;
		if (onSave != null) {
			PanamahOperacao<PanamahLocalEstoque> op = new PanamahOperacao<PanamahLocalEstoque>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.LOCAL_ESTOQUE);
			op.setOp(PanamahTipoOperacao.UPDATE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onSave.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().save(model);
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
	public void save(PanamahLoja model) throws Exception {
		PanamahEvent ev = null;
		if (onSave != null) {
			PanamahOperacao<PanamahLoja> op = new PanamahOperacao<PanamahLoja>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.LOJA);
			op.setOp(PanamahTipoOperacao.UPDATE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onSave.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().save(model);
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
	public void save(PanamahMeta model) throws Exception {
		PanamahEvent ev = null;
		if (onSave != null) {
			PanamahOperacao<PanamahMeta> op = new PanamahOperacao<PanamahMeta>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.META);
			op.setOp(PanamahTipoOperacao.UPDATE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onSave.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().save(model);
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
	public void save(PanamahProduto model) throws Exception {
		PanamahEvent ev = null;
		if (onSave != null) {
			PanamahOperacao<PanamahProduto> op = new PanamahOperacao<PanamahProduto>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.PRODUTO);
			op.setOp(PanamahTipoOperacao.UPDATE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onSave.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().save(model);
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
	public void save(PanamahRevenda model) throws Exception {
		PanamahEvent ev = null;
		if (onSave != null) {
			PanamahOperacao<PanamahRevenda> op = new PanamahOperacao<PanamahRevenda>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.REVENDA);
			op.setOp(PanamahTipoOperacao.UPDATE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onSave.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().save(model);
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
	public void save(PanamahSecao model) throws Exception {
		PanamahEvent ev = null;
		if (onSave != null) {
			PanamahOperacao<PanamahSecao> op = new PanamahOperacao<PanamahSecao>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.SECAO);
			op.setOp(PanamahTipoOperacao.UPDATE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onSave.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().save(model);
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
	public void save(PanamahSubgrupo model) throws Exception {
		PanamahEvent ev = null;
		if (onSave != null) {
			PanamahOperacao<PanamahSubgrupo> op = new PanamahOperacao<PanamahSubgrupo>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.SUBGRUPO);
			op.setOp(PanamahTipoOperacao.UPDATE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onSave.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().save(model);
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
	public void save(PanamahTituloPagar model) throws Exception {
		PanamahEvent ev = null;
		if (onSave != null) {
			PanamahOperacao<PanamahTituloPagar> op = new PanamahOperacao<PanamahTituloPagar>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.TITULO_PAGAR);
			op.setOp(PanamahTipoOperacao.UPDATE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onSave.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().save(model);
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
	public void save(PanamahTituloReceber model) throws Exception {
		PanamahEvent ev = null;
		if (onSave != null) {
			PanamahOperacao<PanamahTituloReceber> op = new PanamahOperacao<PanamahTituloReceber>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.TITULO_RECEBER);
			op.setOp(PanamahTipoOperacao.UPDATE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onSave.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().save(model);
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
	public void save(PanamahTrocaDevolucao model) throws Exception {
		PanamahEvent ev = null;
		if (onSave != null) {
			PanamahOperacao<PanamahTrocaDevolucao> op = new PanamahOperacao<PanamahTrocaDevolucao>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.TROCA_DEVOLUCAO);
			op.setOp(PanamahTipoOperacao.UPDATE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onSave.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().save(model);
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
	public void save(PanamahTrocaFormaPagamento model) throws Exception {
		PanamahEvent ev = null;
		if (onSave != null) {
			PanamahOperacao<PanamahTrocaFormaPagamento> op = new PanamahOperacao<PanamahTrocaFormaPagamento>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.TROCA_FORMA_PAGAMENTO);
			op.setOp(PanamahTipoOperacao.UPDATE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onSave.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().save(model);
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
	public void save(PanamahVenda model) throws Exception {
		PanamahEvent ev = null;
		if (onSave != null) {
			PanamahOperacao<PanamahVenda> op = new PanamahOperacao<PanamahVenda>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.VENDA);
			op.setOp(PanamahTipoOperacao.UPDATE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onSave.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().save(model);
		task.persisteLoteAtual();
		if (task.isLoteAtualCheio()) {
			task.fechaLoteAtual();
			task.verificaEnvio();
		}
	}

	/**
	 * enviar acesso para o lote
	 *
	 * @param acesso acesso
	 * @throws IOException
	 */
	public void delete(PanamahAcesso model) throws Exception {
		PanamahEvent ev = null;
		if (onDel != null) {
			PanamahOperacao<PanamahAcesso> op = new PanamahOperacao<PanamahAcesso>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.ACESSO);
			op.setOp(PanamahTipoOperacao.DELETE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onDel.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().delete(model);
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
	public void delete(PanamahAssinante model) throws Exception {
		PanamahEvent ev = null;
		if (onDel != null) {
			PanamahOperacao<PanamahAssinante> op = new PanamahOperacao<PanamahAssinante>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.ASSINANTE);
			op.setOp(PanamahTipoOperacao.DELETE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onDel.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().delete(model);
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
	public void delete(PanamahCliente model) throws Exception {
		PanamahEvent ev = null;
		if (onDel != null) {
			PanamahOperacao<PanamahCliente> op = new PanamahOperacao<PanamahCliente>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.CLIENTE);
			op.setOp(PanamahTipoOperacao.DELETE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onDel.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().delete(model);
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
	public void delete(PanamahCompra model) throws Exception {
		PanamahEvent ev = null;
		if (onDel != null) {
			PanamahOperacao<PanamahCompra> op = new PanamahOperacao<PanamahCompra>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.COMPRA);
			op.setOp(PanamahTipoOperacao.DELETE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onDel.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().delete(model);
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
	public void delete(PanamahEan model) throws Exception {
		PanamahEvent ev = null;
		if (onDel != null) {
			PanamahOperacao<PanamahEan> op = new PanamahOperacao<PanamahEan>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.EAN);
			op.setOp(PanamahTipoOperacao.DELETE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onDel.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().delete(model);
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
	public void delete(PanamahEstoqueMovimentacao model) throws Exception {
		PanamahEvent ev = null;
		if (onDel != null) {
			PanamahOperacao<PanamahEstoqueMovimentacao> op = new PanamahOperacao<PanamahEstoqueMovimentacao>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.ESTOQUE_MOVIMENTACAO);
			op.setOp(PanamahTipoOperacao.DELETE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onDel.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().delete(model);
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
	public void delete(PanamahEventoCaixa model) throws Exception {
		PanamahEvent ev = null;
		if (onDel != null) {
			PanamahOperacao<PanamahEventoCaixa> op = new PanamahOperacao<PanamahEventoCaixa>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.EVENTO_CAIXA);
			op.setOp(PanamahTipoOperacao.DELETE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onDel.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().delete(model);
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
	public void delete(PanamahFormaPagamento model) throws Exception {
		PanamahEvent ev = null;
		if (onDel != null) {
			PanamahOperacao<PanamahFormaPagamento> op = new PanamahOperacao<PanamahFormaPagamento>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.FORMA_PAGAMENTO);
			op.setOp(PanamahTipoOperacao.DELETE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onDel.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().delete(model);
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
	public void delete(PanamahFornecedor model) throws Exception {
		PanamahEvent ev = null;
		if (onDel != null) {
			PanamahOperacao<PanamahFornecedor> op = new PanamahOperacao<PanamahFornecedor>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.FORNECEDOR);
			op.setOp(PanamahTipoOperacao.DELETE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onDel.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().delete(model);
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
	public void delete(PanamahFuncionario model) throws Exception {
		PanamahEvent ev = null;
		if (onDel != null) {
			PanamahOperacao<PanamahFuncionario> op = new PanamahOperacao<PanamahFuncionario>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.FUNCIONARIO);
			op.setOp(PanamahTipoOperacao.DELETE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onDel.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().delete(model);
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
	public void delete(PanamahGrupo model) throws Exception {
		PanamahEvent ev = null;
		if (onDel != null) {
			PanamahOperacao<PanamahGrupo> op = new PanamahOperacao<PanamahGrupo>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.GRUPO);
			op.setOp(PanamahTipoOperacao.DELETE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onDel.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().delete(model);
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
	public void delete(PanamahHolding model) throws Exception {
		PanamahEvent ev = null;
		if (onDel != null) {
			PanamahOperacao<PanamahHolding> op = new PanamahOperacao<PanamahHolding>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.HOLDING);
			op.setOp(PanamahTipoOperacao.DELETE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onDel.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().delete(model);
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
	public void delete(PanamahLocalEstoque model) throws Exception {
		PanamahEvent ev = null;
		if (onDel != null) {
			PanamahOperacao<PanamahLocalEstoque> op = new PanamahOperacao<PanamahLocalEstoque>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.LOCAL_ESTOQUE);
			op.setOp(PanamahTipoOperacao.DELETE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onDel.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().delete(model);
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
	public void delete(PanamahLoja model) throws Exception {
		PanamahEvent ev = null;
		if (onDel != null) {
			PanamahOperacao<PanamahLoja> op = new PanamahOperacao<PanamahLoja>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.LOJA);
			op.setOp(PanamahTipoOperacao.DELETE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onDel.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().delete(model);
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
	public void delete(PanamahMeta model) throws Exception {
		PanamahEvent ev = null;
		if (onDel != null) {
			PanamahOperacao<PanamahMeta> op = new PanamahOperacao<PanamahMeta>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.META);
			op.setOp(PanamahTipoOperacao.DELETE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onDel.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().delete(model);
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
	public void delete(PanamahProduto model) throws Exception {
		PanamahEvent ev = null;
		if (onDel != null) {
			PanamahOperacao<PanamahProduto> op = new PanamahOperacao<PanamahProduto>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.PRODUTO);
			op.setOp(PanamahTipoOperacao.DELETE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onDel.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().delete(model);
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
	public void delete(PanamahRevenda model) throws Exception {
		PanamahEvent ev = null;
		if (onDel != null) {
			PanamahOperacao<PanamahRevenda> op = new PanamahOperacao<PanamahRevenda>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.REVENDA);
			op.setOp(PanamahTipoOperacao.DELETE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onDel.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().delete(model);
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
	public void delete(PanamahSecao model) throws Exception {
		PanamahEvent ev = null;
		if (onDel != null) {
			PanamahOperacao<PanamahSecao> op = new PanamahOperacao<PanamahSecao>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.SECAO);
			op.setOp(PanamahTipoOperacao.DELETE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onDel.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().delete(model);
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
	public void delete(PanamahSubgrupo model) throws Exception {
		PanamahEvent ev = null;
		if (onDel != null) {
			PanamahOperacao<PanamahSubgrupo> op = new PanamahOperacao<PanamahSubgrupo>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.SUBGRUPO);
			op.setOp(PanamahTipoOperacao.DELETE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onDel.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().delete(model);
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
	public void delete(PanamahTituloPagar model) throws Exception {
		PanamahEvent ev = null;
		if (onDel != null) {
			PanamahOperacao<PanamahTituloPagar> op = new PanamahOperacao<PanamahTituloPagar>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.TITULO_PAGAR);
			op.setOp(PanamahTipoOperacao.DELETE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onDel.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().delete(model);
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
	public void delete(PanamahTituloReceber model) throws Exception {
		PanamahEvent ev = null;
		if (onDel != null) {
			PanamahOperacao<PanamahTituloReceber> op = new PanamahOperacao<PanamahTituloReceber>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.TITULO_RECEBER);
			op.setOp(PanamahTipoOperacao.DELETE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onDel.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().delete(model);
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
	public void delete(PanamahTrocaDevolucao model) throws Exception {
		PanamahEvent ev = null;
		if (onDel != null) {
			PanamahOperacao<PanamahTrocaDevolucao> op = new PanamahOperacao<PanamahTrocaDevolucao>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.TROCA_DEVOLUCAO);
			op.setOp(PanamahTipoOperacao.DELETE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onDel.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().delete(model);
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
	public void delete(PanamahTrocaFormaPagamento model) throws Exception {
		PanamahEvent ev = null;
		if (onDel != null) {
			PanamahOperacao<PanamahTrocaFormaPagamento> op = new PanamahOperacao<PanamahTrocaFormaPagamento>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.TROCA_FORMA_PAGAMENTO);
			op.setOp(PanamahTipoOperacao.DELETE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onDel.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().delete(model);
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
	public void delete(PanamahVenda model) throws Exception {
		PanamahEvent ev = null;
		if (onDel != null) {
			PanamahOperacao<PanamahVenda> op = new PanamahOperacao<PanamahVenda>();
			op.setData(model);
			op.setTipo(PanamahTipoModel.VENDA);
			op.setOp(PanamahTipoOperacao.DELETE);
			ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
			onDel.notify(ev);
		}
		if (ev != null && ev.isCancelled())
			return;
		task.getLoteAtual().delete(model);
		task.persisteLoteAtual();
		if (task.isLoteAtualCheio()) {
			task.fechaLoteAtual();
			task.verificaEnvio();
		}
	}

	public void readNFe(String filePath) throws Exception {
		task.readNFe(filePath);
		task.persisteLoteAtual();
		if (task.isLoteAtualCheio()) {
			task.fechaLoteAtual();
			task.verificaEnvio();
		}
	}
}
