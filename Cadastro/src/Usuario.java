public class Usuario {
    private String nome;
    private String sobrenome;
    private String endereco;
    private String cpf;
    private int idade;


    public Usuario(String nome, String sobrenome, String endereco, String cpf, int idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.idade = idade;
    }

    public Usuario(){

    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    


    

}
