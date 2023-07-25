package EstruturaDecisãoifElse;

import java.util.Scanner;
import java.util.function.IntFunction;

public class DecisãoIfElse {
    Scanner sc = new Scanner(System.in);

    // If Desencadeado
    public void decisaoIf() {

        System.out.println("Informe o Preço do produto!");

        double precoProduto = sc.nextDouble();

        double desconto = 0.0;

        // Se o precoProduto for maior ou igual que 100, então o desconto é 5%
        // Se o precoPrduto for menor que 100, então o desconto é 0%

        if (precoProduto >= 100 && precoProduto < 200) {
            desconto = 5.0;
        }

        if (precoProduto >= 200 && precoProduto < 300) {
            desconto = 10.0;
        }
        if (precoProduto >= 300) {
            desconto = 15.0;
        }
        // Se o precoProduto for maior ou igual a 200, então o desconto é 10%
        // Se o preco produto for menor que 200, então o desconto volta a ser 5%

        // realizar a conta

        double valorDesconto = precoProduto * desconto / 100;

        double precoFinal = precoProduto - valorDesconto;

        System.out.println("O valor do seu produto com desconto é R$" + precoFinal + "!");

    }

    // If Encadeado ou If else

    public void decisaoIfElse() {

        System.out.println("Informe o Preço do produto!");

        double precoProduto = sc.nextDouble();

        double desconto;

        // Estrutura de Decisão Encadeada if-else

        if (precoProduto >= 400) { // 1° condição
            desconto = 17;
        } else if (precoProduto >= 300) { // 2° condição
            desconto = 15;
        } else if (precoProduto >= 200) { // 3° condição
            desconto = 10;
        } else if (precoProduto >= 100) { // 4° condição
            desconto = 5;
        } else {
            desconto = 0;
        }

        // realizar a conta
        double valorDesconto = precoProduto * desconto / 100;

        double precoFinal = precoProduto - valorDesconto;

        System.out.println("O valor do seu produto com desconto é R$" + precoFinal + "!");
    }

}
