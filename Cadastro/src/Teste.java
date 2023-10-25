import java.sql.Connection;
import java.sql.SQLException;


public class Teste {
  public static void main(String[] args) throws SQLException {
      Connection conexao = new FabricaDeConexao().getConexao();
      System.out.println("Conexão aberta!");
      conexao.close();
      
  }

}