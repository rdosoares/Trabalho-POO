package HorasContador;

public class Horario {
    private int tickCount;       
    private double tickRate;     
    private double tickDuration; 

    private final int segundosTotaisIniciais;

    private int horas;
    private int minutos;
    private int segundos;

    public Horario(int horaInicial, int minutoInicial, int segundoInicial, double tickDuration, double tickRate) {
        this.tickDuration = tickDuration;
        this.tickRate = tickRate;
        this.tickCount = 0;
        
        // Transformamos o início em um valor absoluto de segundos
        this.segundosTotaisIniciais = (horaInicial * 3600) + (minutoInicial * 60) + segundoInicial;
        
        // Inicializa os campos de exibição
        atualizarCampos(segundosTotaisIniciais);
    }

    public Horario() {
        this(0, 0, 0, 1.0, 1.0);
    }

    public void tick() {
        tickCount++;

        // Calcula quanto tempo passou em "segundos simulados"
        int progressoSegundos = (int)(tickCount * tickDuration * tickRate);
        
        int totalSegundos = segundosTotaisIniciais + progressoSegundos;

        atualizarCampos(totalSegundos);
    }

    // Método auxiliar para evitar repetição de lógica
    private void atualizarCampos(int totalSegundos) {
        this.segundos = totalSegundos % 60;
        this.minutos  = (totalSegundos / 60) % 60;
        this.horas    = (totalSegundos / 3600) % 24;
    }

    public int getHoras()    { return horas; }
    public int getMinutos()  { return minutos; }
    public int getSegundos() { return segundos; }
    public int getTickCount() { return tickCount; }

    public void setTickRate(double tickRate) {
        this.tickRate = tickRate;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }
}