
  package br.com.casamagalhaes.panamah.sdk.model;

  public class PanamahTituloReceberPagamentos {
      

  private java.util.Date dataHora;

  public java.util.Date getDataHora(){
    return dataHora;
  }

  public void setDataHora(java.util.Date dataHora){
    this.dataHora = dataHora;
  }
  
  private Double valor;

  public Double getValor(){
    return valor;
  }

  public void setValor(Double valor){
    this.valor = valor;
  }
  

      public boolean isValid(){
        return this.dataHora != null && this.valor != null;        
      }
  }
  