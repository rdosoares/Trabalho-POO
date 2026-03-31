package Sensores;

public abstract class Sensor {
    private String id;
    private String marca;
    private String tipo; // Ex: "Luminosidade", "Chuva"
    private String local;

    public Sensor(String id, String tipo, String marca, String local) {
        this.id = id;
        this.tipo = tipo;
        this.marca = marca;
        this.local = local;
    }

    public String getId() { return id; }
    public String getMarca() {return marca; }
    public String getTipo() { return tipo; }
    public String getLocal() { return local; }
    
    public abstract String lerDado(); 
}