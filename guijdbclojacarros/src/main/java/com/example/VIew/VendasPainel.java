package com.example.VIew;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JFormattedTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.example.Connection.CarrosDAO;
import com.example.Connection.ClientesDAO;
import com.example.Connection.VendasDAO;
import com.example.Controller.VendasController;
import com.example.Model.Carros;
import com.example.Model.Clientes;
import com.example.Model.Vendas;

public class VendasPainel extends JPanel {
    // Atributos
    private JButton vender, apagar, limpar, atualizar;
    private JFormattedTextField inputMarca, inputModelo, inputValorVenda, inputPlaca, inputCliente,
            inputData;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;
    private List<Carros> carros;
    private List<Clientes> clientes;
    private List<Vendas> vendas;
    JComboBox<String> carrosComboBox;
    JComboBox<String> clientesComboBox;

    public VendasPainel() {
        super();
        // entrada de dados
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastro Carros"));
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new GridLayout(6, 2));

        painelPrincipal.add(new JLabel("Marca:"));
        inputMarca = new JFormattedTextField();
        painelPrincipal.add(inputMarca);

        painelPrincipal.add(new JLabel("Modelo:"));
        inputModelo = new JFormattedTextField();
        painelPrincipal.add(inputModelo);

        painelPrincipal.add(new JLabel("Valor:"));
        inputValorVenda = new JFormattedTextField();
        painelPrincipal.add(inputValorVenda);

        painelPrincipal.add(new JLabel("Placa:"));
        inputPlaca = new JFormattedTextField();
        painelPrincipal.add(inputPlaca);

        painelPrincipal.add(new JLabel("Cliente:"));
        inputCliente = new JFormattedTextField();
        painelPrincipal.add(inputCliente);

        painelPrincipal.add(new JLabel("Data:"));
        inputData = new JFormattedTextField(formatar("##/##/####"));
        painelPrincipal.add(inputData);

        carrosComboBox = new JComboBox<>();
        clientesComboBox = new JComboBox<>();

        // Preenchendo o JComboBox com os carros
        carros = new CarrosDAO().listarTodos();
        carrosComboBox.addItem("Selecione o Carro");
        for (Carros carro : carros) {
            carrosComboBox.addItem(
                    carro.getMarca() + " - " + carro.getModelo() + " - " + carro.getValor() + " - " + carro.getPlaca());
        }
        add(carrosComboBox);


        // Preenchendo o JComboBox com os clientes
        clientes = new ClientesDAO().listarTodos();
        clientesComboBox.addItem("Selecione o Cliente");
        for (Clientes cliente : clientes) {
            clientesComboBox.addItem(cliente.getNome() +" - "+ cliente.getEmail());
        }
        add(clientesComboBox);
        add(painelPrincipal);


        JPanel botoes = new JPanel();
        botoes.add(vender = new JButton("Vender"));
        botoes.add(apagar = new JButton("Excluir venda"));
        botoes.add(limpar = new JButton("Limpar"));
        botoes.add(atualizar = new JButton("Atualizar"));
        add(botoes);

        // tabela de carros
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Marca", "Modelo", "Valor", "Placa", "Cliente", "Data e Hora" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        // Criar a tabela se ela não existir
        new VendasDAO().criaTabela();
        // Atualizar a Tabela na Abertura da Janela
        atualizarTabela();

