package com.example;



import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) throws Exception {
        try{
            Statement s;
            String usuario = "postgres";
            String senha = "postgres";
            String url = "jdbc:postgresql://localhost:5432/postgres";

            Connection c = DriverManager.getConnection(url, usuario, senha);
            s = c.createStatement();
            s.executeQuery("SELECT * FROM public.contato INSERT INTO contato VALUES ('1', 'Igor', 'iguito@gmail.com');");

            c.close();
        }catch(Exception e){
            System.out.println("\n" + e);
        }
    }
}
