package RevisaoPOO.Cadastro;

public class Cachorro extends Animais {

    String raca;

    public Cachorro(String porte, double peso, String proprietario, String genero, String especie, String raca) {
        this.porte = porte;
        this.peso = peso;
        this.proprietario = proprietario;
        this.genero = genero;
        this.especie = especie;
        this.raca = raca;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String cachorro) {
        this.especie = cachorro;
    }

    
}
