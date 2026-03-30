package Sensores;

public abstract class Sensor {
    private String id;
    private String marca;
    private String tipo; // Ex: "Luminosidade", "Chuva"

    public Sensor(String id, String tipo, String marca) {
        this.id = id;
        this.tipo = tipo;
        this.marca = marca;
    }

    public String getId() { return id; }
    public String getMarca() {return marca; }
    public String getTipo() { return tipo; }
    
    public abstract String lerDado(); 
}