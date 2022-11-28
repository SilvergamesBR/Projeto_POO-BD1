package br.inatel.projeto.control;
import br.inatel.projeto.model.Cliente;
import br.inatel.projeto.model.Unidade;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseUnidade {
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
    //--------------------BUSCANDO NOVO REGISTRO--------------------
    public ArrayList<Unidade> researchUnidade(Cliente cliente){
        connect();
        ArrayList<Unidade> unidades = new ArrayList<Unidade>();
        String sql = "SELECT U.* FROM Unidade AS U INNER JOIN Cliente_has_Unidade AS CU WHERE U.idUnidade = CU.Unidade_idUnidade AND CU.Cliente_CPF = '"+cliente.getCPF()+"'";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Unidade unidade = new Unidade(result.getInt("idUnidade"), result.getString("localizacao"), result.getBoolean("taxa"));
                unidades.add(unidade);
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
        return unidades;
    }
    public int researchUnidadeID(String localizacao){
        connect();
        int ID = 0;
        String sql = "SELECT idUnidade FROM Unidade WHERE Localizacao ='"+localizacao+"'";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                ID = result.getInt("idUnidade");
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
        return ID;
    }
}
