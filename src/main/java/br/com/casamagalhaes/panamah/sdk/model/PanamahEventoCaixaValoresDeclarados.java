
  package br.com.casamagalhaes.panamah.sdk.model;

  public class PanamahEventoCaixaValoresDeclarados {
      

  private String formaPagamentoId;

  public String getFormaPagamentoId(){
    return formaPagamentoId;
  }

  public void setFormaPagamentoId(String formaPagamentoId){
    this.formaPagamentoId = formaPagamentoId;
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
	if(this.valor == null) throw new Exception("valor não pode ser nulo!");        
      }
  }
  