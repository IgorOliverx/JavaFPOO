import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * TodoList
 */

public class TodoList extends JFrame {

    ImageIcon imgConcluido = new ImageIcon(getClass().getResource("resources/verificar.png"));
    ImageIcon imgLixeira = new ImageIcon(getClass().getResource("resources/lixeira.png"));

    private JPanel mainPanel;
    private JTextField caixaInserirTarefa;
    private JButton addButton;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    private JButton deleteButton;
    private JButton markDoneButton;
    private JComboBox<String> filterComboBox;
    private JButton clearCompletedButton;
    private List<Task> tasks;
    private JLabel userLabel;
    public String username;

    // construtor da aplicação
    public TodoList(String userInput) {

        // Configuração da janela principal
        super("Bem vindo(a) " + userInput );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 450);

        //Instancia da classe que contem os metodos
        MetodosTask metodosTask = new MetodosTask(this);


        // Inicializa o painel principal
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Inicializa a lista de tasks e a lista de tasks concluídas
        tasks = new ArrayList<>();
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);


        // Inicializa campos de entrada, botões e JComboBox
        userLabel = new JLabel("Informação do Usuário:"); 
        JLabel userInputLabel = new JLabel(userInput);

        caixaInserirTarefa = new JTextField();
        caixaInserirTarefa.setCursor(new Cursor(Cursor.HAND_CURSOR));

        addButton = new JButton("Adicionar");

        //botao de deletar com a lixeira e configurações pro botao ser apenas o icon
        deleteButton = new JButton(imgLixeira);
        deleteButton.setBorderPainted(false);
        deleteButton.setContentAreaFilled(false);
        deleteButton.setFocusPainted(false);
        deleteButton.setOpaque(false);
        deleteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //botao de concluir configurações pro botao ser apenas o icon
        markDoneButton = new JButton(imgConcluido);
        markDoneButton.setBorderPainted(false);
        markDoneButton.setContentAreaFilled(false);
        markDoneButton.setFocusPainted(false);
        markDoneButton.setOpaque(false);
        markDoneButton.setCursor(new Cursor(Cursor.HAND_CURSOR));


        filterComboBox = new JComboBox<>(new String[] { "Todas", "Ativas",
                "Concluídas" });
        clearCompletedButton = new JButton("Limpar Concluídas");
        // Configuração do painel de entrada
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(caixaInserirTarefa, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);
        // Configuração do painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(deleteButton);
        buttonPanel.add(markDoneButton);
        buttonPanel.add(filterComboBox);
        buttonPanel.add(clearCompletedButton);

        // Adiciona os componentes ao painel principal
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        // Adiciona o painel principal à janela
        this.add(mainPanel);

        // ===============================================================
        // Tratamento de eventos da aplicação
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                metodosTask.adicionarTarefa();
            }
        });

        // Tratamento de evento usando interaçao com o teclado
        caixaInserirTarefa.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    metodosTask.adicionarTarefa();
                }
            }
        });

        // Evento de Concluir tarefa com double click
        taskList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    metodosTask.concluirTask();
                }

            }
        });

        // evento de deletar com o click
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Object[] opcoes = { "Sim", "Não" };
                int resposta = JOptionPane.showOptionDialog(null,
                        "Você tem certeza que quer excluir essa tarefa? ",
                        "Excluir tarefa", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
                if (resposta == JOptionPane.YES_OPTION) {
                    metodosTask.deleteTask();
                }

            }
        });
        // evento de deletar a partir do botao delete 
        taskList.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                 Object[] opcoes = { "Sim", "Não" };
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    int resposta = JOptionPane.showOptionDialog(null,
                        "Você tem certeza que quer excluir essa tarefa? ",
                        "Excluir tarefa", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
                        if (resposta == JOptionPane.YES_OPTION){
                    metodosTask.deleteTask();
                }
                }

            }
        });

        clearCompletedButton.addActionListener(e -> {
            metodosTask.clearCompletedTasks();
        });

        filterComboBox.addActionListener(e -> {
            metodosTask.filterTasks();
        });
        markDoneButton.addActionListener(e -> {
            metodosTask.concluirTask();
        });
    }

    public void setCaixaInserirTarefa(JTextField caixaInserirTarefa) {
        this.caixaInserirTarefa = caixaInserirTarefa;
    }

    public JTextField getCaixaInserirTarefa() {
        return caixaInserirTarefa;
    }

    public JList<String> getTaskList() {
        return taskList;
    }

    public DefaultListModel<String> getListModel() {
        return listModel;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getMarkDoneButton() {
        return markDoneButton;
    }

    public JComboBox<String> getFilterComboBox() {
        return filterComboBox;
    }

    public JButton getClearCompletedButton() {
        return clearCompletedButton;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void run() {
        // Exibe a janela
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}