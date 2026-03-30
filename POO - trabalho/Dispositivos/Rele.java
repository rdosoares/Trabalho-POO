package Dispositivos;

public class Rele extends Dispositivo {

    public Rele(String id, String marca, String modelo, String localizacao, double consumo) {
        super(id, marca, modelo, localizacao, consumo);
    }

    // -- ligar/desligar --
    public void ligarRele() {super.ligar();}
    public void desligarRele() {super.desligar();}

    @Override
    public String exibirStatus() {
        String estado = ligado ? "FECHADO (Passa Corrente)" : "ABERTO (Circuito Interrompido)";
        return "[Relé " + getId() + "] Estado: " + estado;
    }
}