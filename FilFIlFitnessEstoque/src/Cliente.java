public class Cliente {
    private String nome;
    private String cpf;
    private int telefone;

    //Setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    //Getters

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getTelefone() {
        return telefone;
    }
}
