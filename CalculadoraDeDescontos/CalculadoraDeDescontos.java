package CalculadoraDeDescontos;

public class CalculadoraDeDescontos {

    public void calcula20() {

        double precoProduto;
        precoProduto = 200;

        int desconto = 20;
        double precoComDesconto = precoProduto - (precoProduto * desconto / 100);
        System.out.println("O valor do produto com Desconto é" + precoComDesconto + "R$");

    }



public void calcula30() {

    double precoProduto;
    precoProduto = 200;

    int desconto = 30;
    double precoComDesconto = precoProduto - (precoProduto * desconto / 100);
    System.out.println("O valor do produto com Desconto é" + precoComDesconto + "R$");

}

public void calcula50() {

    double precoProduto;
    precoProduto = 200;

    int desconto = 50;
    double precoComDesconto = precoProduto - (precoProduto * desconto / 100);
    System.out.println("O valor do produto com Desconto é" + precoComDesconto + "R$");

}

}
