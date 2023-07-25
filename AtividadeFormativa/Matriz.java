package AtividadeFormativa;

import java.util.Random;
import java.util.Scanner;

public class Matriz {
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();

    public int matriz[][];
    public int linha = 0;
    public int coluna = 0;

    public Matriz() {

        this.coluna = coluna;
        this.linha = linha;
        this.matriz = new int[linha][coluna];

    }

    public void determinarMatriz() {

        System.out.println("Por favor, escreva o Número de linhas desejadas em sua matriz:");
        linha = sc.nextInt();
        System.out.println("Por favor, escreva o Número de colunas desejadas em sua matriz:");
        coluna = sc.nextInt();

        matriz = new int[linha][coluna];
    }

    public void preencherMatriz() {
        for (int j = 0; j < matriz.length; j++) {
            for (int i = 0; i < matriz.length; i++) {
                matriz[j][i] = rd.nextInt(10);
            }

        }
    }

    public void mostrarMatriz() {

        for (int i = 0; i < linha; i++) {

            for (int j = 0; j < coluna; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

    }

    public void alterarMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if(i>j){
                    matriz[i][j] = 1;
                }else if(i==j){
                    matriz[i][j] = 0;
                } else if (j>i){
                    matriz[i][j] = 2;
                }
                
            }
        }
    }

}