package NewIO;
import java.nio.file.Path; // Importa a interface Path (caminho)
import java.nio.file.PathMatcher; // Importa a interface que permite "casar" (match) caminhos
import java.nio.file.Paths; // Importa a classe para criar objetos Path

public class PathMatcher01 {
    public static void main(String[] args) {
        // Cria alguns objetos Path para testar
        Path path1 = Paths.get("arquivo.txt"); // Um arquivo na raiz
        Path path2 = Paths.get("documento.pdf"); // Outro arquivo na raiz
        Path path3 = Paths.get("imagens/foto.jpg"); // Um arquivo dentro de um subdiretório

        System.out.println("Testando PathMatchers com diferentes padrões 'glob':");
        
        // --- Testes ---
        // 'matches' é um método auxiliar (helper) definido abaixo
        
        // 
        
        // '*' (asterisco) = casa com 0 ou mais caracteres (exceto separadores de diretório)
        matches(path1, "*.txt"); // Deve ser true (qualquercoisa.txt)
        matches(path2, "*.pdf"); // Deve ser true (qualquercoisa.pdf)
        matches(path3, "imagens/*.jpg"); // Deve ser true (imagens/qualquercoisa.jpg)
        matches(path3, "*.png"); // Deve ser false (não termina com .png)
        
        // 'doc*.*' = começa com "doc", seguido por 0 ou mais caracteres,
        //            seguido por um ponto (.), seguido por 0 ou mais caracteres.
        matches(path2, "doc*.*");    // Deve ser true (casa com "documento.pdf")

        // '?' (interrogação) = casa com exatamente UM caractere
        matches(path1, "arq??vo.txt");  // Deve ser true (arq[u][i]vo.txt)
        
        // Combinando '*' e '.'
        matches(path1, "arq*vo.*");   // Deve ser true (começa com "arq", tem "vo" no meio, e qualquer extensão)
        matches(path2, "doc*.pdf");   // Deve ser true (começa com "doc", termina com ".pdf")
        matches(path3, "imagens/*.*");  // Deve ser true (qualquer arquivo dentro de "imagens" que tenha uma extensão)
    }

    /**
     * Método auxiliar para criar e executar um PathMatcher.
     * @param path O objeto Path que queremos testar.
     * @param glob O padrão de busca (glob pattern) que queremos aplicar.
     */
    private static void matches (Path path, String glob) {
        
        // 1. Obtém o FileSystem padrão.
        // 2. A partir dele, obtém um PathMatcher.
        // 3. Especificamos a sintaxe: "glob:" + o padrão.
        //    (A outra sintaxe principal é "regex:" para expressões regulares)
        PathMatcher matcher = path.getFileSystem().getPathMatcher("glob:" + glob);
        
        // 4. Executa o teste (o "match").
        //    Verifica se o 'path' *inteiro* corresponde ao padrão 'glob'.
        System.out.println(glob + " => " + matcher.matches(path));
    }
}