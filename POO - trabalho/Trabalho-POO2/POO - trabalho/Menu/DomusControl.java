package Menu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Dispositivos.Dispositivo;
import Utilizador.Casa;
import Utilizador.Divisao;
import Utilizador.Utilizador;


public class DomusControl implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private List<Utilizador> utilizadores   = new ArrayList<>();
    private List<Casa>       casas          = new ArrayList<>();
    private List<Dispositivo> dispositivos  = new ArrayList<>();
    // ...

    //métodos de listagem para poder ver os nossos util. disp. e casas
    public List<Utilizador> getUtilizadores() { return utilizadores; }
    public List<Casa> getCasas()              { return casas; }
    public List<Dispositivo> getDispositivos(){ return dispositivos; }

    //Dispositivos
    public void adicionarDispositivo(String nomeCasa, String nomeDivisao, Dispositivo dispositivo) {
    Casa casa = getCasa(nomeCasa);
    if (casa == null) { System.out.println("Casa não encontrada."); return; }

    Divisao divisao = casa.getDivisao(nomeDivisao);
    if (divisao == null) { System.out.println("Divisão não encontrada."); return; }

    divisao.adicionarDispositivo(dispositivo);
    this.dispositivos.add(dispositivo); // ← adiciona também à lista geral!!!!!
    System.out.println("Dispositivo adicionado com sucesso!");
}


    // Utilizadores
    public void adicionarUtilizador(Utilizador u) {
        utilizadores.add(u);
    }

    public Utilizador getUtilizador(String nome) {
        for (Utilizador u : utilizadores) {
            if (u.getNome().equals(nome)) return u;
        }
        return null;
    }

    // Casas
    public void adicionarCasa(Casa c) {
        casas.add(c);
    }

    public Casa getCasa(String nome) {
        for (Casa c : casas) {
            if (c.getNome().equals(nome)) return c;
        }
        return null;
    }
}
