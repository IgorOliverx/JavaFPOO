package com.example.VIew;



import com.example.Connection.LoginDAO;
import com.example.Controller.LoginController;

/**
 *
 * @author Igor
 */

public class LoginPainel extends javax.swing.JFrame {


    public LoginPainel() {
        super("Concessionária EndrickMotors");
        setVisible(true);
        initComponents();
        setSize(400,400);
        setLocationRelativeTo(null);
        setResizable(false);
    }

  
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jFormattedTextFieldUsuario = new javax.swing.JFormattedTextField();
        jFormattedTextFieldSenha = new javax.swing.JPasswordField();
        labelUsuario = new javax.swing.JLabel();
        labelSenha = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/example/View/imagens/login.jpg"))); // NOI18N

        //setToolTipText("");
        setMinimumSize(new java.awt.Dimension(500, 300));
        setLayout(null);

        jFormattedTextFieldUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldUsuarioActionPerformed(evt);
            }
        });
        add(jFormattedTextFieldUsuario);
        jFormattedTextFieldUsuario.setBounds(300, 140, 137, 22);

        jFormattedTextFieldSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldSenhaActionPerformed(evt);
            }
        });
        add(jFormattedTextFieldSenha);
        jFormattedTextFieldSenha.setBounds(300, 200, 137, 22);

        labelUsuario.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        labelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        labelUsuario.setText("Usuário");
        add(labelUsuario);
        labelUsuario.setBounds(300, 110, 100, 30);

        labelSenha.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        labelSenha.setForeground(new java.awt.Color(255, 255, 255));
        labelSenha.setText("Senha");
        add(labelSenha);
        labelSenha.setBounds(300, 170, 60, 26);

        btnEntrar.setText("Entrar");

        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
                System.out.println("Imprimindo botao - a ação esta funcionando");
            }
        });
        add(btnEntrar);
        btnEntrar.setBounds(370, 270, 72, 23);

        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
                System.out.println('s');
            }
        });
        btnSair.setText("Sair");
        add(btnSair);
        btnSair.setBounds(260, 270, 72, 23);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/example/View/imagens/img.png"))); // NOI18N
        add(jLabel4);
        jLabel4.setBounds(0, 0, 500, 370);

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Usuário");
        add(jLabel5);
        jLabel5.setBounds(300, 120, 90, 26);

        new LoginDAO().inicializarBanco();  
    }

    

    private void jFormattedTextFieldUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldUsuarioActionPerformed
    
    }

    private void jFormattedTextFieldSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldSenhaActionPerformed
    }

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        LoginController operacao = new LoginController();
        String usuario = jFormattedTextFieldUsuario.getText();
        String senha = jFormattedTextFieldSenha.getText();
        
        operacao.verificaLogin(usuario, senha);

        System.out.println(usuario);
        System.out.println(senha);
       
    }

   private void btnSairActionPerformed(java.awt.event.ActionEvent evt){
    dispose();
   }


    public javax.swing.JFormattedTextField getjFormattedTextFieldUsuario() {
        return jFormattedTextFieldUsuario;
    }

    public javax.swing.JPasswordField getjFormattedTextFieldSenha() {
        return jFormattedTextFieldSenha;
    }


    //Atributos da aplicação(padrões do netbeans)
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnSair;
    private javax.swing.JFormattedTextField jFormattedTextFieldUsuario;
    private javax.swing.JPasswordField jFormattedTextFieldSenha;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
  
}
