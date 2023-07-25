package IteracaoWhile;

import java.util.Scanner;

public class ExerciciosWhile {
    Scanner sc = new Scanner(System.in);

    public void exercicio1() {

        int vetorA[] = new int [] {1,3,5,7,9};
        int VetorB[] = new int [5];
        int i = 0;

        while (i<5) {
            VetorB[i] = vetorA[i];
            System.out.println("O vetor B["+i+"]="+ VetorB[i]);
            i++;
        }

    }

    public void exercicio2 () {

        int vetorA[] = new int [] {2,3,4,5,6,7,8,9};
        int vetorB [] = new int [8];
        int i = 0; // Entenda como a posição do indice.

        while (i<8) {
            vetorB[i] = vetorA[i]*2;
            System.out.println("O vetor B["+i+"]=" + vetorB[i]);
            i++;

        }
    }


    public void exercicio3() {

        int vetorA[] = new int [] {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        int vetorB[] = new int [15];
        int i = 0; // pense em "i" como a posição do vetor, que começa no indíce 0 e vai até o indíce 15, no caso. Como quero que os dois tenham o mesmo número de elementos, ele funciona de forma simples.

        while (i<15) {
            vetorB[i] = vetorA[i]*vetorA[i];
            System.out.println("O vetor B ["+i+"]=" + vetorB[i]);
            i++;
        }

    }
    //public void exercicio4() {
//
//      int vetorA[] = new int [] {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
//    int vetorB[] = new int [19];
//  int i = 0; // pense em "i" como a posição do vetor, que começa no indíce 0 e vai até o indíce 15, no caso. Como quero que os dois tenham o mesmo número de elementos, ele funciona de forma simples.
//
//      while (i<19) {
//        vetorB[i] = vetorA[i]*vetorA[i];
//      System.out.println("O vetor B ["+i+"]=" + vetorB[i]);
//    i++;
//}
//}
// O programa compilou com erro ao realizar este teste. Estou meio que comparando os dois vetores e atribuindo uma condição quando eles tem o mesmo numero de elementos. Quando essa condição é desfeita, o programa não pode funcionar. Pelo menos, até este momento, não enxergo uma maneira de fazer com que o código debugue


public void exercicio4 () {


    int vetorA[] = new int [] {2,3,4,5,6,7,8,9,16,99};
    int vetorB [] = new int [10];
    int i = 0;


    while (i<10) {
        vetorB[i] = vetorA[i]*i;
        System.out.println("O vetor B ["+i+"]=" + vetorB[i]);
        i++;
    }
}

public void exercicio5() { // fiz para que todos os resultados, independente do indice do VetorC deem 0 como resposta.

int vetorA[] = new int [] {1,2,3,4,5,6,7,8,9,10};
int vetorB[] = new int [] {-1,-2,-3,-4,-5,-6,-7,-8,-9,-10};
int vetorC[] = new int [10];
int i = 0;


while (i<10) {
    vetorC[i] = vetorA[i] - (-vetorB[i]);
    System.out.println("O vetor C ["+i+"]=" + vetorC[i]);
    i++;
}
}







}
