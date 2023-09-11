import javax.swing.*;
import java.awt.*;

public class Calculadora1 extends JPanel {
    public Calculadora1() {
        super();
       // this.add(new JLabel("Calculadora"));

       JPanel painelMain = new JPanel();
       this.add(painelMain);
       FlowLayout flow = new FlowLayout();
       painelMain.setLayout(flow);



       
       
       JPanel painel = new JPanel();
       this.add(painel);
       GridLayout grid = new GridLayout(7, 4);
       this.setPreferredSize(new Dimension(400, 440));
       painel.setLayout(grid);
       
       
               JTextField txt = new JTextField();
                painel.add(txt);
             //  txt.setPreferredSize(new Dimension(400, 30));
               txt.setText("Resultado");
            
     




        //Criando botoes da primeira row
        painel.add(new MeuBotao("%"));
        painel.add(new MeuBotao("CE"));
        painel.add(new MeuBotao("C"));
        JButton btnX = new JButton();
        painel.add(btnX);
        btnX.setBackground(Color.RED);
        btnX.setText("\u21FD");

        //Criando botoes da segunda row
        painel.add(new MeuBotao("\u03C0"));
        painel.add(new MeuBotao("\u2211"));
        painel.add(new MeuBotao("\u221A"));
        painel.add(new MeuBotao("\u00F7"));

  
     

        //Criando botoes da terceira row
        for (int i = 7; i < 10; i++) {
           JButton btn0 = new JButton();
            painel.add(btn0);
            btn0.setBackground(Color.WHITE);
            btn0.setText("" + i);
        }
       painel.add(new MeuBotao("X"));

        for (int i = 4; i < 7; i++) {
           JButton btn0 = new JButton();
            painel.add(btn0);
            btn0.setBackground(Color.WHITE);
            btn0.setText("" + i);
        }

         painel.add(new MeuBotao("-"));

        for (int i = 1; i < 4; i++) {
            JButton btn0 = new JButton();
            painel.add(btn0);
            btn0.setBackground(Color.WHITE);
            btn0.setText("" + i);
        }

        painel.add(new MeuBotao("\u271A"));
        painel.add(new MeuBotao("\u00B1"));
        JButton btn0 = new JButton();
        painel.add(btn0);
        btn0.setBackground(Color.WHITE);
        btn0.setText("0");
       painel.add(new MeuBotao(","));

        JButton btn = new JButton();
        painel.add(btn);
        btn.setBackground(Color.BLUE);
        btn.setForeground(Color.WHITE);
        btn.setText("=");

        // set do frame
        this.setVisible(true);

    
   

        
        


        
    }

    public class MeuBotao extends JButton {
        public MeuBotao(String text) {
            super();
            Color gainsboro = new Color(245,245,245);
            setBackground(gainsboro);
            setForeground(Color.BLACK);
            setText(text);
        }
    }

    private void criarBotao(String text) {
        MeuBotao btn = new MeuBotao(text);
        add(btn);
    }
}
