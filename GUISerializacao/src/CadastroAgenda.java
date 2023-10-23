package GUISerializacao.src;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CadastroAgenda extends JPanel {
    private JTextField inputDescricao, inputData, inputHora;
    private DefaultTableModel tableModel;
    private JTable table;
    private List<Usuario> usuarios = new ArrayList<>();
    private int linhaSelecionada = -1;

    public CadastroAgenda() {
        
        this.setSize(600, 300);
        
        
        this.setVisible(true);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Descrição");
        tableModel.addColumn("Data");
         tableModel.addColumn("Hora");

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        inputDescricao = new JTextField(20);
        inputData = new JTextField(5);
        inputHora = new JTextField(5);
        JButton cadastrarButton = new JButton("Cadastrar");
        JButton atualizarButton = new JButton("Atualizar");
        JButton apagarButton = new JButton("Apagar");
        JButton apagarTodosButton = new JButton("Apagar Todos");
        JButton salvarButton = new JButton("Salvar");
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Descrição:"));
        inputPanel.add(inputDescricao);
        inputPanel.add(new JLabel("Data:"));
        inputPanel.add(inputData);
        inputPanel.add(new JLabel("Hora:"));
        inputPanel.add(inputHora);



        JPanel painelSUl = new JPanel();
        painelSUl.add(cadastrarButton);
        painelSUl.add(atualizarButton);
        painelSUl.add(apagarButton);
        painelSUl.add(apagarTodosButton);
        painelSUl.add(salvarButton);
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(painelSUl, BorderLayout.SOUTH);
        File arquivo = new File("dados.txt");
        if (arquivo.exists()) {
            usuarios = Serializacao.deserializar("dados.txt");
            //atualizarTabela();
        }
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    inputDescricao.setText((String) table.getValueAt(linhaSelecionada, 0));
                    inputData.setText(table.getValueAt(linhaSelecionada, 1).toString());
                     inputHora.setText(table.getValueAt(linhaSelecionada, 1).toString());
                }
            }
        });
        OperacoesUsuarios operacoes = new OperacoesUsuarios(usuarios, tableModel, table);
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.cadastrarUsuario(inputDescricao.getText(), inputData.getText());
                inputDescricao.setText("");
                inputData.setText("");
            }
        });
        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.atualizarUsuario(linhaSelecionada, inputDescricao.getText(),
                        inputData.getText());

            }
        });
        apagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.apagarUsuario(linhaSelecionada);
            }
        });
        apagarTodosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.apagarTodosUsuarios();
            }
        });
        salvarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                operacoes.salvarUsuarios();
                
            }
        });
    }

    
    

}