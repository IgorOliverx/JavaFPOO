import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex001 {
    JPanel cards;
    private String buttonPainel1 = "Card 1";
    private String buttonPainel2 = "Card 2";
    private String buttonPainel3 = "Card 3"; 
    JPanel card1 = new JPanel();
    JPanel card2 = new JPanel();
    JPanel card3 = new JPanel();

    public Ex001() {
        JFrame jframe = new JFrame();
        JPanel jpanel1 = new JPanel();
        String comboBoxItems[] = { buttonPainel1, buttonPainel2, buttonPainel3 };
        // Criando os Cards

        //CARD 1
        //Componentes card 1 
        JButton prox1 = new JButton("Próximo");
        card1.add(prox1);
        JLabel label1 = new JLabel("Card 1");
        card1.add(label1);
        prox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card1.setVisible(false);
                card2.setVisible(true);
    }
        });






        //CARD 2
        //Componentes cards 2
        JButton prox2 = new JButton("Próximo");
        prox2.addActionListener(new ActionListener() {
            @Override
             public void actionPerformed(ActionEvent e) {
                card2.setVisible(false);
                card3.setVisible(true);
    }
        });
        card2.add(prox2);
        JButton anterior2 = new JButton("Anterior");
         anterior2.addActionListener(new ActionListener() {
            @Override
             public void actionPerformed(ActionEvent e) {
                card2.setVisible(false);
                card1.setVisible(true);
    }
        });
        card2.add(anterior2);
        JLabel label2 = new JLabel("Card 2");
        card2.add(label2);

        //CARD 3 
       //componentes cards 3
         JButton prox3 = new JButton("Próximo");
          prox3.addActionListener(new ActionListener() {
            @Override
             public void actionPerformed(ActionEvent e) {
                card3.setVisible(false);
                card1.setVisible(true);
    }
        });
        card3.add(prox3);
        JButton anterior3 = new JButton("Anterior");
         anterior3.addActionListener(new ActionListener() {
            @Override
             public void actionPerformed(ActionEvent e) {
                card2.setVisible(true);
                card3.setVisible(false);
    }
        });
        card3.add(anterior3);
        JLabel label3 = new JLabel("Card 3");
        card3.add(label3);

        // Adicionando Cards a um CardsLayout
        cards = new JPanel(new CardLayout());
        cards.add(card1, buttonPainel1);
        cards.add(card2, buttonPainel2);
        cards.add(card3, buttonPainel3);
        jframe.add(jpanel1, BorderLayout.PAGE_START);
        jframe.add(cards, BorderLayout.CENTER);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setBounds(100, 100, 300, 300);
        jframe.setVisible(true);
    }

   

}