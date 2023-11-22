package com.example.View;


import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.example.Connection.CarrosDAO;
import com.example.Model.Carros;

import java.util.List;


public class VendasPainel extends JPanel {
    JComboBox<String> carrosComboBox;
    List <Carros> carros;

    public VendasPainel() {
        carrosComboBox = new JComboBox<>();

        //preencha o jcombobox
        carros = new CarrosDAO().listarTodos();
        carrosComboBox.addItem("Selecione o carro");
        for(Carros carro : carros){
            carrosComboBox.addItem(carro.getMarca()
            +" "+ carro.getModelo()
            +" "+ carro.getPlaca());
        }
        add(carrosComboBox);
    }
}
