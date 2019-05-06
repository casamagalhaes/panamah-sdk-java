
  package br.com.casamagalhaes.panamah.sdk.model;

  public class PanamahTituloPagar {
      

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
  
  private String fornecedorId;

  public String getFornecedorId(){
    return fornecedorId;
  }

  public void setFornecedorId(String fornecedorId){
    this.fornecedorId = fornecedorId;
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
  
    private java.util.List<PanamahTituloPagarPagamentos> pagamentos;
    
    public java.util.List<PanamahTituloPagarPagamentos> getPagamentos(){ 
      return pagamentos;
    }

    public void setPagamentos(java.util.List<PanamahTituloPagarPagamentos> pagamentos) {
      this.pagamentos = pagamentos;
    }

    
  }
  