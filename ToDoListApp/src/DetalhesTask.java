public class DetalhesTask {
    
    private String descricao;
    private boolean done;

    public DetalhesTask(String descricao) {
        this.descricao = descricao;
        this.done = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    




}
