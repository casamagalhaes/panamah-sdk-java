
  package br.com.casamagalhaes.panamah.sdk.model;

  import br.com.casamagalhaes.panamah.sdk.IPanamahModel;

  public class PanamahGrupo implements IPanamahModel {

      public PanamahGrupo () {}

      public PanamahGrupo (String id) { this.id = id; }
      
      

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
  

      public void validate() throws Exception {
        if(this.id == null) throw new Exception("id não pode ser nulo!");
	if(this.codigo == null) throw new Exception("codigo não pode ser nulo!");
	if(this.descricao == null) throw new Exception("descricao não pode ser nulo!");
	if(this.secaoId == null) throw new Exception("secaoId não pode ser nulo!");        
      }
  }
  