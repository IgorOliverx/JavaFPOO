import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex001 extends JFrame {
    JPanel cards;
    private String buttonPanel = "Card com JButtons";
    private String textPanel = "Card com JTextField";
    public Ex001() {

        JFrame frameMain = new JFrame();
        JPanel jpanel1 = new JPanel();
        String comboBoxItems[] = { buttonPanel, buttonPanel, buttonPanel };
        JComboBox cb = new JComboBox(comboBoxItems);
        jpanel1.add(cb);


        //CARD 1
        JPanel card1 = new JPanel();
        card1.add(new JButton("Botão UP1"));
        card1.add(new JButton("Botão DOWN1"));

        //CARD 2
        JPanel card2 = new JPanel();
        card2.add(new JButton("Botão UP2"));
        card2.add(new JButton("Botão DOWN2"));
         
        //CARD 3
        JPanel card3 = new JPanel();
        card3.add(new JButton("Botão UP3"));
        card3.add(new JButton("Botão DOWN3"));
        
        cards = new JPanel(new CardLayout());
        cards.add(card1, buttonPanel);
        cards.add(card2, buttonPanel);
        cards.add(card3, buttonPanel);
   
       
        frameMain.add(jpanel1, BorderLayout.PAGE_START);
        frameMain.add(cards, BorderLayout.CENTER);
        frameMain.setDefaultCloseOperation(frameMain.EXIT_ON_CLOSE);
        frameMain.setBounds(100, 100, 300, 300);
        frameMain.setVisible(true);
        Handler handler = new Handler();
        cb.addItemListener(handler);
    }

    public class Handler implements ItemListener {
        public void itemStateChanged(ItemEvent event) {
            CardLayout cl = (CardLayout) (cards.getLayout());
            cl.show(cards, (String) event.getItem());
        }
    }


      
}
