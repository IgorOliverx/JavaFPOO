import javax.swing.JOptionPane;

public class Carros {
    String cor;
    String modelo;
    String marca;
    String ano;

    public Carros(String cor, String modelo, String marca, String ano) {
        this.cor = cor;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
    }




    public Carros() {

    }
    

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

}
