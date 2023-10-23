package GUISerializacao.src;

import java.io.Serializable;

public class Agenda implements Serializable {
    private String descricao;
    private int data,hora;
    
    public Agenda(String descricao, int data, int hora) {
        this.descricao = descricao;
        this.data = data;
        this.hora = hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

   
}
