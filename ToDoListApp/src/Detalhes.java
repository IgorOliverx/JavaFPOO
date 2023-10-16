import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.util.ArrayList;
import java.awt.*;
import java.util.List;


public class Detalhes extends JFrame {
    TodoList todoList = new TodoList(getName());
    DetalhesTask detalhesTask = new DetalhesTask(getName());
    MetodosTask metodosTask = new MetodosTask(todoList);

    private JButton salvar,fechar;
    private JTextField caixaInserirDetalhes;


    private List<DetalhesTask> descricao;

    




    public Detalhes() {
        super();
       JPanel painelMain = new JPanel(new BorderLayout());
       this.add(painelMain, BorderLayout.CENTER);
       JPanel painelSul = new JPanel(new FlowLayout());
       this.add(painelSul, BorderLayout.SOUTH);

       //componentes
       salvar = new JButton("Salvar e sair");
       fechar = new JButton("Fechar");
       caixaInserirDetalhes = new JTextField();

       //adicionando componentes na posição e settando tamanho
       painelSul.add(salvar);
       painelSul.add(fechar);
       painelMain.add(caixaInserirDetalhes);
       painelMain.setSize(200, 100);
    
       //inicializando array que guarda descricao
       descricao = new ArrayList<>();

       fechar.addActionListener(e -> {
        this.dispose();
       });

       salvar.addActionListener(e -> {
        metodosTask.salvarDetalhesTask();
       });
 
    //set Frame
    
    
    this.setSize(300,400);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);


    }



    public JTextField getCaixaInserirDetalhes() {
        return caixaInserirDetalhes;
    }

    
    public List<DetalhesTask> getDescricao() {
        return descricao;
    }


    

}
