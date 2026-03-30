package Dispositivos;

public abstract class Dispositivo {
    private String id;
    protected boolean ligado;

    public Dispositivo(String id) {
        this.id = id;
        this.ligado = false;
    }

    // ADICIONA ESTE MÉTODO AQUI:
    public String getId() {
        return id;
    }

    public void ligar() { this.ligado = true; }
    public void desligar() { this.ligado = false; }
    
    public abstract String exibirStatus();
}