import java.util.ArrayList;
import java.util.List;

public class Liga {
    private String nome;
    private List<Equipe> listaEquipes;
    private String tabelaClassificacao;

    public Liga(String nome) {
        this.nome = nome;
        this.listaEquipes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Equipe> getListaEquipes() {
        return listaEquipes;
    }

    public void setListaEquipes(List<Equipe> listaEquipes) {
        this.listaEquipes = listaEquipes;
    }

    public String getTabelaClassificacao() {
        return tabelaClassificacao;
    }

    public void setTabelaClassificacao(String tabelaClassificacao) {
        this.tabelaClassificacao = tabelaClassificacao;
    }

    public void adicionarEquipe(Equipe equipe) {
        this.listaEquipes.add(equipe);
    }

    public void removerEquipe(Equipe equipe) {
        this.listaEquipes.remove(equipe);
    }
}