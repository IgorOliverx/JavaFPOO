package com.example.Controller;

import javax.swing.JOptionPane;

import com.example.Connection.CarrosDAO;
import com.example.Connection.ClientesDAO;
import com.example.Connection.LoginDAO;
import com.example.Connection.VendasDAO;
import com.example.VIew.LoginPainel;
import com.example.VIew.JanelaPrincipal;

public class LoginController {
    //criando uma variável de classe como referência(eu quebrei muito a cabeça nisto)
   private LoginPainel loginView;

    public LoginController(LoginPainel loginView) {
        this.loginView = loginView;
    }

    public LoginController() {
        super();
    }


    public void verificaLogin(String usuario, String senha){
        LoginDAO login = new LoginDAO();
        if (usuario == null || "".equals(usuario) || senha == null || "".equals(senha)) {
            JOptionPane.showMessageDialog(null, "Preencha todos os dados corretamente!", "",
                            JOptionPane.WARNING_MESSAGE);
                            } else{
                                boolean loginValido = login.verificarLogin(usuario, senha);

                                if(loginValido){
                                    new JanelaPrincipal().run();
                                    loginView.dispose();//CORRIGIR ISSO
                                   
                                }else{
                                    JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!", "", JOptionPane.WARNING_MESSAGE);
                                }
                            }

        }
  
    }

