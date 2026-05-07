package Menu;
import java.util.List;
import java.util.Scanner;

import Dispositivos.Dispositivo;
//import NewMenu;
import Dispositivos.Lampada;
import Dispositivos.Rele;
import Utilizador.Casa;
import Utilizador.Divisao;
import Utilizador.TipoUtilizador;
import Utilizador.Utilizador;

public class TextUI {
    private DomusControl model;
    private Scanner sc;

    public TextUI() {
        this.model = new DomusControl();
        this.sc = new Scanner(System.in);
    }

    public void run() {
        NewMenu menu = new NewMenu(new String[]{
            "Gerir Casas",
            "Gerir Dispositivos",
            "Gerir Utilizadores",
            "Automações",
            "Escalonamentos",
            "Cenários",
            "Avançar Tempo",
            "Listar Dados"
        });

        //menu.setHandler(1, () -> gerirCasas());
        menu.setHandler(2, () -> gerirDispositivos());
        //menu.setHandler(3, () -> gerirUtilizadores());
        //menu.setHandler(4, () -> gerirAutomacoes());
        //menu.setHandler(5, () -> gerirEscalonamentos());
        //menu.setHandler(6, () -> gerirCenarios());
        //menu.setHandler(7, () -> avancarTempo());
        menu.setHandler(8, () -> listarTudo());

        menu.run();
    }

    private void gerirDispositivos() {
        NewMenu sub = new NewMenu(new String[]{
            "Adicionar Dispositivo",
            "Ligar Dispositivo",
            "Desligar Dispositivo",
            "Ver Estado"
        });
        sub.setHandler(1, () -> adicionarDispositivo());
        // ...
        sub.run();
    }

//Adicionar um utilizador
private void adicionarUtilizador() {
    System.out.print("Nome do utilizador: ");
    String nome = sc.nextLine();

    Utilizador u = new Utilizador(nome);
    this.model.adicionarUtilizador(u);
    System.out.println("Utilizador '" + nome + "' criado com sucesso!");
}

//Adicionar uma casa
private void adicionarCasa() {
    System.out.print("Nome da casa: ");
    String nomeCasa = sc.nextLine();

    Casa c = new Casa(nomeCasa);

    System.out.print("Quantas divisões? ");
    int n = lerInt();

    for (int i = 0; i < n; i++) {
        System.out.print("Nome da divisão " + (i+1) + ": ");
        String nomeDivisao = sc.nextLine();
        c.adicionarDivisao(new Divisao(nomeDivisao));
    }

    this.model.adicionarCasa(c);
    System.out.println("Casa '" + nomeCasa + "' criada com " + n + " divisões!");
}


// Opção de adicionar dispositivos
private void adicionarDispositivo() {
    System.out.print("Nome da casa: ");
    String nomeCasa = sc.nextLine();

    System.out.print("Nome da divisão: ");
    String nomeDivisao = sc.nextLine();

    System.out.print("ID: ");
    String id = sc.nextLine();

    System.out.print("Marca: ");
    String marca = sc.nextLine();

    System.out.print("Modelo: ");
    String modelo = sc.nextLine();

    System.out.print("Consumo por hora (Wh): ");
    double consumo = lerDouble();

    System.out.println("Tipo: 1-Lâmpada  2-Relé");
    int tipo = lerInt();

    //dizer qual é o tipo de dispositivo que estamos a adicionar
    switch (tipo) { //falta acrescentar os parâmtros específicos de cada dispositivo como a intensidade e temperatura da lampada
        case 1 -> {
            Lampada l = new Lampada(id, marca, modelo, nomeDivisao, consumo);
            this.model.adicionarDispositivo(nomeCasa, nomeDivisao, l);
            System.out.println("Lâmpada adicionada!");
        }
        case 2 -> {
            Rele r = new Rele(id, marca, modelo, nomeDivisao, consumo);
            this.model.adicionarDispositivo(nomeCasa, nomeDivisao, r);
            System.out.println("Relé adicionado!");
        }
        default -> System.out.println("Tipo inválido.");
    }
}

// Adicionar um utilizador
private void associarUtilizadorACasa() {
    System.out.print("Nome do utilizador: ");
    String nomeU = sc.nextLine();

    System.out.print("Nome da casa: ");
    String nomeC = sc.nextLine();

    Utilizador u = this.model.getUtilizador(nomeU);
    Casa c       = this.model.getCasa(nomeC);

    if (u == null) { System.out.println("Utilizador não encontrado."); return; }
    if (c == null) { System.out.println("Casa não encontrada."); return; }

    u.adicionarCasa(c, TipoUtilizador.UTILIZADOR_COMUM);
    System.out.println("Utilizador adicionado à casa com sucesso!");
}

//Listar os dados para ver melhor
private void listarTudo() {
    NewMenu menu = new NewMenu(new String[]{
        "Ver Utilizadores",
        "Ver Casas e Divisões",
        "Ver Dispositivos"
    });

    menu.setHandler(1, () -> listarUtilizadores());
    menu.setHandler(2, () -> listarCasas());
    menu.setHandler(3, () -> listarDispositivos());

    menu.run();
}

private void listarUtilizadores() {
    List<Utilizador> listaUtilizadores = this.model.getUtilizadores();
    if (listaUtilizadores.isEmpty()) {
        System.out.println("Nenhum utilizador registado.");
        return;
    }
    System.out.println("\n--- Utilizadores ---");
    for (Utilizador utilizador : listaUtilizadores) {
        System.out.println("• " + utilizador.getNome());
        utilizador.listarMinhasCasas();
    }
}

private void listarCasas() {
    List<Casa> listaCasas = this.model.getCasas();
    if (listaCasas.isEmpty()) {
        System.out.println("Nenhuma casa registada.");
        return;
    }
    System.out.println("\n--- Casas ---");
    for (Casa casa : listaCasas) {
        System.out.println("• " + casa.getNome());
        for (Divisao divisao : casa.getDivisoes()) {
            System.out.println("    └─ " + divisao.getNome());
            for (Dispositivo dispositivo : divisao.getDispositivos()) {
                System.out.println("        └─ " + dispositivo.exibirStatus());
            }
        }
    }
}

private void listarDispositivos() {
    List<Casa> listaCasas = this.model.getCasas();

    if (listaCasas.isEmpty()) {
        System.out.println("Nenhum dispositivo registado.");
        return;
    }

    System.out.println("\n--- Dispositivos ---");
    boolean encontrouAlgum = false;

    for (Casa casa : listaCasas) {
        for (Divisao divisao : casa.getDivisoes()) {
            for (Dispositivo dispositivo : divisao.getDispositivos()) {
                System.out.println("• " + dispositivo.exibirStatus());
                encontrouAlgum = true;
            }
        }
    }

    if (!encontrouAlgum) {
        System.out.println("Nenhum dispositivo registado.");
    }
}

//necessário para ler os doubles para registar intensidade de dispositivos
private double lerDouble() {
    try {
        return Double.parseDouble(sc.nextLine().trim());
    } catch (NumberFormatException e) {
        System.out.println("Valor inválido, assumido 0.0.");
        return 0.0;
    }
}

private int lerInt() {
    try {
        return Integer.parseInt(sc.nextLine().trim());
    } catch (NumberFormatException e) {
        System.out.println("Valor inválido, assumido 0.");
        return 0;
    }
}
}