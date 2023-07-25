package AtividadeFormativa;

public class App {
    public static void main(String[] args) {
        
        Matriz m = new Matriz();

        m.determinarMatriz();
        m.preencherMatriz();
        m.mostrarMatriz();

        System.out.println("Agora vamos alterar a matriz de acordo com as condicionais impostas:");
        
        m.alterarMatriz();
        m.mostrarMatriz();

    }
}