package com.example.VIew;

import java.util.function.Supplier;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.plaf.DimensionUIResource;

import com.example.Main;




public class JanelaPrincipal extends JFrame {
    // criação do tabbedPane para incluir as tabs
    private JTabbedPane jTPane;

    public JanelaPrincipal() {
        super("Dashboard - Controle de vendas");
        setResizable(false);

        jTPane = new JTabbedPane();
        add(jTPane);
        // criandos as tabs
        // tab1 carros
        CarrosPainel tab1 = new CarrosPainel();
        jTPane.add("Carros", tab1);
        setBounds(200, 200, 832, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ClientesPainel tab2 = new ClientesPainel();
        jTPane.add("Clientes", tab2);
        VendasPainel tab3 = new VendasPainel();
        jTPane.add("Vendas",tab3); 
       
    }

    // métodos para tornar a janela visível
    public void run() {
        this.setVisible(true);
    }
}
