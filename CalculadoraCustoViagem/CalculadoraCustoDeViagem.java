public class CalculadoraCustoDeViagem {
    public static void main(String[] args) {
        System.out.println("=Calculadora de Custo de Viagem");
        int distanciaPercorrida = 222;
        int tempoGasto = 3;
        int autonomiaDaViagem = 10;
        int preçoGasolina = 5; // fazendo teste de versionamento 
        int custoAdicionais = 56;
        float combustivelUsado = distanciaPercorrida / autonomiaDaViagem;
        float custoFinal = combustivelUsado * preçoGasolina;
        float valorTotalGasto = custoFinal + custoAdicionais;
        System.out.println("A distância percorrida foi de" + distanciaPercorrida + "km");
        System.out.println("o tempo gasto foi de" + tempoGasto + "horas");
        System.out.println("O combustível custou R$" + preçoGasolina + "por litro");
        System.out.println("A autonomia do veículo ficou na casa dos" + autonomiaDaViagem + "km/l");
        System.out.println("O valor total investido para realizar o percurso foi de:");
        System.out.println("R$" + valorTotalGasto);
    }
}
