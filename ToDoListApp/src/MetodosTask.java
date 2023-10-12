import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class MetodosTask {

    private TodoList todoList;

    public MetodosTask(TodoList todoList) {
        this.todoList = todoList;
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
        int selectedIndex = todoList.getTaskList().getSelectedIndex(); // marca os indices das tarefas para poder excluir

        // remove de um em um
        try{
        if (selectedIndex >= 0 && selectedIndex < todoList.getTasks().size()) {
           todoList.getTasks().remove(selectedIndex);
            updateTaskList();
        }}catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao remover");
        }
    }

    public void concluirTask() {
        // Marca a task selecionada como concluída
        int selectedIndex = todoList.getTaskList().getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < todoList.getTasks().size()) {
            Task task = todoList.getTasks().get(selectedIndex);
            task.setDone(true);
            Date d = new Date();
            task.setDataFim(d.getTime());
            updateTaskList();
            JOptionPane.showMessageDialog(null, "Você concluiu a task em " + task.duracaoTarefa() + " segundos");

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
