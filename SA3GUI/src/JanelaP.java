import javax.swing.*;
import java.awt.*;

public class JanelaP extends JFrame {
    public JanelaP() {
        super("Projeto");

        this.add(new JanelaAbas());
        

        
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.pack();
    }
}
