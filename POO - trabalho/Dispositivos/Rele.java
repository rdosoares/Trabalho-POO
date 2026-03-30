package Dispositivos;

public class Rele extends Dispositivo {

    public Rele(String id) {
        super(id);
    }

    @Override
    public String exibirStatus() {
        String estado = ligado ? "FECHADO (Passa Corrente)" : "ABERTO (Circuito Interrompido)";
        return "[Rele " + getId() + "] Estado: " + estado;
    }
}