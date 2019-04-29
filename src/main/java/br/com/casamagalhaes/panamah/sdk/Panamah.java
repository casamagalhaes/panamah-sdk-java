package br.com.casamagalhaes.panamah.sdk;

/**
 * Panamah client
 * 
 * 
 */
public class Panamah {

    private static Panamah instance;

    /**
     * configuração inicial
     * 
     * @return 
     */
    public synchronized static Panamah init() {
        if (instance == null) {
            instance = new Panamah();
        }
        return instance;
    }

	public void send(PanamahVenda venda) {

       
    }

    public void flush(){

    }
    
    public void progress(){
        
    }
}