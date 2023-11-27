package com.example.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {
    //Atributo de conexão
    private Connection connection;
    
    //Construtor inicializando a conexão com o banco de dados
    public LoginDAO(){
        this.connection = ConnectionFactory.getConnection();
    }

    //método de inicialização do banco
    public void inicializarBanco() {
        if (!tabelaExiste()) {
            criaTabela();
            preencherTabela("adm", "adm"); // Credenciais de acesso
        }
    }

    //método de verificação de tabela existente
    private boolean tabelaExiste() {
        boolean tabelaExiste = false;
        String verificaTabela = "SELECT 1 FROM login LIMIT 1";
    
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(verificaTabela);
            tabelaExiste = true;
        } catch (SQLException e) {
           System.out.println("Tabela não existe"+ e.getMessage());
        }
    
        return tabelaExiste;
    }

    public void criaTabela(){
        String sql = "CREATE TABLE IF NOT EXISTS login (SENHA VARCHAR(30),USUARIO VARCHAR(25) PRIMARY KEY)";
      try (Statement stmt = this.connection.createStatement()) {
         stmt.execute(sql);
         System.out.println("Tabela criada com sucesso.");
      } catch (SQLException e) {
         throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
      } finally {
         ConnectionFactory.closeConnection(this.connection);
      }
    }

// Preencher usuario no banco
public void preencherTabela(String usuario, String senha) {
    PreparedStatement stmt = null;
    String sql = "INSERT INTO login (usuario, senha) VALUES (?, ?)";
    try {
       stmt = connection.prepareStatement(sql);
       stmt.setString(1, usuario);
       stmt.setString(2, senha);
       stmt.executeUpdate();
       System.out.println("Credenciais criadas");
    } catch (SQLException e) {
       throw new RuntimeException("Erro ao criar credenciais.", e);
    } finally {
       ConnectionFactory.closeConnection(connection, stmt);
    }
 }

      public boolean verificarLogin(String usuario, String senha){
            PreparedStatement stmt = null;
            boolean loginValido = false;
            ResultSet resultado = null;
        String sql = "SELECT * FROM login WHERE usuario = ? AND senha = ?";

         try {
            //preparação do statement
         stmt = connection.prepareStatement(sql);
         stmt.setString(1, usuario);
         stmt.setString(2, senha);
         resultado = stmt.executeQuery();

         //verificação da instrução
        if(resultado.next()){
            loginValido = true;
            System.out.println("login realizado com sucesso!");
        }
      } catch (SQLException e) {
         throw new RuntimeException("Erro ao verificar credenciais.", e);
      } finally {
         ConnectionFactory.closeConnection(connection, stmt);
      }
      return loginValido;
    }

  
}


