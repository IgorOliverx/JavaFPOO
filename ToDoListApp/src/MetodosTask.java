import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class MetodosTask {
    ImageIcon imgConcluido = new ImageIcon(getClass().getResource("resources/verificar.png"));

    private TodoList todoList;
    private Login login;
    private Detalhes detalhes;

    public MetodosTask(TodoList todoList) {
        this.todoList = todoList;
    }

    public MetodosTask(Login login) {
        this.login = login;
    }

    // metodo de fazer login
    public void fazerLogin() {
        login.setUsername(login.getUsernameField().getText());
        if (login.getUsername().length() > 2 && login.getUsername().length() < 15 ) {
            JFrame TodoList = new TodoList(login.getUsername());
            TodoList.setVisible(true);
            login.dispose(); 
        
        } else {
            JOptionPane.showMessageDialog(null, "Insira seu nome corretamente");
        }

    }

    public void exibirStatus(String message) {
        JLabel status = new JLabel(message);
        JOptionPane janela = new JOptionPane(status, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null,
                new Object[] {}, null);

        JDialog caixa = janela.createDialog("Status");
        caixa.setModal(false);

        int delay = 1000;

        Timer timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                caixa.setVisible(false); // Fecha a janela do JOptionPane
            }
        });

        timer.setRepeats(false); // Apenas um único disparo
        timer.start();
        caixa.setVisible(true); // Exibe o JOptionPane
    }

   

    public void adicionarTarefa() {
        // Adiciona uma nova task à lista de tasks
        String taskDescription = todoList.getCaixaInserirTarefa().getText().trim();// remove espaços vazios
        if (!taskDescription.isEmpty()) {
            Task newTask = new Task(taskDescription);
            todoList.getTasks().add(newTask);
            updateTaskList();
            todoList.getCaixaInserirTarefa().setText("");
        }
    }

    public void deleteTask() {
        // Exclui a task selecionada da lista de tasks
        int selectedIndex = todoList.getTaskList().getSelectedIndex(); // marca os indices das tarefas para poder
                                                                       // excluir
        Object[] opcoes = { "Sim", "Não" };
        try {
            // remove de um em um
            if (selectedIndex >= 0 && selectedIndex < todoList.getTasks().size()) {
                int resposta = JOptionPane.showOptionDialog(null,
                        "Você tem certeza que quer excluir essa tarefa? ",
                        "Excluir tarefa", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
                if (resposta == JOptionPane.YES_OPTION) {
                    todoList.getTasks().remove(selectedIndex);
                    updateTaskList();
                    exibirStatus("Tarefa deletada com sucesso");
                }
            } else {
                JOptionPane.showMessageDialog(null ,"Por favor, selecione uma tarefa!", null, JOptionPane.CANCEL_OPTION);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro!", "Error", JOptionPane.CANCEL_OPTION);
        }
    }

    public void detalhesTask() {

        int selectedIndex = todoList.getTaskList().getSelectedIndex();// marca os indices das tarefas

        if (selectedIndex >= 0 && selectedIndex < todoList.getTasks().size()) {
            Detalhes detalhe = new Detalhes();
            detalhe.setVisible(true);
        }

    }

    public void salvarDetalhesTask() {
        int selectedIndex = todoList.getTaskList().getSelectedIndex();// marca os indices das tarefas
        String detalhesDaTask = detalhes.getCaixaInserirDetalhes().getText().trim();

        if (selectedIndex >= 0 && selectedIndex < todoList.getTasks().size()) {
            Detalhes detalhe = new Detalhes();
            detalhe.setVisible(true);

            DetalhesTask newDescricao = new DetalhesTask(detalhesDaTask);
            detalhes.getDescricao().add(newDescricao);
             //updateTaskList();
            // detalhes.getCaixaInserirDetalhes().setText("");

        }
    }

    public void concluirTask() {
        // Marca a task selecionada como concluída -> arrumar logica pra impedir de
        // concluir a task mais de uma vez FAZER ISSO URGENTE!!! -> logica resolvida
        int selectedIndex = todoList.getTaskList().getSelectedIndex();

        if (selectedIndex >= 0 && selectedIndex < todoList.getTasks().size()) {
            Task task = todoList.getTasks().get(selectedIndex);

            if (task.isDone() == false) {
                task.setDone(true);
                Date d = new Date();
                task.setDataFim(d.getTime());
                updateTaskList();
                JOptionPane.showMessageDialog(null, "Você concluiu a task em " + task.duracaoTarefa() + " segundos",
                        "Concluir tarefa", selectedIndex, imgConcluido);

            } else {
                JOptionPane.showMessageDialog(null, "Tarefa já concluída!", null, JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma tarefa selecionada!", null, JOptionPane.CANCEL_OPTION);
        }

    }

    public void filterTasks() {
        // Filtra as tasks com base na seleção do JComboBox
        String filter = (String) todoList.getFilterComboBox().getSelectedItem();
        todoList.getListModel().clear();
        for (Task task : todoList.getTasks()) {
            if (filter.equals("Todas") || (filter.equals("Ativas") &&
                    !task.isDone()) || (filter.equals("Concluídas") && task.isDone())) {
                todoList.getListModel().addElement(task.getDescription());
            }
        }
    }

    public void clearCompletedTasks() {
        // Limpa todas as tasks concluídas da lista
        List<Task> completedTasks = new ArrayList<>();
        for (Task task : todoList.getTasks()) {
            if (task.isDone()) {
                completedTasks.add(task);
            }
        }
        todoList.getTasks().removeAll(completedTasks);
        updateTaskList();
    }

    public void updateTaskList() {
        // Atualiza a lista de tasks exibida na GUI
        todoList.getListModel().clear();
        for (Task task : todoList.getTasks()) {
            todoList.getListModel().addElement(task.getDescription() + (task.isDone() ?

                    " (✔)" : ""));

        }
    }

}
