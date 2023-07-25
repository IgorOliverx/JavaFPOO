package AtividadeRevisao1;

import java.util.Scanner;

public class ExemplosRevisao {
    Scanner sc = new Scanner(System.in);

    // criar métodos da Classe

    public void exemplo1() {
        // Criar um projeto para ler 2 notas e a Frequência
        // Falar se o aluno está aprovado ou reprovado
        // 1. Ler a primeira nota

        System.out.println("Informe a primeira nota");
        Double nota1 = sc.nextDouble();
        // 2. Ler a segunda nota
        System.out.println("Informe a segunda nota");
        Double nota2 = sc.nextDouble();
        // 3. Calcular a media

        Double media = (nota1 + nota2) / 2;
        // 4. Mostrar a media calculada
        System.out.println("A Media do aluno é " + media);
        // 5. Informar o total de aulas

        System.out.println("Professor, informe o total de aulas dadas");
        Double aulasDadas = sc.nextDouble();
        // 6. Informe o total de faltas do aluno
        System.out.println("Professor, informe o total de faltas do aluno");
        Double aulasFaltas = sc.nextDouble();
        // 7. Calcular a porcentagem de frequência

        Double frequencia = (aulasDadas - aulasFaltas) / aulasDadas;
        frequencia *= 100;
        // 8. Mostrar a frequencia do aluno em %
        System.out.println("O aluno teve " + frequencia + "%");
        // 9. Se (media>=50 e frequencia>=75) entao o aluno esta aprovado
        if (media >= 50 && frequencia >= 75) {
            System.out.println("Aluno Aprovado!");
        } else if (media <= 50 && frequencia >= 75) {
            System.out.println("O aluno terá o direito de fazer recuperação!");
        } else {
            System.out.println("Aluno Reprovado!");
        }

    }

}
