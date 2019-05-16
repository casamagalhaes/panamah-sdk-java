
  package br.com.casamagalhaes.panamah.sdk.model;

  import br.com.casamagalhaes.panamah.sdk.IPanamahModel;

  public class PanamahEan implements IPanamahModel {

      public PanamahEan () {}

      public PanamahEan (String id) { this.id = id; }
      
      

  private String id;

  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
  }
  
  private String produtoId;

  public String getProdutoId(){
    return produtoId;
  }

  public void setProdutoId(String produtoId){
    this.produtoId = produtoId;
  }
  
  private Boolean tributado;

  public Boolean getTributado(){
    return tributado;
  }

  public void setTributado(Boolean tributado){
    this.tributado = tributado;
  }
  

      public void validate() throws Exception {
        if(this.id == null) throw new Exception("id não pode ser nulo!");
	if(this.produtoId == null) throw new Exception("produtoId não pode ser nulo!");        
      }
  }
  