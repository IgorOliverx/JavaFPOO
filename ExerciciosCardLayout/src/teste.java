import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class teste extends JFrame {
    public teste() {
        super("Exemplo de JLabel com Imagem");

        // Criar um ImageIcon com a imagem desejada
        ImageIcon icone = new ImageIcon("/resources/java.png");

        // Criar um JLabel e definir o ImageIcon
        JLabel labelComImagem = new JLabel(icone);

        // Criar um painel para adicionar o JLabel
        JPanel painel = new JPanel();
        painel.add(labelComImagem);

        // Adicionar o painel ao JFrame
        add(painel);

        // Configurar o tamanho da janela e encerrar quando fechada
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tornar a janela visível
        setVisible(true);
    }

    public static void main(String[] args) {
        new teste();
    }
}
