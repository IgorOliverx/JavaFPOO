import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;

public class ExemploConcatNome extends JFrame {
    public ExemploConcatNome() {
        super("Exemplo 1 - Evento");

        JPanel p = new JPanel(new GridLayout(3,2));
        this.add(p);//add p ao frame

        //add elemen/componentes ao p

        //linha do nome
        p.add(new JLabel("NOME: ", null, ABORT));
        JTextField caixaNome = new JTextField();
        p.add(caixaNome);

        //linha sobrenome
        p.add(new JLabel("SOBRENOME: ", null, ABORT));
        JTextField caixaSobrenome = new JTextField();
        p.add(caixaSobrenome);

        JButton botao = new JButton("OK");
        p.add(botao);

        JLabel nomeCompleto  = new JLabel();
        p.add(nomeCompleto);
        

   
       
        //set do frame 
        this.setDefaultCloseOperation(2);//fecha a janela e para o programa
        this.setBounds(100, 100,300,300);
       this.setVisible(true);
    }

    public static void main(String[] args) {
        ExemploConcatNome a = new ExemploConcatNome();
        
    }
}
