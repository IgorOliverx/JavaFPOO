CODIGO ATE O MOMENTO DIA 12/10/2023 -> ESTOU DIVIDINDO A LOGICA EM VARIAS CLASSES: SEGUE O CODIGO QUE AINDA PODE SER SALVO CASO TUDO DE ERRADO:


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
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.logging.Handler;
import java.util.Date;

/**
 * TodoList
 */

public class TodoList extends JFrame {

 
    
    ImageIcon imgConcluido = new ImageIcon(getClass().getResource("resources/verificar.png"));
    ImageIcon imgLixeira = new ImageIcon(getClass().getResource("resources/lixeira.png"));

    private JPanel mainPanel;
    private JTextField caixaInserirTarefa;
    public void setCaixaInserirTarefa(JTextField caixaInserirTarefa) {
        this.caixaInserirTarefa = caixaInserirTarefa;
    }
    
    public JTextField getCaixaInserirTarefa() {
        return caixaInserirTarefa;
    }

    private JButton addButton;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    private JButton deleteButton;
    private JButton markDoneButton;
    private JComboBox<String> filterComboBox;
    private JButton clearCompletedButton;
    private List<Task> tasks;





    public JList<String> getTaskList() {
        return taskList;
    }

    public void setTaskList(JList<String> taskList) {
        this.taskList = taskList;
    }

    public DefaultListModel<String> getListModel() {
        return listModel;
    }

    public void setListModel(DefaultListModel<String> listModel) {
        this.listModel = listModel;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    public JButton getMarkDoneButton() {
        return markDoneButton;
    }

    public void setMarkDoneButton(JButton markDoneButton) {
        this.markDoneButton = markDoneButton;
    }

    public JComboBox<String> getFilterComboBox() {
        return filterComboBox;
    }

    public void setFilterComboBox(JComboBox<String> filterComboBox) {
        this.filterComboBox = filterComboBox;
    }

    public JButton getClearCompletedButton() {
        return clearCompletedButton;
    }

    public void setClearCompletedButton(JButton clearCompletedButton) {
        this.clearCompletedButton = clearCompletedButton;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String username;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    // construtor
    public TodoList(String username) {
        
        // Configuração da janela principal
        super("To-Do List App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450, 300);
        // Inicializa o painel principal
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        // Inicializa a lista de tasks e a lista de tasks concluídas
        tasks = new ArrayList<>();
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        
        MetodosTask metodosTask = new MetodosTask(this);
        
        

        // Inicializa campos de entrada, botões e JComboBox
        caixaInserirTarefa = new JTextField();
        caixaInserirTarefa.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addButton = new JButton("Adicionar");
        deleteButton = new JButton(imgLixeira);
        deleteButton.setBorderPainted(false);
        deleteButton.setContentAreaFilled(false);
        deleteButton.setFocusPainted(false);
        deleteButton.setOpaque(false);
        deleteButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
        // Tratamento de evento do método normal
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        // Tratamento de evento usando interaçao com o teclado
        caixaInserirTarefa.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    addTask();
                }
            }
        });

       

        // Evento de Concluir tarefa com double click
        taskList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    markTaskDone();
                }

            }
        });
        

        //evento de deletar com o click
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Object[] opcoes = { "Sim", "Não" };
                int resposta = JOptionPane.showOptionDialog(null,
				"Você tem certeza que quer excluir essa tarefa? ",
				"Exemplo", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
                if (resposta == JOptionPane.YES_OPTION){
                deleteTask();}

            }
        });
        //evento de deletar a partir do botao delete
         taskList.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    deleteTask();
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
            metodosTask.markTaskDone();
        });
    }


    // ==================================================================================

    // // Configuração de Listener para os Eventos
    // private void addTask() {
    //     // Adiciona uma nova task à lista de tasks
    //     String taskDescription = caixaInserirTarefa.getText().trim();// remove espaços vazios
    //     if (!taskDescription.isEmpty()) {
    //         Task newTask = new Task(taskDescription);
    //         tasks.add(newTask);
    //         updateTaskList();
    //         caixaInserirTarefa.setText("");
    //     }
    // }

    // private void deleteTask() {
    //     // Exclui a task selecionada da lista de tasks
    //     int selectedIndex = taskList.getSelectedIndex(); // marca os indices das tarefas para poder excluir

    //     // remove de um em um
    //     try{
    //     if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
    //         tasks.remove(selectedIndex);
    //         updateTaskList();
    //     }}catch(Exception e){
    //         JOptionPane.showMessageDialog(null, "Erro ao remover");
    //     }
    // }

    // private void markTaskDone() {
    //     // Marca a task selecionada como concluída
    //     int selectedIndex = taskList.getSelectedIndex();
    //     if (selectedIndex >= 0 && selectedIndex < tasks.size()) {
    //         Task task = tasks.get(selectedIndex);
    //         task.setDone(true);
    //         Date d = new Date();
    //         task.setDataFim(d.getTime());
    //         updateTaskList();
    //         JOptionPane.showMessageDialog(null, "Você concluiu a task em " + task.duracaoTarefa() + " segundos");

    //     }
    // }

    // private void filterTasks() {
    //     // Filtra as tasks com base na seleção do JComboBox
    //     String filter = (String) filterComboBox.getSelectedItem();
    //     listModel.clear();
    //     for (Task task : tasks) {
    //         if (filter.equals("Todas") || (filter.equals("Ativas") &&
    //                 !task.isDone()) || (filter.equals("Concluídas") && task.isDone())) {
    //             listModel.addElement(task.getDescription());
    //         }
    //     }
    // }

    // private void clearCompletedTasks() {
    //     // Limpa todas as tasks concluídas da lista
    //     List<Task> completedTasks = new ArrayList<>();
    //     for (Task task : tasks) {
    //         if (task.isDone()) {
    //             completedTasks.add(task);
    //         }
    //     }
    //     tasks.removeAll(completedTasks);
    //     updateTaskList();
    // }

    // private void updateTaskList() {
    //     // Atualiza a lista de tasks exibida na GUI
    //     listModel.clear();
    //     for (Task task : tasks) {
    //         listModel.addElement(task.getDescription() + (task.isDone() ?

    //                 " (✔)" : ""));

    //     }
    // }

    public void run() {
        // Exibe a janela
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TodoList("Luigi").run();
    }
}















   taskList.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                 Object[] opcoes = { "Sim", "Não" };
                int resposta = JOptionPane.showOptionDialog(null,
                        "Você tem certeza que quer excluir essa tarefa? ",
                        "Excluir tarefa", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
                if (e.getKeyCode() == KeyEvent.VK_DELETE && resposta == JOptionPane.YES_OPTION) {
                    

                    metodosTask.deleteTask();
                }

            }
        });








 taskList.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {         
                     Object[] opcoes = { "Sim", "Não" };
                int resposta = JOptionPane.showOptionDialog(null,
                        "Você tem certeza que quer excluir essa tarefa? ",
                        "Excluir tarefa", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

                        if(e.getKeyCode() == KeyEvent.VK_DELETE && resposta == JOptionPane.YES_OPTION){
                    metodosTask.deleteTask();
                    }
                }

            }
        });