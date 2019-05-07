
  package br.com.casamagalhaes.panamah.sdk.model;

  public class PanamahFuncionario {
      

  private java.util.Date dataNascimento;

  public java.util.Date getDataNascimento(){
    return dataNascimento;
  }

  public void setDataNascimento(java.util.Date dataNascimento){
    this.dataNascimento = dataNascimento;
  }
  
  private String id;

  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
  }
  
  private String login;

  public String getLogin(){
    return login;
  }

  public void setLogin(String login){
    this.login = login;
  }
  
  private String nome;

  public String getNome(){
    return nome;
  }

  public void setNome(String nome){
    this.nome = nome;
  }
  
  private String numeroDocumento;

  public String getNumeroDocumento(){
    return numeroDocumento;
  }

  public void setNumeroDocumento(String numeroDocumento){
    this.numeroDocumento = numeroDocumento;
  }
  
  private Boolean ativo;

  public Boolean getAtivo(){
    return ativo;
  }

  public void setAtivo(Boolean ativo){
    this.ativo = ativo;
  }
  
  private String senha;

  public String getSenha(){
    return senha;
  }

  public void setSenha(String senha){
    this.senha = senha;
  }
  
      private java.util.List<String> lojaIds;

      public java.util.List<String> getLojaIds(){ 
        return lojaIds;
      }

      public void setLojaIds(java.util.List<String> lojaIds) {
        this.lojaIds = lojaIds;
      }
      

      public void validate() throws Exception {
        if(this.id == null) throw new Exception("id não pode ser nulo!");
	if(this.nome == null) throw new Exception("nome não pode ser nulo!");
	if(this.ativo == null) throw new Exception("ativo não pode ser nulo!");        
      }
  }
  