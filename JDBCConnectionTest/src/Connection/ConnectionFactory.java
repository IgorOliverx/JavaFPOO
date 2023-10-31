package Connection;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ConnectionFactory
 */
public class ConnectionFactory {
    //atributos -> final indica uma constante
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "postgres";

    //metodos da classe
    public static Connection getConnection() {
        try{
        return DriverManager.getConnection(URL, USUARIO, SENHA);
        }catch(SQLException e){
            throw new RuntimeException("Erro ao obter conexão com o banco de dados" + e);
        }
    }

    public static void closeConnection(Connection connection){
        try{
            if(connection != null){
                connection.close();
            }
        }catch(SQLException e){
            System.out.println("Erro ao fechar a conexao");
        }
    }

     public static void close(Connection connection, PreparedStatement stmt){
        try{
            if(connection != null && stmt != null){
                connection.close();
            }
        }catch(SQLException e){
            System.out.println("Erro ao fechar a conexao");
        }
    }

  
    public static void main(String[] args) {
        

    }
    
}