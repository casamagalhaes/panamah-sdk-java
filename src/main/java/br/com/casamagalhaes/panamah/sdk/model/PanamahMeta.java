
  package br.com.casamagalhaes.panamah.sdk.model;

  import br.com.casamagalhaes.panamah.sdk.IPanamahModel;

  public class PanamahMeta implements IPanamahModel {

      public PanamahMeta () {}

      public PanamahMeta (String id) { this.id = id; }
      
      

  private String id;

  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
  }
  
  private Double mes;

  public Double getMes(){
    return mes;
  }

  public void setMes(Double mes){
    this.mes = mes;
  }
  
  private Double ano;

  public Double getAno(){
    return ano;
  }

  public void setAno(Double ano){
    this.ano = ano;
  }
  
  private String lojaId;

  public String getLojaId(){
    return lojaId;
  }

  public void setLojaId(String lojaId){
    this.lojaId = lojaId;
  }
  
  private String secaoId;

  public String getSecaoId(){
    return secaoId;
  }

  public void setSecaoId(String secaoId){
    this.secaoId = secaoId;
  }
  
  private Double valor;

  public Double getValor(){
    return valor;
  }

  public void setValor(Double valor){
    this.valor = valor;
  }
  

      public void validate() throws Exception {
        if(this.id == null) throw new Exception("id não pode ser nulo!");
	if(this.mes == null) throw new Exception("mes não pode ser nulo!");
	if(this.ano == null) throw new Exception("ano não pode ser nulo!");
	if(this.lojaId == null) throw new Exception("lojaId não pode ser nulo!");
	if(this.secaoId == null) throw new Exception("secaoId não pode ser nulo!");
	if(this.valor == null) throw new Exception("valor não pode ser nulo!");        
      }
  }
  