package br.inatel.projeto.view;

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

}
