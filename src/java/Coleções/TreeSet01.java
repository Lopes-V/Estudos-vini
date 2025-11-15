package Coleções;
import java.util.NavigableSet; // Importa a interface de navegação
import java.util.TreeSet; // Importa a implementação (que é ordenada)

public class TreeSet01 {

    public static void main(String[] args) {
        
        // 1. CRIAÇÃO DO TREESET
        
        // Boa prática: declare com a interface NavigableSet,
        // instancie com a classe TreeSet.
        //
        // O TreeSet automaticamente usará a "ordem natural" dos Integers
        // (definida pela interface Comparable que Integer implementa).
        NavigableSet<Integer> numeros = new TreeSet<>();

        // 2. ADICIONANDO ITENS (fora de ordem)
        System.out.println("Adicionando itens...");
        numeros.add(50);
        numeros.add(10);
        numeros.add(80);
        numeros.add(20);
        
        // 3. PROVA DE SET (SEM DUPLICATAS)
        // O 'add' retorna 'false' pois 50 já existe.
        System.out.println("Tentando adicionar 50 de novo: " + numeros.add(50)); 
        
        // 4. PROVA DE ORDEM
        // Mesmo adicionados fora de ordem, o TreeSet os armazena
        // e sempre os exibe em ordem natural (crescente).
        System.out.println("\nTreeSet (sempre ordenado): " + numeros); 
        // Saída: [10, 20, 50, 80]

        // --- 5. USANDO OS MÉTODOS DE NAVEGAÇÃO ---
        // Vamos usar o número 50 como nosso "pivô" de busca.
        
        // 
        System.out.println("\n--- Métodos de Navegação (Pivô = 50) ---");

        // lower (menor < 50)
        System.out.println("lower(50) (Quem é < 50?): " + numeros.lower(50)); // Saída: 20

        // floor (menor ou igual <= 50)
        System.out.println("floor(50) (Quem é <= 50?): " + numeros.floor(50)); // Saída: 50
        
        // ceiling (maior ou igual >= 50)
        System.out.println("ceiling(50) (Quem é >= 50?): " + numeros.ceiling(50)); // Saída: 50

        // higher (maior > 50)
        System.out.println("higher(50) (Quem é > 50?): " + numeros.higher(50)); // Saída: 80

        // E se o número NÃO EXISTIR? Ex: pivô = 49
        System.out.println("\n--- (Pivô = 49, não está no set) ---");
        System.out.println("floor(49) (Quem é <= 49?): " + numeros.floor(49)); // Saída: 20
        System.out.println("ceiling(49) (Quem é >= 49?): " + numeros.ceiling(49)); // Saída: 50

        // --- 6. REMOVENDO PELAS BORDAS ---
        System.out.println("\n--- Removendo elementos ---");
        
        // Remove e retorna o primeiro (menor)
        System.out.println("pollFirst() (remove o menor): " + numeros.pollFirst()); // Saída: 10
        
        // Remove e retorna o último (maior)
        System.out.println("pollLast() (remove o maior): " + numeros.pollLast()); // Saída: 80
        
        System.out.println("Set após remoções: " + numeros); // Saída: [20, 50]

        // --- 7. VISÃO REVERSA ---
        System.out.println("\nVisão descendente: " + numeros.descendingSet()); // Saída: [50, 20]
    }
}