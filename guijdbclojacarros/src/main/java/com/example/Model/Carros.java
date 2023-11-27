package com.example.Model;

//A classe carros representa a modelagem de dados a partir do banco de dados e uma entidade
public class Carros {
    //atributos
    private String marca;
    private String modelo;
    private String ano;
    private String placa;
    private String valor;


    //Inicializando construtor da classe
    public Carros(String marca, String modelo, String ano, String placa, String valor) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.valor = valor;
    }

    //Construtor vazio
    public Carros(){
        
    }
    


    //métodos especiais
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getAno() {
        return ano;
    }
    public void setAno(String ano) {
        this.ano = ano;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }

    //inicilizando atributos com os metodos especiais getter and settter
    
}
