package com.example.View;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientesPainel extends JPanel{
    private JTextField nomeField, cpField, telefoneField, enderecoField, cidadeField;
    private JButton limpar, cadastrar;
    public ClientesPainel() {
        super();
        setLayout(new BorderLayout());
        add(new JLabel("Cadastro de Cliente"), BorderLayout.NORTH);

        JPanel painel = new JPanel();
        this.add(painel, BorderLayout.CENTER);
        painel.add(nomeField = new JTextField());



    }
}
