
  package br.com.casamagalhaes.panamah.sdk.model;

  public class PanamahAcesso {
      

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
      
  }
  