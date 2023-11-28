package com.example;

import com.example.Controller.LoginController;
import com.example.VIew.JanelaPrincipal;
import com.example.VIew.LoginPainel;

public class Main {
    public static void main(String[] args) {
    
      LoginPainel loginView = new LoginPainel();//criando um objeto da pagina de login
      LoginController loginController = new LoginController(loginView);//iniciando a pagina de login a partir do controller
   }
 
    
}