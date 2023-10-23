package GUISerializacao.src;

import javax.swing.JTabbedPane;
import javax.swing.*;
import java.awt.*;

public class JanelaAbas extends JTabbedPane{
    
    public JanelaAbas() {
        super();
    
    this.add("Cadastrar", new CadastroUsuarios());
    this.add("Agendar", new CadastroAgenda());

    this.setVisible(true);
}
}
