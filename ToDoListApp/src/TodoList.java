import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;

/**
 * TodoList  
 */

public class TodoList extends JFrame {

    //trazendo imagens dos icons 
    ImageIcon imgConcluido = new ImageIcon(getClass().getResource("resources/verificar.png"));
    ImageIcon imgLixeira = new ImageIcon(getClass().getResource("resources/arrastar.png"));
    ImageIcon imgDetalhes = new ImageIcon(getClass().getResource("resources/lista.png"));
    ImageIcon imgAdd = new ImageIcon(getClass().getResource("resources/add.png"));
     ImageIcon imgRecarregar = new ImageIcon(getClass().getResource("resources/reload.png"));
   
     //atributos da aplicação
    private JPanel mainPanel;
    private JTextField caixaInserirTarefa;
    private JButton addButton, markDoneButton, clearCompletedButton, desfazer, detalhes;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;
    private JComboBox<String> filterComboBox;
    private List<Task> tasks;
    public String username;
    private JLabel userLabel;
    private JLabel data,hora,btnDeletar;
    
    


    // construtor da aplicação
    public TodoList(String userInput) {

        // Configuração da janela principal
        super("Bem vindo(a) " + userInput);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(650, 450);
        this.setLocationRelativeTo(null);

        // Instancia da classe que contem os metodos
        MetodosTask metodosTask = new MetodosTask(this);

        // Inicializa o painel principal
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Inicializa a lista de tasks e a lista de tasks concluídas
        tasks = new ArrayList<>();
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        // Inicializa campos de entrada, botões e JComboBox -> parte superior do painel
        userLabel = new JLabel("Informação do Usuário:");
        JLabel userInputLabel = new JLabel(userInput);
        caixaInserirTarefa = new JTextField();

        //botao de adicionar com configurações que lhe permitem ser apenas o icon
        addButton = new JButton(imgAdd);
        addButton.setBorderPainted(false);
        addButton.setContentAreaFilled(false);
        addButton.setFocusPainted(false);
        addButton.setOpaque(false);
        addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // 'botao' de deletar com a lixeira e configurações 
        btnDeletar = new JLabel(imgLixeira);
        btnDeletar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //chamando o metodo de arrastarDeletar(o evento foi feito na própria classe)
        metodosTask.arrastarDeletar(this);

        // botao de concluir configurações pro botao ser apenas o icon
        markDoneButton = new JButton(imgConcluido);
        markDoneButton.setBorderPainted(false);
        markDoneButton.setContentAreaFilled(false);
        markDoneButton.setFocusPainted(false);
        markDoneButton.setOpaque(false);
        markDoneButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //JcomboBox
        filterComboBox = new JComboBox<>(new String[] { "Todas", "Ativas",
                "Concluídas" });
        filterComboBox.setCursor(new Cursor(Cursor.HAND_CURSOR));
        filterComboBox.setBackground(Color.WHITE);

        //Botao de limpar concluidas
        clearCompletedButton = new JButton("Limpar Concluídas");
        clearCompletedButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clearCompletedButton.setBackground(Color.WHITE);


        // configuração e estilização do botao de detalhes
        detalhes = new JButton(imgDetalhes);
        detalhes.setBorderPainted(false);
        detalhes.setContentAreaFilled(false);
        detalhes.setFocusPainted(false);
        detalhes.setOpaque(false);
        detalhes.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //configuração e estilizacao do botao de desfazer
        desfazer = new JButton(imgRecarregar);
        desfazer.setBorderPainted(false);
        desfazer.setContentAreaFilled(false);
        desfazer.setFocusPainted(false);
        desfazer.setOpaque(false);
        desfazer.setCursor(new Cursor(Cursor.HAND_CURSOR));


        //Configuração para aparecer data e hora em JLabel
        data = new JLabel();
        hora = new JLabel();

        Date dataSistema = new Date();

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        data.setText(formato.format(dataSistema));

        Timer horaSistema = new Timer(0, new hora());
        horaSistema.start(); 

        // Configuração do painel de entrada
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(caixaInserirTarefa, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

 
    
        // Configuração do painel de botões -> parte inferior do painel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(markDoneButton);
        buttonPanel.add(btnDeletar);
        buttonPanel.add(new JLabel("‎‎ ‎ "));
        buttonPanel.add(filterComboBox);
        buttonPanel.add(clearCompletedButton);
        buttonPanel.add(detalhes);
        buttonPanel.add(desfazer);
        buttonPanel.add(data);
        buttonPanel.add(hora);
        
        // Adiciona os componentes ao painel principal
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Adiciona o painel principal à janela
        this.add(mainPanel);

//===============================================================
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
            
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    metodosTask.concluirTask();
                }

            }
        });
        
          //evento conluir tarefa
        markDoneButton.addActionListener(e -> {
            metodosTask.concluirTask();
        });

        //evento de clicar para deletar
         btnDeletar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                metodosTask.deleteTask();
            }
        });

        // evento de deletar a partir do botao delete
        taskList.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    metodosTask.deleteTask();
                }
            }
        });

        //evento para limpar tasks completadas
        clearCompletedButton.addActionListener(e -> {
            metodosTask.clearCompletedTasks();
        });

        //evento para desfazer concluir
        desfazer.addActionListener(e -> {
            metodosTask.desfazerConcluir();
                
        });

        //evento de detalhes da task(sem funcionamento)
        detalhes.addActionListener(e -> {
            metodosTask.detalhesTask();
        });

        //evento de filtrar tarefas
        filterComboBox.addActionListener(e -> {
            metodosTask.filterTasks();
        });
      
    }//fecha o construtor

    //metodos especiais

    public JLabel getBtnDeletar() {
        return btnDeletar;
    }

    public void setBtnDeletar(JLabel btnDeletar) {
        this.btnDeletar = btnDeletar;
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

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
    
    public void run() {
        // Exibe a janela
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }

   //classe que pega a hora e formata ela para o padrão
    public class hora implements ActionListener{

        public void actionPerformed(ActionEvent e) {
        Calendar horaAgora = Calendar.getInstance();
        hora.setText(String.format("%1$tH:%1$tM:%1$tS", horaAgora));
        }
        
    }
}