package RevisaoPOO;

import RevisaoPOO.Cadastro.Animais;
import RevisaoPOO.Cadastro.Cachorro;
import RevisaoPOO.Cadastro.Gato;
import RevisaoPOO.Cadastro.Usuario;

import javax.print.attribute.standard.JobMediaSheets;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws InterruptedException {
        // armazenar animais
        Animais[] animais = new Animais[10];
        Usuario[] usuario = new Usuario[10];
        Cachorro[] dog = new Cachorro[10];
        Gato[] cat = new Gato[10];
        // vetor do gato

        // vetor do cachorro

        // variáveis de loop e decisão
        int cont = 0;
        int escolha;
        boolean ligado = true;
        int criarConta = 0;

        JOptionPane.showMessageDialog(null, "Bem-vindo! Este é o seu veterinário personalizado On-line");

        while (ligado) {
            escolha = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma opção:"
                    + "\n 1- Realizar uma consulta ON-LINE"
                    + "\n 2- Enciclopédia dos Animais"
                    + "\n 3- Sair"));

            JOptionPane.showMessageDialog(null, "Você entrou em uma consulta ON-LINE.");
            escolha = Integer.parseInt(JOptionPane.showInputDialog("LOGIN"
                    + "\n 1- Entrar"
                    + "\n 2- Cadastrar"
                    + "\n 3- Voltar"));
            if (escolha == 1) {
                usuario[cont] = new Usuario();
                usuario[cont].setEmail(JOptionPane.showInputDialog("E-mail"));
                usuario[cont].setSenha(JOptionPane.showInputDialog("Senha"));
                
               
               
            }
            if (escolha == 2) {
                JOptionPane.showMessageDialog(null,
                        "Por favor, realize seu cadastro e forneça informações suas e do seu Pet!");
                animais[cont] = new Animais();
                usuario[cont] = new Usuario();

                animais[cont].setPorte(JOptionPane.showInputDialog("Informe o porte do seu animal"));
                animais[cont].setEspecie(JOptionPane.showInputDialog("Informe a espécie do seu animal"));
                animais[cont].setGenero(JOptionPane.showInputDialog("Informe o genêro do seu animal"));
                animais[cont].setProprietario(JOptionPane.showInputDialog("Informe o seu nome"));
                usuario[cont].setEmail(JOptionPane.showInputDialog("Informe o E-Mail"));
                usuario[cont].setSenha(JOptionPane.showInputDialog("Crie uma Senha:"));
                JOptionPane.showMessageDialog(null, "Seu cadastro foi realizado com sucesso!");
                JOptionPane.showMessageDialog(null, "Infos: "
                +"\n Porte: "+ animais[cont].getPorte()
                +"\n Espécie: "+ animais[cont].getEspecie()
                +"\n Genêro: "+animais[cont].getGenero()
                +"\n Proprietário: "+ animais[cont].getProprietario()
                +"\n E-mail: "+ usuario[cont].getEmail()
                +"\n Senha: ********" );
                 cont++;

            } if (escolha == 3) {
                ligado = false;
                JOptionPane.showMessageDialog(null, "Obrigado pela preferência!" +
                        "\n Até a próxima!");
            } 

        }

    }

}
