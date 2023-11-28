package com.example.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {
    // Atributo de conexão
    private Connection connection;
    
    // Construtor inicializando a conexão com o banco de dados
    public LoginDAO(){
        this.connection = ConnectionFactory.getConnection();
    }

    // Método de inicialização do banco
    public void inicializarBanco() {
        try{
            // Verifica se a tabela existe; se não existir, cria e preenche com credenciais padrão
            if (!tabelaExiste()) {
                criaTabela();
                preencherTabela("adm", "adm"); // Credenciais de acesso
            }
        } catch(Exception e){
            System.out.println("Não foi possível inserir credencial: " + e.getMessage());
        }
    }

    // Método de verificação de tabela existente
    private boolean tabelaExiste() {
        boolean tabelaExiste = false;
        String verificaTabela = "SELECT 1 FROM login LIMIT 1";
    
        try (Statement stmt = connection.createStatement()) {
            // Tenta executar a consulta para verificar se a tabela existe
            ResultSet rs = stmt.executeQuery(verificaTabela);
            tabelaExiste = true;
        } catch (SQLException e) {
            System.out.println("Tabela não existe: " + e.getMessage());
        }
    
        return tabelaExiste;
    }

    // Método para criar a tabela se ela não existir
    public void criaTabela(){
        String sql = "CREATE TABLE IF NOT EXISTS login (SENHA VARCHAR(30), USUARIO VARCHAR(25) PRIMARY KEY)";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Método para preencher a tabela com credenciais padrão
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

    // Método para verificar se as credenciais estão corretas
    public boolean verificarLogin(String usuario, String senha){
        PreparedStatement stmt = null;
        boolean loginValido = false;
        ResultSet resultado = null;
        String sql = "SELECT * FROM login WHERE usuario = ? AND senha = ?";

        try {
            // Prepara a consulta SQL com os parâmetros de usuário e senha
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            resultado = stmt.executeQuery();

            // Verifica se a consulta retornou algum resultado válido
            if(resultado.next()){
                loginValido = true;
                System.out.println("Login realizado com sucesso!");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao verificar credenciais.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
        return loginValido;
    }
}
