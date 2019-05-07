
  package br.com.casamagalhaes.panamah.sdk.model;

  public class PanamahVendaItens {
      

  private Double acrescimo;

  public Double getAcrescimo(){
    return acrescimo;
  }

  public void setAcrescimo(Double acrescimo){
    this.acrescimo = acrescimo;
  }
  
  private Double desconto;

  public Double getDesconto(){
    return desconto;
  }

  public void setDesconto(Double desconto){
    this.desconto = desconto;
  }
  
  private Boolean efetivo;

  public Boolean getEfetivo(){
    return efetivo;
  }

  public void setEfetivo(Boolean efetivo){
    this.efetivo = efetivo;
  }
  
  private String funcionarioId;

  public String getFuncionarioId(){
    return funcionarioId;
  }

  public void setFuncionarioId(String funcionarioId){
    this.funcionarioId = funcionarioId;
  }
  
  private Double preco;

  public Double getPreco(){
    return preco;
  }

  public void setPreco(Double preco){
    this.preco = preco;
  }
  
  private String produtoId;

  public String getProdutoId(){
    return produtoId;
  }

  public void setProdutoId(String produtoId){
    this.produtoId = produtoId;
  }
  
  private String codigoRegistrado;

  public String getCodigoRegistrado(){
    return codigoRegistrado;
  }

  public void setCodigoRegistrado(String codigoRegistrado){
    this.codigoRegistrado = codigoRegistrado;
  }
  
  private Boolean promocao;

  public Boolean getPromocao(){
    return promocao;
  }

  public void setPromocao(Boolean promocao){
    this.promocao = promocao;
  }
  
  private Double quantidade;

  public Double getQuantidade(){
    return quantidade;
  }

  public void setQuantidade(Double quantidade){
    this.quantidade = quantidade;
  }
  
  private Double servico;

  public Double getServico(){
    return servico;
  }

  public void setServico(Double servico){
    this.servico = servico;
  }
  
  private Double valorTotal;

  public Double getValorTotal(){
    return valorTotal;
  }

  public void setValorTotal(Double valorTotal){
    this.valorTotal = valorTotal;
  }
  
  private Double valorUnitario;

  public Double getValorUnitario(){
    return valorUnitario;
  }

  public void setValorUnitario(Double valorUnitario){
    this.valorUnitario = valorUnitario;
  }
  
  private String tipoPreco;

  public String getTipoPreco(){
    return tipoPreco;
  }

  public void setTipoPreco(String tipoPreco){
    this.tipoPreco = tipoPreco;
  }
  
  private Double custo;

  public Double getCusto(){
    return custo;
  }

  public void setCusto(Double custo){
    this.custo = custo;
  }
  
  private Double markup;

  public Double getMarkup(){
    return markup;
  }

  public void setMarkup(Double markup){
    this.markup = markup;
  }
  
  private Double lucro;

  public Double getLucro(){
    return lucro;
  }

  public void setLucro(Double lucro){
    this.lucro = lucro;
  }
  

      public void validate() throws Exception {
        if(this.efetivo == null) throw new Exception("efetivo não pode ser nulo!");
	if(this.preco == null) throw new Exception("preco não pode ser nulo!");
	if(this.produtoId == null) throw new Exception("produtoId não pode ser nulo!");
	if(this.quantidade == null) throw new Exception("quantidade não pode ser nulo!");
	if(this.valorTotal == null) throw new Exception("valorTotal não pode ser nulo!");
	if(this.valorUnitario == null) throw new Exception("valorUnitario não pode ser nulo!");
	if(this.tipoPreco == null) throw new Exception("tipoPreco não pode ser nulo!");        
      }
  }
  