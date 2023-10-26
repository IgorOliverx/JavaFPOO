import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class TelaDeCadastro extends JFrame {
    private JLabel nome;
    private JLabel sobrenome;
    private JLabel endereco;
    private JLabel cpf;
    private JLabel idade;

   private JTextField nomeText;
     private JTextField sobrenomeText;
    private JTextField enderecoText;
    private JTextField cpfText;
    private JTextField idadeText;

    private JButton enviar;

    Statement stmt;


    public TelaDeCadastro() {
        super();

        JPanel painelMain = new JPanel();
        this.add(painelMain);

        //Connection connection = null;

        nome = new JLabel("Nome");
        nomeText = new JTextField();
        nomeText.setColumns(5);
        sobrenome = new JLabel("Sobrenome");
        sobrenomeText = new JTextField();
        sobrenomeText.setColumns(5);
        endereco = new JLabel("Endereço");
        enderecoText = new JTextField();
        enderecoText.setColumns(5);
        cpf = new JLabel("CPF");
        cpfText = new JTextField();
        cpfText.setColumns(5);
        idade = new JLabel("Idade");
        idadeText = new JTextField();
        idadeText.setColumns(5);

        painelMain.add(nome);
        painelMain.add(nomeText);
        painelMain.add(sobrenome);
        painelMain.add(sobrenomeText);
        painelMain.add(endereco);
        painelMain.add(enderecoText);
        painelMain.add(cpf);
        painelMain.add(cpfText);
        painelMain.add(idade);
        painelMain.add(idadeText);
        enviar = new JButton("Enviar");
        painelMain.add(enviar);


        enviar.addActionListener(e->{
            Connection conexao = new FabricaDeConexao().getConexao();
            String sql = "INSERT INTO clientes (nome, sobrenome, endereco, cpf, idade) VALUES(?);";

         

        });
        //set do frame
        this.setVisible(true);
        this.setSize(600, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        painelMain.setVisible(true);
        painelMain.setSize(600, 400);

    }

    public static void main(String[] args) {
        new TelaDeCadastro();
    }
}
