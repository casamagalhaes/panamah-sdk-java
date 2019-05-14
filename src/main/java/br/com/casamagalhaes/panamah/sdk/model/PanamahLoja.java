
  package br.com.casamagalhaes.panamah.sdk.model;

  public class PanamahLoja {

      public PanamahLoja () {}

      public PanamahLoja (String id) { this.id = id; }
      
      

  private Boolean ativa;

  public Boolean getAtiva(){
    return ativa;
  }

  public void setAtiva(Boolean ativa){
    this.ativa = ativa;
  }
  
  private String id;

  public String getId(){
    return id;
  }

  public void setId(String id){
    this.id = id;
  }
  
  private String descricao;

  public String getDescricao(){
    return descricao;
  }

  public void setDescricao(String descricao){
    this.descricao = descricao;
  }
  
  private String numeroDocumento;

  public String getNumeroDocumento(){
    return numeroDocumento;
  }

  public void setNumeroDocumento(String numeroDocumento){
    this.numeroDocumento = numeroDocumento;
  }
  
  private Boolean matriz;

  public Boolean getMatriz(){
    return matriz;
  }

  public void setMatriz(Boolean matriz){
    this.matriz = matriz;
  }
  
  private String holdingId;

  public String getHoldingId(){
    return holdingId;
  }

  public void setHoldingId(String holdingId){
    this.holdingId = holdingId;
  }
  
  private String ramo;

  public String getRamo(){
    return ramo;
  }

  public void setRamo(String ramo){
    this.ramo = ramo;
  }
  
  private String logradouro;

  public String getLogradouro(){
    return logradouro;
  }

  public void setLogradouro(String logradouro){
    this.logradouro = logradouro;
  }
  
  private String numero;

  public String getNumero(){
    return numero;
  }

  public void setNumero(String numero){
    this.numero = numero;
  }
  
  private String uf;

  public String getUf(){
    return uf;
  }

  public void setUf(String uf){
    this.uf = uf;
  }
  
  private String cidade;

  public String getCidade(){
    return cidade;
  }

  public void setCidade(String cidade){
    this.cidade = cidade;
  }
  
  private String bairro;

  public String getBairro(){
    return bairro;
  }

  public void setBairro(String bairro){
    this.bairro = bairro;
  }
  
  private String cep;

  public String getCep(){
    return cep;
  }

  public void setCep(String cep){
    this.cep = cep;
  }
  
  private String distrito;

  public String getDistrito(){
    return distrito;
  }

  public void setDistrito(String distrito){
    this.distrito = distrito;
  }
  
  private String complemento;

  public String getComplemento(){
    return complemento;
  }

  public void setComplemento(String complemento){
    this.complemento = complemento;
  }
  
  private String telefone;

  public String getTelefone(){
    return telefone;
  }

  public void setTelefone(String telefone){
    this.telefone = telefone;
  }
  
  private Double qtdCheckouts;

  public Double getQtdCheckouts(){
    return qtdCheckouts;
  }

  public void setQtdCheckouts(Double qtdCheckouts){
    this.qtdCheckouts = qtdCheckouts;
  }
  
  private Double areaM2;

  public Double getAreaM2(){
    return areaM2;
  }

  public void setAreaM2(Double areaM2){
    this.areaM2 = areaM2;
  }
  
  private Double qtdFuncionarios;

  public Double getQtdFuncionarios(){
    return qtdFuncionarios;
  }

  public void setQtdFuncionarios(Double qtdFuncionarios){
    this.qtdFuncionarios = qtdFuncionarios;
  }
  

      public void validate() throws Exception {
        if(this.ativa == null) throw new Exception("ativa não pode ser nulo!");
	if(this.id == null) throw new Exception("id não pode ser nulo!");
	if(this.descricao == null) throw new Exception("descricao não pode ser nulo!");
	if(this.numeroDocumento == null) throw new Exception("numeroDocumento não pode ser nulo!");
	if(this.matriz == null) throw new Exception("matriz não pode ser nulo!");
	if(this.holdingId == null) throw new Exception("holdingId não pode ser nulo!");
	if(this.ramo == null) throw new Exception("ramo não pode ser nulo!");
	if(this.uf == null) throw new Exception("uf não pode ser nulo!");
	if(this.cidade == null) throw new Exception("cidade não pode ser nulo!");
	if(this.bairro == null) throw new Exception("bairro não pode ser nulo!");        
      }
  }
  