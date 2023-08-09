package Coleções;

import java.util.LinkedList;

public class ExemploLinkedList {
    LinkedList<String> pessoas = new LinkedList<>();

    public void teste() {
        pessoas.add("Pedro");
        pessoas.add("Maria");
        pessoas.add("João");
        //Adiciona o elemento na primeira posição
        pessoas.addFirst("Cecília");

        System.out.println(pessoas);

        // Remove o último elemento
        pessoas.removeLast();

    }
}
