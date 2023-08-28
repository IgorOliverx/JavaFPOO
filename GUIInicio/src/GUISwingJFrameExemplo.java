import javax.swing.JFrame;

public class GUISwingJFrameExemplo extends JFrame {
    public GUISwingJFrameExemplo() {
        super("Minha primeira aplicação com o JFrame");
        this.setSize(500, 500); // tamanho da janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fecha a janela com o "x"
        this.setVisible(true); // torna a janela visível 
        this.setResizable(false); // impede o user de editar a janela
        this.setLocationRelativeTo(null);
    }
}
