import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Ex005 extends JFrame {
     int cont = 0;

    public Ex005() {
        super("Quiz Palestra Itália");
        // adicionando um Painel principal ao frame e dando o card lyout
        JPanel painelMain = new JPanel();// metafora "caixa do baralho"
        CardLayout cl = new CardLayout();
        // definindo o layout do painelMain
        painelMain.setLayout(cl);
        this.add(painelMain);

        // Card 1 Início Game
        JPanel card1 = new JPanel();
        JPanel sub = new JPanel();
        sub.setLayout(new BorderLayout());
        card1.add(sub);

        sub.setBorder(new EmptyBorder(20,10,20,10));
        JLabel titulo = new JLabel("Bem-Vindo ao QUIZZMEIRAS");
        titulo.setBorder(new EmptyBorder(0,10,20,10));
        Font fonte = new Font("arial", Font.BOLD, 14);
        titulo.setFont(fonte);

     
        JButton btn1 = new JButton("Iniciar");
        btn1.setBackground(Color.GREEN);
        btn1.setForeground(Color.WHITE);

       sub.add(titulo, BorderLayout.NORTH);
       sub.add(btn1, BorderLayout.CENTER);

    

        painelMain.add(card1, "Home");
        btn1.addActionListener(e -> {
            // troca do card
            cl.show(painelMain, btn1.getText());

        });

        // Card 2 login
        JPanel card2 = new JPanel();
        card2.add(new JLabel("Em que ano foi fundado o PALESTRA ITÁLIA?"));// Pagina de login
        JButton btn2 = new JButton("1914");
        JButton btn3 = new JButton("1911");
        JButton btn4 = new JButton("1912");
        JButton btn5 = new JButton("1915");
        card2.add(btn2);// resposta correta
        card2.add(btn3);
        card2.add(btn4);
        card2.add(btn5);
        painelMain.add(card2, "Iniciar");

        // tratamento de eventos
        btn2.addActionListener(e -> {
            // troca do card
            cl.show(painelMain, btn2.getText());
            cont +=1;

        });

        // Card 3
        JPanel card3 = new JPanel();
        card3.add(new JLabel("Ano que o PALMEIRAS ganhou a 1° Libertadores?"));// Pagina de login
        JButton btn6 = new JButton("1995");
        JButton btn7 = new JButton("1998");
        JButton btn8 = new JButton("1999");
        JButton btn9 = new JButton("2021");
        card3.add(btn6);
        card3.add(btn7);
        card3.add(btn8);// resposta correta
        card3.add(btn9);
        painelMain.add(card3, "1914");
        btn8.addActionListener(e -> {
            cl.show(painelMain, btn8.getText());
            cont +=1;
        });
        



         // Card 4
        JPanel card4 = new JPanel();
        card4.add(new JLabel("Ano que o PALMEIRAS ganhou a 1° CDB?"));// Pagina de login
        JButton btn10 = new JButton("1998");
        JButton btn11 = new JButton("1992");
        JButton btn12 = new JButton("1991");
        JButton btn13 = new JButton("2020");
        card4.add(btn10);// resposta correta
        card4.add(btn11);
        card4.add(btn12);
        card4.add(btn13);
        painelMain.add(card4, "1999");
        btn10.addActionListener(e -> {
            cl.show(painelMain, btn10.getText());
            cont+=1;
        });
       



          // Card 5
        JPanel card5 = new JPanel();
        card5.add(new JLabel("PALMEIRAS 6X1 boca JUnior?"));// Pagina de login
        JButton btn14 = new JButton("1994");
        JButton btn15 = new JButton("1997");
        JButton btn16 = new JButton("1990");
        JButton btn17 = new JButton("2001");
        card5.add(btn14);// resposta correta
        card5.add(btn15);
        card5.add(btn16);
        card5.add(btn17);
        System.out.println(cont);
        painelMain.add(card5, "1998");
        btn14.addActionListener(e -> {

            cl.show(painelMain, btn14.getText());
            cont+=1;
        });
       

        
        // Card 6
        JPanel card6 = new JPanel();
        card6.add(new JLabel("PALMEIRAS 4x0 COR PAULISTÃO"));// Pagina de login
        MeuBotao btn18 = new MeuBotao("1985");
        JButton btn19 = new JButton("1987");
        JButton btn20 = new JButton("1988");
        JButton btn21 = new JButton("1993");
        card6.add(btn18);
        card6.add(btn19);
        card6.add(btn20);
        card6.add(btn21);// resposta correta
        painelMain.add(card6, "1994");
        btn21.addActionListener(e -> {

            cl.show(painelMain, btn21.getText());
            cont+=1;
                 System.out.println(cont);
        });
       

           // Card 7
        JPanel card7 = new JPanel();
        card7.add(new JLabel("PARABÉNS PALMEIRENSE"));// Pagina de login
        painelMain.add(card7, "1993");

     


        // set do frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ao fechar a tela fecha jvm
        this.setBounds(EXIT_ON_CLOSE, ABORT, 300, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public class MeuBotao extends JButton {
        public MeuBotao(String text) {
            super();
            Color gainsboro = new Color(245, 245, 245);
            setBackground(gainsboro);
            setForeground(Color.BLACK);
            setText(text);
        }
    }

    // criei um metodo para instanciar a classe acima e assim poder criar botoes com
    // as config pré=definidas
    private void criarBotao(String text) {
        MeuBotao btn = new MeuBotao(text);
        add(btn);
    }
}
