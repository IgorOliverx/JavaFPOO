package com.example.View;

import java.util.List;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.text.ParseException;

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

        // criando verificacao
        boolean camposObrigatorios = carPlacaField.getText().isEmpty() || carMarcaField.getText().isEmpty()
                || carModeloField.getText().isEmpty();

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

        // Configura a ação do botão "cadastrar" para adicionar um novo registro no
        // banco de dados
        CarrosControl operacoes = new CarrosControl(carros, tableModel, table);

        // ---- AÇÃO DE CADASTRAR CARRO ----
        cadastrar.addActionListener(e -> {
            // Chama o método "cadastrar" do objeto operacoes com os valores dos campos de
            // entrada
            try {
                int ano = Integer.parseInt(carAnoField.getText()); // fazendo verificação de ano
                String car = carValorField.getText();// transformando o valor do input em String
                double num = Double.parseDouble(car);// Passando a string para double
                Locale br = new Locale("pt", "BR");// Padrao brasileiro
                NumberFormat nf = NumberFormat.getCurrencyInstance(br);// numberFormat com a nossa localizacao
                String valorF = nf.format(num);// valorfinal transformado em string depois do tratamento

                //instrução 1 do bloco de verificação
                if (ano > 1900 && ano <= 2024) {

                    //CORRIGIR MODELO ENVIANDO MESMO SEM ESTAR PREENCHIDO
                    // metodo de cadastro
                    operacoes.cadastrar(carMarcaField.getText(), carModeloField.getText(),
                            carAnoField.getText(), carPlacaField.getText(), valorF);
                    // Limpa os campos de entrada após a operação de cadastro
                    carMarcaField.setText("");
                    carModeloField.setText("");
                    carAnoField.setText("");
                    carPlacaField.setText("");
                    carValorField.setText("");

                } else {
                    JOptionPane.showMessageDialog(null, "A data informada é inválida!", "",
                            JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, "Por favor, preencha corretamente os dados", "",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        // ---- AÇÃO DE EDITAR CARRO ----
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

    // metodo para verificacao de campos
    private boolean verificacaoVazio(JTextField campoInput) {
        return campoInput.getText() != null && !campoInput.getText().trim().isEmpty();
        // se o campo for difente de nulo e se o campo pode ter um trecho retirado(isso
        // acontece
        // pq o valor padrão do jtextfield nao e nulo mas equivale a "")
    }

}