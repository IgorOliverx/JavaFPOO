import java.util.*;
import java.awt.*;
import javax.swing.*;


public class ExemploFlowLayout {
 public ExemploFlowLayout() {
   int cont = 0;


    //criando o frame - padrão de GridLayout - JFrame é como se fosse o body e o JPanel é a div
    JFrame janela1 = new JFrame("Olha minha janela, ta bastante sol");
    //Modificar o layout do frame
    FlowLayout flow = new FlowLayout();
    janela1.setLayout(flow);
    //criando componentes e 
    JLabel texto = new JLabel("Informe o Nº de Botões", null, 0);
    JTextField painel1 = new JTextField(null, "Insira o Nº", 25);
    JButton btn1 = new JButton("Enviar", null);
    //adicionar os componentes --> dentro da janela
    janela1.add(texto);
    janela1.add(painel1);
    janela1.add(btn1);
 
    //set Frame
    janela1.setDefaultCloseOperation(2);
    janela1.pack();
    janela1.setVisible(true);



    //Criando uma ação para o botão
    btn1.addActionListener(e -> {
     int quant = Integer.parseInt(painel1.getText());
     for (int i = 0; i < quant; i++) {
      janela1.add(new JButton(""+ i+1));
      janela1.pack();
     }
    });



 }   
}
