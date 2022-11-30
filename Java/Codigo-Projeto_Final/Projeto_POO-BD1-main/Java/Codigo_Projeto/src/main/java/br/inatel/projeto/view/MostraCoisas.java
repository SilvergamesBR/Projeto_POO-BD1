
package br.inatel.projeto.view;

import br.inatel.projeto.model.Unidade;

import javax.swing.*;

/**
 * Classe Viewer que apresenta as informacoes para o usuario
 * @author Eduardo Karpfenstein, Lucas Fajardo de Mello
 * @version 1.0 - Finalizado
 * @since 27/11/22
 */
public class MostraCoisas {
    /**
     * Funcao que mostra mensagem para o usuario ao logar
     * @return uma mensagem ao usuario
     */
    public static void AvisoLogar(){
        JOptionPane.showMessageDialog(null,"Insira suas informacos para fazer login");
    }

    /**
     * Funcao que mostra mensagem de erro para o usuario ao logar incorretamente
     * @return uma mensagem ao usuario
     */
    public static void AvisoLogErro(){
        JOptionPane.showMessageDialog(null,"CPF ou senha errado, insira novamente","Erro !!",JOptionPane.ERROR_MESSAGE);
    }
    /**
     * Funcao que mostra mensagem de boas vindas para o usuario
     * @return uma mensagem ao usuario
     */
    public static void BemVindo(){
        JOptionPane.showMessageDialog(null,"Bem vindo(a) as lojas Luardo clique em ok para comecar a comprar !");
    }

    /**
     * Funcao que mostra mensagem para o usuario com o total de sua compra
     * @return uma mensagem ao usuario
     */
    public static void MostraTotal(float total){
        JOptionPane.showMessageDialog(null,"Seu total e de "+total+"R$");
        JOptionPane.showMessageDialog(null,"Obrigado por comprar na nossa loja !\nVolte sempre !");
    }

    /**
     * Funcao que mostra mensagem para o usuario ao atualizar sua senha
     * @return uma mensagem ao usuario
     */
    public static void AvisoSenha(){
        JOptionPane.showMessageDialog(null,"Senha Atualizada com Sucesso !");
    }

    /**
     * Funcao que mostra mensagem para o usuario ao deletar sua conta
     * @return uma mensagem ao usuario
     */
    public static void AvisoDeletado(){
        JOptionPane.showMessageDialog(null,"Conta Deletada !");
    }

    /**
     * Funcao que mostra mensagem para o usuario requisitar informacoes do SAC
     * @return uma mensagem ao usuario
     */
    public static void MostraSAC(Unidade unidade){
        JOptionPane.showMessageDialog(null,"Email do SAC: "+unidade.getSac().getEmail()+"\nTelefone do SAC: "+unidade.getSac().getTelefone());
    }

    /**
     * Funcao que mostra mensagem para o usuario ao encerrar sua compra
     * @return uma mensagem ao usuario
     */
    public static void MsgObrigado() {
        JOptionPane.showMessageDialog(null,"Obrigado pela preferencia !\nVolte sempre !");
    }
}
