package Connection;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDao {
    private Connection connection;
    private PreparedStatement stmt;

    public ConnectionDao() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS minhatable (ID SERIAL PRIMARY KEY, NOME VARCHAR(255), EMAIL VARCHAR(255));";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar tabela: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    public void apagarTabela() {
        String sql = "DROP TABLE minhatable";
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Tabela apagada com sucesso.");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao apagar tabela.", e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    public void inserir(String nome, String email) {
        String sql = "INSERT INTO minhatable (NOME, EMAIL) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.executeUpdate();
            System.out.println("dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.close(this.connection, this.stmt);
        }
    }

    public void buscarPorId(int id) {
        String sql = "SELECT * FROM minhatable WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                int idBuscado = resultSet.getInt("ID");
                String nomeBuscado = resultSet.getString("NOME");
                String emailBuscado = resultSet.getString("EMAIL");
                System.out.println("o Resultado da busca é id " + idBuscado + " nome " +

                        nomeBuscado + " email " + emailBuscado);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }

    }
}