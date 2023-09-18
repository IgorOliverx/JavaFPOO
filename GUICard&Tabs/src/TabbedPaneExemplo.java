import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class TabbedPaneExemplo extends JFrame {
    public TabbedPaneExemplo() {
        super();
        JTabbedPane janelaAbas = new JTabbedPane();
        JPanel aba1 = new JPanel();
        for (int i = 0; i < 3; i++) {
            
            aba1.add(new JButton("Hola qué tal!"));
        }
        JPanel aba2 = new JPanel();
        for (int i = 0; i < 3; i++) {
            aba2.add(new JButton("Hola como estas tu!"));
        }
        JTextField dew = new JTextField("erinfwdiwnefwoidmwpefmwe");
        aba2.add(dew);

        //adicionando as abas ao tabed pane 
            janelaAbas.addTab("Aba 1", null, aba1,"aba um");
            janelaAbas.addTab("Aba 2", null, aba2,"aba dois");

        //add tabbed pane ao frame
            this.add(janelaAbas);



        this.setVisible(true);
        this.setBounds(EXIT_ON_CLOSE, ABORT, 300, 400);
        this.setLocationRelativeTo(null);
    }
}
