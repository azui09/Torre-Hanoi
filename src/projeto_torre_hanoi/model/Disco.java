package projeto_torre_hanoi.model;

public class Disco {
    private int tamanho;
    private String asteriscos = "";

    public Disco(int tamanho) {
        this.tamanho = tamanho;
        this.asteriscos = "";
        for(int i = 0; i < tamanho; i++) {
            asteriscos += '*';
        }
    }

    public int getTamanho() {
        return tamanho;
    }

    public String getAsteriscos() {
        return asteriscos;
    }
}
