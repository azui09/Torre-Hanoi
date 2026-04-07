package Torre_Hanoi.model;

public class Torre {
    private final String nome;
    private final Pilhas<Disco> discos;

    public Torre(String nome, int capacidade) {
        this.nome = nome;
        this.discos = new Pilhas<>(capacidade);
    }

    public void adicionarDisco(Disco disco) throws Exception {
        if (discos.isEmpty() || discos.topo().getTamanho() > disco.getTamanho()) {
            discos.push(disco);
        } else {
            throw new Exception("Movimento invalido");
        }
    }

    public Disco removerDisco() throws Exception {
        return discos.pop();
    }

    public boolean isEmpty() {
        return discos.isEmpty();
    }

    public void mostrarDiscos() {
        Pilhas<Disco> temporaria = new Pilhas<>(discos.sizeElements());
        try {
            while (!discos.isEmpty()) {
                Disco disco = discos.pop();
                System.out.println(disco.getAsteriscos());
                temporaria.push(disco);
            }
            while (!temporaria.isEmpty()) {
                discos.push(temporaria.pop());
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public String getNome() {
        return nome;
    }

    public Disco topo() throws Exception {
        return discos.topo();
    }
}
