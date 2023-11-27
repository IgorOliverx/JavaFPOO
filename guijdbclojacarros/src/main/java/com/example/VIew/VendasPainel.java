package com.example.View;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.example.Connection.CarrosDAO;
import com.example.Connection.ClientesDAO;
import com.example.Model.Carros;
import com.example.Model.Clientes;


import java.util.List;


public class VendasPainel extends JPanel {
    //atributos da aplicação
    JComboBox<String> carrosComboBox;
    List <Carros> carros;//retorno da lista de carros

    JComboBox<String> clientesComboBox;
    List <Clientes> clientes;//retorno da lista de clientes


    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    private JButton btnVender;
    private JButton btnAtualizar;

    public VendasPainel() {
        carrosComboBox = new JComboBox<>();
        clientesComboBox = new JComboBox<>();

        //preencha o jcombobox
        carros = new CarrosDAO().listarTodos();
        carrosComboBox.addItem("Selecione o carro");
        for(Carros carro : carros){
            carrosComboBox.addItem(carro.getMarca()
            +" "+ carro.getModelo()
            +"   -   "+ carro.getPlaca());
        }
        add(carrosComboBox);

        clientes = new ClientesDAO().listarTodos();
        clientesComboBox.addItem("Selecione o cliente");
        for(Clientes cliente : clientes){
            clientesComboBox.addItem(cliente.getNome()
            +"   -   "+ cliente.getCpf()
            );
        }
        add(clientesComboBox);

        btnVender = new JButton("Vender");
        add(btnVender);
        btnAtualizar = new JButton("Atualizar");
        add(btnAtualizar);

         // tabela de carros
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Modelo", "Marca", "Placa", "Vendedor", "Valor", "Comprador", "Data" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);


    }
}
