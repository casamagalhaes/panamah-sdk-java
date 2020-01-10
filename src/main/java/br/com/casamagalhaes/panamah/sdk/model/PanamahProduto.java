package br.com.casamagalhaes.panamah.sdk.model;

import br.com.casamagalhaes.panamah.sdk.IPanamahModel;

import java.util.List;

public class PanamahProduto implements IPanamahModel {

    private PanamahProdutoComposicao composicao;
    private String tipoComposicao;
    private String descricao;
    private java.util.Date dataInclusao;
    private String finalidade;
    private Boolean ativo;
    private String grupoId;
    private String id;
    private Boolean pesoVariavel;
    private java.math.BigDecimal quantidadeItensEmbalagem;
    private String secaoId;
    private String subgrupoId;
    private java.util.List<PanamahProdutoFornecedores> fornecedores;
    private java.util.List<PanamahProdutoEan> eans;

    public PanamahProduto() {
    }

    public PanamahProduto(String id) {
        this.id = id;
    }

    public PanamahProdutoComposicao getComposicao() {
        return composicao;
    }

    public void setComposicao(PanamahProdutoComposicao composicao) {
        this.composicao = composicao;
    }

    public String getTipoComposicao() {
        return tipoComposicao;
    }

    public void setTipoComposicao(String tipoComposicao) {
        this.tipoComposicao = tipoComposicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public java.util.Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(java.util.Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(String grupoId) {
        this.grupoId = grupoId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getPesoVariavel() {
        return pesoVariavel;
    }

    public void setPesoVariavel(Boolean pesoVariavel) {
        this.pesoVariavel = pesoVariavel;
    }

    public java.math.BigDecimal getQuantidadeItensEmbalagem() {
        return quantidadeItensEmbalagem;
    }

    public void setQuantidadeItensEmbalagem(java.math.BigDecimal quantidadeItensEmbalagem) {
        this.quantidadeItensEmbalagem = quantidadeItensEmbalagem;
    }

    public String getSecaoId() {
        return secaoId;
    }

    public void setSecaoId(String secaoId) {
        this.secaoId = secaoId;
    }

    public String getSubgrupoId() {
        return subgrupoId;
    }

    public void setSubgrupoId(String subgrupoId) {
        this.subgrupoId = subgrupoId;
    }

    public java.util.List<PanamahProdutoFornecedores> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(java.util.List<PanamahProdutoFornecedores> fornecedores) {
        this.fornecedores = fornecedores;
    }

    public List<PanamahProdutoEan> getEans() {
        return eans;
    }

    public void setEans(List<PanamahProdutoEan> eans) {
        this.eans = eans;
    }

    public void validate() throws Exception {
        if (this.descricao == null) throw new Exception("descricao não pode ser nulo!");
        if (this.id == null) throw new Exception("id não pode ser nulo!");
        if (this.secaoId == null) throw new Exception("secaoId não pode ser nulo!");
    }
}
  