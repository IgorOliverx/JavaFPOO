package com.example.VIew;

import java.util.List;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JFormattedTextField;

import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import java.awt.GridLayout;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.text.ParseException;

import com.example.Connection.CarrosDAO;
import com.example.Controller.CarrosControl;
import com.example.Model.Carros;

public class CarrosPainel extends JPanel {
    // Atributos(componentes)
    private JButton cadastrar, apagar, editar, limpar;
    private JFormattedTextField carMarcaField, carModeloField, carAnoField, carPlacaField,
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
        carMarcaField = new JFormattedTextField();
        inputPanel.add(carMarcaField);

        inputPanel.add(new JLabel("Modelo"));
        carModeloField = new JFormattedTextField();
        inputPanel.add(carModeloField);

        inputPanel.add(new JLabel("Ano"));
        carAnoField = new JFormattedTextField(formatar("####"));
        inputPanel.add(carAnoField);

        inputPanel.add(new JLabel("Placa"));
        carPlacaField = new JFormattedTextField(formatar("UUU-####"));
        inputPanel.add(carPlacaField);

        inputPanel.add(new JLabel("Valor"));
    carValorField = new JFormattedTextField();
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

                // instrução 1 do bloco de verificação
                if (ano > 1900 && ano <= 2024) {
                     
                        // criando verificacao
                     boolean camposObrigatorios = carPlacaField.getText().isEmpty() || carMarcaField.getText().isEmpty()
                || carModeloField.getText().isEmpty();
                  
                 
                    if(camposObrigatorios){
                         JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!", "",
                            JOptionPane.WARNING_MESSAGE);
                    }else{
                    operacoes.cadastrar(carMarcaField.getText(), carModeloField.getText(),
                            carAnoField.getText(), carPlacaField.getText(), valorF);
                    // Limpa os campos de entrada após a operação de cadastro
                    limparCampos();

                }} else {
                    JOptionPane.showMessageDialog(null, "O ano informado é inválido!", "",
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
            limparCampos();
        });

        // Configura a ação do botão "apagar" para excluir um registro no banco de dados
        apagar.addActionListener(e -> {
            // Chama o método "apagar" do objeto operacoes com o valor do campo de
            // entrada "placa"
            operacoes.apagar(carPlacaField.getText());
            // Limpa os campos de entrada após a operação de exclusão
           limparCampos();
        });

        limpar.addActionListener(e ->{
            limparCampos();
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

    private void limparCampos(){
            carMarcaField.setText("");
            carModeloField.setText("");
            carAnoField.setText("");
            carPlacaField.setText("");
            carValorField.setText("");
    }

     private MaskFormatter formatar(String mascara){
        MaskFormatter mask = null;
        try{
            mask = new MaskFormatter(mascara);
        }catch(ParseException e){
            System.out.println("Formatacao com erro"+ e);
        }
        return mask;
    }

}