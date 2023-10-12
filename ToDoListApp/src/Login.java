import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JPanel mainPanel;
    private JLabel usernameLabel;
    private JButton loginButton;
    private JTextField usernameField;
    private String username;
    Dimension d  = new Dimension(600,450);
    
    public Login() {
        super("Página de início");
        this.setPreferredSize(d);
        
        // Definindo o JFrame 'TodoList' como false
        JFrame TodoList = new TodoList(username);
        TodoList.setVisible(false);
        
        // Criando e definindo os componentes ao Frame

        

        mainPanel = new JPanel();
        //mainPanel.setPreferredSize(d);
        mainPanel.setLayout(new GridBagLayout()); // set do layout -> GridBag
        usernameLabel = new JLabel("Nome de Usuário");
        usernameField = new JTextField(20); // definindo o tamanho do TextField
        loginButton = new JButton("Login");

        this.add(mainPanel);

        // Criando um GridBagConstraints para centralizar os componentes do Panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username = usernameField.getText();
                if(username.length() > 2){
                JFrame TodoList = new TodoList(username);
                TodoList.setVisible(true);
                dispose(); // Oculta o frame atual
                }else{
                JOptionPane.showMessageDialog(null,"Insira seu nome corretamente");
                }
            }
        });

        // Estilizando e adicionando os componentes ao Panel
        mainPanel.setBackground(new Color(70, 130, 180));
       
        // Adicionando os componentes ao painel com GridBagConstraints para deixá-los
        // centtrtalizados
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(usernameLabel, gbc);
        gbc.gridy = 1;
        mainPanel.add(usernameField, gbc);
        gbc.gridy = 2;
        mainPanel.add(loginButton, gbc);

        // set do frame
        this.setSize(300, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
