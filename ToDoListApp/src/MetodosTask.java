import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class MetodosTask {
    ImageIcon imgConcluido = new ImageIcon(getClass().getResource("resources/verificar.png"));

    private TodoList todoList;
    private Login login;


    public MetodosTask(TodoList todoList) {
        this.todoList = todoList;
    }

    public MetodosTask(Login login){
        this.login = login;
    }

    //metodo de fazer login
      public void fazerLogin(){
        login.setUsername(login.getUsernameField().getText());
        if(login.getUsername().length() > 2){
            JFrame TodoList = new TodoList(login.getUsername());
            TodoList.setVisible(true);
            login.dispose();
        }else {
            JOptionPane.showMessageDialog(null,"Insira seu nome corretamente");
        }

    }



    public void exibirStatus(String message) {
        JLabel status = new JLabel(message);
        JOptionPane janela = new JOptionPane(status, JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
    
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
        int selectedIndex = todoList.getTaskList().getSelectedIndex(); // marca os indices das tarefas para poder excluir
        try{
        // remove de um em um
        if (selectedIndex >= 0 && selectedIndex < todoList.getTasks().size()) {
           todoList.getTasks().remove(selectedIndex);
            updateTaskList();
        }else{
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma tarefa!");
        }}catch(Exception e ){
            JOptionPane.showMessageDialog(null, "Erro!", "Error", JOptionPane.CANCEL_OPTION);
        }
    }

    public void detalhesTask(){

        int selectedIndex = todoList.getTaskList().getSelectedIndex();//marca os indices das tarefas
        List<Task> detalhesTasks = new ArrayList<>();

        if (selectedIndex >= 0 && selectedIndex < todoList.getTasks().size()) {
           Detalhes detalhe = new Detalhes();
           detalhe.setVisible(true);


           todoList.getTasks();
            updateTaskList();
        }
    }

    public void concluirTask() {
        // Marca a task selecionada como concluída -> arrumar logica pra impedir de concluir a task mais de uma vez FAZER ISSO URGENTE!!!
        boolean concluido= false;
        int selectedIndex = todoList.getTaskList().getSelectedIndex();

        if (selectedIndex >= 0 && selectedIndex < todoList.getTasks().size() && concluido==false) {
            Task task = todoList.getTasks().get(selectedIndex);
            task.setDone(true);
            Date d = new Date();
            task.setDataFim(d.getTime());
            updateTaskList();
            JOptionPane.showMessageDialog(null, "Você concluiu a task em " + task.duracaoTarefa() + " segundos","Concluir tarefa", selectedIndex, imgConcluido);
            
            concluido=true;

        }else{
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
