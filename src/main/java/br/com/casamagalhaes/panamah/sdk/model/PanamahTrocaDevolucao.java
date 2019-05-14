
  package br.com.casamagalhaes.panamah.sdk.model;

  public class PanamahTrocaDevolucao {

      public PanamahTrocaDevolucao () {}

      public PanamahTrocaDevolucao (String id) { this.id = id; }
      
      

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
  
  private String vendaId;

  public String getVendaId(){
    return vendaId;
  }

  public void setVendaId(String vendaId){
    this.vendaId = vendaId;
  }
  
  private String id;

  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
  }
  
    private java.util.List<PanamahTrocaDevolucaoItens> itens;
    
    public java.util.List<PanamahTrocaDevolucaoItens> getItens(){ 
      return itens;
    }

    public void setItens(java.util.List<PanamahTrocaDevolucaoItens> itens) {
      this.itens = itens;
    }

    
  private String lojaId;

  public String getLojaId(){
    return lojaId;
  }

  public void setLojaId(String lojaId){
    this.lojaId = lojaId;
  }
  
  private String numeroCaixa;

  public String getNumeroCaixa(){
    return numeroCaixa;
  }

  public void setNumeroCaixa(String numeroCaixa){
    this.numeroCaixa = numeroCaixa;
  }
  
  private String operadorId;

  public String getOperadorId(){
    return operadorId;
  }

  public void setOperadorId(String operadorId){
    this.operadorId = operadorId;
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
  
  private String vendedorId;

  public String getVendedorId(){
    return vendedorId;
  }

  public void setVendedorId(String vendedorId){
    this.vendedorId = vendedorId;
  }
  

      public void validate() throws Exception {
        if(this.data == null) throw new Exception("data não pode ser nulo!");
	if(this.id == null) throw new Exception("id não pode ser nulo!");
	if(this.itens == null) throw new Exception("itens não pode ser nulo!");
	if(this.lojaId == null) throw new Exception("lojaId não pode ser nulo!");
	if(this.valor == null) throw new Exception("valor não pode ser nulo!");        
      }
  }
  