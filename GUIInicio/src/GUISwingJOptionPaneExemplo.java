import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GUISwingJOptionPaneExemplo extends JOptionPane {


    String infor ="Minha primeira dialog";
    public GUISwingJOptionPaneExemplo() {
        super();
        this.showMessageDialog(getComponentPopupMenu(), infor, infor, ERROR_MESSAGE, icon);
    }
}
