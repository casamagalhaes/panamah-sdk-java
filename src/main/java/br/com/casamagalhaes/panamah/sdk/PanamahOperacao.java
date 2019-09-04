package br.com.casamagalhaes.panamah.sdk;

public class PanamahOperacao<T> {

    private T data;

    private PanamahTipoOperacao op;
    private PanamahTipoModel tipo;
    private String assinanteId;
    private PanamahConfig config;

    public PanamahOperacao() {
    }

    public PanamahOperacao(T data, String assinanteId, PanamahConfig config) {
        this.data = data;
        this.assinanteId = assinanteId;
        this.config = config;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public PanamahTipoOperacao getOp() {
        return op;
    }

    public void setOp(PanamahTipoOperacao tipo) {
        this.op = tipo;
    }

    public PanamahTipoModel getTipo() {
        return tipo;
    }

    public void setTipo(PanamahTipoModel tipo) {
        this.tipo = tipo;
    }

    public String getAssinanteId() {
        return assinanteId;
    }

    public void setAssinanteId(String assinanteId) {
        this.assinanteId = assinanteId;
    }

	public PanamahConfig getConfig() {
		return config;
	}

	public void setConfig(PanamahConfig config) {
		this.config = config;
	}
}
