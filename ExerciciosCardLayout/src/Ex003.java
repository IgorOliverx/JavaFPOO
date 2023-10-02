import java.awt.*;
import javax.swing.*;

public class Ex003 extends JFrame{
    //construtor
    public Ex003() {
        super("Exercicio - 3_CARD LAYOUT");
        //adicionando um Painel principal ao frame e dando o card lyout
        JPanel painelMain = new JPanel();//metafora "caixa do baralho"
        CardLayout cl = new CardLayout();
        //definindo o layout do painelMain
        painelMain.setLayout(cl);
        this.add(painelMain);

        //Card 1 home
        JPanel card1 = new JPanel( );
        card1.add(new JLabel("Página de boas vindas"));//mensagem de boas vindas
        JButton btn1 = new JButton("Login");
        JButton btn2 = new JButton("Cadastro");
        card1.add(btn1);
        card1.add(btn2);
        painelMain.add(card1, "Home");



          //Card 2 login
        JPanel card2 = new JPanel( );
        card1.add(new JLabel("Página de login"));//Pagina de login
        JButton btn3 = new JButton("Home");
        JButton btn4 = new JButton("Cadastro");
        card2.add(btn3);
        card2.add(btn4);
        painelMain.add(card2, "Login");

        //Card 2 login
        JPanel card3 = new JPanel( );
        card1.add(new JLabel("Página de Cadastro"));//Pagina de cadastro
        JButton btn5 = new JButton("Home");
        JButton btn6 = new JButton("Login");
        card2.add(btn5);
        card2.add(btn6);
        painelMain.add(card3, "Cadastro");


        //set do frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ao fechar a tela fecha jvm
        this.setBounds(EXIT_ON_CLOSE, ABORT, 300, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);


        
        
    }


}