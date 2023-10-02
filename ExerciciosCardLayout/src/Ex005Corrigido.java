import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Ex005Corrigido extends JFrame{
    public Ex005Corrigido() {
        super("Exercicio 5 - JOGO QUIZ");
        CardLayout cl = new CardLayout();
        JPanel painelMain = new JPanel(cl);//set do layout na instancia do objeto
        this.add(painelMain);




        JPanel card1 = new JPanel();
        card1.add(new JLabel("Quem ganhou a copa de 74?"));
        JButton but1 = new JButton("Start");
        card1.add(but1);
        painelMain.add(card1, "Start");


        JPanel card2 = new JPanel();
        card2.add(new JLabel("Quem ganhou a copa de 10?"));
        JButton but2 = new JButton("Start");
        card1.add(but2);
        painelMain.add(card2, "P1");



    }
    
}
