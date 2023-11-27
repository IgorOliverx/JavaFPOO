package com.example.Controller;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.example.Connection.ClientesDAO;
import com.example.Connection.VendasDAO;
import com.example.Model.Vendas;

public class VendasController {
     private List<Vendas> vendas;
    private DefaultTableModel tableModel;
    private JTable table;
    
    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        vendas = new VendasDAO().listarTodos();
        // Obtém os clientes atualizados do banco de dados
        for (Vendas venda : vendas) {
            // Adiciona os dados de cada cliente como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { venda.getModeloVeiculo(), venda.getMarcaVeiculo(),

                    venda.getPlacaVeiculo(), venda.getVendedor(), venda.getValorVenda(), venda.getComprador(), venda.getDataVenda()});
        }
    }

     // Método para cadastrar um novo cliente no banco de dados
     public void cadastrar(String modelo, String marca, String placa, String vendedor, String valor, String comprador, String data) {
        new VendasDAO().vender(modelo, marca, placa, vendedor, valor, comprador, data);
        // Chama o método de cadastro no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após o cadastro
    }

    
}
