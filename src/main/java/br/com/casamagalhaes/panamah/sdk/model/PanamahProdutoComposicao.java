
  package br.com.casamagalhaes.panamah.sdk.model;

  public class PanamahProdutoComposicao {
      

    private java.util.List<PanamahProdutoComposicaoItens> itens;
    
    public java.util.List<PanamahProdutoComposicaoItens> getItens(){ 
      return itens;
    }

    public void setItens(java.util.List<PanamahProdutoComposicaoItens> itens) {
      this.itens = itens;
    }

    
  private Double quantidade;

  public Double getQuantidade(){
    return quantidade;
  }

  public void setQuantidade(Double quantidade){
    this.quantidade = quantidade;
  }
  

      public void validate() throws Exception {
        if(this.quantidade == null) throw new Exception("quantidade não pode ser nulo!");        
      }
  }
  