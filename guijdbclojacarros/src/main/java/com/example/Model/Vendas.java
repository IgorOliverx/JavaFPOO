package com.example.Model;

public class Vendas {

    // Atributos
    private String marca;
    private String modelo;
    private String valor;
    private String placa;
    private String cliente;
    private String dataHora;

    


    public Vendas(String marca, String modelo, String valor, String placa, String cliente, String dataHora) {
        this.marca = marca;
        this.modelo = modelo;
        this.valor = valor;
        this.placa = placa;
        this.cliente = cliente;
        this.dataHora = dataHora;
    }

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
    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public String getDataHora() {
        return dataHora;
    }
    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    // Construtor

}