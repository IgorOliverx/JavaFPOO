package ExerciciosIfElse;

import java.util.Scanner;

import javax.lang.model.element.Element;

public class Exercicios {

    Scanner sc = new Scanner(System.in);

    public void exercicio1() {
        System.out.println("Informe o 1° valor!");
        double valor1 = sc.nextDouble();

        System.out.println("Informe o 2° valor!");
        double valor2 = sc.nextDouble();

        if (valor1 > valor2) {
            System.out.println("O 1° valor é Maior" + valor1 + "!");

        } else {
            System.out.println("O 2° valor é Maior" + valor2 + "!");
        }
    }

    public void exercicio2() {

        System.out.println("Informe seu ano de nascimento");
        int anoNascimento = sc.nextInt();

        if (anoNascimento <= 2007) {
            System.out.println("Você - Cidadão registrado, está apto a votar!");
        } else {
            System.out.println("Você - Cidadão, não está apto a votar por não atingir o requisito minímo de idade!");
        }

    }

    public void exercicio3() {
        System.out.println("Olá, para obter acesso você precisa digitar uma senha!");

        System.out.println("Por favor, digite a Senha!");
        double senha = sc.nextDouble();

        if (senha == 1234) {
            System.out.println("ACESSO PERMITIDO!");
        } else {
            System.out.println("ACESSO NEGADO!");
        }
    }

    public void exercicio4() {

        System.out.println("Olá! Seja Bem-Vindo ao Hortifruti online!");
        System.out.println("Por favor, digite quantas maçãs gostaria de comprar!");
        double maças = sc.nextDouble();

        if (maças >= 12) {
            System.out.println("O preço por unidade de maçã será de R$0,25 e o preço total será de " + (maças * 0.25));
        } else {
            System.out.println("O preço por unidade de maçã será de R$0.30 e o preço total será de" + (maças * 0.35));
        }
        System.out.println(
                "Por favor, digite novamente quantas maças gostaria de comprar, e se assim é possível obter desconto!");
        double quantidade = sc.nextDouble();

        if (quantidade >= 30) {

            System.out.println(
                    "Parabéns, Você obteve 2% de desconto, mas deve calcular por conta própria porquê o tempo está limitado para eu ir além! :)");

        } else {
            System.out.println(
                    "Infelizmente Você não comprou o minímo de maças para obter um Desconto especial, Por favor, compre mais!");

        }

    }

    public void exercicio5() { // Esse é difícil ein - Não Consegui executar, por isto resolvi outro no mesmo modelo!
        System.out.println("Por favor, Digite 3 valores para que eu os classifique em ordem Crescente!");
        int x = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if ((x < b) && (x < c)) {
            System.out.println("A ordem crescente dos números é" + x + b + c);
        } else {
            System.out.println("");
        }

        if ((x < c) && (x < b)) {
            System.out.println("A ordem crescente dos números é" + x + c + b);
        } else {
            System.out.println("");
        }


        if ((b < c) && (b < x)) {
            System.out.println("A ordem crescente dos números é" + b + c + x);
        } else {
            System.out.println("");
        }

        if ((b < x) && (b < c)) {
            System.out.println("A ordem crescente dos números é" + b + x + c);
        } else {
            System.out.println("");
        }

        if ((c < b) && (c < x)) {
            System.out.println("A ordem crescente dos números é" + c + b + x);
        } else {
            System.out.println("");
        }

        if ((c < x) && (c < b)) {
            System.out.println("A ordem crescente dos números é" + c + x + b);
        } else {
            System.out.println("");
        }


    }

    public void exercicio6() { // tentarei fazer o exercicio acima, mas somente com dois números

        System.out.println("Olá! Peço que escreva dois números e então os classificarei em ordem crescente!");
        System.out.println("Informe o 1° número");
        int c = sc.nextInt();
        System.out.println("Informe o 2° número");
        int d = sc.nextInt();

        if (c > d) {
            System.out.println(d + "," + c);

        } else {
            System.out.println(c + "," + d);
        }
    }

    // Exercício Extra
    public void exercicio7() {

        System.out.println("Olá, Para saber se vocÊ está Aprovado no Curso, Pedirei algumas informações!");
        System.out.println("Informe a Sua nota do 1° Semestre!");
        Double nota1 = sc.nextDouble();
        System.out.println("Informe a Sua nota do 2° Semestre!");
        Double nota2 = sc.nextDouble();
        if ((nota1 + nota2) / 2 >= 5.0) {
            System.out.println("O Aluno está Aprovado pelo Critério NOTA");
        } else {
            System.out.println("O Aluno está Reprovado pelo Critério NOTA");
        }
        System.out.println("Agora, Avaliaremos outro critério, a frequência!");
        System.out.println("Por favor, informe sua Frequência Final");
        Double freq = sc.nextDouble();
        if (freq >= 75) {
            System.out.println("O Aluno está APROVADO pelo critério FREQUÊNCIA!");
        } else {
            System.out.println("O Aluno está REPROVADO pelo critério FREQUÊNCIA!");
        }
        System.out.println("Agora que Avaliamos os dois possíveis critérios, exibirei seu resultado final!");

        if ((nota1 + nota2) / 2 >= 5.0 && freq >= 75) {
            System.out.println("O Aluno está oficialmente Aprovado!");
        } else {
            System.out.println("O aluno está oficialmente Reprovado!");
        }
    }

    // Lista extra estrutura if-else

    public void exercicio8() {
        System.out.println("Dado os número que forem inseridos, determinarei-os em PAR ou ÍMPAR!");
        System.out.println("Informe um Valor Inteiro qualquer!");
        int num = sc.nextInt();

        if (num % 2 < 1) {
            System.out.println("O número informado é par!");
        } else {
            System.out.println("O número informado é impar!");
        }

    }

    public void exercicio9() {
        System.out.println(
                "Por favor, informe sua nota para saber se você passou direto, se pode fazer uma recuperação ou foi reprovado direto!");
        int nota = sc.nextInt();
        if (nota >= 7) {
            System.out.println("O aluno está Aprovado direto!");
        } else {
            System.out.println("");
        }
        if ((nota >= 5) && (nota < 7)) {
            System.out.println("O aluno tem direito de fazer uma recuperação!");
        } else {
            System.out.println("");
        }
        if (nota < 5) {
            System.out.println("O aluno está Reprovado direto!");
        }
    }

    public void exercicio10 () {

        System.out.println("o Programa a seguir calculará o seu peso ideal de acordo com seu Sexo e sua Altura!");

        System.out.println("Informe seu sexo - 1 para FEMININO e 2 para MASCULINO");
        int sex = sc.nextInt();
        System.out.println("Informe sua altura!");
        Double altura = sc.nextDouble();
        
if (sex==1)  { 

    System.out.println("O seu peso ideal é" +((62.1*altura)-44.7) +"KG aproximadamente!");

}else {

    System.out.println("O seu peso ideal é" +((72.7*altura)-58) +"KG aproximadamente!");

}

    }

    public void exercicio11 () //Faça um programa que verifique (usando if e else) se uma letra digitada é vogal ou consoante.
    {
System.out.println("Informe um Letra e eu a determinarei como Vogal ou Consoante");
String letra = sc.nextLine();

if (equals(letra))  {
    System.out.println("A letra digitada é uma Vogal");
    
} else {

    System.out.println("A letra digitada é uma consoante");
}
    }


























}
