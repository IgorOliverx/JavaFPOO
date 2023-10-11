import javax.swing.*;
import java.awt.*;

public class Relogio extends JFrame {
    JPanel mainPanel;
    JLabel title;
    JPanel timer;

    // Construtor
    public Relogio () {
        super("Teste");

        // Criando e adionando os componenetes ao Frame
        mainPanel = new JPanel(new BorderLayout());
        title = new JLabel("Timer");
        timer = new JPanel();

        this.add(mainPanel);
        this.add((timer), BorderLayout.CENTER);
        this.add((title), BorderLayout.NORTH);


    }
}
