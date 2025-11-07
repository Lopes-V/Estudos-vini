package Coleções;
import java.util.ArrayList;
import java.util.Collections; // Importa a classe Collections para usar o sort()
import java.util.List;

/**
 * Nossa classe de domínio.
 * Para que o Collections.sort() saiba como ordenar Filmes,
 * nós "assinamos o contrato" implementando Comparable<Filme>.
 */
// 
class Filme implements Comparable<Filme> {
    
    private String titulo;
    private int anoLancamento;
    private double avaliacao;

    public Filme(String titulo, int anoLancamento, double avaliacao) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.avaliacao = avaliacao;
    }

    // Getters para os atributos
    public String getTitulo() {
        return titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    // Sobrescrevemos o toString() para facilitar a impressão
    @Override
    public String toString() {
        return "Filme [Título: " + titulo + ", Avaliação: " + avaliacao + "]";
    }

    // --- ESTE É O MÉTODO PRINCIPAL DA INTERFACE COMPARABLE ---
    /**
     * Compara este Filme com outro Filme.
     * A ordem natural será definida pelo TÍTULO.
     */
    @Override
    public int compareTo(Filme outroFilme) {
        // Queremos ordenar por título.
        // A classe String (this.titulo) já implementa Comparable!
        // Então, podemos simplesmente delegar a comparação para ela.
        
        // Compara o título deste filme com o título do outro filme.
        return this.titulo.compareTo(outroFilme.getTitulo());
        
        /*
         * NOTA: Se quiséssemos ordenar por avaliação (double):
         * return Double.compare(this.avaliacao, outroFilme.getAvaliacao());
         *
         * Se quiséssemos ordenar por ano (int):
         * return Integer.compare(this.anoLancamento, outroFilme.getAnoLancamento());
         */
    }
}

// Classe principal para testar a ordenação
public class Comparable01 {
    public static void main(String[] args) {
        // 1. Cria a lista de filmes
        List<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(new Filme("O Poderoso Chefão", 1972, 9.2));
        listaDeFilmes.add(new Filme("A Origem", 2010, 8.8));
        listaDeFilmes.add(new Filme("Interestelar", 2014, 8.6));
        listaDeFilmes.add(new Filme("Batman: O Cavaleiro das Trevas", 2008, 9.0));

        // 2. Imprime a lista antes da ordenação (ordem de inserção)
        System.out.println("--- Lista Antes da Ordenação ---");
        for (Filme f : listaDeFilmes) {
            System.out.println(f);
        }

        // 3. A MÁGICA ACONTECE AQUI
        // Como 'Filme' implementa 'Comparable', o Collections.sort()
        // sabe exatamente como ordenar: ele chamará o método compareTo()
        // que escrevemos para cada comparação.
        Collections.sort(listaDeFilmes);

        // 4. Imprime a lista depois da ordenação
        System.out.println("\n--- Lista Depois da Ordenação (por Título) ---");
        for (Filme f : listaDeFilmes) {
            System.out.println(f); // A lista agora estará em ordem alfabética de título
        }
    }
}