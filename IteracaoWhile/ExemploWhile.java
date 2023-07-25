package IteracaoWhile;

import java.util.Random;
import java.util.Scanner;

public class ExemploWhile {
    Scanner sc = new Scanner(System.in);

    public void exemplo01() {

        int i = 0; // Varíavel do tipo "i" é muito comum. É o nosso contador. O repetir de laços

        while (i > -1) {

            System.out.println("O número da iteração é " + i);
            i = i + 1; // Note que ao colocar o incremento antes da impressã, o número é somado antes.
                       // Como está, ele imprimirá até 9.999.
            // se eu quisesse que ele rodasse até 10.000, deveria ter colocado a antes do
            // sysOut.
            // i += 1; ---- Incremento;
            // i++; ---- Incremento;

        }

    }

    public void exemplo02() {

        for (int i = 0; i < 10000; i++) {
            System.out.println("O número da interação é " + i);
        }
    }

    public void exemplo03() { // Um pouco complexo, mas bem lógico.

        int vetor[] = new int[10];
        int i = 0;
        while (i < 10) {
            System.out.println("Informe o valor do índice " + i + " do vetor");
            vetor[i] = sc.nextInt();
            i++;
        }

        while (1 < 10) {
            System.out.println("O vetor [" + i + "] =" + vetor[i]);
            i++;
        }

        // while (i>0) {
        // i--;
        // System.out.println("O vetor ["+i+"] =" +vetor[i]);
        // }
    }

    public void exemplo04() {

        Random rd = new Random();
        int valorSorteado = rd.nextInt(10); // 10 posições. 0 até 9. rd significa random.
        boolean tenteNovamente = true; // while é associado com boolean 
        while (tenteNovamente) {
            System.out.println("Digite um Número");
            int nDigitado = sc.nextInt();
            if(nDigitado==valorSorteado) {
                System.out.println("Você acertou!");
                tenteNovamente = false;
            } else {
                System.out.println("Você errou!");
            }

        }


    }

}
