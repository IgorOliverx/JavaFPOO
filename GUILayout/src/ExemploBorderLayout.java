import javax.swing.*;
import java.awt.*;

public class ExemploBorderLayout extends JFrame{
    public ExemploBorderLayout (){ 
        super();
        //adicionar o painel e definir o layout
        JPanel painel = new JPanel(new BorderLayout());
        this.add(painel);

        //adicionar componentes nas 5 posições 
        painel.add(new JButton("South"), BorderLayout.SOUTH);
        painel.add(new JTextArea("North", 5, 25), BorderLayout.NORTH);
        painel.add(new JButton("Center"), BorderLayout.CENTER);
        painel.add(new JButton("West"), BorderLayout.WEST);
        painel.add(new JButton("East"), BorderLayout.EAST);
     


          //set do frame
          this.setDefaultCloseOperation(EXIT_ON_CLOSE);
          this.pack(); // compactação do painel
          this.setVisible(true);

    }
}
