package projeto_torre_hanoi.model;

public class Torre {
    private String nome;
    private Pilhas<Disco> discos;

    public Torre(String nome, int capacidade) {
        this.nome = nome;
        this.discos = new Pilhas<>(capacidade);
    }

    public void adicionarDisco(Disco disco) throws Exception {
        if(discos.isEmpty() || discos.topo().getTamanho() >disco.getTamanho()) {
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
            while(!discos.isEmpty()) {
                temporaria.push(discos.pop());
            }
            while(!temporaria.isEmpty()) {
                Disco disco = temporaria.pop();
                System.out.println(disco.getAsteriscos());
                discos.push(disco);
            }
        } catch(Exception e) {
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
