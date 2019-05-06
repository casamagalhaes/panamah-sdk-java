
  package br.com.casamagalhaes.panamah.sdk.model;

  public class PanamahLocalEstoque {
      

  private String id;

  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
  }
  
  private String lojaId;

  public String getLojaId(){
    return lojaId;
  }

  public void setLojaId(String lojaId){
    this.lojaId = lojaId;
  }
  
  private String descricao;

  public String getDescricao(){
    return descricao;
  }

  public void setDescricao(String descricao){
    this.descricao = descricao;
  }
  
  private Boolean disponivelParaVenda;

  public Boolean getDisponivelParaVenda(){
    return disponivelParaVenda;
  }

  public void setDisponivelParaVenda(Boolean disponivelParaVenda){
    this.disponivelParaVenda = disponivelParaVenda;
  }
  
  }
  