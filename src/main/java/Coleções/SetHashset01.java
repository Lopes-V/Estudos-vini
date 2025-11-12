package Coleções;
import java.util.HashSet;
import java.util.Set; // Importa a interface Set
import java.util.TreeSet; // (Apenas para mostrar a diferença de ordem no final)

public class SetHashset01 {
    public static void main(String[] args) {
        
        // 1. CRIAÇÃO DO SET
        
        // Boa prática: Declaramos a variável como a Interface (Set)
        // e a instanciamos com a Classe Concreta (HashSet).
        Set<String> meusItens = new HashSet<>();

        // 2. ADICIONANDO ELEMENTOS
        System.out.println("Adicionando itens...");
        meusItens.add("Notebook");
        meusItens.add("Mouse");
        meusItens.add("Teclado");
        meusItens.add("Monitor");
        meusItens.add(null); // HashSet permite um (e apenas um) item nulo

        // 3. TENTANDO ADICIONAR DUPLICATAS
        // O método 'add()' retorna 'false' se o item já existe
        // e a adição falha (sem causar erro).
        System.out.println("Tentando adicionar 'Mouse' de novo: " + meusItens.add("Mouse"));
        System.out.println("Tentando adicionar 'Teclado' de novo: " + meusItens.add("Teclado"));

        // 4. IMPRIMINDO O CONJUNTO
        
        // **PERCEBA DUAS COISAS:**
        // 1. Os itens duplicados ("Mouse", "Teclado") NÃO estão lá duas vezes.
        // 2. A ordem de impressão NÃO É a ordem que inserimos.
        System.out.println("\n--- Conteúdo do HashSet (Sem Duplicatas, Sem Ordem) ---");
        System.out.println(meusItens);

        // 5. VERIFICANDO SE UM ITEM EXISTE (uso principal)
        // Isso é muito rápido em um HashSet.
        System.out.println("\n--- Verificações (contains) ---");
        System.out.println("O conjunto 'contém' Teclado? " + meusItens.contains("Teclado"));
        System.out.println("O conjunto 'contém' Cadeira? " + meusItens.contains("Cadeira"));

        // 6. ITERANDO SOBRE O SET
        // (A ordem não é garantida)
        System.out.println("\n--- Iterando sobre o Set ---");
        for (String item : meusItens) {
            System.out.println(item);
        }

        // 7. REMOVENDO UM ITEM
        meusItens.remove("Monitor");
        System.out.println("\nApós remover 'Monitor': " + meusItens);

        // 8. BÔNUS: E SE EU QUISER ORDEM?
        // Se precisar de ordem alfabética (ou natural), use 'TreeSet'.
        // (Ele é mais lento que o HashSet para inserir).
        Set<String> itensOrdenados = new TreeSet<>(meusItens);
        System.out.println("\nUsando TreeSet para ordenar: " + itensOrdenados);
    }
}