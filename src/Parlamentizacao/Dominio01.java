package Parlamentizacao;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate; // Importante para o final!

/**
 * Nossa classe de domínio simples.
 */
class Carro {
    private String nome;
    private String cor;
    private int ano;

    public Carro(String nome, String cor, int ano) {
        this.nome = nome;
        this.cor = cor;
        this.ano = ano;
    }

    // Getters
    public String getNome() { return nome; }
    public String getCor() { return cor; }
    public int getAno() { return ano; }

    @Override
    public String toString() {
        return "Carro{" + "nome='" + nome + '\'' + ", cor='" + cor + '\'' + ", ano=" + ano + '}';
    }
}