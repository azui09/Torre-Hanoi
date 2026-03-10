package projeto_torre_hanoi.model;

public class Pilhas<T> {
    private int topoPilha;
    private T[] elementos;

    public Pilhas(int tamanho) {
        this.elementos = (T[]) new Object[tamanho];
        this.topoPilha = -1;
    }

    public boolean isEmpty() {
        return topoPilha == -1;
    }

    public boolean isFull() {
        return topoPilha == elementos.length - 1;
    }

    public void push(T e) throws Exception {
        if (!isFull()) {
            elementos[++topoPilha] = e;
        } else {
            throw new Exception("Overflow!");
        }
    }

    public T pop() throws Exception {
        if (!isEmpty()) {
            return elementos[topoPilha--];
        } else {
            throw new Exception("Underflow");
        }
    }

    public T topo() throws Exception {
        if (!isEmpty()) {
            return elementos[topoPilha];
        } else {
            throw new Exception("Underflow");
        }
    }

    public int sizeElements() {
        return topoPilha + 1;
    }
}
