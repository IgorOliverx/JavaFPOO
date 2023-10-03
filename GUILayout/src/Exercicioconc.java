import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exercicioconc extends JFrame {

    public Exercicioconc() {
        super();

        JPanel painel = new JPanel();
        this.add(painel);

        //label nome
        JLabel insNome = new JLabel("NOME:");
        painel.add(insNome);
        //text field de nome
        JTextField nome = new JTextField();
        Dimension dm = new Dimension(200, 20);
        painel.add(nome);
        nome.setPreferredSize(dm);
   

          //label sobrenome
        JLabel insSobrenome = new JLabel("SOBRENOME:");
        painel.add(insSobrenome);
        //text field de sobrenome
        JTextField sobrenome = new JTextField();
        painel.add(sobrenome);
        sobrenome.setPreferredSize(dm);


        JButton but = new JButton("OK");
        painel.add(but);
       
        JLabel nomeCompleto = new JLabel();
        painel.add(nomeCompleto);
      
       
        //set do frame 
        setSize(250,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setVisible(true);


        //metodo 1
        // but.addActionListener(e->{
        //     nomeCompleto.setText(nome.getText()+ " "+ sobrenome.getText());
        // });

        //metodo 2
        but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e ){
                  nomeCompleto.setText(nome.getText()+ " "+ sobrenome.getText());
            }
        });

    }


    public static void main(String[] args) {
        new Exercicioconc();
    }
}


