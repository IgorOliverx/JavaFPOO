package com.example.Controller;

import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.example.Model.Clientes;
import com.example.Connection.CarrosDAO;
import com.example.Connection.ClientesDAO;
public class ClientesControl {
     private List<Clientes> clientes;
    private DefaultTableModel tableModel;
    private JTable table;

    //Construtor inicializando atributos
    public ClientesControl(List<Clientes> clientes, DefaultTableModel tableModel, JTable table) {
        this.clientes = clientes;
        this.tableModel = tableModel;
        this.table = table;
    }

    //Construtor vazio
    public ClientesControl(){
    }


    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        clientes = new ClientesDAO().listarTodos();
        // Obtém os clientes atualizados do banco de dados
        for (Clientes cliente : clientes) {
            // Adiciona os dados de cada cliente como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { cliente.getNome(), cliente.getEmail(),

                    cliente.getTelefone(), cliente.getCpf()});
        }
    }

     // Método para cadastrar um novo cliente no banco de dados
     public void cadastrar(String nome, String email, String telefone, String cpf) {
        new ClientesDAO().cadastrar(nome, email, telefone, cpf);
        // Chama o método de cadastro no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após o cadastro
    }

     // Método para atualizar os dados de um cliente no banco de dados
    public void atualizar(String nome, String email, String telefone, String cpf) {
        new ClientesDAO().atualizar(nome, email, telefone, cpf);
        // Chama o método de atualização no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a atualização
    }

    // Método para apagar um carro do banco de dados
    public void apagar(String cpf) {
        new ClientesDAO().apagar(cpf);
        // Chama o método de exclusão no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a exclusão
    }











    










}
