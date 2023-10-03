import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exercicioconc extends JFrame implements ActionListener{
    private JButton but;
    private JLabel teste;
    private String nomeW;
    private String sobrenome;


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
        but.addActionListener(this);
      
       
        //set do frame 
        setSize(250,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setVisible(true);

    }
    @Override
public void actionPerformed(ActionEvent evento) {
    resultado = nome+sobrenome;
}


    public static void main(String[] args) {
        new Exercicioconc();
    }
}


