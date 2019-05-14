
  package br.com.casamagalhaes.panamah.sdk.model;

  public class PanamahVendaPagamentos {

      public PanamahVendaPagamentos () {}

      
      

  private String formaPagamentoId;

  public String getFormaPagamentoId(){
    return formaPagamentoId;
  }

  public void setFormaPagamentoId(String formaPagamentoId){
    this.formaPagamentoId = formaPagamentoId;
  }
  
  private String sequencial;

  public String getSequencial(){
    return sequencial;
  }

  public void setSequencial(String sequencial){
    this.sequencial = sequencial;
  }
  
  private Double valor;

  public Double getValor(){
    return valor;
  }

  public void setValor(Double valor){
    this.valor = valor;
  }
  

      public void validate() throws Exception {
        if(this.formaPagamentoId == null) throw new Exception("formaPagamentoId não pode ser nulo!");
	if(this.sequencial == null) throw new Exception("sequencial não pode ser nulo!");
	if(this.valor == null) throw new Exception("valor não pode ser nulo!");        
      }
  }
  