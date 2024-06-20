import java.util.Date;

public class Partidas {
    private Equipe equipeCasa;
    private Equipe equipeVisitante;
    private Date dataHora;
    private String local;
    private String resultadoPartida;

    public Partidas(Equipe equipeCasa, Equipe equipeVisitante, Date dataHora, String local, String resultadoPartida) {
        this.equipeCasa = equipeCasa;
        this.equipeVisitante = equipeVisitante;
        this.dataHora = dataHora;
        this.local = local;
        this.resultadoPartida = resultadoPartida;
    }

    public Equipe getEquipeCasa() {
        return equipeCasa;
    }

    public void setEquipeCasa(Equipe equipeCasa) {
        this.equipeCasa = equipeCasa;
    }

    public Equipe getEquipeVisitante() {
        return equipeVisitante;
    }

    public void setEquipeVisitante(Equipe equipeVisitante) {
        this.equipeVisitante = equipeVisitante;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getResultadoPartida() {
        return resultadoPartida;
    }

    public void setResultadoPartida(String resultadoPartida) {
        this.resultadoPartida = resultadoPartida;
    }
}