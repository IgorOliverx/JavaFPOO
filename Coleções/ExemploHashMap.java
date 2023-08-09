package Coleções;

import java.util.HashMap;

public class ExemploHashMap {
    
    public void teste () {

        //Incluindo elementos na lista (chave/valor)

        HashMap<String,String> estadoCapital = new HashMap<>();
        estadoCapital.put("SP", "São Paulo");
        estadoCapital.put("RJ", "Rio de Janeiro");
        estadoCapital.put("MG", "Minas Gerais");
        estadoCapital.put("ES", "Vitória");
        estadoCapital.put("PR", "Coritiba");

        //Buscando um elemento na lista pelo valor da sua chave
        System.out.println(estadoCapital.get("ES"));


        for (String i : estadoCapital.keySet()) {
            System.out.println(i+ ":" + estadoCapital.get(i));
        }
    }

    public void exercicio() {

        HashMap<String,Integer> nameIdade = new HashMap<>();

      nameIdade.put("Igor", 16);

      for (String i : nameIdade.keySet()) {
          System.out.println(nameIdade.get(i));
        
      }

    }
}
