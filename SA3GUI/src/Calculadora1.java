import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public class Calculadora1 extends JPanel {
    public Calculadora1() {
        super();
     

        BorderLayout border = new BorderLayout();
        this.setLayout(border);

        JTextField txt = new JTextField();
        this.add(txt, BorderLayout.NORTH);
        txt.setPreferredSize(new Dimension(100, 50));
        txt.setText("0");

        JPanel painel = new JPanel();
        this.add(painel, BorderLayout.CENTER);
        GridLayout grid = new GridLayout(8, 5);

        painel.setLayout(grid);

     

        // 1° LINHA
        painel.add(new MeuBotao("tan"));
        painel.add(new MeuBotao("cos"));
        painel.add(new MeuBotao("exp"));
        painel.add(new MeuBotao("mod"));
        JButton btnX = new JButton();
        painel.add(btnX);
        btnX.setBackground(Color.RED);
        btnX.setText("\u21FD");

        // 2° LINHA
        painel.add(new MeuBotao("sin"));
        painel.add(new MeuBotao("%"));
        painel.add(new MeuBotao("CE"));
        painel.add(new MeuBotao("C"));
        painel.add(new MeuBotao("n!"));

        // 3° LINHA
        painel.add(new MeuBotao("Deg"));
        painel.add(new MeuBotao("\u03C0"));
        painel.add(new MeuBotao("\u2211"));
        painel.add(new MeuBotao("\u221A"));
        painel.add(new MeuBotao("\u00F7"));

        // 4° LINHA
        painel.add(new MeuBotao("Rad"));
        for (int i = 7; i < 10; i++) {
            JButton btn0 = new JButton();
            painel.add(btn0);
            btn0.setBackground(Color.WHITE);
            btn0.setText("" + i);
        }
        painel.add(new MeuBotao("X"));

        // 5° LINHA
        painel.add(new MeuBotao("lnv"));
        for (int i = 4; i < 7; i++) {
            JButton btn0 = new JButton();
            painel.add(btn0);
            btn0.setBackground(Color.WHITE);
            btn0.setText("" + i);
        }

        painel.add(new MeuBotao("-"));

        // 6° LINHA
        painel.add(new MeuBotao("e"));
        for (int i = 1; i < 4; i++) {
            JButton btn0 = new JButton();
            painel.add(btn0);
            btn0.setBackground(Color.WHITE);
            btn0.setText("" + i);
        }

        // 7° LINHA
        painel.add(new MeuBotao("\u271A"));
        painel.add(new MeuBotao("log"));
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
            Color gainsboro = new Color(245, 245, 245);
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
