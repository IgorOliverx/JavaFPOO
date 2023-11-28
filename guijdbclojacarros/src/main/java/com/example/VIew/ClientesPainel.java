
package com.example.VIew;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import com.example.Connection.ClientesDAO;
import com.example.Controller.ClientesController;
import com.example.Model.Clientes;

/**
 *
 * @author DevTarde_A - Igor
 */
public class ClientesPainel extends javax.swing.JPanel {
    
    //Atributos da aplicação -> Jeito do netbeans
    private javax.swing.JFormattedTextField InputCpf;
    private javax.swing.JFormattedTextField InputEmail;
    private javax.swing.JFormattedTextField InputNome;
    private javax.swing.JFormattedTextField InputTelefone;
    private javax.swing.JButton bntEditar;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnCadastro;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JFormattedTextField inputPesquisar;
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


    private List<Clientes> clientes;

    /**
     * Serve para criar o ClientesPanel.
     */
    public ClientesPainel() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
   
    private void initComponents() {
        jSeparator1 = new javax.swing.JSeparator();
        labelTitulo = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inputPesquisar = new javax.swing.JFormattedTextField();
        labelCpf = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        InputNome = new javax.swing.JFormattedTextField();
        labelTelefone = new javax.swing.JLabel();
        btnCadastro = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        InputEmail = new javax.swing.JFormattedTextField(formatar("###.###.###-##"));
        bntEditar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        InputCpf = new javax.swing.JFormattedTextField(); 
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        InputTelefone = new javax.swing.JFormattedTextField(formatar("(##) #####-####"));

        jSeparator1.setAlignmentX(0.0F);

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        labelTitulo.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        labelTitulo.setText("CADASTRO DE CLIENTES");
        add(labelTitulo);
        labelTitulo.setBounds(280, 20, 280, 34);

        labelEmail.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        labelEmail.setText("Cpf");
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
        labelCpf.setText("Email");
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
                new String[] { "Nome", "Email", "Telefone", "CPF" });
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

        // tratamento de eventos do construtor -> seleciona as linhas da tabela
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    InputNome.setText((String) table.getValueAt(linhaSelecionada, 0));
                    InputCpf.setText((String) table.getValueAt(linhaSelecionada, 1));
                    InputTelefone.setText((String) table.getValueAt(linhaSelecionada, 2));
                    InputEmail.setText((String) table.getValueAt(linhaSelecionada, 3));
                } else {
                    limparCampos();
                }
            }
        });
        
        


        ClientesController operacoes = new ClientesController(clientes, tableModel, table);

        // ---- AÇÃO DE CADASTRAR CLIENTE ----
        btnCadastro.addActionListener(e -> {
            operacoes.cadastrar(InputNome.getText(), InputEmail.getText(),
                    InputTelefone.getText(), InputCpf.getText());
            // Limpa os campos de entrada após a operação de cadastro
           limparCampos();
        });

        
        bntEditar.addActionListener(e -> {
            if (linhaSelecionada != -1) {
                String cpf = InputCpf.getText(); // Obtendo o CPF diretamente do campo de texto(estava com erro no retorno)
                operacoes.atualizar(InputNome.getText(), InputEmail.getText(), InputTelefone.getText(), cpf);
                limparCampos();
                atualizarTabela();
            }
        });


        // Configura a ação do botão "apagar" para excluir um registro no banco de dados
        btnApagar.addActionListener(e -> {
            // Chama o método "apagar" do objeto operacoes com o valor do campo de
            // entrada "placa"
            operacoes.apagar(InputCpf.getText());
            // Limpa os campos de entrada após a operação de exclusão
           limparCampos();
        });

        btnLimpar.addActionListener(e ->{

            limparCampos();
        });

    }


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

    private void limparCampos(){
            InputNome.setText("");
            InputCpf.setText("");
            InputTelefone.setText("");
            InputEmail.setText("");
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
