package ArrayList;
import java.util.*;




public class ArrayList {

    int add;
    int cont;
     //Criar um vetor com o tamanho cont
      //copiar o primeiro vetor que foi criado, e criar um novo com uma posição a mais ou seja cont++
    int v1[] = new int[cont];
    


    public void add(int add) {
        int v2[] = new int [cont+1];
        //copiei o vetor 1 para o vetor 2. Mas, note que o vetor 2 é maior, então ele conta com um espaço vazio
        for (int i = 0; i < v1.length; i++) {
            v2[i] = v1[i];
        }
        //adicionei o valor do add na última posição do vetor 2
        v2[v2.length-1] = add;
        
        
        
        
        //agora copiarei o v2 para o v1 redefinindo o tamanho do v1;
        int v1[] = new int[cont+1];
        for (int i = 0; i < v2.length; i++) {
            v1[i] = v2[i];
        }
        
        
        cont++;       
    }

    public void imprimir(){
        for (int i = 0; i < v1.length; i++) {
            System.out.println(v1[i]);
        }
    }
}