
package br.inatel.projeto.model;

import br.inatel.projeto.control.DatabaseProduto;
import br.inatel.projeto.control.DatabaseSAC;

import java.util.ArrayList;

/**
 * Classe Unidade onde seus metodos e atributos sao estabelecidos
 * @author Eduardo Karpfenstein, Lucas Fajardo de Mello
 * @version 1.0 - Finalizado
 * @since 27/11/22
 */
public class Unidade{
    private int idUnidade;
    private String localizacao;
    private boolean taxa;
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private SAC sac = null;
    DatabaseSAC SACdb = new DatabaseSAC();
    DatabaseProduto prodDB = new DatabaseProduto();

    /**
     * Este construtor é mandatorio para se receber os parametros das informacoes da unidade
     * @param idUnidade recebe o ID da unidade, primary key
     * @param localizacao recebe a localizacao da unidade
     * @param taxa recebe a taxa de compra da unidade
     * Ao final procura e recebe um SAC
     */
    public Unidade(int idUnidade, String localizacao, boolean taxa) {
        this.idUnidade = idUnidade;
        this.localizacao = localizacao;
        this.taxa = taxa;
        sac = SACdb.researchSAC(this);
        produtos = prodDB.researchProduto(this);
    }

    /**
     * getter para ID da Unidade
     * @return Id da Unidade
     */
    public int getIdUnidade() {
        return idUnidade;
    }

    /**
     * getter para Localizacao da Unidade
     * @return localizacao da Unidade
     */
    public String getLocalizacao() {
        return localizacao;
    }

    /**
     * getter para taxa da Unidade
     * @return taxa da Unidade
     */
    public boolean isTaxa() {
        return taxa;
    }

    /**
     * getter para lista de produtos da Unidade
     * @return lista de produtos da Unidade
     */
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    /**
     * getter para SAC da Unidade
     * @return SAC da Unidade
     */
    public SAC getSac() {
        return sac;
    }

    /**
     * Override do metodo padrao `toString` para que seja formatado adequadamente
     * @return retorna formatado
     */
    @Override
    public String toString(){
        return localizacao;
    }
}