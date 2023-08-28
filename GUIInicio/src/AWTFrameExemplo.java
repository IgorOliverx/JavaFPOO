import java.awt.Frame;

import javax.swing.JOptionPane;



public class AWTFrameExemplo extends Frame {



    public AWTFrameExemplo() {
        super("Minha primeira janela AWT");
        this.setSize(500, 500); 
        this.setVisible(true);
        this.setResizable(false);
    }

    
    
}
