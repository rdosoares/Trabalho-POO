package Utilizador;
import Dispositivos.Dispositivo;
import java.util.ArrayList;
import java.util.List;

public class Divisao {
    private final String nome;
    private final List<Dispositivo> dispositivos;

    public Divisao(String nome) {
        this.nome = nome;
        this.dispositivos = new ArrayList<>();
    }

    public void adicionarDispositivo(Dispositivo d) {
        this.dispositivos.add(d);
    }
    
    public String getNome() { return nome; }
}