package Variaveis;

// Importa a classe Scanner, para ler entradas do usuário (embora não seja usada neste código).
import java.util.Scanner;

public class VariaveisString {
    // Método principal, o ponto de entrada da aplicação.
    public static void main(String[] args) {
        // Cria um objeto Scanner, mas a variável 'sc' não é utilizada no restante do código.
        Scanner sc = new Scanner(System.in);
        
        // Declara uma String 'n' e a inicializa com o valor "Vinicius".
        String n = "Vinicius";
        
        // Converte a String em um array de bytes usando o charset padrão e imprime o endereço de memória do array.
        System.out.println(n.getBytes());
        // Retorna um fluxo (IntStream) dos valores inteiros dos caracteres e imprime o endereço de memória do objeto do fluxo.
        System.out.println(n.chars());
        // Imprime o comprimento (número de caracteres) da String 'n'. Saída: 8.
        System.out.println(n.length());
        // Substitui a ocorrência exata da String "Vinicius" (o valor de 'n') por "MACHO ALFA" e imprime o resultado.
        System.out.println(n.replace(n,"MACHO ALFA"));
        // Verifica se a String 'n' termina com a letra "a". Retorna e imprime 'false' (falso).
        System.out.println(n.endsWith("a"));
        // O método formatted() serve para formatar strings com argumentos (ex: "%s".formatted("valor")).
        // Chamado sem argumentos, ele apenas retorna a própria String. Saída: "Vinicius".
        System.out.println(n.formatted());
        
        // Tenta dividir (split) a String 'n' usando o espaço " " como delimitador.
        // Como não há espaços em "Vinicius", o array resultante terá um único elemento: "Vinicius".
        String[] palavras = n.split(" ");
        // Imprime o endereço de memória do array 'palavras', e não o seu conteúdo.
        System.out.println(palavras);
        // Tenta dividir a String 'n' usando "i" como delimitador.
        // Isso também retorna um array, mas a linha imprime apenas o endereço de memória do array.
        System.out.println(n.split("i"));

        // Cria um objeto StringBuilder vazio. É uma sequência de caracteres MUTÁVEL e mais eficiente para concatenações.
        StringBuilder sB = new StringBuilder(); 
        // Retorna e imprime uma parte da String 'n', do índice 0 até o 5 (o índice 6 não é incluído). Saída: "Vinici".
        System.out.println(n.substring(0, 6));
        
        // Adiciona um caractere de espaço ao StringBuilder 'sB'.
        sB.append(" ");
        // Imprime o conteúdo atual de 'sB'. Saída: " ".
        System.out.println(sB);
        // Imprime a capacidade de armazenamento atual do StringBuilder antes que ele precise ser redimensionado. O padrão inicial é 16.
        System.out.println(sB.capacity());
        // Inverte o conteúdo de 'sB' (um espaço invertido ainda é um espaço) e imprime o resultado.
        System.out.println(sB.reverse());
        
        // Chama o método formatted(), mas não armazena nem imprime o resultado. Esta linha não tem efeito visível.
        n.formatted();
        // Retorna uma referência da string do "pool" de strings do Java, mas o resultado não é usado. Sem efeito visível.
        n.intern();

        // Cria um objeto StringBuffer vazio. É uma alternativa ao StringBuilder que é "thread-safe" (sincronizada).
        StringBuffer stringBuffer = new StringBuffer(); 
        // Adiciona a string "nome" ao StringBuffer.
        stringBuffer.append("nome");
        // Garante que o StringBuffer tenha capacidade para pelo menos 6 caracteres. Não altera o conteúdo.
        stringBuffer.ensureCapacity(6);
        // Imprime o comprimento do conteúdo atual do StringBuffer ("nome"). Saída: 4.
        System.out.println(stringBuffer.length());
    }
}