import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {
  private static final String user = "root";
  private static final String password = "SENHA";
  private static final String url = "jdbc:mysql://localhost:3306/DB";
  private static Connection con = null;

  public static Connection getConexao() {

      try {

          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection(url, user, password);
          return con;

      } catch (Exception e) {
          System.out.println(e.getMessage());
          return null;
      }
  }

  public static void fechar() throws SQLException {
      if (con != null) {
          con.close();

      }
  }

}