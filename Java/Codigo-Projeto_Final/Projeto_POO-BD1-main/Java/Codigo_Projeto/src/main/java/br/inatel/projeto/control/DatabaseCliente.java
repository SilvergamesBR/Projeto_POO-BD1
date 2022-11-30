
package br.inatel.projeto.control;

import br.inatel.projeto.model.Cliente;

import java.sql.*;

/**
 * Classe de Database que conecta com o banco de dados do Cliente
 * @author Eduardo Karpfenstein, Lucas Fajardo de Mello
 * @version 1.0 - Finalizado
 * @since 27/11/22
 */
public class DatabaseCliente {
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

    /**
     * Funcao que conecta ao Banco de Dados
     */
    public void connect(){

        try{
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }

    //--------------------INSERINDO NOVO REGISTRO--------------------
    /**
     * Funcao que insere um novo registro
     * @return checagem de conxecao
     */
    public boolean insertCliente(Cliente cliente){
        connect();
        String sql = "INSERT INTO Cliente(CPF,Nome,Genero,Senha) VALUES (?,?,?,?)";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1,cliente.getCPF());// concatena CPF no primeiro ? do comando
            pst.setString(2,cliente.getNome());// concatena nome no segundo ? do comando
            pst.setString(3,cliente.getGenero());// concatena genero no terceiro ? do comando
            pst.setString(4,cliente.getSenha());// concatena Senha no quarta ? do comando
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
    /**
     * Funcao que busca um novo registro
     * @return registro pesquisado
     */
    public Cliente researchCliente(String CPF,String Senha){
        connect();
        Cliente cliente = null;
        String sql = "SELECT * FROM Cliente as C WHERE C.CPF = '"+CPF+"' AND C.Senha = '"+Senha+"'";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                cliente = new Cliente(result.getString("Nome"), result.getString("CPF"),result.getString("Genero"),result.getString("Senha"));
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
        return cliente;
    }

    //--------------------ATUALIZANDO SENHA DO REGISTRO--------------------
    /**
     * Funcao que atualiza um novo registro
     * @return checagem de conxecao
     */
    public boolean updateCliente(Cliente cliente,String senha){
        connect();
        String sql = "UPDATE Cliente SET Senha=? WHERE CPF=?";

        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1,senha);
            pst.setString(2,cliente.getCPF());
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
    /**
     * Funcao que exclui um novo registro
     * @return checagem de conxecao
     */
    public boolean deleteCliente(Cliente cliente){
        connect();
        String sql = "DELETE FROM Cliente WHERE CPF =? AND Senha =?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, cliente.getCPF());
            pst.setString(2, cliente.getSenha());
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

