package Utilizador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Casa implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String nome;
    private final List<Divisao> divisoes;

    public Casa(String nome) {
        this.nome = nome;
        this.divisoes = new ArrayList<>();
    }

    public void adicionarDivisao(Divisao d) {
        this.divisoes.add(d);
    }

    public String getNome() { return nome; }

    public Divisao getDivisao(String nomeDivisao) {
    for (Divisao d : divisoes) {
        if (d.getNome().equals(nomeDivisao)) {
            return d;
        }
    }
    return null; // não encontrou
    }

    public Divisao[] getDivisoes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDivisoes'");
    }
}

