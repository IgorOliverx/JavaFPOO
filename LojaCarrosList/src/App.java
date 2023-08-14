import javax.swing.JOptionPane;
import ArrayList.ArrayList;
import java.util.*;
import LojaCarrosList.lib.*;

public class App extends Carros{
    public static void main(String[] args) throws Exception {
        List <Carros> listaCarros = new java.util.ArrayList<>();

        boolean ligado = true;
        int escolha;

     

        JOptionPane.showMessageDialog(null, "Seja bem-vindo ao JAVA-Car");
        
        while (ligado) {

            while (ligado) {
                escolha = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma opção:"
                        + "\n 1- Cadastrar Carro"
                        + "\n 2- Listar Carros"
                        + "\n 3- Consultar Carros"
                        + "\n 4- Apagar Carro"));

                if (escolha == 1) {
                       //Cadastrar novo carro
                       Carros c = new Carros();
                       c.setMarca(JOptionPane.showInputDialog(null, "Informe a marca do seu carro:"));
                       c.setModelo(JOptionPane.showInputDialog(null, "Informe o modelo do seu carro:"));
                       c.setAno(JOptionPane.showInputDialog(null, "Informe o ano do seu carro:"));
                       c.setCor(JOptionPane.showInputDialog(null, "Informe a cor do seu carro:")); 
                      listaCarros.add(c);
                }
            

                 if (escolha == 2) { 
                      //listar os carros cadastrados
                      String listar = " ";
                      for (Carros carros : listaCarros) {
                        listar+= 
                        "Marca do carro:"+carros.getMarca()+ " Modelo do carro: "+carros.getModelo()+"\n";
                      }
                      JOptionPane.showMessageDialog(null, listar);
                    
                }

                 if (escolha == 3) {
                   
                }

                if (escolha == 4) {
                  
                }

               
        }
}
}
}