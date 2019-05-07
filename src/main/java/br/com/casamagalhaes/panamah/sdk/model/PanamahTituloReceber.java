
  package br.com.casamagalhaes.panamah.sdk.model;

  public class PanamahTituloReceber {
      

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
  
  private String clienteId;

  public String getClienteId(){
    return clienteId;
  }

  public void setClienteId(String clienteId){
    this.clienteId = clienteId;
  }
  
  private String documento;

  public String getDocumento(){
    return documento;
  }

  public void setDocumento(String documento){
    this.documento = documento;
  }
  
  private Double valorNominal;

  public Double getValorNominal(){
    return valorNominal;
  }

  public void setValorNominal(Double valorNominal){
    this.valorNominal = valorNominal;
  }
  
  private Double valorJuros;

  public Double getValorJuros(){
    return valorJuros;
  }

  public void setValorJuros(Double valorJuros){
    this.valorJuros = valorJuros;
  }
  
  private Double valorMulta;

  public Double getValorMulta(){
    return valorMulta;
  }

  public void setValorMulta(Double valorMulta){
    this.valorMulta = valorMulta;
  }
  
  private Double valorDevido;

  public Double getValorDevido(){
    return valorDevido;
  }

  public void setValorDevido(Double valorDevido){
    this.valorDevido = valorDevido;
  }
  
  private Double valorPago;

  public Double getValorPago(){
    return valorPago;
  }

  public void setValorPago(Double valorPago){
    this.valorPago = valorPago;
  }
  
  private java.util.Date dataEmissao;

  public java.util.Date getDataEmissao(){
    return dataEmissao;
  }

  public void setDataEmissao(java.util.Date dataEmissao){
    this.dataEmissao = dataEmissao;
  }
  
  private java.util.Date dataVencimento;

  public java.util.Date getDataVencimento(){
    return dataVencimento;
  }

  public void setDataVencimento(java.util.Date dataVencimento){
    this.dataVencimento = dataVencimento;
  }
  
    private java.util.List<PanamahTituloReceberPagamentos> pagamentos;
    
    public java.util.List<PanamahTituloReceberPagamentos> getPagamentos(){ 
      return pagamentos;
    }

    public void setPagamentos(java.util.List<PanamahTituloReceberPagamentos> pagamentos) {
      this.pagamentos = pagamentos;
    }

    

      public void validate() throws Exception {
        if(this.id == null) throw new Exception("id não pode ser nulo!");
	if(this.lojaId == null) throw new Exception("lojaId não pode ser nulo!");
	if(this.clienteId == null) throw new Exception("clienteId não pode ser nulo!");
	if(this.documento == null) throw new Exception("documento não pode ser nulo!");
	if(this.valorNominal == null) throw new Exception("valorNominal não pode ser nulo!");
	if(this.valorJuros == null) throw new Exception("valorJuros não pode ser nulo!");
	if(this.valorMulta == null) throw new Exception("valorMulta não pode ser nulo!");
	if(this.valorDevido == null) throw new Exception("valorDevido não pode ser nulo!");
	if(this.valorPago == null) throw new Exception("valorPago não pode ser nulo!");
	if(this.dataEmissao == null) throw new Exception("dataEmissao não pode ser nulo!");
	if(this.dataVencimento == null) throw new Exception("dataVencimento não pode ser nulo!");
	if(this.pagamentos == null) throw new Exception("pagamentos não pode ser nulo!");        
      }
  }
  