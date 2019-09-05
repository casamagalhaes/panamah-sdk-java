package br.com.casamagalhaes.panamah.sdk;

import br.com.casamagalhaes.panamah.sdk.model.*;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Timer;

/**
 * PanamahStream client
 *
 * @author Casa Magalhães
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
        return task;
    }

    public HashMap<String, PanamahPendencias> pending(int start, int count) throws Exception {
        return task.pending(start, count);
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

    private <T extends IPanamahModel> void processaOp(T model, String assinanteId, PanamahTipoOperacao tipoOp) throws Exception {
        if (model == null)
            throw new RuntimeException("model não pode ser nulo!");
        model.validate();

        PanamahOperacao<T> op = new PanamahOperacao<>();
        op.setData(model);
        op.setTipo(PanamahTipoModel.ACESSO);
        op.setOp(tipoOp);
        if (assinanteId == null)
            assinanteId = task.getConfig().getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);

        PanamahEvent ev = new PanamahEvent(task.getConfig(), task.getLoteAtual(), op, null);
        if (onSave != null)
            onSave.notify(ev);
        if (ev.isCancelled())
            return;
        // TODO resolver a concorrência aqui
        task.getLoteAtual().save(op);
        task.persisteLoteAtual();
    }

    public void save(PanamahAcesso model) throws Exception {
        save(model, null);
    }

    public void save(PanamahAcesso model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.UPDATE);
    }

    public void delete(PanamahAcesso model) throws Exception {
        delete(model, null);
    }

    public void delete(PanamahAcesso model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.DELETE);
    }

    public void save(PanamahAssinante model) throws Exception {
        save(model, null);
    }

    public void save(PanamahAssinante model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.UPDATE);
    }

    public void delete(PanamahAssinante model) throws Exception {
        delete(model, null);
    }

    public void delete(PanamahAssinante model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.DELETE);
    }

    public void save(PanamahCliente model) throws Exception {
        save(model, null);
    }

    public void save(PanamahCliente model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.UPDATE);
    }

    public void delete(PanamahCliente model) throws Exception {
        delete(model, null);
    }

    public void delete(PanamahCliente model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.DELETE);
    }

    public void save(PanamahCompra model) throws Exception {
        save(model, null);
    }

    public void save(PanamahCompra model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.UPDATE);
    }

    public void delete(PanamahCompra model) throws Exception {
        delete(model, null);
    }

    public void delete(PanamahCompra model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.DELETE);
    }

    public void save(PanamahEan model) throws Exception {
        save(model, null);
    }

    public void save(PanamahEan model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.UPDATE);
    }

    public void delete(PanamahEan model) throws Exception {
        delete(model, null);
    }

    public void delete(PanamahEan model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.DELETE);
    }

    public void save(PanamahEstoqueMovimentacao model) throws Exception {
        save(model, null);
    }

    public void save(PanamahEstoqueMovimentacao model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.UPDATE);
    }

    public void delete(PanamahEstoqueMovimentacao model) throws Exception {
        delete(model, null);
    }

    public void delete(PanamahEstoqueMovimentacao model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.DELETE);
    }

    public void save(PanamahEventoCaixa model) throws Exception {
        save(model, null);
    }

    public void save(PanamahEventoCaixa model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.UPDATE);
    }

    public void delete(PanamahEventoCaixa model) throws Exception {
        delete(model, null);
    }

    public void delete(PanamahEventoCaixa model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.DELETE);
    }

    public void save(PanamahFormaPagamento model) throws Exception {
        save(model, null);
    }

    public void save(PanamahFormaPagamento model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.UPDATE);
    }

    public void delete(PanamahFormaPagamento model) throws Exception {
        delete(model, null);
    }

    public void delete(PanamahFormaPagamento model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.DELETE);
    }

    public void save(PanamahFornecedor model) throws Exception {
        save(model, null);
    }

    public void save(PanamahFornecedor model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.UPDATE);
    }

    public void delete(PanamahFornecedor model) throws Exception {
        delete(model, null);
    }

    public void delete(PanamahFornecedor model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.DELETE);
    }

    public void save(PanamahFuncionario model) throws Exception {
        save(model, null);
    }

    public void save(PanamahFuncionario model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.UPDATE);
    }

    public void delete(PanamahFuncionario model) throws Exception {
        delete(model, null);
    }

    public void delete(PanamahFuncionario model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.DELETE);
    }

    public void save(PanamahGrupo model) throws Exception {
        save(model, null);
    }

    public void save(PanamahGrupo model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.UPDATE);
    }

    public void delete(PanamahGrupo model) throws Exception {
        delete(model, null);
    }

    public void delete(PanamahGrupo model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.DELETE);
    }

    public void save(PanamahHolding model) throws Exception {
        save(model, null);
    }

    public void save(PanamahHolding model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.UPDATE);
    }

    public void delete(PanamahHolding model) throws Exception {
        delete(model, null);
    }

    public void delete(PanamahHolding model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.DELETE);
    }

    public void save(PanamahLocalEstoque model) throws Exception {
        save(model, null);
    }

    public void save(PanamahLocalEstoque model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.UPDATE);
    }

    public void delete(PanamahLocalEstoque model) throws Exception {
        delete(model, null);
    }

    public void delete(PanamahLocalEstoque model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.DELETE);
    }

    public void save(PanamahLoja model) throws Exception {
        save(model, null);
    }

    public void save(PanamahLoja model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.UPDATE);
    }

    public void delete(PanamahLoja model) throws Exception {
        delete(model, null);
    }

    public void delete(PanamahLoja model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.DELETE);
    }

    public void save(PanamahMeta model) throws Exception {
        save(model, null);
    }

    public void save(PanamahMeta model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.UPDATE);
    }

    public void delete(PanamahMeta model) throws Exception {
        delete(model, null);
    }

    public void delete(PanamahMeta model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.DELETE);
    }

    public void save(PanamahProduto model) throws Exception {
        save(model, null);
    }

    public void save(PanamahProduto model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.UPDATE);
    }

    public void delete(PanamahProduto model) throws Exception {
        delete(model, null);
    }

    public void delete(PanamahProduto model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.DELETE);
    }

    public void save(PanamahRevenda model) throws Exception {
        save(model, null);
    }

    public void save(PanamahRevenda model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.UPDATE);
    }

    public void delete(PanamahRevenda model) throws Exception {
        delete(model, null);
    }

    public void delete(PanamahRevenda model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.DELETE);
    }

    public void save(PanamahSecao model) throws Exception {
        save(model, null);
    }

    public void save(PanamahSecao model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.UPDATE);
    }

    public void delete(PanamahSecao model) throws Exception {
        delete(model, null);
    }

    public void delete(PanamahSecao model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.DELETE);
    }

    public void save(PanamahSubgrupo model) throws Exception {
        save(model, null);
    }

    public void save(PanamahSubgrupo model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.UPDATE);
    }

    public void delete(PanamahSubgrupo model) throws Exception {
        delete(model, null);
    }

    public void delete(PanamahSubgrupo model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.DELETE);
    }

    public void save(PanamahTituloPagar model) throws Exception {
        save(model, null);
    }

    public void save(PanamahTituloPagar model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.UPDATE);
    }

    public void delete(PanamahTituloPagar model) throws Exception {
        delete(model, null);
    }

    public void delete(PanamahTituloPagar model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.DELETE);
    }

    public void save(PanamahTituloReceber model) throws Exception {
        save(model, null);
    }

    public void save(PanamahTituloReceber model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.UPDATE);
    }

    public void delete(PanamahTituloReceber model) throws Exception {
        delete(model, null);
    }

    public void delete(PanamahTituloReceber model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.DELETE);
    }

    public void save(PanamahTrocaDevolucao model) throws Exception {
        save(model, null);
    }

    public void save(PanamahTrocaDevolucao model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.UPDATE);
    }

    public void delete(PanamahTrocaDevolucao model) throws Exception {
        delete(model, null);
    }

    public void delete(PanamahTrocaDevolucao model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.DELETE);
    }

    public void save(PanamahTrocaFormaPagamento model) throws Exception {
        save(model, null);
    }

    public void save(PanamahTrocaFormaPagamento model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.UPDATE);
    }

    public void delete(PanamahTrocaFormaPagamento model) throws Exception {
        delete(model, null);
    }

    public void delete(PanamahTrocaFormaPagamento model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.DELETE);
    }

    public void save(PanamahVenda model) throws Exception {
        save(model, null);
    }

    public void save(PanamahVenda model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.UPDATE);
    }

    public void delete(PanamahVenda model) throws Exception {
        delete(model, null);
    }

    public void delete(PanamahVenda model, String assinanteId) throws Exception {
        processaOp(model, assinanteId, PanamahTipoOperacao.DELETE);
    }

    public void readNFe(String filePath) throws Exception {
        task.readNFe(filePath);
        task.persisteLoteAtual();
    }
}
