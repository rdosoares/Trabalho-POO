public abstract class Dispositivo {
    private String id;
    private String marca;
    private String modelo;
    private String localDivisao;
    protected double consumoPorHora; // em Wh
    protected boolean ligado;
    private long tempoInicioLigado; 
    private double horasAcumuladas;

    public Dispositivo(String id, String marca, String modelo, String localizacao, double consumo) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.localDivisao = localizacao;
        this.consumoPorHora = consumo;
        this.ligado = false;
        this.horasAcumuladas = 0;
    }

    // -- Getters --
    public String getId() { return id; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getLocalDivisao() { return localDivisao; }
    public double getConsumoPorHora() { return consumoPorHora; }

	 // --- Lógica de Energia ---
    public void ligar() {
        if (!this.ligado) {
            this.ligado = true;
            this.tempoInicioLigado = System.currentTimeMillis(); 
        }
    }
    
    public void desligar() {
        if (this.ligado) {
            this.ligado = false;
            long agora = System.currentTimeMillis();
            // Converte a diferença de milissegundos para horas e acumula
            this.horasAcumuladas += (agora - tempoInicioLigado) / (1000.0 * 60 * 60);
        }
    }
    
    public double getConsumoTotal() {
        double total = horasAcumuladas;
        if (ligado) {
            long agora = System.currentTimeMillis();
            total += (agora - tempoInicioLigado) / (1000.0 * 60 * 60);
        }
        return total * consumoPorHora; // Retorna o gasto total em Wh
    }
    
    public abstract String exibirStatus();
}