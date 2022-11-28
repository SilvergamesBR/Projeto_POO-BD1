package br.inatel.projeto.control;

import br.inatel.projeto.model.Cliente;
import br.inatel.projeto.model.Produto;
import br.inatel.projeto.model.SAC;
import br.inatel.projeto.model.Unidade;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseProduto {
    Connection connection; // objeto responsável por fazer a conexão com mysql
    Statement statement; // objeto responsável por preparar consultas "SELECT"
    ResultSet result; // objeto responsável por executar consultas "SELECT"
    PreparedStatement pst; // objeto responsável por preparar querys de manipulação dinâmica(INSERT, UPDATE, DELETE)

    static final String user = "root"; // usuário da instância local do servidor
    static final String password = "Fajardo22"; // senha do usuário da instância local do servidor
    static final String database = "projeto"; // nome do banco de dados a ser utilizado

    // String com URL de conexão com o servidor
    static final String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    private boolean check = false;

    public void connect(){

        try{
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }
    //buscando o SAC ligado a loja
    public ArrayList<Produto> researchProduto(Unidade unidade){
        connect();
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        String sql = "SELECT * FROM Produto WHERE Unidade_idUnidade='"+unidade.getIdUnidade()+"'";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Produto prodTemp = new Produto(result.getInt("codigoProduto"), result.getInt("Unidade_idUnidade"), result.getString("nome"),result.getFloat("valor"), result.getString("descricao"), result.getInt("quantidade"));
                produtos.add(prodTemp);
            }
        }catch(SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }
        finally {
            try{
                connection.close();
                statement.close();
                result.close();
            } catch (SQLException e){
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return produtos;
    }

    public boolean updateCarrinho(ArrayList<Produto> carrinho) {
        for (Produto produto : carrinho) {
            connect();
            String sql = "UPDATE Produto SET Quantidade=Quantidade-? WHERE CodigoProduto=?";

            try {
                pst = connection.prepareStatement(sql);
                pst.setInt(1, produto.getQuantidade());
                pst.setInt(2, produto.getCodigoProduto());
                pst.execute();
                check = true;
            } catch (SQLException e) {
                System.out.println("Erro de conexão: " + e.getMessage());
                check = false;
            } finally {
                try {
                    connection.close();
                    pst.close();
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar conexão: " + e.getMessage());
                }
            }
        }
        return check;
    }
}
