import javax.swing.*;
import java.awt.*;

public class ExemploGridLayout extends JFrame {
    public ExemploGridLayout() {
        super("Janela principal");

        //adicionando um painel - container secundário onde colocarei os componentes
        JPanel painel = new JPanel();
        //adicionei o painel ao container principal 'Jframe'
        this.add(painel);
        //modificar o layout padrão do jpanel'flow' -> grid
        GridLayout grid = new GridLayout(4, 4);
        painel.setLayout(grid);

        //adicionando os componentes ao JPanel

    painel.add(new JButton("7"));
    painel.add(new JButton("8"));
    painel.add(new JButton("9"));
    painel.add(new JButton("X"));
    painel.add(new JButton("4"));
    painel.add(new JButton("5"));
    painel.add(new JButton("6"));
    painel.add(new JButton("-"));
    painel.add(new JButton("1"));
    painel.add(new JButton("2"));
    painel.add(new JButton("3"));
    painel.add(new JButton("+" ));
    painel.add(new JButton("+/-"));
    painel.add(new JButton("0"));
    painel.add(new JButton(","));

    JButton btn = new JButton();
    painel.add(btn);
    btn.setBackground(Color.RED);


        

        //set do frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack(); // compactação do painel
        this.setVisible(true);
    //calculadora em java?

    }
}
