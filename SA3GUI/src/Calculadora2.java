import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calculadora2 extends JPanel implements ActionListener {
    private JTextField display;
    private double valor1, valor2;
    private char operacao; // char (1 caractere)

    public Calculadora2() {
        setLayout(new BorderLayout());
        display = new JTextField();
        display.setEditable(false); // impossibilita o user de alterar o valor do display
        display.setPreferredSize(new Dimension(100, 50)); // redimensiona o display
        add(display, BorderLayout.NORTH);

        JPanel botoesPainel = new JPanel();
        botoesPainel.setLayout(new GridLayout(5, 4));

        // array de botões
        String[] botoes = {
                "log", "rad", "CE", "C",
                "7", "8", "9", "+",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                ".", "0", "/", "="
        };

        // iteração que adiciona um ouvinte de evento a todos os botoes => laço foreach que atribui os textos a botoes
        for (String text : botoes) {
            JButton button = new JButton(text);
            button.addActionListener(this);
            botoesPainel.add(button);



            // cores dos botões
            if (text.equals("C") || text.equals("CE")) {
                button.setBackground(Color.RED);
            } else if (text.equals("=")) {
                button.setBackground(Color.BLUE);
                button.setForeground(Color.WHITE);
            } else {
                button.setBackground(Color.WHITE);
            }
        }

        add(botoesPainel, BorderLayout.CENTER);
    }

    // adicionando ouvintes aos botões - STACKOVER FLOW e GITHUB :)
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        try {
            // add o botao ao display caso o msm seja um numero e um ponto decimal
            if (Character.isDigit(comando.charAt(0)) || comando.equals(".")) {
                display.setText(display.getText() + comando); //concatena os textos
            } else if ("+-*/".contains(comando)) {
                // add o botão se for um operador - armazena o valor atual do display como
                // valor1 e o operador.
                valor1 = Double.parseDouble(display.getText());
                operacao = comando.charAt(0);
                display.setText("");
                // se o botao clicado for "=" ele calcula oriundo da operação escolhida
            } else if (comando.equals("=")) {
                valor2 = Double.parseDouble(display.getText());
                double resultado = calcular();
                display.setText(String.valueOf(resultado));
            } else if (comando.equals("C")) {
                // Limpa o display
                display.setText("");
            } else if (comando.equals("CE")) {
                // Limpa o último caractere do display

                String txtAtual = display.getText(); // armazena o que esta no display na variavel txtAtual
                if (!txtAtual.isEmpty()) { // verifica primeiramente se o display nao esta vazio
                    txtAtual = txtAtual.substring(0, txtAtual.length() - 1); // percorre os caracteres escritos(lenght)
                  // e o substring tem a capacidade de contar as letras como indices => - 1 remove o ultimo indice
                    display.setText(txtAtual);
                }
            }
            // tratamento de erro
        } catch (NumberFormatException ex) {
            display.setText("Erro");
        }
    }

    // Método para realizar as operações
    private double calcular() {
        switch (operacao) {
            case '+':
                return valor1 + valor2;
            case '-':
                return valor1 - valor2;
            case '*':
                return valor1 * valor2;
            case '/':
                if (valor2 != 0) {
                    return valor1 / valor2;
                } else {
                    return Double.POSITIVE_INFINITY; // números absurdamente grandes
                }
            default:
                return 0;
        }
    }

}
