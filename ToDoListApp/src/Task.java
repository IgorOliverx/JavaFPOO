import java.util.Date;
public class Task {
    // atributos
    private String description;
    private boolean done;
    private double dataInicio;
    private double dataFim;

    // construtor(somente String description)
    public Task(String description) {
        this.description = description;
        this.done = false;
        Date d = new Date();
        this.dataInicio = d.getTime();

    }


    
    // set and Gets
    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
    public void setDataInicio(double dataInicio) {
        this.dataInicio = dataInicio;
    }
 
    public double duracaoTarefa(){
        double duracaoTask = dataFim - dataInicio;
        duracaoTask = duracaoTask/1000;
        return duracaoTask;
    }
    public void setDataFim(double dataFim) {
        this.dataFim = dataFim;
    }



    public void setDescription(String description) {
        this.description = description;
    }}