package Coleções;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.JOptionPane;
//import java.util.* importa todas as funções da biblioteca java.util

public class ExemploArrayList {
    //Criando um ArrayList
    ArrayList <String> carros = new ArrayList<>();
    
    public void teste () {
        //Adicionando elementos com o método add
        carros.add("Fusca");
        carros.add("Brasília");
        carros.add("Chevette");
        carros.add("Monza");
        carros.add("Monza");

        //Imprimindo os elementos - olha a diferença do array normal, eu não poderia fazer isto!
        JOptionPane.showMessageDialog(null, carros);

        //Ordenando a list com o metodo ()sort.
        Collections.sort(carros); // Ordenação em ordem alfabetica
        JOptionPane.showMessageDialog(null, carros, null, 0);
        Collections.reverse(carros);//Ordenação reversa
        JOptionPane.showMessageDialog(null, carros, null, 0);
        //Percorrer a lista - e é claro que com o forI - posteriormente vem o foreach
        for (int i = 0; i < carros.size(); i++) {
            JOptionPane.showMessageDialog(null, carros.get(i), null, i);            
        }

        //Percorrendo a lista com o FOREACH
        for(String i : carros) {
            JOptionPane.showMessageDialog(null, i, i, 0);
        }

        //Limpando o vetor com o método clear
        carros.clear();
         JOptionPane.showMessageDialog(null, carros);

    } 

    public void exercicio1() {
        //Criar um ArrayList de numeros inteiros;
        //preencher com 5 numeros aleatorios usando o random talvez - ordenar e imprimir

        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(Integer.parseInt(JOptionPane.showInputDialog(null,"Digite um número" )));
         numeros.add(Integer.parseInt(JOptionPane.showInputDialog(null,"Digite um número" )));
          numeros.add(Integer.parseInt(JOptionPane.showInputDialog(null,"Digite um número" )));
           numeros.add(Integer.parseInt(JOptionPane.showInputDialog(null,"Digite um número" )));
            numeros.add(Integer.parseInt(JOptionPane.showInputDialog(null,"Digite um número" )));
            JOptionPane.showInputDialog(null, numeros, null, 0, null, null, numeros);
        Collections.sort(numeros);
        JOptionPane.showInputDialog(null, numeros, null, 0, null, null, numeros);
    }


}
