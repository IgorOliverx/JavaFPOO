package CalculadoraVelocidade2Scanner;

import java.util.Scanner;

public class CalculadoraScanner {
    public void calcular() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe a Distância Percorrida");
        double distanciaPercorrida = sc.nextDouble();
        System.out.println("A Distância percorrida foi de " + distanciaPercorrida + " km!");
        System.out.println("Informe o tempo gasto na viagem!");
        double tempoGasto = sc.nextDouble();
        System.out.println("O tempo gasto na Viagem foi de " + tempoGasto + " horas!");
        sc.close();
double velocidadeMedia = distanciaPercorrida/tempoGasto;
System.out.println("A Velocidade Média de sua viagem foi de " +velocidadeMedia+ " km/h");

    }

}
