package ExceptionTryCatch;

import javax.swing.JOptionPane;

public class ExemploTryCatchFinally {
    public static void main(String[] args) {
        // exemplo de try catch e finally

        String fraseInicial = null;
        String fraseFinal = null;

        fraseInicial = JOptionPane.showInputDialog(null, "Digite uma frase:");

        if (fraseInicial.equals("")) {
            fraseInicial = null;
        }
        try { 
            fraseFinal = fraseInicial.toUpperCase();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), fraseFinal, 0);
            fraseFinal = "Não foi digitado uma frase";

        } finally {
            JOptionPane.showMessageDialog(null, fraseFinal);

        }
    }
}
