package Coleções;

// Importa a interface NavigableMap, que estende SortedMap e fornece métodos adicionais
// para navegação dentro do mapa (como pegar o anterior, o próximo, etc.)
import java.util.NavigableMap;

public class TreeMap01 {

    public static void main(String[] args) {

        // Criação de um TreeMap, que é uma implementação de NavigableMap.
        // O TreeMap mantém os elementos ordenados pela chave (no caso, Integer).
        NavigableMap<Integer, String> treeCapitais = new java.util.TreeMap<>();

        // Adicionando pares (chave, valor) ao mapa.
        // A chave representa um número e o valor o nome de uma capital.
        treeCapitais.put(1, "Brasília");
        treeCapitais.put(2, "Salvador");

        // Percorre todas as entradas do mapa e imprime chave e valor.
        // O TreeMap garante que a ordem será crescente pela chave.
        for (NavigableMap.Entry<Integer, String> capital : treeCapitais.entrySet()) {
            System.out.println(capital.getKey() + " - " + capital.getValue());
        }

        System.out.println("-------------------");

        // firstEntry(): retorna a primeira entrada (menor chave) do mapa.
        System.out.println("Primeira capital: " + treeCapitais.firstEntry().getValue());

        // lastEntry(): retorna a última entrada (maior chave) do mapa.
        System.out.println("Última capital: " + treeCapitais.lastEntry().getValue());

        // headMap(2): retorna um mapa contendo todas as entradas com chave menor que 2.
        // Não inclui a chave 2, a menos que se especifique true como segundo parâmetro.
        System.out.println(treeCapitais.headMap(2));

        // tailMap(2): retorna um mapa com todas as entradas a partir da chave 2 (inclusive).
        System.out.println(treeCapitais.tailMap(2));

        // subMap(1, 2): retorna um mapa com as chaves entre 1 (inclusiva) e 2 (exclusiva).
        System.out.println(treeCapitais.subMap(1, 2));

        // lowerEntry(2): retorna a entrada imediatamente anterior à chave 2.
        // No caso, a chave 1.
        System.out.println(treeCapitais.lowerEntry(2));

        // higherEntry(1): retorna a entrada imediatamente posterior à chave 1.
        // No caso, a chave 2.
        System.out.println(treeCapitais.higherEntry(1));

        // floorEntry(2): retorna a entrada com a maior chave menor ou igual a 2.
        System.out.println(treeCapitais.floorEntry(2));

        // ceilingEntry(1): retorna a entrada com a menor chave maior ou igual a 1.
        System.out.println(treeCapitais.ceilingEntry(1));
    }
}
