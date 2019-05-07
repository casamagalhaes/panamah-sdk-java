
  package br.com.casamagalhaes.panamah.sdk.model;

  public class PanamahMeta {
      

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
  

      public boolean isValid(){
        return this.id != null && this.mes != null && this.ano != null && this.lojaId != null && this.secaoId != null && this.valor != null;        
      }
  }
  