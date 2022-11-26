package br.inatel.projeto.control;

import br.inatel.projeto.model.Cliente;
import br.inatel.projeto.model.SAC;
import br.inatel.projeto.model.Unidade;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseSAC {
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
    public SAC researchSAC(Unidade unidade){
        connect();
        SAC sac = null;
        String sql = "SELECT * FROM SAC WHERE Unidade_idUnidade='"+unidade.getIdUnidade()+"'";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                sac = new SAC(result.getInt("Unidade_idUnidade"), result.getInt("idSAC"), result.getString("Telefone"),result.getString("Email"));
                System.out.println("Email = " + sac.getEmail());
                System.out.println("Telefone = " + sac.getTelefone());
                System.out.println("---------------------------------");
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
        return sac;
    }
}
