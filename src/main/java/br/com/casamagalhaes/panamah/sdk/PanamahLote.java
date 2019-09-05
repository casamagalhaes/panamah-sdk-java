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

import java.util.Collections;

public class PanamahLote {

    private Date criacao = new Date();
    private Date ultimaAtualizacao = new Date();
    private PanamahStatusLote status = PanamahStatusLote.ABERTO;
    private List<PanamahOperacao<?>> operacoes = new ArrayList<PanamahOperacao<?>>();

    public boolean isVelho(PanamahConfig config) {
        return new Date().getTime() > criacao.getTime() + config.getTtl();
    }

    public PanamahStatusLote getStatus() {
        return status;
    }

    public void setStatus(PanamahStatusLote status) {
        this.status = status;
    }

    public List<PanamahOperacao<?>> getOperacoes() {
        if (operacoes == null)
            operacoes = Collections.synchronizedList(new ArrayList<PanamahOperacao<?>>());
        return operacoes;
    }

    public void setOperacoes(List<PanamahOperacao<?>> operacoes) {
        if (operacoes == null)
            operacoes = Collections.synchronizedList(new ArrayList<PanamahOperacao<?>>());
        this.operacoes = operacoes;
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

    public void save(PanamahCliente cliente, String assinanteId, PanamahConfig config) throws Exception {
        if (cliente == null)
            throw new RuntimeException("cliente não pode ser nulo!");
        cliente.validate();
        if (operacoes == null)
            operacoes = Collections.synchronizedList(new ArrayList<PanamahOperacao<?>>());
        PanamahOperacao<PanamahCliente> op = new PanamahOperacao<PanamahCliente>();
        op.setOp(PanamahTipoOperacao.UPDATE);
        op.setTipo(PanamahTipoModel.CLIENTE);
        op.setData(cliente);
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void delete(PanamahCliente cliente, String assinanteId, PanamahConfig config) throws Exception {
        if (cliente == null)
            throw new RuntimeException("cliente não pode ser nulo!");
        cliente.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();
        PanamahOperacao<PanamahCliente> op = new PanamahOperacao<PanamahCliente>();
        op.setOp(PanamahTipoOperacao.DELETE);
        op.setTipo(PanamahTipoModel.CLIENTE);
        op.setData(new PanamahCliente(cliente.getId()));
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void save(PanamahCompra compra, String assinanteId, PanamahConfig config) throws Exception {
        if (compra == null)
            throw new RuntimeException("compra não pode ser nulo!");
        compra.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();
        PanamahOperacao<PanamahCompra> op = new PanamahOperacao<PanamahCompra>();
        op.setOp(PanamahTipoOperacao.UPDATE);
        op.setTipo(PanamahTipoModel.COMPRA);
        op.setData(compra);
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void delete(PanamahCompra compra, String assinanteId, PanamahConfig config) throws Exception {
        if (compra == null)
            throw new RuntimeException("compra não pode ser nulo!");
        compra.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();
        PanamahOperacao<PanamahCompra> op = new PanamahOperacao<PanamahCompra>();
        op.setOp(PanamahTipoOperacao.DELETE);
        op.setTipo(PanamahTipoModel.COMPRA);
        op.setData(new PanamahCompra(compra.getId()));
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void save(PanamahAssinante assinante, String assinanteId, PanamahConfig config) throws Exception {
        if (assinante == null)
            throw new RuntimeException("assinante não pode ser nulo!");
        assinante.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();
        PanamahOperacao<PanamahAssinante> op = new PanamahOperacao<PanamahAssinante>();
        op.setOp(PanamahTipoOperacao.UPDATE);
        op.setTipo(PanamahTipoModel.ASSINANTE);
        op.setData(assinante);
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void delete(PanamahAssinante assinante, String assinanteId, PanamahConfig config) throws Exception {
        if (assinante == null)
            throw new RuntimeException("assinante não pode ser nulo!");
        assinante.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();
        PanamahOperacao<PanamahAssinante> op = new PanamahOperacao<PanamahAssinante>();
        op.setOp(PanamahTipoOperacao.DELETE);
        op.setTipo(PanamahTipoModel.ASSINANTE);
        op.setData(new PanamahAssinante(assinante.getId()));
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void save(PanamahOperacao<PanamahAcesso> op) throws Exception {
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();
        operacoes.add(op);
    }

    public void delete(PanamahAcesso acesso, String assinanteId, PanamahConfig config) throws Exception {
        if (acesso == null)
            throw new RuntimeException("acesso não pode ser nulo!");
        acesso.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();
        PanamahOperacao<PanamahAcesso> op = new PanamahOperacao<PanamahAcesso>();
        op.setOp(PanamahTipoOperacao.DELETE);
        op.setTipo(PanamahTipoModel.ACESSO);
        op.setData(new PanamahAcesso(acesso.getId()));
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void save(PanamahEan ean, String assinanteId, PanamahConfig config) throws Exception {
        if (ean == null)
            throw new RuntimeException("ean não pode ser nulo!");
        ean.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();
        PanamahOperacao<PanamahEan> op = new PanamahOperacao<PanamahEan>();
        op.setOp(PanamahTipoOperacao.UPDATE);
        op.setTipo(PanamahTipoModel.EAN);
        op.setData(ean);
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void delete(PanamahEan ean, String assinanteId, PanamahConfig config) throws Exception {
        if (ean == null)
            throw new RuntimeException("ean não pode ser nulo!");
        ean.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();
        PanamahOperacao<PanamahEan> op = new PanamahOperacao<PanamahEan>();
        op.setOp(PanamahTipoOperacao.DELETE);
        op.setTipo(PanamahTipoModel.EAN);
        op.setData(new PanamahEan(ean.getId()));
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void save(PanamahEstoqueMovimentacao estoqueMovimentacao, String assinanteId, PanamahConfig config)
            throws Exception {
        if (estoqueMovimentacao == null)
            throw new RuntimeException("estoqueMovimentacao não pode ser nulo!");
        estoqueMovimentacao.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();
        PanamahOperacao<PanamahEstoqueMovimentacao> op = new PanamahOperacao<PanamahEstoqueMovimentacao>();
        op.setOp(PanamahTipoOperacao.UPDATE);
        op.setTipo(PanamahTipoModel.ESTOQUE_MOVIMENTACAO);
        op.setData(estoqueMovimentacao);
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void delete(PanamahEstoqueMovimentacao estoqueMovimentacao, String assinanteId, PanamahConfig config)
            throws Exception {
        if (estoqueMovimentacao == null)
            throw new RuntimeException("estoqueMovimentacao não pode ser nulo!");
        estoqueMovimentacao.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();
        PanamahOperacao<PanamahEstoqueMovimentacao> op = new PanamahOperacao<PanamahEstoqueMovimentacao>();
        op.setOp(PanamahTipoOperacao.DELETE);
        op.setTipo(PanamahTipoModel.ESTOQUE_MOVIMENTACAO);
        op.setData(new PanamahEstoqueMovimentacao(estoqueMovimentacao.getId()));
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void save(PanamahEventoCaixa eventoCaixa, String assinanteId, PanamahConfig config) throws Exception {
        if (eventoCaixa == null)
            throw new RuntimeException("eventoCaixa não pode ser nulo!");
        eventoCaixa.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();
        PanamahOperacao<PanamahEventoCaixa> op = new PanamahOperacao<PanamahEventoCaixa>();
        op.setOp(PanamahTipoOperacao.UPDATE);
        op.setTipo(PanamahTipoModel.EVENTO_CAIXA);
        op.setData(eventoCaixa);
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void delete(PanamahEventoCaixa eventoCaixa, String assinanteId, PanamahConfig config) throws Exception {
        if (eventoCaixa == null)
            throw new RuntimeException("eventoCaixa não pode ser nulo!");
        eventoCaixa.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();
        PanamahOperacao<PanamahEventoCaixa> op = new PanamahOperacao<PanamahEventoCaixa>();
        op.setOp(PanamahTipoOperacao.DELETE);
        op.setTipo(PanamahTipoModel.EVENTO_CAIXA);
        op.setData(new PanamahEventoCaixa(eventoCaixa.getId()));
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void save(PanamahFormaPagamento formaPagamento, String assinanteId, PanamahConfig config) throws Exception {
        if (formaPagamento == null)
            throw new RuntimeException("formaPagamento não pode ser nulo!");
        formaPagamento.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();
        PanamahOperacao<PanamahFormaPagamento> op = new PanamahOperacao<PanamahFormaPagamento>();
        op.setOp(PanamahTipoOperacao.UPDATE);
        op.setTipo(PanamahTipoModel.FORMA_PAGAMENTO);
        op.setData(formaPagamento);
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void delete(PanamahFormaPagamento formaPagamento, String assinanteId, PanamahConfig config)
            throws Exception {
        if (formaPagamento == null)
            throw new RuntimeException("formaPagamento não pode ser nulo!");
        formaPagamento.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();
        PanamahOperacao<PanamahFormaPagamento> op = new PanamahOperacao<PanamahFormaPagamento>();
        op.setOp(PanamahTipoOperacao.DELETE);
        op.setTipo(PanamahTipoModel.FORMA_PAGAMENTO);
        op.setData(new PanamahFormaPagamento(formaPagamento.getId()));
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void save(PanamahFornecedor fornecedor, String assinanteId, PanamahConfig config) throws Exception {
        if (fornecedor == null)
            throw new RuntimeException("fornecedor não pode ser nulo!");
        fornecedor.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();
        PanamahOperacao<PanamahFornecedor> op = new PanamahOperacao<PanamahFornecedor>();
        op.setOp(PanamahTipoOperacao.UPDATE);
        op.setTipo(PanamahTipoModel.FORNECEDOR);
        op.setData(fornecedor);
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void delete(PanamahFornecedor fornecedor, String assinanteId, PanamahConfig config) throws Exception {
        if (fornecedor == null)
            throw new RuntimeException("fornecedor não pode ser nulo!");
        fornecedor.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();
        PanamahOperacao<PanamahFornecedor> op = new PanamahOperacao<PanamahFornecedor>();
        op.setOp(PanamahTipoOperacao.DELETE);
        op.setTipo(PanamahTipoModel.FORNECEDOR);
        op.setData(new PanamahFornecedor(fornecedor.getId()));
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);

    }

    public void save(PanamahFuncionario funcionario, String assinanteId, PanamahConfig config) throws Exception {
        if (funcionario == null)
            throw new RuntimeException("funcionario não pode ser nulo!");
        funcionario.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();
        PanamahOperacao<PanamahFuncionario> op = new PanamahOperacao<PanamahFuncionario>();
        op.setOp(PanamahTipoOperacao.UPDATE);
        op.setTipo(PanamahTipoModel.FUNCIONARIO);
        op.setData(funcionario);
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void delete(PanamahFuncionario funcionario, String assinanteId, PanamahConfig config) throws Exception {
        if (funcionario == null)
            throw new RuntimeException("funcionario não pode ser nulo!");
        funcionario.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();
        PanamahOperacao<PanamahFuncionario> op = new PanamahOperacao<PanamahFuncionario>();
        op.setOp(PanamahTipoOperacao.DELETE);
        op.setTipo(PanamahTipoModel.FUNCIONARIO);
        op.setData(new PanamahFuncionario(funcionario.getId()));
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void save(PanamahGrupo grupo, String assinanteId, PanamahConfig config) throws Exception {
        if (grupo == null)
            throw new RuntimeException("grupo não pode ser nulo!");
        grupo.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();
        PanamahOperacao<PanamahGrupo> op = new PanamahOperacao<PanamahGrupo>();
        op.setOp(PanamahTipoOperacao.UPDATE);
        op.setTipo(PanamahTipoModel.GRUPO);
        op.setData(grupo);
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void delete(PanamahGrupo grupo, String assinanteId, PanamahConfig config) throws Exception {
        if (grupo == null)
            throw new RuntimeException("grupo não pode ser nulo!");
        grupo.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();

        PanamahOperacao<PanamahGrupo> op = new PanamahOperacao<PanamahGrupo>();
        op.setOp(PanamahTipoOperacao.DELETE);
        op.setTipo(PanamahTipoModel.GRUPO);
        op.setData(new PanamahGrupo(grupo.getId()));
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void save(PanamahHolding holding, String assinanteId, PanamahConfig config) throws Exception {
        if (holding == null)
            throw new RuntimeException("holding não pode ser nulo!");
        holding.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();

        PanamahOperacao<PanamahHolding> op = new PanamahOperacao<PanamahHolding>();
        op.setOp(PanamahTipoOperacao.UPDATE);
        op.setTipo(PanamahTipoModel.HOLDING);
        op.setData(holding);
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void delete(PanamahHolding holding, String assinanteId, PanamahConfig config) throws Exception {
        if (holding == null)
            throw new RuntimeException("holding não pode ser nulo!");
        holding.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();

        PanamahOperacao<PanamahHolding> op = new PanamahOperacao<PanamahHolding>();
        op.setOp(PanamahTipoOperacao.DELETE);
        op.setTipo(PanamahTipoModel.HOLDING);
        op.setData(new PanamahHolding(holding.getId()));
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void save(PanamahLocalEstoque localEstoque, String assinanteId, PanamahConfig config) throws Exception {
        if (localEstoque == null)
            throw new RuntimeException("localEstoque não pode ser nulo!");
        localEstoque.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();

        PanamahOperacao<PanamahLocalEstoque> op = new PanamahOperacao<PanamahLocalEstoque>();
        op.setOp(PanamahTipoOperacao.UPDATE);
        op.setTipo(PanamahTipoModel.LOCAL_ESTOQUE);
        op.setData(localEstoque);
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void delete(PanamahLocalEstoque localEstoque, String assinanteId, PanamahConfig config) throws Exception {
        if (localEstoque == null)
            throw new RuntimeException("localEstoque não pode ser nulo!");
        localEstoque.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();

        PanamahOperacao<PanamahLocalEstoque> op = new PanamahOperacao<PanamahLocalEstoque>();
        op.setOp(PanamahTipoOperacao.DELETE);
        op.setTipo(PanamahTipoModel.LOCAL_ESTOQUE);
        op.setData(new PanamahLocalEstoque(localEstoque.getId()));
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void save(PanamahLoja loja, String assinanteId, PanamahConfig config) throws Exception {
        if (loja == null)
            throw new RuntimeException("loja não pode ser nulo!");
        loja.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();

        PanamahOperacao<PanamahLoja> op = new PanamahOperacao<PanamahLoja>();
        op.setOp(PanamahTipoOperacao.UPDATE);
        op.setTipo(PanamahTipoModel.LOJA);
        op.setData(loja);
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void delete(PanamahLoja loja, String assinanteId, PanamahConfig config) throws Exception {
        if (loja == null)
            throw new RuntimeException("loja não pode ser nulo!");
        loja.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();

        PanamahOperacao<PanamahLoja> op = new PanamahOperacao<PanamahLoja>();
        op.setOp(PanamahTipoOperacao.DELETE);
        op.setTipo(PanamahTipoModel.LOJA);
        op.setData(new PanamahLoja(loja.getId()));
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void save(PanamahMeta meta, String assinanteId, PanamahConfig config) throws Exception {
        if (meta == null)
            throw new RuntimeException("meta não pode ser nulo!");
        meta.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();

        PanamahOperacao<PanamahMeta> op = new PanamahOperacao<PanamahMeta>();
        op.setOp(PanamahTipoOperacao.UPDATE);
        op.setTipo(PanamahTipoModel.META);
        op.setData(meta);
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);

    }

    public void delete(PanamahMeta meta, String assinanteId, PanamahConfig config) throws Exception {
        if (meta == null)
            throw new RuntimeException("meta não pode ser nulo!");
        meta.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();

        PanamahOperacao<PanamahMeta> op = new PanamahOperacao<PanamahMeta>();
        op.setOp(PanamahTipoOperacao.DELETE);
        op.setTipo(PanamahTipoModel.META);
        op.setData(new PanamahMeta(meta.getId()));
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);

    }

    public void save(PanamahProduto produto, String assinanteId, PanamahConfig config) throws Exception {
        if (produto == null)
            throw new RuntimeException("produto não pode ser nulo!");
        produto.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();

        PanamahOperacao<PanamahProduto> op = new PanamahOperacao<PanamahProduto>();
        op.setOp(PanamahTipoOperacao.UPDATE);
        op.setTipo(PanamahTipoModel.PRODUTO);
        op.setData(produto);
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);

    }

    public void delete(PanamahProduto produto, String assinanteId, PanamahConfig config) throws Exception {
        if (produto == null)
            throw new RuntimeException("produto não pode ser nulo!");
        produto.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();

        PanamahOperacao<PanamahProduto> op = new PanamahOperacao<PanamahProduto>();
        op.setOp(PanamahTipoOperacao.DELETE);
        op.setTipo(PanamahTipoModel.PRODUTO);
        op.setData(new PanamahProduto(produto.getId()));
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);

    }

    public void save(PanamahRevenda revenda, String assinanteId, PanamahConfig config) throws Exception {
        if (revenda == null)
            throw new RuntimeException("revenda não pode ser nulo!");
        revenda.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();

        PanamahOperacao<PanamahRevenda> op = new PanamahOperacao<PanamahRevenda>();
        op.setOp(PanamahTipoOperacao.UPDATE);
        op.setTipo(PanamahTipoModel.REVENDA);
        op.setData(revenda);
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);

    }

    public void delete(PanamahRevenda revenda, String assinanteId, PanamahConfig config) throws Exception {
        if (revenda == null)
            throw new RuntimeException("revenda não pode ser nulo!");
        revenda.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();

        PanamahOperacao<PanamahRevenda> op = new PanamahOperacao<PanamahRevenda>();
        op.setOp(PanamahTipoOperacao.DELETE);
        op.setTipo(PanamahTipoModel.REVENDA);
        op.setData(new PanamahRevenda(revenda.getId()));
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);

    }

    public void save(PanamahSecao secao, String assinanteId, PanamahConfig config) throws Exception {
        if (secao == null)
            throw new RuntimeException("secao não pode ser nulo!");
        secao.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();

        PanamahOperacao<PanamahSecao> op = new PanamahOperacao<PanamahSecao>();
        op.setOp(PanamahTipoOperacao.UPDATE);
        op.setTipo(PanamahTipoModel.SECAO);
        op.setData(secao);
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);

    }

    public void delete(PanamahSecao secao, String assinanteId, PanamahConfig config) throws Exception {
        if (secao == null)
            throw new RuntimeException("secao não pode ser nulo!");
        secao.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();

        PanamahOperacao<PanamahSecao> op = new PanamahOperacao<PanamahSecao>();
        op.setOp(PanamahTipoOperacao.DELETE);
        op.setTipo(PanamahTipoModel.SECAO);
        op.setData(new PanamahSecao(secao.getId()));
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);

    }

    public void save(PanamahSubgrupo subgrupo, String assinanteId, PanamahConfig config) throws Exception {
        if (subgrupo == null)
            throw new RuntimeException("subgrupo não pode ser nulo!");
        subgrupo.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();

        PanamahOperacao<PanamahSubgrupo> op = new PanamahOperacao<PanamahSubgrupo>();
        op.setOp(PanamahTipoOperacao.UPDATE);
        op.setTipo(PanamahTipoModel.SUBGRUPO);
        op.setData(subgrupo);
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);

    }

    public void delete(PanamahSubgrupo subgrupo, String assinanteId, PanamahConfig config) throws Exception {
        if (subgrupo == null)
            throw new RuntimeException("subgrupo não pode ser nulo!");
        subgrupo.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();

        PanamahOperacao<PanamahSubgrupo> op = new PanamahOperacao<PanamahSubgrupo>();
        op.setOp(PanamahTipoOperacao.DELETE);
        op.setTipo(PanamahTipoModel.SUBGRUPO);
        op.setData(new PanamahSubgrupo(subgrupo.getId()));
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);

    }

    public void save(PanamahTituloPagar tituloPagar, String assinanteId, PanamahConfig config) throws Exception {
        if (tituloPagar == null)
            throw new RuntimeException("tituloPagar não pode ser nulo!");
        tituloPagar.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();

        PanamahOperacao<PanamahTituloPagar> op = new PanamahOperacao<PanamahTituloPagar>();
        op.setOp(PanamahTipoOperacao.UPDATE);
        op.setTipo(PanamahTipoModel.TITULO_PAGAR);
        op.setData(tituloPagar);
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);

    }

    public void delete(PanamahTituloPagar tituloPagar, String assinanteId, PanamahConfig config) throws Exception {
        if (tituloPagar == null)
            throw new RuntimeException("tituloPagar não pode ser nulo!");
        tituloPagar.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();

        PanamahOperacao<PanamahTituloPagar> op = new PanamahOperacao<PanamahTituloPagar>();
        op.setOp(PanamahTipoOperacao.DELETE);
        op.setTipo(PanamahTipoModel.TITULO_PAGAR);
        op.setData(new PanamahTituloPagar(tituloPagar.getId()));
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void save(PanamahTituloReceber tituloReceber, String assinanteId, PanamahConfig config) throws Exception {
        if (tituloReceber == null)
            throw new RuntimeException("tituloReceber não pode ser nulo!");
        tituloReceber.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();

        PanamahOperacao<PanamahTituloReceber> op = new PanamahOperacao<PanamahTituloReceber>();
        op.setOp(PanamahTipoOperacao.UPDATE);
        op.setTipo(PanamahTipoModel.TITULO_RECEBER);
        op.setData(tituloReceber);
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void delete(PanamahTituloReceber tituloReceber, String assinanteId, PanamahConfig config) throws Exception {
        if (tituloReceber == null)
            throw new RuntimeException("tituloReceber não pode ser nulo!");
        tituloReceber.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();

        PanamahOperacao<PanamahTituloReceber> op = new PanamahOperacao<PanamahTituloReceber>();
        op.setOp(PanamahTipoOperacao.DELETE);
        op.setTipo(PanamahTipoModel.TITULO_RECEBER);
        op.setData(new PanamahTituloReceber(tituloReceber.getId()));
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void save(PanamahTrocaDevolucao trocaDevolucao, String assinanteId, PanamahConfig config) throws Exception {
        if (trocaDevolucao == null)
            throw new RuntimeException("trocaDevolucao não pode ser nulo!");
        trocaDevolucao.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();
        PanamahOperacao<PanamahTrocaDevolucao> op = new PanamahOperacao<PanamahTrocaDevolucao>();
        op.setOp(PanamahTipoOperacao.UPDATE);
        op.setTipo(PanamahTipoModel.TROCA_DEVOLUCAO);
        op.setData(trocaDevolucao);
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void delete(PanamahTrocaDevolucao trocaDevolucao, String assinanteId, PanamahConfig config)
            throws Exception {
        if (trocaDevolucao == null)
            throw new RuntimeException("trocaDevolucao não pode ser nulo!");
        trocaDevolucao.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();
        PanamahOperacao<PanamahTrocaDevolucao> op = new PanamahOperacao<PanamahTrocaDevolucao>();
        op.setOp(PanamahTipoOperacao.DELETE);
        op.setTipo(PanamahTipoModel.TROCA_DEVOLUCAO);
        op.setData(new PanamahTrocaDevolucao(trocaDevolucao.getId()));
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void save(PanamahTrocaFormaPagamento trocaFormaPagamento, String assinanteId, PanamahConfig config)
            throws Exception {
        if (trocaFormaPagamento == null)
            throw new RuntimeException("trocaFormaPagamento não pode ser nulo!");
        trocaFormaPagamento.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();
        PanamahOperacao<PanamahTrocaFormaPagamento> op = new PanamahOperacao<PanamahTrocaFormaPagamento>();
        op.setOp(PanamahTipoOperacao.UPDATE);
        op.setTipo(PanamahTipoModel.TROCA_FORMA_PAGAMENTO);
        op.setData(trocaFormaPagamento);
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void delete(PanamahTrocaFormaPagamento trocaFormaPagamento, String assinanteId, PanamahConfig config)
            throws Exception {
        if (trocaFormaPagamento == null)
            throw new RuntimeException("trocaFormaPagamento não pode ser nulo!");
        trocaFormaPagamento.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();
        PanamahOperacao<PanamahTrocaFormaPagamento> op = new PanamahOperacao<PanamahTrocaFormaPagamento>();
        op.setOp(PanamahTipoOperacao.DELETE);
        op.setTipo(PanamahTipoModel.TROCA_FORMA_PAGAMENTO);
        op.setData(new PanamahTrocaFormaPagamento(trocaFormaPagamento.getId()));
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void save(PanamahVenda venda, String assinanteId, PanamahConfig config) throws Exception {
        if (venda == null)
            throw new RuntimeException("venda não pode ser nulo!");
        venda.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();
        PanamahOperacao<PanamahVenda> op = new PanamahOperacao<PanamahVenda>();
        op.setOp(PanamahTipoOperacao.UPDATE);
        op.setTipo(PanamahTipoModel.VENDA);
        op.setData(venda);
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void delete(PanamahVenda venda, String assinanteId, PanamahConfig config) throws Exception {
        if (venda == null)
            throw new RuntimeException("venda não pode ser nulo!");
        venda.validate();
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();
        PanamahOperacao<PanamahVenda> op = new PanamahOperacao<PanamahVenda>();
        op.setOp(PanamahTipoOperacao.DELETE);
        op.setTipo(PanamahTipoModel.VENDA);
        op.setData(new PanamahVenda(venda.getId()));
        if (assinanteId == null)
            assinanteId = config.getAuth().getAssinante().getId();
        op.setAssinanteId(assinanteId);
        operacoes.add(op);
    }

    public void addFalhas(ArrayList<PanamahOperacao<?>> ops) {
        if (operacoes == null)
            operacoes = new ArrayList<PanamahOperacao<?>>();
        operacoes.addAll(ops);
    }

    public List<PanamahOperacao<?>> removeExcedente() {
        if (operacoes.size() >= 500) {
            List<PanamahOperacao<?>> sub = operacoes.subList(499, operacoes.size() - 1);
            operacoes.removeAll(sub);
            return sub;
        }
        return null;
    }
}
