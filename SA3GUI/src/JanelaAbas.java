import javax.swing.JTabbedPane;

public class JanelaAbas extends JTabbedPane {
    public JanelaAbas() {
        super();
        this.add("Calculadora 1", new Calculadora1());
        this.add("Calculadora 2",new Calculadora2());
        this.add("Calculadora 3",new Calculadora3());

        this.setVisible(true);
    }


}
