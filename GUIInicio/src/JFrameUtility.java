import java.util.*;
import java.awt.*;
import javax.swing.*;

public class JFrameUtility extends JFrame {
    public JFrameUtility() {
        super("Janela Principal");
        // set da janela
        this.setVisible(true); // torna a janela visível
        this.setBounds(300, 200, 500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fecha a janela com o "x"
        this.setResizable(false); // impede o user de editar a janela
        //Ajustando o layout da janela;
        FlowLayout flow = new FlowLayout();
        this.setLayout(flow);

        // adicionar os componentes
        for (int i = 0; i < 6; i++) {
            this.add(new JButton("" + i));
        }
        this.add(new TextField("Meu Texto",15));
    }
}
