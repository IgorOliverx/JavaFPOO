package com.example.Model;
public class Clientes {
    private String nome;
    private int idade;
    private String status;


    public Clientes(String nome, int idade, String status) {
        this.nome = nome;
        this.idade = idade;
        this.status = status;
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    //Construtor da Classe
    
}
