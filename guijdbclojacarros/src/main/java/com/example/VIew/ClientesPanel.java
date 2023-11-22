/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.example.View;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.example.Connection.ClientesDAO;
import com.example.Controller.ClientesControl;
import com.example.Model.Clientes;

/**
 *
 * @author DevTarde_A - Igor
 */
public class ClientesPanel extends javax.swing.JPanel {

    private List<Clientes> clientes;

    /**
     * Creates new form ClientesPanel
     */
    public ClientesPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jSeparator1 = new javax.swing.JSeparator();
        labelTitulo = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inputPesquisar = new javax.swing.JTextField();
        labelCpf = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        InputNome = new javax.swing.JTextField();
        labelTelefone = new javax.swing.JLabel();
        btnCadastro = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        InputEmail = new javax.swing.JTextField();
        bntEditar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        InputCpf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        InputTelefone = new javax.swing.JTextField();

        jSeparator1.setAlignmentX(0.0F);

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        labelTitulo.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        labelTitulo.setText("CADASTRO DE CLIENTES");
        add(labelTitulo);
        labelTitulo.setBounds(280, 20, 280, 34);

        labelEmail.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        labelEmail.setText("e-mail");
        add(labelEmail);
        labelEmail.setBounds(230, 150, 70, 23);
        add(jLabel6);
        jLabel6.setBounds(204, 85, 0, 0);

        jLabel2.setIcon(new javax.swing.ImageIcon(
                getClass().getResource("/com/example/View/imagens/user-icon-vector-removebg-preview.png"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(30, 50, 180, 180);

        add(inputPesquisar);
        inputPesquisar.setBounds(580, 290, 190, 22);

        labelCpf.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        labelCpf.setText("CPF");
        add(labelCpf);
        labelCpf.setBounds(510, 150, 90, 20);

        labelNome.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        labelNome.setText("Nome");
        add(labelNome);
        labelNome.setBounds(230, 80, 70, 23);

        add(InputNome);
        InputNome.setBounds(230, 110, 190, 22);
        InputNome.getAccessibleContext().setAccessibleName("inputNome");
        InputNome.getAccessibleContext().setAccessibleDescription("");

        labelTelefone.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        labelTelefone.setText("Telefone");
        add(labelTelefone);
        labelTelefone.setBounds(510, 80, 100, 23);

        btnCadastro.setText("Cadastrar");
        add(btnCadastro);
        btnCadastro.setBounds(40, 290, 100, 23);

        btnLimpar.setText("Limpar");
        add(btnLimpar);
        btnLimpar.setBounds(350, 290, 90, 23);

        add(InputEmail);
        InputEmail.setBounds(230, 180, 190, 22);

        bntEditar.setText("Editar");
        add(bntEditar);
        bntEditar.setBounds(150, 290, 80, 23);

        btnApagar.setText("Apagar");
        add(btnApagar);
        btnApagar.setBounds(250, 290, 90, 23);

        add(InputCpf);
        InputCpf.setBounds(510, 180, 190, 22);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/example/View/imagens/lupa.png"))); // NOI18N
        add(jLabel4);
        jLabel4.setBounds(540, 280, 50, 40);

        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "CPF", "Nome", "Telefone", "Email" });
        table = new JTable(tableModel);
        jScrollPane3.setViewportView(table);

        add(jScrollPane3);
        jScrollPane3.setBounds(0, 330, 810, 170);
        add(jSeparator2);
        jSeparator2.setBounds(70, 50, 690, 20);
        add(jSeparator3);
        jSeparator3.setBounds(50, 380, 750, 70);
        add(jSeparator4);
        jSeparator4.setBounds(30, 320, 750, 20);

        add(InputTelefone);
        InputTelefone.setBounds(510, 110, 190, 22);

        new ClientesDAO().criaTabela();
        atualizarTabela();

        // tratamento de eventos do construtor
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    InputCpf.setText((String) table.getValueAt(linhaSelecionada, 0));
                    InputNome.setText((String) table.getValueAt(linhaSelecionada, 1));
                    InputTelefone.setText((String) table.getValueAt(linhaSelecionada, 2));
                    InputEmail.setText((String) table.getValueAt(linhaSelecionada, 3));
                }
            }
        });

        ClientesControl operacoes = new ClientesControl(clientes, tableModel, table);

        // ---- AÇÃO DE CADASTRAR CLIENTE ----
        btnCadastro.addActionListener(e -> {
            operacoes.cadastrar(InputNome.getText(), InputCpf.getText(),
                    InputTelefone.getText(), InputEmail.getText());
            // Limpa os campos de entrada após a operação de cadastro
            InputNome.setText("");
            InputCpf.setText("");
            InputTelefone.setText("");
            InputEmail.setText("");
        });

        // ---- AÇÃO DE EDITAR CLIENTE ----
        bntEditar.addActionListener(e -> {
            // Chama o método "atualizar" do objeto operacoes com os valores dos
            // campos de entrada
            operacoes.atualizar(InputNome.getText(), InputCpf.getText(),
                    InputTelefone.getText(), InputEmail.getText());
            // Limpa os campos de entrada após a operação de atualização
            InputNome.setText("");
            InputCpf.setText("");
            InputTelefone.setText("");
            InputEmail.setText("");
        });

        // Configura a ação do botão "apagar" para excluir um registro no banco de dados
        btnApagar.addActionListener(e -> {
            // Chama o método "apagar" do objeto operacoes com o valor do campo de
            // entrada "placa"
            operacoes.apagar(InputEmail.getText());
            // Limpa os campos de entrada após a operação de exclusão
            InputNome.setText("");
            InputCpf.setText("");
            InputTelefone.setText("");
            InputEmail.setText("");
        });

    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField InputCpf;
    private javax.swing.JTextField InputEmail;
    private javax.swing.JTextField InputNome;
    private javax.swing.JTextField InputTelefone;
    private javax.swing.JButton bntEditar;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnCadastro;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JTextField inputPesquisar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel labelCpf;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelTelefone;
    private javax.swing.JLabel labelTitulo;
    private DefaultTableModel tableModel;
    private JTable table;
    private int linhaSelecionada = -1;

    // End of variables declaration//GEN-END:variables

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        // tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        tableModel.setRowCount(0);
        clientes = new ClientesDAO().listarTodos();
        // Obtém os clientes atualizados do banco de dados
        for (Clientes cliente : clientes) {
            // Adiciona os dados de cada cliente como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { cliente.getNome(), cliente.getEmail(),

                    cliente.getTelefone(), cliente.getCpf() });

        }
    }
}
