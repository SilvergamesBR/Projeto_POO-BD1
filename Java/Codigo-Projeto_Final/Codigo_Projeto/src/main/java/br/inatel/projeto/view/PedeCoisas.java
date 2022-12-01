
package br.inatel.projeto.view;

import br.inatel.projeto.model.Produto;
import br.inatel.projeto.model.Unidade;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Classe Viewer que requisita as informacoes para o usuario
 * @author Eduardo Karpfenstein, Lucas Fajardo de Mello
 * @version 1.0 - Finalizado
 * @since 27/11/22
 */
public class PedeCoisas {
    /**
     * Funcao que requisita CPF do Usuario
     * @return uma infomacao escrita pelo usuario
     */
    public static String PedeCPF(){
        return JOptionPane.showInputDialog("Digite seu CPF\n(lembre-se de colocar os pontos e traco)");
    }
    /**
     * Funcao que requisita senha do Usuario
     * @return uma infomacao escrita pelo usuario
     */
    public static String PedeSenha(){
        return JOptionPane.showInputDialog("Digite sua senha");
    }
    /**
     * Funcao que requisita genero do Usuario
     * @return uma infomacao escrita pelo usuario
     */
    public static String PedeGenero(){
        Object[] opcoes = {"Masculino","Feminino","Nao Binario","Outro"};
        return (String) JOptionPane.showInputDialog(null,"Selecione o seu genero","Selecione",JOptionPane.PLAIN_MESSAGE,null,opcoes,"Masculino");
    }
    /**
     * Funcao que requisita nome do Usuario
     * @return uma infomacao escrita pelo usuario
     */
    public static String PedeNome(){
        return JOptionPane.showInputDialog("Insira o seu nome");
    }

    /**
     * Funcao que requisita criacao de um novo Usuario
     * @return uma infomacao escolhida pelo usuario
     */
    public static int PerguntaNovo(){
        return JOptionPane.showConfirmDialog(null,"Deseja criar uma nova conta ?","Desejos",JOptionPane.YES_NO_OPTION);
    }

    /**
     * Funcao que requisita alocacao de uma nova Unidade ao Usuario
     * @return uma infomacao escolhida pelo usuario
     */
    public static int PerguntaNovaUnid(){
        return JOptionPane.showConfirmDialog(null,"Deseja se cadastrar em uma nova unidade ?","Desejos",JOptionPane.YES_NO_OPTION);
    }

    /**
     * Funcao que requisita escolha da unidade pelo Usuario para alocacao
     * @return uma infomacao escolhida pelo usuario
     */
    public static String PedeUnidade(ArrayList<Unidade> unidades){
        ArrayList<String> opcoes = new ArrayList<String>();
        opcoes.add("Sao Paulo,SP");
        opcoes.add("Rio de Janeiro,RJ");
        opcoes.add("Pouso Alegre,MG");
        opcoes.add("Juiz de Fora,MG");
        if(unidades != null) {
            for (int i = 0; i < unidades.size(); i++) {
                for (int j = 0; j < opcoes.size(); j++) {
                    if (opcoes.get(j).equals(unidades.get(i).getLocalizacao())) {
                        opcoes.remove(j);
                    }
                }
            }
        }
        return (String) JOptionPane.showInputDialog(null,"Selecione a unidade","Selecione",JOptionPane.PLAIN_MESSAGE,null,opcoes.toArray(),"");
    }

    /**
     * Funcao que requisita escolha da unidade pelo Usuario para compra
     * @return uma infomacao escolhida pelo usuario
     */
    public static Unidade PedeUnidadeCompra(ArrayList<Unidade> unidades){
        return (Unidade) JOptionPane.showInputDialog(null,"Selecione a unidade da qual voce quer comprar","Selecione",JOptionPane.PLAIN_MESSAGE,null,unidades.toArray(),"");
    }

    /**
     * Funcao que requisita escolha do produto pelo Usuario para compra
     * @return uma infomacao escolhida pelo usuario
     */
    public static Produto PedeProduto(ArrayList<Produto> produtos){
        return (Produto) JOptionPane.showInputDialog(null,"Selecione o produto que voce quer comprar","Selecione",JOptionPane.PLAIN_MESSAGE,null,produtos.toArray(),"");
    }

    /**
     * Funcao que requisita escolha da quantida de produtos pelo Usuario para compra
     * @return uma infomacao escolhida pelo usuario
     */
    public static int PedeQuantidade(Produto produto){
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantas unidades desse produto voce deseja?\nTemos "+produto.getQuantidade()+" em estoque"));
        if(quantidade > produto.getQuantidade()){
            quantidade = Integer.parseInt(JOptionPane.showInputDialog("Nao temos essa quantidade em estoque, favor selecionar menos unidades\nTemos "+produto.getQuantidade()+" em estoque"));
        }
        return quantidade;
    }

    /**
     * Funcao que requisita escolha do Usuario se ele gostaria de continuar ou encerrar a compra
     * @return uma infomacao escolhida pelo usuario
     */
    public static int PerguntaContComp(){
        return JOptionPane.showConfirmDialog(null,"Deseja continuar comprando ?","Desejos",JOptionPane.YES_NO_OPTION);
    }
    /**
     * Funcao que requisita escolha do Usuario se ele gostaria de deletar sua conta
     * @return uma infomacao escolhida pelo usuario
     */
    public static int PerguntaDelete(){
        return JOptionPane.showConfirmDialog(null,"Deseja deletar a sua conta","Desejos",JOptionPane.YES_NO_OPTION);
    }

    /**
     * Funcao que requisita as escolhas de operacao que o usuario deseja realizar
     * @return uma infomacao escolhida pelo usuario
     */
    public static int PerguntaPrincipal(){
        String aux;
        int i;
        Object[] opcoes = {"Agregar Unidade","Realizar Compra","Atualizar Senha","Deletar Conta","Informacoes do SAC", "Finalizar Operacao"};
        aux = (String) JOptionPane.showInputDialog(null,"Selecione o que deseja fazer","Selecione",JOptionPane.PLAIN_MESSAGE,null,opcoes,"Masculino");
        for(i = 0; i < opcoes.length; i++){
            if(aux == opcoes[i]){
                break;
            }
        }
        return i;
    }

    /**
     * Funcao que altera a senha do usuario
     * @return uma infomacao escrita pelo usuario
     */
    public static String PedeNovaSenha(){
        return JOptionPane.showInputDialog("Digite sua nova senha");
    }

    /**
     * Funcao que requisita escolha do Usuario de qual unidade deseja obter as informacoes do SAC
     * @return uma infomacao escolhida pelo usuario
     */
    public static Unidade PedeUnidadeSAC(ArrayList<Unidade> unidades){
        return (Unidade) JOptionPane.showInputDialog(null,"Selecione a unidade da qual voce quer as informacoes","Selecione",JOptionPane.PLAIN_MESSAGE,null,unidades.toArray(),"");
    }

}
