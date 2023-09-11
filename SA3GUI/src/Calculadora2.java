import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora2 extends JFrame {
    private JTextField texto;
    private double numero1 = 0;
    private String operacao = "";
    private boolean novaOperacao = true;
    private JPanel painel;

    public Calculadora2() {
        super("Calculadora Padrão");

        BorderLayout border = new BorderLayout();
        this.setLayout(border);

        painel = new JPanel();
        JPanel painel2 = new JPanel();
        JPanel painel3 = new JPanel();

        this.add(painel3, BorderLayout.SOUTH);
        this.add(painel, BorderLayout.CENTER);
        this.add(painel2, BorderLayout.NORTH);

        this.setBounds(300, 300, 300, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        GridLayout grid = new GridLayout(4, 4);
        FlowLayout flow = new FlowLayout();

        painel.setLayout(grid);
        painel2.setLayout(flow);
        painel3.setLayout(flow);

        // Criar botões de números
        String valoresM[] = { "4", "5", "6" };
        for (int i = 0; i < valoresM.length; i++) {
            painel.add(new JButton(valoresM[i]));
        }

        JButton menos = new JButton("-");
        painel.add(menos);
        Color seilam = new Color(220, 220, 220);
        menos.setBackground(seilam);

        String valoresMa[] = { "3", "2", "1" };
        for (int i = 0; i < valoresMa.length; i++) {
            painel.add(new JButton(valoresMa[i]));
        }

        JButton mais = new JButton("+");
        painel.add(mais);
        Color seilamais = new Color(220, 220, 220);
        mais.setBackground(seilamais);

        JButton maismenos = new JButton("+/-");
        painel.add(maismenos);

        JButton ponto = new JButton(".");
        painel.add(ponto);

        JButton apagar = new JButton("C");
        painel.add(apagar);
        Color apaagar = new Color(178, 34, 34);
        apagar.setBackground(apaagar);

        JButton div = new JButton("/");
        painel.add(div);
        Color seiladiv = new Color(220, 220, 220);
        div.setBackground(seiladiv);

        JButton igual = new JButton("=");
        painel3.add(igual);
        igual.setPreferredSize(new Dimension(250, 50));

        // Adicionar ActionListener para os botões de números e operações
        addActionListeners(); // Adicione esta linha

        this.setVisible(true);
    }

    private void addActionListeners() {
        // Botões de números
        for (int i = 0; i < 10; i++) {
            String numero = String.valueOf(i);
            JButton botaoNumero = new JButton(numero);
            botaoNumero.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (novaOperacao) {
                        texto.setText(numero);
                        novaOperacao = false;
                    } else {
                        texto.setText(texto.getText() + numero);
                    }
                }
            });
            painel.add(botaoNumero);
        }

        // Botões de operações
JButton botaoSoma = new JButton("+");
botaoSoma.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        realizarOperacao();
        operacao = "+";
    }
});
painel.add(botaoSoma);

JButton botaoSubtracao = new JButton("-");
botaoSubtracao.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        realizarOperacao();
        operacao = "-";
    }
});
painel.add(botaoSubtracao);

JButton botaoMultiplicacao = new JButton("x");
botaoMultiplicacao.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        realizarOperacao();
        operacao = "x";
    }
});
painel.add(botaoMultiplicacao);

JButton botaoDivisao = new JButton("/");
botaoDivisao.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        realizarOperacao();
        operacao = "/";
    }
});
painel.add(botaoDivisao);

    }

   // Resto do código permanece o mesmo...

private void realizarOperacao() {
    if (operacao != null && !operacao.isEmpty()) {
        double numero2 = Double.parseDouble(texto.getText());
        switch (operacao) {
            case "+":
                numero1 += numero2;
                break;
            case "-":
                numero1 -= numero2;
                break;
            case "x":
                numero1 *= numero2;
                break;
            case "/":
                if (numero2 != 0) {
                    numero1 /= numero2;
                } else {
                    JOptionPane.showMessageDialog(this, "Erro: Divisão por zero", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                break;
        }
        texto.setText(String.valueOf(numero1));
    } else {
        numero1 = Double.parseDouble(texto.getText());
    }
    novaOperacao = true;
}

// Resto do código permanece o mesmo...


  

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculadora2());
    }
}
