package Automacoes;

import java.util.List;

import Dispositivos.Dispositivo;
import Sensores.Sensor;

public abstract class Automacao {
    protected String nome;
    protected boolean ativa;

    public Automacao(String nome) {
        this.nome = nome;
        this.ativa = true;
    }

    // Método abstrato que cada automação implementará com sua lógica
    public abstract void verificarExecutar(Sensor sensor, List<Dispositivo> dispositivos);

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
}