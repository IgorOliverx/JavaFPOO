import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Handler;

public class Exercicioconc extends JFrame {


    private JTextField nome, sobrenome;
    private JLabel nomeCompleto;

    public Exercicioconc() {
        super();

        JPanel painel = new JPanel();
        this.add(painel);

        //label nome
        JLabel insNome = new JLabel("NOME:");
        painel.add(insNome);
        //text field de nome
        nome = new JTextField();
        Dimension dm = new Dimension(200, 20);
        painel.add(nome);
        nome.setPreferredSize(dm);
   

          //label sobrenome
        JLabel insSobrenome = new JLabel("SOBRENOME:");
        painel.add(insSobrenome);
        //text field de sobrenome
        sobrenome = new JTextField();
        painel.add(sobrenome);
        sobrenome.setPreferredSize(dm);


        JButton but = new JButton("OK");
        painel.add(but);
       
        nomeCompleto = new JLabel();
        painel.add(nomeCompleto);
      
       
        //set do frame 
        setSize(250,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setVisible(true);


        //Tratamento simplificado -> callback so funciona quando existe apenas um método
        // but.addActionListener(e->{
        //     nomeCompleto.setText(nome.getText()+ " "+ sobrenome.getText());
        // });

        //Tratamento de evento do método normal
        // but.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e ){
        //           nomeCompleto.setText(nome.getText()+ " "+ sobrenome.getText());
        //     }    
        // });

        //Tratamento pelo manipulador handler
        //Instancia 
        Handler hd = new Handler();
        but.addActionListener(hd);

    }
    public class Handler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 1; i++) {
                
            }
            nomeCompleto.setText(nome.getText()+ " "+ sobrenome.getText());
            
        }
        
    }


    public static void main(String[] args) {
        new Exercicioconc();
    }
}


