package Coleções;
import java.util.ArrayList;
import java.util.Iterator; // Importa a interface Iterator
import java.util.List;

/**
 * Classe de domínio simples para o exemplo.
 */
class Manga {
    private String nome;
    private int quantidade;

    public Manga(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "Manga{nome='" + nome + "', qtd=" + quantidade + "}";
    }
}

public class Interator01 {
    public static void main(String[] args) {
        
        // 1. Cria e popula a lista de mangas
        List<Manga> mangas = new ArrayList<>();
        mangas.add(new Manga("Bleach", 5));
        mangas.add(new Manga("One Piece", 10));
        mangas.add(new Manga("Sem Estoque", 0)); // Este será removido
        mangas.add(new Manga("Naruto", 2));
        mangas.add(new Manga("Esgotado", 0)); // Este também será removido

        System.out.println("Lista Original: " + mangas);
        
        // --- MÉTODO 1: O ITERATOR (O jeito "clássico") ---
        // Este é o bloco de código que estava comentado na sua imagem.
        
        //         
        // 1. Pede à coleção o seu "iterador" (o cursor).
        Iterator<Manga> mangaIterator = mangas.iterator();

        // 2. O loop 'while'. Lê-se: "Enquanto o iterador TIVER UM PRÓXIMO item..."
        while (mangaIterator.hasNext()) {
            
            // 3. Pega o próximo item.
            // O 'next()' faz DUAS coisas:
            //    a) Retorna o item atual.
            //    b) Avança o cursor para o próximo item.
            Manga manga = mangaIterator.next();

            // 4. A lógica de negócio (igual à da sua imagem)
            if (manga.getQuantidade() == 0) {
                
                // 5. A REMOÇÃO SEGURA!
                // 'iterator.remove()' remove o ÚLTIMO item que foi pego
                // pelo 'next()'. Esta é a forma 100% segura de
                // modificar a coleção durante a iteração.
                mangaIterator.remove();
            }
        }

        System.out.println("Lista após o Iterator: " + mangas);

        System.out.println("---");
        
        // --- MÉTODO 2: O 'removeIf' (O jeito "moderno" do Java 8+) ---
        // Este é o método que *não* estava comentado na sua imagem.
        // É um atalho que faz EXATAMENTE a mesma coisa que o Iterator acima,
        // mas de forma muito mais limpa.

        // Vamos adicionar mais um item com 0 para o exemplo
        mangas.add(new Manga("Esgotado 2", 0));
        System.out.println("Lista antes do 'removeIf': " + mangas);

        // "Remova SE" (removeIf) qualquer 'manga' onde
        // (->) a condição 'manga.getQuantidade() == 0' for verdadeira.
        mangas.removeIf(manga -> manga.getQuantidade() == 0);
        
        // Por "baixo dos panos", o 'removeIf' está usando um Iterator
        // igual ao que fizemos manualmente acima!
        
        System.out.println("Lista após o 'removeIf': " + mangas);
    }
}