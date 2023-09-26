import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex003 extends JFrame{
    public Ex003() {
        super("Exercício 1 - Sem gambiarra");
        //criando um painel principal
        JPanel painelMain = new JPanel();
        //layout do painel- cardlayout
        CardLayout cl = new CardLayout();
        painelMain.setLayout(cl);
        //criar os cards para adicionar o painelMain
        JPanel card1 = new JPanel();
        card1.add(new JLabel("Tela de início"));
        card1.add(new JLabel("Bem-vindo!"));
        

        JPanel card2 = new JPanel();
        card2.add(new JLabel("Login"));

        JPanel card3 = new JPanel();
        card3.add(new JLabel("Cadastro"));


        //botoes
        JButton botaoNext = new JButton("Próximo");
        card1.add(botaoNext);
        JButton botaoNext2 = new JButton("Próximo");
        card2.add(botaoNext2);
        JButton botaoNext3 = new JButton("Próximo");
        card3.add(botaoNext3);
        //adicionando cads ao  painelMain
        painelMain.add(card1);
        painelMain.add(card2);
        painelMain.add(card3);
        //set do frame
        this.add(painelMain);
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);

        //criando actionlisterener para o botao
        botaoNext.addActionListener(e ->{
            cl.next(painelMain);
        });
        botaoNext2.addActionListener(e ->{
            cl.next(painelMain);
        });
        botaoNext3.addActionListener(e ->{
            cl.next(painelMain);
        });






    }
}
