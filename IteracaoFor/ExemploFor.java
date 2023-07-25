package IteracaoFor;

import java.util.Scanner;
import java.util.Arrays;

public class ExemploFor {

    Scanner sc = new Scanner(System.in);

    public void exemplo1() {
        for (int i = 0; i < 10; i++) {

            System.out.println("O número da Iteração é " + i);
        }

    }

    public void exemplo2() {

        int vetorA[] = new int[] { 1, 2, 3, 4, 5 };

        for (int i = 0; i < 5; i++) {
            System.out.println("O vetor A [" + i + "]=" + vetorA[i]);
        }

    }

    public void exemplo3() {
        int vetor[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        for (int i = 9; i < 10; i--) {
            System.out
                    .println("Classificando os vetores em ordem descrescente, temos: O vetor  [" + i + "]=" + vetor[i]);
        }
    }

    public void exemplo4() {
        Double vetor[] = new Double[] { 7.00, 9.00, 6.00, 7.50 };
        Double vetorM = (vetor[0] + vetor[1] + vetor[2] + vetor[3]) / 4;

        for (int i = 0; i < 4; i++) {
            System.out.println("Classificando os vetores em ordem, temos: O vetor  [" + i + "]=" + vetor[i]);

        }
        System.out.println("A média final se daria em: " + vetorM);

    }

    // double notas [] = new notas [4];
    // for (int i = 0; i < notas.length; i++) {
    // syso("digite a nota "+i+1+" do aluno") }
    // notas [i] = sc.nextDouble(); }
    //
    // double = media=0;
    // for (int i = 0; i < notas.length; i++) {
    // syso("nota"+(i+1)+"="+notas[i]);
    // media += notas[i]
    //
    //
    //
    //
    //
    //
    //
    //

    //
    //

    public void exemplo5() {

        double vetor[] = new double[10];
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("vetor [" + (i + 1) + "]=");
            vetor[i] = sc.nextDouble();
        }

        for (int i = 9; i >= 0; i--) {

            System.out.println("vetor[" + (i + 1) + "]=" + vetor[i]);

        }

    }

    public void exemplo6() {

        double notas[] = new double[4];

        for (int i = 0; i < notas.length; i++) {
            System.out.print("Digite a nota " + (i + 1) + " do Aluno:");
            notas[i] = sc.nextDouble();
        }

        double media = 0;

        for (int i = 0; i < notas.length; i++) {
            System.out.println("Nota " + (i + 1) + "= " + notas[i]);
            media += notas[i];
        }

        media /= notas.length;
        System.out.println("A média do Aluno é " + media);
    }

    public void exemplo7() {

        String vetor[] = new String[] { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
        int consoantes = 0;

        System.out.println("As letras a serem lidas vão de a até j");

        for (int i = 0; i < vetor.length; i++) {

            if ((vetor[i].charAt(0) >= 'b' && vetor[i].charAt(0) <= 'j') && vetor[i].charAt(0) != 'e'
                    && vetor[i].charAt(0) != 'i' && vetor[i].charAt(0) != 'o' && vetor[i].charAt(0) != 'u') {
                consoantes++;
            }
        }

        System.out.println("Foram lidas " + consoantes + " consoantes");
    }

    public void exemplo7a() {

        System.out.println("Digite uma palavra");
        String palavra = sc.next();
        palavra.toLowerCase();
        int cont = 0;

        for (int i = 0; i < palavra.length(); i++) {
            char c = palavra.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {

            } else {
                cont++;
                System.out.println(c + " é consoante");
            }

        }

        System.out.println("O número de consoantes é " + cont);
    }

    public void exemplo8() {

        int vetorPar[] = new int[20];
        int vetorImpar[] = new int[20];
        int vetorNum[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

        for (int i = 0; i < vetorNum.length; i++) {

            if (vetorNum[i] % 2 == 0) {
                vetorPar[i] = vetorNum[i];
            } else {
                vetorImpar[i] = vetorNum[i];
            }

        }

        for (int i = 0; i < vetorNum.length; i++) {
            System.out.println("vetor[" + i + "]=" + vetorNum[i]);
            System.out.println("vetorPar[" + i + "]=" + vetorPar[i]);
            System.out.println("vetorImpar[" + i + "]=" + vetorImpar[i]);
        }
    }

    // Exercicio 8 com contador

    public void exemplo8a() {

        int vetorNum[] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
        int contImpar = 0;
        int contPar = 0;
        //apenas contando quantos números pares e impares
        for (int i = 0; i < vetorNum.length; i++) {
            if (vetorNum[i] % 2 == 0) {
                contPar++;
            } else {
                contImpar++;
            }
        }

        // Primeiro você está fazendo os contadores, e atribuindo os valores do vetorNum ( posso chama-lo de vetor pai) aos contadores
        //Agora você cria os vetores e atribui os tamanhos corretos, que são aquele que tem os contadores; 
        int vetorPar[] = new int[contPar];
        int vetorImpar[] = new int[contImpar];
        //distribuindo os valores nos vetores
        contImpar = 0;
        contPar = 0;

        for (int i = 0; i < vetorImpar.length; i++) {
            if(vetorNum[i]%2 ==0 ) {
                vetorPar[contPar] = vetorNum[i];
            contPar++;
            }else {
                vetorImpar[contImpar] = vetorNum[i];
                contImpar++;
            }
        }
    }

}
