/**
 * teste
 */

 import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Teste extends JFrame {
    ImageIcon imagem = new ImageIcon(getClass().getResource("1.png"));
    JLabel label = new JLabel(imagem);
    

    public Teste() {
        super();

        this.add(label);

        setSize(500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Teste();
    }
}


