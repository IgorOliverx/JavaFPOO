package com.example.Model;

public class Vendas {
    private String valorVenda;
    private String dataVenda;
    private String carroVendido;
    private String vendedor;


    public Vendas(String valorVenda, String dataVenda, String carroVendido){
        this.valorVenda = valorVenda;
        this.dataVenda = dataVenda;
        this.carroVendido = carroVendido;
    }


    public String getValorVenda() {
        return valorVenda;
    }


    public void setValorVenda(String valorVenda) {
        this.valorVenda = valorVenda;
    }


    public String getDataVenda() {
        return dataVenda;
    }


    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }


    public String getCarroVendido() {
        return carroVendido;
    }


    public void setCarroVendido(String carroVendido) {
        this.carroVendido = carroVendido;
    }


    public String getVendedor() {
        return vendedor;
    }


    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }


    
}
