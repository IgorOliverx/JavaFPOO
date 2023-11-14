package com.example.VIew;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.example.Connection.CarrosDAO;
import com.example.Controller.CarrosControl;
import com.example.Model.Carros;

import javafx.event.ActionEvent;

public class CarrosPainel extends JPanel {
    // Atributos(componentes)
    private JButton cadastrar, apagar, editar, limpar;
    private JTextField carMarcaField, carModeloField, carAnoField, carPlacaField,
            carValorField;
    private List<Carros> carros;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    // Construtor(GUI-JPanel)
    public CarrosPainel() {
        super();
        // entrada de dados
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastro Carros"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Marca"));
        carMarcaField = new JTextField(20);
        inputPanel.add(carMarcaField);
        inputPanel.add(new JLabel("Modelo"));
        carModeloField = new JTextField(20);
        inputPanel.add(carModeloField);
        inputPanel.add(new JLabel("Ano"));
        carAnoField = new JTextField(20);
        inputPanel.add(carAnoField);
        inputPanel.add(new JLabel("Placa"));
        carPlacaField = new JTextField(20);
        inputPanel.add(carPlacaField);
        inputPanel.add(new JLabel("Valor"));
        carValorField = new JTextField(20);
        inputPanel.add(carValorField);
        add(inputPanel);
        JPanel botoes = new JPanel();
        botoes.add(cadastrar = new JButton("Cadastrar"));
        botoes.add(editar = new JButton("Editar"));
        botoes.add(apagar = new JButton("Apagar"));
        botoes.add(limpar = new JButton("Limpar"));
        add(botoes);
        // tabela de carros
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Marca", "Modelo", "Ano", "Placa", "Valor" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        // criar a tabela caso nao exista
        new CarrosDAO().criaTabela();
        // atualizar a tabela na abertura da janela
        atualizarTabela();

        // tratamento de eventos do construtor
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    carMarcaField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    carModeloField.setText((String) table.getValueAt(linhaSelecionada, 1));
                    carAnoField.setText((String) table.getValueAt(linhaSelecionada, 2));
                    carPlacaField.setText((String) table.getValueAt(linhaSelecionada, 3));
                    carValorField.setText((String) table.getValueAt(linhaSelecionada, 4));
                }
            }
        });

        CarrosControl operacoes = new CarrosControl(carros, tableModel, table);
        // Configura a ação do botão "cadastrar" para adicionar um novo registro no
        // banco
        // de dados

        cadastrar.addActionListener(e -> {
            // Chama o método "cadastrar" do objeto operacoes com os valores dos
            // campos de entrada

            try{ 
            int ano = Integer.parseInt(carAnoField.getText());
            int valor = Integer.parseInt(carValorField.getText());
             if (ano > 1900 && ano <= 2024) {
                operacoes.cadastrar(carMarcaField.getText(), carModeloField.getText(),
                        carAnoField.getText(), carPlacaField.getText(), carValorField.getText());
                // Limpa os campos de entrada após a operação de cadastro
                carMarcaField.setText("");
                carModeloField.setText("");
                carAnoField.setText("");
                carPlacaField.setText("");
                carValorField.setText("");
             }else {
                JOptionPane.showMessageDialog(null, "A data informada é inválida", "", JOptionPane.WARNING_MESSAGE);
            }
        }catch(Exception erro){
                JOptionPane.showMessageDialog(null, "Dados inseridos inválidos", "", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Configura a ação do botão "editar" para atualizar um registro no banco de
        // dados
        editar.addActionListener(e -> {
            // Chama o método "atualizar" do objeto operacoes com os valores dos
            // campos de entrada
            operacoes.atualizar(carMarcaField.getText(), carModeloField.getText(),
                    carAnoField.getText(), carPlacaField.getText(), carValorField.getText());
            // Limpa os campos de entrada após a operação de atualização
            carMarcaField.setText("");
            carModeloField.setText("");
            carAnoField.setText("");
            carPlacaField.setText("");
            carValorField.setText("");
        });

        // Configura a ação do botão "apagar" para excluir um registro no banco de dados
        apagar.addActionListener(e -> {
            // Chama o método "apagar" do objeto operacoes com o valor do campo de
            // entrada "placa"
            operacoes.apagar(carPlacaField.getText());
            // Limpa os campos de entrada após a operação de exclusão
            carMarcaField.setText("");
            carModeloField.setText("");
            carAnoField.setText("");
            carPlacaField.setText("");
            carValorField.setText("");
        });

    }

    // método(atualizar tabela)
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        carros = new CarrosDAO().listarTodos();
        // Obtém os carros atualizados do banco de dados
        for (Carros carro : carros) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { carro.getMarca(), carro.getModelo(),

                    carro.getAno(), carro.getPlaca(), carro.getValor() });
        }
    }
}