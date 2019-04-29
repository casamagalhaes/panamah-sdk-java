package br.com.casamagalhaes.panamah.sdk;

/**
 * Panamah client
 *
 * @author Casa Magalhães
 *
 */
public class Panamah {

    private static Panamah instance;

    private Panamah() {
    }

    /**
     * configuração inicial
     *
     * @return instância singleton
     */
    public synchronized static Panamah init() {
        if (instance == null) {
            instance = new Panamah();
        }
        return instance;
    }

    /**
     * enviar venda para o lote
     *
     * @param assinante assinante
     */
    public void send(PanamahAssinante assinante) {

    }

    /**
     * enviar cliente para o lote
     *
     * @param cliente cliente
     */
    public void send(PanamahCliente cliente) {

    }

    /**
     * enviar compra para o lote
     *
     * @param compra compra
     */
    public void send(PanamahCompra compra) {

    }

    /**
     * enviar revenda para o lote
     *
     * @param revenda
     */
    public void send(PanamahRevenda revenda) {

    }

    /**
     * enviar movimentação de estoque para o lote
     *
     * @param estoqueMovimentacao estoqueMovimentacao
     */
    public void send(PanamahEstoqueMovimentacao estoqueMovimentacao) {

    }

    /**
     * enviar evento de caixa para o lote
     *
     * @param eventoCaixa eventoCaixa
     */
    public void send(PanamahEventoCaixa eventoCaixa) {

    }

    /**
     * enviar fornecedor para o lote
     *
     * @param fornecedor fornecedor
     */
    public void send(PanamahFornecedor fornecedor) {

    }

    /**
     * enviar funcionario para o lote
     *
     * @param funcionario funcionario
     */
    public void send(PanamahFuncionario funcionario) {

    }

    /**
     * enviar grupo para o lote
     *
     * @param grupo grupo
     */
    public void send(PanamahGrupo grupo) {

    }

    /**
     * enviar holding para o lote
     *
     * @param holding holding
     */
    public void send(PanamahHolding holding) {

    }

    /**
     * enviar localEstoque para o lote
     *
     * @param localEstoque localEstoque
     */
    public void send(PanamahLocalEstoque localEstoque) {

    }

    /**
     * enviar venda para o lote
     *
     * @param venda venda de produto
     */
    public void send(PanamahVenda venda) {

    }

    /**
     * chamada para forçar o fechamento e envio do lote atual
     */
    public void flush() {

    }

    /**
     * chamada para saber o status geral dos lotes
     */
    public void progress() {

    }
}
