package RevisaoPOO;

import RevisaoPOO.Cadastro.Animais;
import RevisaoPOO.Cadastro.Cachorro;
import RevisaoPOO.Cadastro.Gato;
import RevisaoPOO.Cadastro.Usuario;

import javax.swing.JOptionPane;

public class App {
        static Animais[] animais = new Animais[10];
        static Usuario[] usuario = new Usuario[10];
        static Cachorro[] dog = new Cachorro[10];
        static Gato[] cat = new Gato[10];
        static int cont = 0;
    public static void main(String[] args) throws InterruptedException{
        int escolha;
        boolean ligado = true;

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
                boolean loginValido = realizarLogin();

                if (loginValido) {
                    JOptionPane.showMessageDialog(null, "Login realizado com sucesso! Bem-vindo!");
                    JOptionPane.showInputDialog("Por favor, informe os sintomas de seu " + animais[cont].getEspecie());
                } else {
                    JOptionPane.showMessageDialog(null, "Login inválido! Tente novamente com outras credenciais.");
                }
            }

            if (escolha == 2) {
                JOptionPane.showMessageDialog(null, "Por favor, realize seu cadastro e forneça informações suas e do seu Pet!");
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
                        + "\n Porte: " + animais[cont].getPorte()
                        + "\n Espécie: " + animais[cont].getEspecie()
                        + "\n Genêro: " + animais[cont].getGenero()
                        + "\n Proprietário: " + animais[cont].getProprietario()
                        + "\n E-mail: " + usuario[cont].getEmail()
                        + "\n Senha: ********");
                cont++;
            }

            if (escolha == 3) {
                ligado = false;
                JOptionPane.showMessageDialog(null, "Obrigado pela preferência!" +
                        "\n Até a próxima!");
            }
        }
    }

    public static boolean realizarLogin() {
        String email = JOptionPane.showInputDialog("E-mail");
        if (email == null) {
            return false;
        }

        String senha = JOptionPane.showInputDialog("Senha");

        for (int i = 0; i < cont; i++) {
            if (usuario[i].getEmail().equals(email) && usuario[i].getSenha().equals(senha)) {
                return true;
            }
        }

        return false;
    }
    }
         
