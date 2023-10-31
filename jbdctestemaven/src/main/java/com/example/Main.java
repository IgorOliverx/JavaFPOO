package jbdctestemaven.src.main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    private String id;
     public static void main(String[] args) throws Exception {
        try{
            Statement s;
            String usuario = "postgres";
            String senha = "postgres";
            String url = "jdbc:postgresql://localhost:5432/postgres";

            Connection c = DriverManager.getConnection(url, usuario, senha);
            s = c.createStatement();


            System.out.println("Insira um Id:");
            Scanner sc = new Scanner (System.in);
            String  id = sc.next();


            
            s.executeQuery("INSERT INTO contato VALUES('', 'DIOGO', 'SFSDS')");
            
            c.close();
        }catch(Exception e){
            System.out.println("\n" + e);
        }
    }
}
