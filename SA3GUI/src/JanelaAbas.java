import javax.swing.JTabbedPane;

public class JanelaAbas extends JTabbedPane {
    public JanelaAbas() {
        super();
        this.add("Científica", new Calculadora1());
        this.add("Padrão", new Calculadora2());
        this.add("Conversor M/Km", new Calculadora3());

        this.setVisible(true);
    }

}
