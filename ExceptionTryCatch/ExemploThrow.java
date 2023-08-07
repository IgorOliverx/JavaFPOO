package ExceptionTryCatch;

import javax.swing.JOptionPane;

import java.util.regex.*;

public class ExemploThrow {
    public static void main(String[] args) {
        boolean tenteNovamente = true;
        String senha;
        String user;
        String dataNascimento;

        while (tenteNovamente) {

            try {
                user = JOptionPane.showInputDialog(null, "Informe um User");
                dataNascimento = JOptionPane.showInputDialog(null,
                        "informe sua data de nascimento dd/mm/aaaa");
                dataNascimento = dataNascimento.replace("/", "");
                senha = JOptionPane.showInputDialog(null, "Informe uma senha:");

                if (user.equals(senha)) {
                    throw new Exception("A sua senha não pode ser igual ao seu User");
                }
                if (senha.length() < 4) {
                    throw new Exception("A senha deve conter mais que 8 caracteres");
                }
                if (senha.equals(dataNascimento)) {
                    throw new Exception("A sua senha não pode ser igual a sua data de nascimento");
                }if (senha.contains("ABC")) {
                    throw new Exception ("Sua senha deve conter ao menos 1 caractere maiscúlo");
                } if (senha.contains("abc")){
                    throw new Exception("Sua senha deve conter ao menos 1 caractere minúsculo");
                }
                

                JOptionPane.showMessageDialog(null, "User cadastrada com sucesso!");
                JOptionPane.showMessageDialog(null, "Senha cadastrada com sucesso!");
                JOptionPane.showMessageDialog(null, "Data de nascimento cadastrada com sucesso!");
                tenteNovamente = false;


            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }
    }
}
