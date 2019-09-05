package br.com.casamagalhaes.panamah.sdk;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        return operacoes;
    }

    public void setOperacoes(List<PanamahOperacao<?>> operacoes) {
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

    public void addFalhas(ArrayList<PanamahOperacao<?>> ops) {
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

    public synchronized <T extends IPanamahModel> void save(PanamahOperacao<T> op) {
        operacoes.add(op);
    }
}
