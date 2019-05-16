
  package br.com.casamagalhaes.panamah.sdk.model;

  import br.com.casamagalhaes.panamah.sdk.IPanamahModel;

  public class PanamahAcesso implements IPanamahModel {

      public PanamahAcesso () {}

      public PanamahAcesso (String id) { this.id = id; }
      
      

  private String id;

  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
  }
  
      private java.util.List<String> funcionarioIds;

      public java.util.List<String> getFuncionarioIds(){ 
        return funcionarioIds;
      }

      public void setFuncionarioIds(java.util.List<String> funcionarioIds) {
        this.funcionarioIds = funcionarioIds;
      }
      

      public void validate() throws Exception {
        if(this.id == null) throw new Exception("id não pode ser nulo!");
	if(this.funcionarioIds == null) throw new Exception("funcionarioIds não pode ser nulo!");        
      }
  }
  