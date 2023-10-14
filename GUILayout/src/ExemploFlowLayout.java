import java.util.*;
import java.awt.*;
import javax.swing.*;


public class ExemploFlowLayout {
 public ExemploFlowLayout() {
   int cont = 0;


    //criando o frame - padrão de GridLayout - JFrame é como se fosse o body e o JPanel é a div
    JFrame janela1 = new JFrame("Olha minha janela, ta bastante sol");
  
 
    //set Frame
    janela1.setSize(230, 200);
    janela1.add(new JLabel("ahuahaihia"));
    janela1.setDefaultCloseOperation(2);
    janela1.pack();
    janela1.setVisible(true);



 }   
 public static void main(String[] args) {
  new ExemploFlowLayout();
 }
}
