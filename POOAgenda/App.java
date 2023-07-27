package POOAgenda;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import POOAgenda.Cadastro.Animais;
import POOAgenda.Cadastro.Gato;
import POOAgenda.Cadastro.Animais;
import POOAgenda.Cadastro.Cachorro;
import POOAgenda.Cadastro.Outros;

public class App {
    public static void main(String[] args) {
        // o vetor servirá para armazenar todos os objetos
        Gato gatos[] = new Gato[10];
        Cachorro dogs [] = new Cachorro[10];
        ArrayList<Outros> outros = new ArrayList<Outros>();


       //criando um contador para percorrer as infos do vertor que foi criado
       int contDog = 0; int contCat = 0; int contOutros = 0;

       //Criar o cadastro 

       boolean ligar = true;

       JOptionPane.showMessageDialog(null, "Bem-Vindo ao consultório do Dr. Igor");
       //if(LocalDateTime)
       
       while(ligar) {
        int acao = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar PET\n 2 - Agendar Consulta \n 3- Sair "));
        if(acao == 1) {
            int acao2 = Integer.parseInt(JOptionPane.showInputDialog("1 - Gato\n 2 - Cachorro \n 3 - Outro "));
            if(acao2 == 1) {
                //Cadastro do Gato
                //isso ta no meu código, só copiar e colar 
            }else if (acao2 == 2) {
                //Cadastro do cachorro
            }else if (acao2 == 3) {
                //Cadastro de outro pet
            }else {
                //opção inválida
                JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        } else if (acao == 2) {
            //agendamento
        }
       }

}
}