package ExceptionTryCatch;

import javax.swing.JOptionPane;
import java.io.*;

public class ExemploTryCatch {
    public static void main(String[] args) {
        int n1, n2;
        boolean ligar = true;

        String[] options = { "Somar", "Subtrair", "Dividir", "Multiplicar" };
        int optionType;
        int messageType;

        var selection = JOptionPane.showOptionDialog(null, "Escolha uma operação aritmética", "Calculadora",
                optionType = 0, messageType = 3, null, options, options[0]);

        if (selection == 0) {
            while (ligar) {
                try {
                    n1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um número inteiro:"));
                    n2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite outro número inteiro:"));
                    JOptionPane.showMessageDialog(null, "O resultado da operação é = " + (n1 + n2));
                    ligar = false;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "ERRO - Valor digitado não é um número inteiro");
                }

            }
        }

        if (selection == 1) {
            while (ligar) {
                try {
                    n1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um número inteiro:"));
                    n2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite outro número inteiro:"));
                    JOptionPane.showMessageDialog(null, "O resultado da operação é = " + (n1 - n2));
                    ligar = false;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "ERRO - Valor digitado não é um número inteiro");
                }

            }
        }

        if (selection == 2) {
            while (ligar) {
                try {
                    n1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um número inteiro:"));
                    n2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite outro número inteiro:"));
                    JOptionPane.showMessageDialog(null, "O resultado da operação é = " + (n1 / n2));
                    ligar = false;
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "ERRO - Valor digitado não é um número inteiro");
            } catch (ArithmeticException e2) {
                JOptionPane.showMessageDialog(null, "ERRO - Não é possível dividir um número por zero '0' ");
            } catch (Exception e3) {
                JOptionPane.showMessageDialog(null, "ERRO - Por favor, tente novamente! ");
            }
        }

        if (selection == 3) {
            while (ligar) {
                try {
                    n1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite um número inteiro:"));
                    n2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite outro número inteiro:"));
                    JOptionPane.showMessageDialog(null, "O resultado da operação é = " + (n1 * n2));
                    ligar = false;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "ERRO - Valor digitado não é um número inteiro");
                }

            }
        }
    }
}
}