        // Seleção das linhas
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    inputMarca.setText((String) table.getValueAt(linhaSelecionada, 0));
                    inputModelo.setText((String) table.getValueAt(linhaSelecionada, 1));
                    inputValorVenda.setText((String) table.getValueAt(linhaSelecionada, 2));
                    inputPlaca.setText((String) table.getValueAt(linhaSelecionada, 3));
                    inputCliente.setText((String) table.getValueAt(linhaSelecionada, 4));
                    inputData.setText((String) table.getValueAt(linhaSelecionada, 5));
                }
            }
        });

        //Instanciando objeto do controller para realizar ações 
        VendasController operacoes = new VendasController(vendas, tableModel, table);

        carrosComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verifica se não é a primeira opção ("Selecione o Carro")
                if (carrosComboBox.getSelectedIndex() != 0) {
                    // Obtém o índice do carro selecionado
                    int selectedIndex = carrosComboBox.getSelectedIndex() - 1; // Desconta o índice do título

                    // Obtém o carro selecionado com base no índice
                    Carros carroSelecionado = carros.get(selectedIndex);

                    // Define os valores nos campos de texto com as informações do carro selecionado
                    inputMarca.setText(carroSelecionado.getMarca());
                    inputModelo.setText(carroSelecionado.getModelo());
                    inputValorVenda.setText(String.valueOf(carroSelecionado.getValor())); // Se for numérico
                    inputPlaca.setText(carroSelecionado.getPlaca());

                } else {
                    inputMarca.setText("");
                    inputModelo.setText("");
                    inputValorVenda.setText("");
                    inputPlaca.setText("");
                }
            }
        });

        clientesComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verifica se não é a primeira opção ("Selecione o Carro")
                if (clientesComboBox.getSelectedIndex() != 0) {
                    // Obtém o índice do carro selecionado
                    int selectedIndex = clientesComboBox.getSelectedIndex() - 1; // Desconta o índice do título

                    // Obtém o carro selecionado com base no índice
                    Clientes clienteSelecionado = clientes.get(selectedIndex);

                    // Define os valores nos campos de texto com as informações do carro selecionado
                    inputCliente.setText(clienteSelecionado.getNome());

                } else {
                    inputCliente.setText("");
                }
            }
        });

        vender.addActionListener(e -> {
            //Pegando as informações de todos os campos dos inputs
            String marca = inputMarca.getText();
            String modelo = inputModelo.getText();
            String valor = inputValorVenda.getText();
            String placa = inputPlaca.getText();
            String cliente = inputCliente.getText();
            String dataHora = inputData.getText();
        
            //realizando verificação de dados vazios
            if (marca.isEmpty() || modelo.isEmpty() || valor.isEmpty() || placa.isEmpty() ||
                    cliente.isEmpty() || dataHora.isEmpty()) {
                exibirErro("Não é Possível Vender Dados Vazios!");
                return;
            }
        
            //Pegando posição dos índices 
            int indexCarros = carrosComboBox.getSelectedIndex();
            int indexClientes = clientesComboBox.getSelectedIndex();
        
            //Verificação em caso do indíce não corresponder a informação
            if (indexCarros <= 0 || indexClientes <= 0) {
                exibirErro("Preencha os Campos Corretamente!");
                return;
            }
        
            //Instanciando objetos da classe de carros e clientes para verificar as informações
            Carros carroSelecionado = carros.get(indexCarros - 1);
            Clientes clienteSelecionado = clientes.get(indexClientes - 1);
        
            //Verificação para agerir se o campo selecionado é correspondente ao banco de dados(impede de trocar infos manualmente)
            boolean camposIguais = marca.equals(carroSelecionado.getMarca()) &&
                    modelo.equals(carroSelecionado.getModelo()) &&
                    placa.equals(carroSelecionado.getPlaca()) &&
                    cliente.equals(clienteSelecionado.getNome()) &&
                    !dataHora.isEmpty();
        
            if (!camposIguais) {
                exibirErro("Preencha os Campos Corretamente!");
            } else {
                operacoes.apagarCarro(placa);
                operacoes.vender(marca, modelo, valor, placa, cliente, dataHora);
                limparCamposCarro();
            }
        });

      limpar.addActionListener(e -> {
        limparCamposCarro();
      });

      //atualizar o cliente adicionado por ultimo para nao ter que fechar o programa
      atualizar.addActionListener(e -> {
        clientes = new ClientesDAO().listarTodos();
        carros = new CarrosDAO().listarTodos();
        if (!clientes.isEmpty() && !carros.isEmpty()) {
            Clientes ultimoCliente = clientes.get(clientes.size() - 1);
            clientesComboBox.addItem(ultimoCliente.getNome() + " - " + ultimoCliente.getEmail());
            Carros ultimoCarro = carros.get(carros.size() -1);
            carrosComboBox.addItem(ultimoCarro.getMarca()+ " - "+ ultimoCarro.getModelo()+" - "+ ultimoCarro.getPlaca());
        }
    });
    

     
        apagar.addActionListener(e -> {

            //verificando se os campos estao vazio
            boolean camposVendaVazio = inputMarca.getText().isEmpty() || inputModelo.getText().isEmpty()
                    || inputValorVenda.getText().isEmpty() || inputPlaca.getText().isEmpty()
                    || inputCliente.getText().isEmpty() || inputData.getText().isEmpty();

            if (camposVendaVazio) {
               exibirErro("Por favor, selecione uma venda");
            } else if (JOptionPane.showConfirmDialog(null, "Deseja excluir esse registro de venda??",
                    null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                operacoes.apagar(inputPlaca.getText());

                // Método para limpar os campos após a exclusão
                limparCamposCarro();

            }
        });
   
    }

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        vendas = new VendasDAO().listarTodos();
        for (Vendas venda : vendas) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { venda.getMarca(), venda.getModelo(),
                    venda.getPlaca(), venda.getCliente(), venda.getValor(), venda.getDataHora() });
        }
    }

      // Método para exibir mensagem
        private void exibirErro(String message) {
            JOptionPane.showMessageDialog(null, message, "Informação Inválida", 2);
        }
        
        // Método para limpar campos
        private void limparCamposCarro() {
            inputMarca.setText("");
            inputModelo.setText("");
            inputValorVenda.setText("");
            inputPlaca.setText("");
            inputCliente.setText("");
            inputData.setText("");
        }

        // Método para formatar uma máscara
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