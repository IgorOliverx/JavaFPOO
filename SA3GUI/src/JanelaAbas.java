import javax.swing.JTabbedPane;

public class JanelaAbas extends JTabbedPane {
    public JanelaAbas() {
        super();
        this.add("Calculadora Científica", new Calculadora1());
        this.add("Calculadora 2",new Calculadora2());
     

        this.setVisible(true);
    }


}
