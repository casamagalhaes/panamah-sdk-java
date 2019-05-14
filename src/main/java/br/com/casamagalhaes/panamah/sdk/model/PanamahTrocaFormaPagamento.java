
  package br.com.casamagalhaes.panamah.sdk.model;

  public class PanamahTrocaFormaPagamento {

      public PanamahTrocaFormaPagamento () {}

      public PanamahTrocaFormaPagamento (String id) { this.id = id; }
      
      

  private String autorizadorId;

  public String getAutorizadorId(){
    return autorizadorId;
  }

  public void setAutorizadorId(String autorizadorId){
    this.autorizadorId = autorizadorId;
  }
  
  private java.util.Date data;

  public java.util.Date getData(){
    return data;
  }

  public void setData(java.util.Date data){
    this.data = data;
  }
  
  private String formaPagamentoDestinoId;

  public String getFormaPagamentoDestinoId(){
    return formaPagamentoDestinoId;
  }

  public void setFormaPagamentoDestinoId(String formaPagamentoDestinoId){
    this.formaPagamentoDestinoId = formaPagamentoDestinoId;
  }
  
  private String formaPagamentoOrigemId;

  public String getFormaPagamentoOrigemId(){
    return formaPagamentoOrigemId;
  }

  public void setFormaPagamentoOrigemId(String formaPagamentoOrigemId){
    this.formaPagamentoOrigemId = formaPagamentoOrigemId;
  }
  
  private String id;

  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
  }
  
  private String lojaId;

  public String getLojaId(){
    return lojaId;
  }

  public void setLojaId(String lojaId){
    this.lojaId = lojaId;
  }
  
  private String vendaId;

  public String getVendaId(){
    return vendaId;
  }

  public void setVendaId(String vendaId){
    this.vendaId = vendaId;
  }
  
  private String operadorId;

  public String getOperadorId(){
    return operadorId;
  }

  public void setOperadorId(String operadorId){
    this.operadorId = operadorId;
  }
  
  private String sequencialPagamento;

  public String getSequencialPagamento(){
    return sequencialPagamento;
  }

  public void setSequencialPagamento(String sequencialPagamento){
    this.sequencialPagamento = sequencialPagamento;
  }
  
  private Double valor;

  public Double getValor(){
    return valor;
  }

  public void setValor(Double valor){
    this.valor = valor;
  }
  
  private Double valorContraValeOuTroco;

  public Double getValorContraValeOuTroco(){
    return valorContraValeOuTroco;
  }

  public void setValorContraValeOuTroco(Double valorContraValeOuTroco){
    this.valorContraValeOuTroco = valorContraValeOuTroco;
  }
  

      public void validate() throws Exception {
        if(this.data == null) throw new Exception("data não pode ser nulo!");
	if(this.formaPagamentoDestinoId == null) throw new Exception("formaPagamentoDestinoId não pode ser nulo!");
	if(this.formaPagamentoOrigemId == null) throw new Exception("formaPagamentoOrigemId não pode ser nulo!");
	if(this.id == null) throw new Exception("id não pode ser nulo!");
	if(this.lojaId == null) throw new Exception("lojaId não pode ser nulo!");
	if(this.sequencialPagamento == null) throw new Exception("sequencialPagamento não pode ser nulo!");
	if(this.valor == null) throw new Exception("valor não pode ser nulo!");        
      }
  }
  