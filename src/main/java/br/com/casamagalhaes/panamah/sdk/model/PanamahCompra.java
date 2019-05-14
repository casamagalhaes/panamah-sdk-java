
  package br.com.casamagalhaes.panamah.sdk.model;

  public class PanamahCompra {

      public PanamahCompra () {}

      public PanamahCompra (String id) { this.id = id; }
      
      

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
  
  private String funcionarioId;

  public String getFuncionarioId(){
    return funcionarioId;
  }

  public void setFuncionarioId(String funcionarioId){
    this.funcionarioId = funcionarioId;
  }
  
  private java.util.Date dataEntrada;

  public java.util.Date getDataEntrada(){
    return dataEntrada;
  }

  public void setDataEntrada(java.util.Date dataEntrada){
    this.dataEntrada = dataEntrada;
  }
  
  private java.util.Date dataEmissao;

  public java.util.Date getDataEmissao(){
    return dataEmissao;
  }

  public void setDataEmissao(java.util.Date dataEmissao){
    this.dataEmissao = dataEmissao;
  }
  
  private java.util.Date dataHoraCompra;

  public java.util.Date getDataHoraCompra(){
    return dataHoraCompra;
  }

  public void setDataHoraCompra(java.util.Date dataHoraCompra){
    this.dataHoraCompra = dataHoraCompra;
  }
  
  private Double desconto;

  public Double getDesconto(){
    return desconto;
  }

  public void setDesconto(Double desconto){
    this.desconto = desconto;
  }
  
  private Boolean efetiva;

  public Boolean getEfetiva(){
    return efetiva;
  }

  public void setEfetiva(Boolean efetiva){
    this.efetiva = efetiva;
  }
  
  private Double quantidadeItens;

  public Double getQuantidadeItens(){
    return quantidadeItens;
  }

  public void setQuantidadeItens(Double quantidadeItens){
    this.quantidadeItens = quantidadeItens;
  }
  
  private String tipoDesconto;

  public String getTipoDesconto(){
    return tipoDesconto;
  }

  public void setTipoDesconto(String tipoDesconto){
    this.tipoDesconto = tipoDesconto;
  }
  
  private Double valor;

  public Double getValor(){
    return valor;
  }

  public void setValor(Double valor){
    this.valor = valor;
  }
  
  private Double acrescimo;

  public Double getAcrescimo(){
    return acrescimo;
  }

  public void setAcrescimo(Double acrescimo){
    this.acrescimo = acrescimo;
  }
  
    private java.util.List<PanamahCompraItens> itens;
    
    public java.util.List<PanamahCompraItens> getItens(){ 
      return itens;
    }

    public void setItens(java.util.List<PanamahCompraItens> itens) {
      this.itens = itens;
    }

    

      public void validate() throws Exception {
        if(this.id == null) throw new Exception("id não pode ser nulo!");
	if(this.lojaId == null) throw new Exception("lojaId não pode ser nulo!");
	if(this.dataEntrada == null) throw new Exception("dataEntrada não pode ser nulo!");
	if(this.dataEmissao == null) throw new Exception("dataEmissao não pode ser nulo!");
	if(this.dataHoraCompra == null) throw new Exception("dataHoraCompra não pode ser nulo!");
	if(this.efetiva == null) throw new Exception("efetiva não pode ser nulo!");
	if(this.quantidadeItens == null) throw new Exception("quantidadeItens não pode ser nulo!");
	if(this.valor == null) throw new Exception("valor não pode ser nulo!");
	if(this.itens == null) throw new Exception("itens não pode ser nulo!");        
      }
  }
  