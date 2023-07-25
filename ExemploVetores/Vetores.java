package ExemploVetores;

import java.util.Scanner;

public class Vetores {
    Scanner sc = new Scanner(System.in);
    public void exemplo1() {
        //criar um vetor com 5 N° inteiros

        int vetorInt[] = new int [5]; //vetor vazio
        int vetorInt2 [] = new int[] {1,2,3,4,5};
        //preenchendo o vetorint 
        vetorInt[0] = sc.nextInt();//1° posição índice 0 
        vetorInt[1] = sc.nextInt();//2° posição índice 1 
        vetorInt[2] = sc.nextInt();//3° posição índice 2 
        vetorInt[3] = sc.nextInt();//4° posição índice 3 
        vetorInt[4] = sc.nextInt();//5° posição índice 4 
        System.out.println("O valor da 1° posição é "+ vetorInt[0]);
        System.out.println("O valor da 2° posição é "+ vetorInt[1]);
        System.out.println("O valor da 3° posição é "+ vetorInt[2]);
        System.out.println("O valor da 4° posição é "+ vetorInt[3]);
        System.out.println("O valor da 5° posição é "+ vetorInt[4]);


    }

    public void exemplo2() {

        Double vetorInt[] = new Double[10];

System.out.println("Preencha o vetor de 10 posições");

vetorInt[0] = sc.nextDouble();
vetorInt[1] = sc.nextDouble();
vetorInt[2] = sc.nextDouble();
vetorInt[3] = sc.nextDouble();
vetorInt[4] = sc.nextDouble();
vetorInt[5] = sc.nextDouble();
vetorInt[6] = sc.nextDouble();
vetorInt[7] = sc.nextDouble();
vetorInt[8] = sc.nextDouble();
vetorInt[9] = sc.nextDouble();

System.out.println("O valor do índice 9 é "+ vetorInt[9]);

System.out.println("O valor do índice 9 é "+ vetorInt[8]);

System.out.println("O valor do índice 9 é "+ vetorInt[7]);

System.out.println("O valor do índice 9 é "+ vetorInt[6]);

System.out.println("O valor do índice 9 é "+ vetorInt[5]);

System.out.println("O valor do índice 9 é "+ vetorInt[4]);

System.out.println("O valor do índice 9 é "+ vetorInt[3]);

System.out.println("O valor do índice 9 é "+ vetorInt[2]);

System.out.println("O valor do índice 9 é "+ vetorInt[1]);
    }

    public void exemplo03 () {

        int iteracao = 0;
        while (iteracao <10) {
            System.out.println("iteracao de número" + iteracao + ".");
            iteracao = iteracao + 1;
        }
    }
}
