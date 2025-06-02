public class Fornecedores {
    private String nome;
    private String cnpj;
    private int telefone;

    //Setters

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    //Getters

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public int getTelefone() {
        return telefone;
    }
}
