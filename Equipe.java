import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private String nome;
    private String pais;
    private List<Jogador> listaJogadores;
    private Treinador treinador;

    public Equipe(String nome, String pais) {
        this.nome = nome;
        this.pais = pais;
        this.listaJogadores = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Jogador> getListaJogadores() {
        return listaJogadores;
    }

    public void adicionarJogador(Jogador jogador) {
        listaJogadores.add(jogador);
    }

    public void removerJogador(Jogador jogador) {
        listaJogadores.remove(jogador);
    }

    public Treinador getTreinador() {
        return treinador;
    }

    public void setTreinador(Treinador treinador) {
        this.treinador = treinador;
    }

    public static class Jogador extends Pessoa {
        private String posicao;
        private String numeroCamisa;
        private String habilidade;


        public Jogador(String nome, int idade, String nacionalidade, String equipeAtual, String posicao, String numeroCamisa, String habilidade) {
            super(nome, idade, nacionalidade, equipeAtual);
            this.posicao = posicao;
            this.numeroCamisa = numeroCamisa;
            this.habilidade = habilidade;
        }

        public String getPosicao() {
            return posicao;
        }

        public void setPosicao(String posicao) {
            this.posicao = posicao;
        }

        public String getNumeroCamisa() {
            return numeroCamisa;
        }

        public void setNumeroCamisa(String numeroCamisa) {
            this.numeroCamisa = numeroCamisa;
        }

        public String getHabilidade() {
            return habilidade;
        }

        public void setHabilidade(String habilidade) {
            this.habilidade = habilidade;
        }
    }


}