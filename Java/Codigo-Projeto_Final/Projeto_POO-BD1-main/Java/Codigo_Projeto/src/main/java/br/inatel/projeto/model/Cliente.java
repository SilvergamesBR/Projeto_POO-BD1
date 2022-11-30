
package br.inatel.projeto.model;

/**
 * Classe Cliente onde seus metodos e atributos sao estabelecidos
 * @author Eduardo Karpfenstein, Lucas Fajardo de Mello
 * @version 1.0 - Finalizado
 * @since 27/11/22
 */
public class Cliente {
    private String nome;
    private String CPF;
    private String genero;
    private String senha;

    /**
     * Este construtor é mandatorio para se receber os parametros das informacoes dos clientes
     * @param nome recebe o nome do cliente
     * @param CPF recebe o CPF do cliente, considerada como primary key
     * @param genero recebe o genero do cliente
     * @param senha recebe a senha do cliente
     */
    public Cliente(String nome, String CPF, String genero, String senha) {
        this.nome = nome;
        this.CPF = CPF;
        this.genero = genero;
        this.senha = senha;
    }

    /**
     * getter para nome do Cliente
     * @return nome do Cliente
     */
    public String getNome() {
        return nome;
    }

    /**
     * getter para CPF do Cliente
     * @return CPF do Cliente
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * getter para genero do Cliente
     * @return genero do Cliente
     */
    public String getGenero() {
        return genero;
    }

    /**
     * getter para senha do Cliente
     * @return senha do Cliente
     */
    public String getSenha() {
        return senha;
    }

}
