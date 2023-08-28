import javax.swing.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class ContainerComponentes extends JFrame{
    //atributos
    int cont=0;
    public ContainerComponentes() {
        super("Manipulando componentes");
        this.setBounds(400, 400, 500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        FlowLayout flow = new FlowLayout();
        this.setLayout(flow);

        //Criar um outro container 
        JPanel painel1 = new JPanel();
        this.add(painel1);
        //adicionar um Jbutton e um Jpanel
        // Fazer uma ação para o botao(addACtionListener)
        //criar primeiramente o botao

        
        JButton btn = new JButton("Clique Aqui!");
        JLabel texto = new JLabel("Nº de Cliques");
        // JButton btn1 = new JButton("Clique Aqui pra reiniciar!");

        painel1.add(btn);
        painel1.add(texto);
        // painel1.add(btn1);

        btn.addActionListener(e -> {
            cont++;
            texto.setText("Nº de Cliques é = "+ cont);
            add(new JButton(""+ cont));
        });
        // btn1.addActionListener(e -> {
        //     cont = 0;
        // });


    









        this.setVisible(true);
        
    }
}
