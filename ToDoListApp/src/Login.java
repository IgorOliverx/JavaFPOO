import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Login extends JFrame {

    //instancia de objetos 
    ImageIcon imgC = new ImageIcon(getClass().getResource("resources/verificar.png"));
    ImageIcon imgLogin = new ImageIcon(getClass().getResource("resources/login.png"));
   
    
    private JPanel mainPanel;
    private JLabel usernameLabel;
    private JButton loginButton;
    private JTextField usernameField;
    private String username;
    private JLabel labelLogin;
    
    
    public Login() {
        super("Página de início");

        // Definindo o JFrame 'TodoList' como false
        JFrame TodoList = new TodoList(username);
        TodoList.setVisible(false);
        
        //instanciando classe de metodos
        MetodosTask metodosTask = new MetodosTask(this);

        // Criando e definindo os componentes ao Frame
        mainPanel = new JPanel();
        //mainPanel.setPreferredSize(d);
        mainPanel.setLayout(new GridBagLayout()); // set do layout -> GridBag
        usernameLabel = new JLabel("Nome de Usuário");
        usernameField = new JTextField(40); // definindo o tamanho do TextField
        loginButton = new JButton("Login");
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelLogin = new JLabel(imgLogin);

        this.add(mainPanel);

        // Criando um GridBagConstraints para centralizar os componentes do Panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               metodosTask.fazerLogin();
            }
        });

        usernameField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    metodosTask.fazerLogin();
                }
            }
        });

        // Estilizando e adicionando os componentes ao Panel
        mainPanel.setBackground(new Color(70, 130, 180));
       
        // Adicionando os componentes ao painel com GridBagConstraints para posicioná-los
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1; // redefine a largura da img
        mainPanel.add(labelLogin, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        mainPanel.add(usernameLabel, gbc);

        gbc.gridy = 2;
        mainPanel.add(usernameField, gbc);

        gbc.gridy = 3;
        mainPanel.add(loginButton, gbc);

        // set do frame
        this.setSize(453, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //metodos especiais
      public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
    
    public JTextField getUsernameField() {
        return usernameField;
    }

   


}
