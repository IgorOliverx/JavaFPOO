package com.example.View;

import javax.swing.*;
import java.awt.*;
import com.example.Model.Carros;
import com.example.Connection.*;
import com.example.Controller.*;

public class VendasView extends JPanel {
    JComboBox<String> carrosComboBox;

    public VendasView() {
        super();
        carrosComboBox = new JComboBox<>();

        //preenche o jcombobox com os carros

    }
}
