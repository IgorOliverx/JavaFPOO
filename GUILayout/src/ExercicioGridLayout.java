import javax.swing.*;
import java.awt.*;

public class ExercicioGridLayout extends JFrame {
    public ExercicioGridLayout() {
        super();
        
       
        JPanel painel1 = new JPanel();
        this.add(painel1);
        FlowLayout flow = new FlowLayout();
        painel1.setLayout(flow);
        

         //adicionando um painel - container secundário onde colocarei os componentes
        JPanel painel = new JPanel();
        //adicionei o painel ao container principal 'Jframe'
        this.add(painel);
        //modificar o layout padrão do jpanel'flow' -> grid
        GridLayout grid = new GridLayout(5, 4);
        painel.setLayout(grid);


        //adicionando os componentes ao JPanel

    JTextField txt = new JTextField();
    painel1.add(txt);
    txt.setSize(100, 20);
    txt.setText("Resultado");

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
    painel.add(new JButton("+"));
    painel.add(new JButton("0"));
    painel.add(new JButton(","));

    JButton btn = new JButton();
    painel.add(btn);
    btn.setBackground(Color.BLUE);
    btn.setText("=");



        

        //set do frame
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack(); // compactação do painel
        this.setVisible(true);
    //calculadora em java?

    }
    }

