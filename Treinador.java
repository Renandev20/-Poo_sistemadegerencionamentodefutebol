public class Treinador extends Pessoa {
    private int experiencia;
    private String especializacao;
    private String titulos;

    public Treinador(String nome, int idade, String nacionalidade, String equipeAtual, int experiencia, String especializacao, String titulos) {
        super(nome, idade, nacionalidade, equipeAtual);
        this.experiencia = experiencia;
        this.especializacao = especializacao;
        this.titulos = titulos;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public String getTitulos() {
        return titulos;
    }

    public void setTitulos(String titulos) {
        this.titulos = titulos;
    }
}