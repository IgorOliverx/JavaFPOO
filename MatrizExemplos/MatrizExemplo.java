package MatrizExemplos;

import java.util.Random;
import java.util.Scanner;

public class MatrizExemplo {
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();
    public void exemplo1() {
        //exemplo de criação/preenchimento/impressão de matriz
        //declara a minha matriz de 2 dimensões
        int tab[][]=new int[10][9];
        //preencher a matriz
        for (int i = 0; i < 10; i++) {
            // laço vai percorrer a 1ª dimensão da matriz
            for (int j = 0; j < 9; j++) {
                // laço vai preencher a 2º dimensão da matriz
                //System.out.print("tab["+i+"]["+j+"]=");
                tab[i][j]=rd.nextInt(1,9);//preencher o valor na posição               
            }          
        }
        //Imprimir a minha matriz
        for (int i = 0; i < 10; i++) {
            // laço vai percorrer a 1ª dimensão da matriz
            for (int j = 0; j < 9; j++) {
                // laço vai preencher a 2º dimensão da matriz
                System.out.println("tab["+i+"]["+j+"]="+tab[i][j]);              
            }          
        }
        //Imprimindo em Formato de Matriz
        for (int i = 0; i < 10; i++) {
            // laço vai percorrer a 1ª dimensão da matriz
            System.out.print("| ");   
            for (int j = 0; j < 9; j++) {
                // laço vai preencher a 2º dimensão da matriz
                System.out.print(+tab[i][j]+" ");              
            }   
            System.out.println(" |");       
        }
    }





        public void exemplo2 (){
        int matriz [] [] = new int [5] [5]; //criando a matriz


        for (int i = 0; i < 5; i++) { //linhas
            System.out.print("|");
             
            for (int j = 0; j < 5; j++) { //colunas
                if (i==j) {
                    System.out.print("1 ");
                }else {
                System.out.print("0 ");
            }              
            }   
            System.out.println("|");       
        }


    }
    
    
    
    public void exemplo3(){

        int matriz[][]=new int[4][4];
        //preenchimento da matriz
        for (int i = 0; i < matriz.length; i++) { //percorrer as linhas
            for (int j = 0; j < matriz.length; j++) { //percorrer as colunas da linha 
               matriz [i] [j] = rd.nextInt(1,10);             
            }          
        }
        System.out.println("Aqui temos a matriz principal");
        //imprimir a matriz
        for (int i = 0; i < matriz.length; i++) {
            // laço vai percorrer a 1ª dimensão da matriz
            System.out.print("| ");   
            for (int j = 0; j < matriz.length; j++) {
                // laço vai preencher a 2º dimensão da matriz
                System.out.print(" "+matriz[i][j]);              
            }   
            System.out.println(" |");       
        }
        System.out.println("Aqui temos a matriz transposta");
        //imprimir a matriz transposta
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("| ");   
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(" "+matriz[j][i]);              
            }   
            System.out.println(" |");       
        }

        //soma dos elementos da diagonal principal
        //diagonal principal é quando o i==j 
        int soma = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if(i==j) {
                    soma+=matriz[i][j];
                    
                }
            }
            
        }
        System.out.println("A soma da diagonal é "+ soma);





    }

    public void exemplo4() {
        int matriz[][]=new int[4][4];
        //preenchimento da matriz
        for (int i = 0; i < matriz.length; i++) { //percorrer as linhas
            for (int j = 0; j < matriz.length; j++) { //percorrer as colunas da linha 
               matriz [i] [j] = rd.nextInt(1,10);             
            }          
        }
        System.out.println("Aqui temos a matriz principal");
        //imprimir a matriz
        for (int i = 0; i < matriz.length; i++) {
            // laço vai percorrer a 1ª dimensão da matriz
            System.out.print("| ");   
            for (int j = 0; j < matriz.length; j++) {
                // laço vai preencher a 2º dimensão da matriz
                System.out.print(" "+matriz[i][j]);              
            }   
            System.out.println(" |");       
        }
       
     
        int soma = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if(i>j) {
                    soma+=matriz[i][j];   
                }
                
            }
            
        }
        System.out.println("A soma dos elementos abaixo da diagonal é "+ soma);

    }

    public void exemplo5(){
        int matriz[][]=new int[4][4];
        //preenchimento da matriz
        for (int i = 0; i < matriz.length; i++) { //percorrer as linhas
            for (int j = 0; j < matriz.length; j++) { //percorrer as colunas da linha 
               matriz [i] [j] = rd.nextInt(1,10);             
            }          
        }
        System.out.println("Aqui temos a matriz principal");
        //imprimir a matriz
        for (int i = 0; i < matriz.length; i++) {
            // laço vai percorrer a 1ª dimensão da matriz
            System.out.print("| ");   
            for (int j = 0; j < matriz.length; j++) {
                // laço vai preencher a 2º dimensão da matriz
                System.out.print(" "+matriz[i][j]);              
            }   
            System.out.println(" |");       
        }
       
       
        int soma = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if(i<j) {
                    soma+=matriz[i][j];
                    
                }
            }
            
        }
        System.out.println("A soma dos elementos acima da diagonal é "+ soma);

    }

    
}




