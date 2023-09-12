import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora3 extends JPanel {
    private JTextField milhasField;
    private JLabel resultadoLabel;

    public Calculadora3() {

        // adicionando layout ao container
        JPanel painel = new JPanel();
        GroupLayout layout = new GroupLayout(painel);
        painel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel milhasLabel = new JLabel("Milhas:");
        milhasField = new JTextField(10);

        // alterando cor e adicionando ouvinte ao botao de converter
        JButton converterBtn = new JButton("Converter");
        converterBtn.setBackground(Color.BLUE);
        converterBtn.setForeground(Color.WHITE);
        converterBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                converterMilhasKm();
            }
        });

        resultadoLabel = new JLabel("Resultado: ");

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(milhasLabel)
                                .addComponent(resultadoLabel))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(milhasField)
                                .addComponent(converterBtn)));

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(milhasLabel)
                                .addComponent(milhasField))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(resultadoLabel)
                                .addComponent(converterBtn)));

        add(painel);

    }

    private void converterMilhasKm() {
        try {
            double milhas = Double.parseDouble(milhasField.getText());
            double quilometros = milhas * 1.60934;
            resultadoLabel.setText("Resultado: " + String.format("%.2f", quilometros) + " km");
        } catch (NumberFormatException e) {
            resultadoLabel.setText("Digite um número válido de milhas.");
        }
    }

}
