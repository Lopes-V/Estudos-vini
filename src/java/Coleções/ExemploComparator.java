// package Coleções;
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Comparator;
// import java.util.List;

// // Relembrando nossa classe:
// class Filme implements Comparable<Filme> {
//     private String titulo;
//     private int anoLancamento;
//     private double avaliacao;

//     public Filme(String titulo, int anoLancamento, double avaliacao) {
//         this.titulo = titulo;
//         this.anoLancamento = anoLancamento;
//         this.avaliacao = avaliacao;
//     }

//     // Getters
//     public String getTitulo() { return titulo; }
//     public int getAnoLancamento() { return anoLancamento; }
//     public double getAvaliacao() { return avaliacao; }

//     @Override
//     public String toString() {
//         return "Filme [Título: " + titulo + ", Ano: " + anoLancamento + ", Avaliação: " + avaliacao + "]";
//     }

//     // ORDEM NATURAL: por Título (como definido no exemplo anterior)
//     @Override
//     public int compareTo(Filme outroFilme) {
//         return this.titulo.compareTo(outroFilme.getTitulo());
//     }
// }

// /**
//  * Esta é uma classe 'Comparator' externa.
//  * Sua única finalidade é saber como comparar dois Filmes pela AVALIAÇÃO.
//  */
// // 
// class SortByAvaliacao implements Comparator<Filme> {

//     // Este é o método principal da interface Comparator
//     @Override
//     public int compare(Filme f1, Filme f2) {
//         // Queremos ordenar da MAIOR avaliação para a MENOR (descendente).
//         // Por isso, comparamos f2 com f1 (invertido).
//         // Usar Double.compare() é a forma correta de comparar 'doubles'.
//         return Double.compare(f2.getAvaliacao(), f1.getAvaliacao());
//     }
// }
// public class ExemploComparator {
//     public static void main(String[] args) {
//         // 1. Cria a lista de filmes
//         List<Filme> listaDeFilmes = new ArrayList<>();
//         listaDeFilmes.add(new Filme("O Poderoso Chefão", 1972, 9.2));
//         listaDeFilmes.add(new Filme("A Origem", 2010, 8.8));
//         listaDeFilmes.add(new Filme("Interestelar", 2014, 8.6));
//         listaDeFilmes.add(new Filme("Batman: O Cavaleiro das Trevas", 2008, 9.0));

//         // 2. Imprime a lista antes da ordenação
//         System.out.println("--- Lista Original (Ordem de Inserção) ---");
//         for (Filme f : listaDeFilmes) {
//             System.out.println(f);
//         }

//         // 3. ORDENAÇÃO NATURAL (usando o 'compareTo' da classe Filme)
//         Collections.sort(listaDeFilmes);
//         System.out.println("\n--- Ordenado por Título (Comparable) ---");
//         for (Filme f : listaDeFilmes) {
//             System.out.println(f);
//         }

//         // 4. ORDENAÇÃO ALTERNATIVA (usando o 'Comparator' externo)
//         // Criamos uma instância do nosso comparador
//         SortByAvaliacao comparadorPorAvaliacao = new SortByAvaliacao();
        
//         // Passamos a lista E o comparador para o método sort()
//         Collections.sort(listaDeFilmes, comparadorPorAvaliacao);
        
//         System.out.println("\n--- Ordenado por Avaliação (Comparator) ---");
//         for (Filme f : listaDeFilmes) {
//             System.out.println(f); // Agora ordenado pela maior avaliação
//         }
        
//         // 5. ORDENAÇÃO MODERNA (Java 8+ com lambda e 'comparing')
//         // Não é preciso criar uma classe inteira!
//         // "Ordene por ano de lançamento"
//         Comparator<Filme> porAno = Comparator.comparingInt(Filme::getAnoLancamento);
//         Collections.sort(listaDeFilmes, porAno);

//         System.out.println("\n--- Ordenado por Ano (Comparator Moderno) ---");
//         for (Filme f : listaDeFilmes) {
//             System.out.println(f); // Agora ordenado pelo ano
//         }
//     }
// }