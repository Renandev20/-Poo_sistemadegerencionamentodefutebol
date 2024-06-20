public class Pessoa {
    private String nome;
    private int idade;
    private String nacionalidade;
    private String equipeAtual;

    public Pessoa(String nome, int idade, String nacionalidade, String equipeAtual) {
        this.nome = nome;
        this.idade = idade;
        this.nacionalidade = nacionalidade;
        this.equipeAtual = equipeAtual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getEquipeAtual() {
        return equipeAtual;
    }

    public void setEquipeAtual(String equipeAtual) {
        this.equipeAtual = equipeAtual;
    }
}