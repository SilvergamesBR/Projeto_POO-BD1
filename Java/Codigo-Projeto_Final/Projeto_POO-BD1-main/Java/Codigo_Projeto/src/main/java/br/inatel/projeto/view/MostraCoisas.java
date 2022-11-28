package br.inatel.projeto.view;

import br.inatel.projeto.model.Unidade;

import javax.swing.*;

public class MostraCoisas {
    public static void AvisoLogar(){
        JOptionPane.showMessageDialog(null,"Insira suas informacos para fazer login");
    }

    public static void AvisoLogErro(){
        JOptionPane.showMessageDialog(null,"CPF ou senha errado, insira novamente","Erro !!",JOptionPane.ERROR_MESSAGE);
    }

    public static void BemVindo(){
        JOptionPane.showMessageDialog(null,"Bem vindo(a) as lojas Luardo clique em ok para comecar a comprar !");
    }

    public static void MostraTotal(float total){
        JOptionPane.showMessageDialog(null,"Seu total e de "+total+"R$");
        JOptionPane.showMessageDialog(null,"Obrigado por comprar na nossa loja !\nVolte sempre !");
    }

    public static void AvisoSenha(){
        JOptionPane.showMessageDialog(null,"Senha Atualizada com Sucesso !");
    }

    public static void AvisoDeletado(){
        JOptionPane.showMessageDialog(null,"Conta Deletada !");
    }

    public static void MostraSAC(Unidade unidade){
        JOptionPane.showMessageDialog(null,"Email do SAC: "+unidade.getSac().getEmail()+"\nTelefone do SAC: "+unidade.getSac().getTelefone());
    }

    public static void MsgObrigado() {
        JOptionPane.showMessageDialog(null,"Obrigado pela preferencia !\nVolte sempre !");
    }
}
