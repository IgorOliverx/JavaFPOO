package com.example.Model;

public class Vendas {
    
    private String modeloVeiculo;
    private String marcaVeiculo;
    private String placaVeiculo;
    private String vendedor;
    private String valorVenda;
    private String comprador;
    private String dataVenda;

    //Construtor inicializando atributos
    public Vendas(String modeloVeiculo, String marcaVeiculo, String placaVeiculo, String vendedor, String valorVenda, String comprador, String dataVenda) {
        this.modeloVeiculo = modeloVeiculo;
        this.marcaVeiculo = marcaVeiculo;
        this.placaVeiculo = placaVeiculo;
        this.vendedor = vendedor;
        this.valorVenda = valorVenda;
        this.comprador = comprador;
        this.dataVenda = dataVenda;
    }

    //construtor vazio
    public Vendas() {}

    //métodos especiais
    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public String getMarcaVeiculo() {
        return marcaVeiculo;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public String getVendedor() {
        return vendedor;
    }

    public String getValorVenda() {
        return valorVenda;
    }

    public String getComprador() {
        return comprador;
    }

    public String getDataVenda() {
        return dataVenda;
    }
    

    



   
    
}
