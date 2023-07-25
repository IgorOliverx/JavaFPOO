package EstruturaDecisaoSwitch;

import java.util.Scanner;

public class SwitchCase {
Scanner sc = new Scanner(System.in);

    public void letra() {

System.out.println("Digite uma letra do alfabeto:");
String letra = sc.nextLine();
switch (letra) {
    case "a":System.out.println(letra+" É uma vogal");
    break;
    case "e":System.out.println(letra+ " É uma vogal");
    break;
    case "i":System.out.println(letra+ " É uma vogal");
    break;
    case "o":System.out.println(letra+ " É uma vogal");
    break;
    case "u":System.out.println(letra+ " É uma vogal");
    break;
    default:System.out.println(letra+ " É consoante");
    break;


}

}

public void meses() {

    System.out.println("Digite um número entre 1 e 12:");
int meses = sc.nextInt();
switch (meses) {
    case 1:System.out.println(meses+" É o Mês de Janeiro!");
    break;
    case 2:System.out.println(meses+ " É O Mês de Fevereiro!");
    break;
    case 3:System.out.println(meses+ " É o Mês de Março!");
    break;
    case 4:System.out.println(meses+ " É o Mês de Abril!");
    break;
    case 5:System.out.println(meses+ " É o Mês de Maio!");
    break;
    case 6:System.out.println(meses+" É o Mês de Junho!");
    break;
    case 7:System.out.println(meses+ " É o Mês de Julho!");
    break;
    case 8:System.out.println(meses+ " É o Mês de Agosto!");
    break;
    case 9:System.out.println(meses+ " É o Mês de Setembro");
    break;
    case 10:System.out.println(meses+ " É o Mês de Outubro");
    break;
    case 11:System.out.println(meses+ " É o Mês de Novembro");
    break;
    case 12:System.out.println(meses+ " É o Mês de Dezembro");
    break;
    default:System.out.println("NÃO RECONHECIDO");
    break;


}



}
}
