
  package br.com.casamagalhaes.panamah.sdk.model;

  public class PanamahSubgrupo {
      

  private String id;

  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
  }
  
  private String codigo;

  public String getCodigo(){
    return codigo;
  }

  public void setCodigo(String codigo){
    this.codigo = codigo;
  }
  
  private String descricao;

  public String getDescricao(){
    return descricao;
  }

  public void setDescricao(String descricao){
    this.descricao = descricao;
  }
  
  private String secaoId;

  public String getSecaoId(){
    return secaoId;
  }

  public void setSecaoId(String secaoId){
    this.secaoId = secaoId;
  }
  
  private String grupoId;

  public String getGrupoId(){
    return grupoId;
  }

  public void setGrupoId(String grupoId){
    this.grupoId = grupoId;
  }
  

      public void validate() throws Exception {
        if(this.id == null) throw new Exception("id não pode ser nulo!");
	if(this.codigo == null) throw new Exception("codigo não pode ser nulo!");
	if(this.descricao == null) throw new Exception("descricao não pode ser nulo!");
	if(this.secaoId == null) throw new Exception("secaoId não pode ser nulo!");
	if(this.grupoId == null) throw new Exception("grupoId não pode ser nulo!");        
      }
  }
  