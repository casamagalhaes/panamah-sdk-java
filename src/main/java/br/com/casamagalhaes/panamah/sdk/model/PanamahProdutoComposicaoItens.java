
  package br.com.casamagalhaes.panamah.sdk.model;

  public class PanamahProdutoComposicaoItens {

      public PanamahProdutoComposicaoItens () {}

      
      

  private String produtoId;

  public String getProdutoId(){
    return produtoId;
  }

  public void setProdutoId(String produtoId){
    this.produtoId = produtoId;
  }
  
  private Double quantidade;

  public Double getQuantidade(){
    return quantidade;
  }

  public void setQuantidade(Double quantidade){
    this.quantidade = quantidade;
  }
  

      public void validate() throws Exception {
        if(this.produtoId == null) throw new Exception("produtoId não pode ser nulo!");
	if(this.quantidade == null) throw new Exception("quantidade não pode ser nulo!");        
      }
  }
  