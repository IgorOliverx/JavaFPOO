import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.*;

public class Detalhes extends JFrame {
    TodoList todoList = new TodoList(getName());

    Dimension d = new Dimension(300, 150);

    public Detalhes() {
        super();
       JPanel painelMain = new JPanel(new BorderLayout());
       this.add(painelMain, BorderLayout.CENTER);
       JPanel painelSul = new JPanel(new FlowLayout());
       this.add(painelSul, BorderLayout.SOUTH);
       painelSul.add(new JButton("Salvar e sair"));
       painelSul.add(new JButton("Fechar") );
       painelMain.add(new JTextField());
       painelMain.setSize(200, 100);
    
  
 
    //set Frame
    
    
    this.setSize(300,400);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);


    }
public static void main(String[] args) {
    new Detalhes();
}
}
