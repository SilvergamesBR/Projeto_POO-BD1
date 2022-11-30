
package br.inatel.projeto.model;

/**
 * Classe SAC onde seus metodos e atributos sao estabelecidos
 * @author Eduardo Karpfenstein, Lucas Fajardo de Mello
 * @version 1.0 - Finalizado
 * @since 27/11/22
 */
public class SAC {
    private int unidade_idUnidade;
    private int idSAC;
    private String telefone;
    private String email;

    /**
     * Este construtor é mandatorio para se receber os parametros das informacoes do SAC
     * @param unidade_idUnidade recebe o ID da unidade a qual o SAC pertence, foreign key de unidade
     * @param idSAC recebe o codigo do SAC, primary key
     * @param telefone recebe o telefone de contato do SAC
     * @param email recebe o email de contato do SAC
     */
    public SAC(int unidade_idUnidade, int idSAC, String telefone, String email) {
        this.unidade_idUnidade = unidade_idUnidade;
        this.idSAC = idSAC;
        this.telefone = telefone;
        this.email = email;
    }

    /**
     * getter para telefone do SAC
     * @return telefone do SAC
     */
    public String getTelefone() {
        return telefone;
    }

     /**
     * getter para telefone do SAC
     * @return telefone do SAC
     */
    public String getEmail() {
        return email;
    }

}
