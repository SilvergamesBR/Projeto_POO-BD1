package br.inatel.projeto.control;

import br.inatel.projeto.model.Cliente;
import br.inatel.projeto.model.Unidade;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseCliente_Has_Unidade {
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
    //inserindo uma nova loja para o cliente
    public boolean insertCliente_Has_Unidade(Cliente cliente,int ID){
        connect();
        String sql = "INSERT INTO Cliente_has_Unidade(Cliente_CPF,Unidade_idUnidade) VALUES (?,?)";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1,cliente.getCPF());// concatena CPF no primeiro ? do comando
            pst.setInt(2,ID);// concatena nome no segundo ? do comando
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de conexão: " + e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                pst.close();
            } catch (SQLException e){
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return check;
    }
    //--------------------EXCLUINDO REGISTRO--------------------
    public boolean deleteCliente_has_Unidade(Cliente cliente,int ID){
        connect();
        String sql = "DELETE FROM Cliente_has_Unidade WHERE Cliente_CPF = ? AND Unidade_idUnidade = ?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, cliente.getCPF());
            pst.setInt(2, ID);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de conexão: " + e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                pst.close();
            } catch (SQLException e){
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return check;
    }
}
