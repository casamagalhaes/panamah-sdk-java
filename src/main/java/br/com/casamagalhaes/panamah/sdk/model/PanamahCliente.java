
  package br.com.casamagalhaes.panamah.sdk.model;

  public class PanamahCliente {

      public PanamahCliente () {}

      public PanamahCliente (String id) { this.id = id; }
      
      

  private String id;

  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
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
  
  private String ramo;

  public String getRamo(){
    return ramo;
  }

  public void setRamo(String ramo){
    this.ramo = ramo;
  }
  
  private String uf;

  public String getUf(){
    return uf;
  }

  public void setUf(String uf){
    this.uf = uf;
  }
  
  private String cidade;

  public String getCidade(){
    return cidade;
  }

  public void setCidade(String cidade){
    this.cidade = cidade;
  }
  
  private String bairro;

  public String getBairro(){
    return bairro;
  }

  public void setBairro(String bairro){
    this.bairro = bairro;
  }
  

      public void validate() throws Exception {
        if(this.id == null) throw new Exception("id não pode ser nulo!");
	if(this.nome == null) throw new Exception("nome não pode ser nulo!");
	if(this.numeroDocumento == null) throw new Exception("numeroDocumento não pode ser nulo!");
	if(this.ramo == null) throw new Exception("ramo não pode ser nulo!");
	if(this.uf == null) throw new Exception("uf não pode ser nulo!");
	if(this.cidade == null) throw new Exception("cidade não pode ser nulo!");
	if(this.bairro == null) throw new Exception("bairro não pode ser nulo!");        
      }
  }
  