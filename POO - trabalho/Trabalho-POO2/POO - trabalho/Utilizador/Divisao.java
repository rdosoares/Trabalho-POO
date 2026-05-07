package Utilizador;
import Dispositivos.Dispositivo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Divisao implements Serializable{
    private static final long serialVersionUID = 1L;
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

    public Dispositivo[] getDispositivos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDispositivos'");
    }
}