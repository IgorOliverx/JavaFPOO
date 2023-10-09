import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Handler;


public class ExKey extends JFrame {

    private JTextField teclaDig;
    private JTextField  Dig;
    private JLabel teclaExibir, digitarAoVivo, copiaDigitar;

    public ExKey(){
        super();

         Dimension d = new Dimension(50, 20);
         Dimension e = new Dimension(100, 20);

        BorderLayout bd = new BorderLayout();
        JPanel painel = new JPanel(bd);
        this.add(painel);




//Criando um painel para colocar no topo
        FlowLayout fl = new FlowLayout();
        JPanel painelTop = new JPanel(fl);
        painel.add(painelTop, BorderLayout.NORTH);

//Primeira linha 
        teclaExibir = new JLabel("Tecla digitada");
        painelTop.add(teclaExibir);
        teclaDig = new JTextField();
        painelTop.add(teclaDig);
      
       
        teclaDig.setPreferredSize(d);

//Segunda linha


//Criando um painel para colocar no centro
        JPanel painelCenter = new JPanel(fl);
        painel.add(painelCenter, BorderLayout.CENTER);
        
        digitarAoVivo = new JLabel("Digite aqui");
        painelCenter.add(digitarAoVivo);


        Dig = new JTextField();
        painelCenter.add(Dig);
        Dig.setPreferredSize(e);


//Terceiro painel no sul
    JPanel painelSul = new JPanel(fl);
        painel.add(painelSul, BorderLayout.SOUTH);
        
        copiaDigitar = new JLabel();
        painelSul.add(copiaDigitar);

        //set do frame 
        setSize(250,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setVisible(true);

        Handler hd = new Handler();
        Dig.addKeyListener(hd);

    }

    public class Handler implements KeyListener{

        @Override
        public void keyPressed(KeyEvent e) {
            
        }

        @Override
        public void keyReleased(KeyEvent e) {
            copiaDigitar.setText(Dig.getText());
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            teclaDig.setText("" +c);

            
            
            
        
            
        }
        
    }






    public static void main(String[] args) {
        new ExKey();
    }
}
