package JDBCTeste.src;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class App {
    public static void main(String[] args) throws Exception {
        try{
            Statement s;
            String usuario = "postgres";
            String senha = "postgres";
            String url = "jdbc:postgresql://localhost:5432/postgres";

            Connection c = DriverManager.getConnection(url, usuario, senha);
            s = c.createStatement();
            s.executeQuery("INSERT INTO contato VALUES ('2', 'Raphael veiga', 'veiguinha23Manguito@gmail.com');");

            c.close();
        }catch(Exception e){
            System.out.println("\n" + e);
        }
    }
}
