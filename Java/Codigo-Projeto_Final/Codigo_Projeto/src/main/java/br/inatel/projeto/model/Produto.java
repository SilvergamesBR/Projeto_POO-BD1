
package br.inatel.projeto.model;

/**
 * Classe Produto onde seus metodos e atributos sao estabelecidos
 * @author Eduardo Karpfenstein, Lucas Fajardo de Mello
 * @version 1.0 - Finalizado
 * @since 27/11/22
 */
public class Produto {
    private int codigoProduto;
    private int unidade_idUnidade;
    private String nome;
    private float valor;
    private String descricao;
    private int quantidade;

    /**
     * Este construtor é mandatorio para se receber os parametros das informacoes dos produtos
     * @param codigoProduto recebe o codigo do produto, primary key
     * @param unidade_idUnidade recebe o ID da unidade a qual o produto pertence, foreign key de unidade
     * @param nome recebe o nome do produto
     * @param valor recebe o valor do produto
     * @param descricao recebe a descricao do produto
     * @param quantidade recebe a quantidade em estoque do produto
     */
    public Produto(int codigoProduto, int unidade_idUnidade, String nome, float valor, String descricao, int quantidade) {
        this.codigoProduto = codigoProduto;
        this.unidade_idUnidade = unidade_idUnidade;
        this.nome = nome;
        this.valor = valor;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    /**
     * getter para codigo do Produto
     * @return codigo do Produto
     */
    public int getCodigoProduto() {
        return codigoProduto;
    }

    /**
     * getter para valor do Produto
     * @return valor do Produto
     */
    public float getValor() {
        return valor;
    }

    /**
     * setter para valor do Produto
     * @return valor do Produto modificado
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

    /**
     * getter para quantidade do Produto
     * @return quantidade do Produto
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * setter para quantidade do Produto
     * @return quantidade do Produto modificado
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    /**
     * Override do metodo padrao `toString` para que seja formatado adequadamente
     * @return retorna formatado
     */
    @Override
    public String toString(){
        if(descricao != null) {
            return nome + ": " + descricao+" Valor unitario: "+valor;
        }else{
            return nome+" Valor unitario: "+valor;
        }
    }

}
