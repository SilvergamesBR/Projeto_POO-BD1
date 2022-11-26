package br.inatel.projeto.control;
import br.inatel.projeto.model.Unidade;

import java.sql.*;

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

    //--------------------INSERINDO NOVO REGISTRO--------------------
    public boolean insertUnidade(Unidade unidade){
        connect();
        String sql = "INSERT INTO Unidade(idUnidade,localizacao,taxa) VALUES (?,?,?)";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1, unidade.getIdUnidade());// concatena idUnidade no primeiro ? do comando
            pst.setString(2, unidade.getLocalizacao());// concatena localizacao no segundo ? do comando
            pst.setBoolean(3, unidade.isTaxa());// concatena taxa no terceiro ? do comando// concatena Senha no quarta ? do comando
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

    //--------------------BUSCANDO NOVO REGISTRO--------------------
    public Unidade researchUnidade(int idUnidade){
        connect();
        Unidade unidade = null;
        String sql = "SELECT * FROM Unidade as U WHERE U.idUnidade = '"+idUnidade+"'";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                unidade = new Unidade(result.getInt("idUnidade"), result.getString("localizacao"),result.getBoolean("taxa"));
                System.out.println("Id = " + unidade.getIdUnidade());
                System.out.println("Localizacao = " + unidade.getLocalizacao());
                System.out.println("Possui taxa = " + unidade.isTaxa());
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
        return unidade;
    }

}
