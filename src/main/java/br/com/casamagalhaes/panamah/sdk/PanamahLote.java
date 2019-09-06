package br.com.casamagalhaes.panamah.sdk;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class PanamahLote {

	private Date criacao = new Date();
	private Date ultimaAtualizacao = new Date();
	private PanamahStatusLote status = PanamahStatusLote.ABERTO;
	private LinkedBlockingQueue<PanamahOperacao<?>> operacoes = new LinkedBlockingQueue<PanamahOperacao<?>>();

	public boolean isVelho(PanamahConfig config) {
		return new Date().getTime() > criacao.getTime() + config.getTtl();
	}

	public PanamahStatusLote getStatus() {
		return status;
	}

	public void setStatus(PanamahStatusLote status) {
		this.status = status;
	}

	public LinkedBlockingQueue<PanamahOperacao<?>> getOperacoes() {
		return operacoes;
	}

	public void setOperacoes(LinkedBlockingQueue<PanamahOperacao<?>> operacoes) {
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

	public LinkedBlockingQueue<PanamahOperacao<?>> removeExcedente() {
		LinkedBlockingQueue<PanamahOperacao<?>> sub = new LinkedBlockingQueue<PanamahOperacao<?>>();
		while (operacoes.size() >= 500) 
			sub.add(operacoes.remove());
		return sub;
	}

	public synchronized <T extends IPanamahModel> void save(PanamahOperacao<T> op) {
		operacoes.add(op);
	}
}
