package NewIO;

import java.io.IOException; // Importa para tratamento de exceções de I/O.
import java.nio.file.FileVisitResult; // Importa a enumeração que diz ao "visitante" o que fazer (CONTINUE, TERMINATE, etc.).
import java.nio.file.Files; // Importa a classe Files, que contém o método 'walkFileTree'.
import java.nio.file.Path; // Importa a interface Path.
import java.nio.file.Paths; // Importa a classe Paths para criar objetos Path.
import java.nio.file.SimpleFileVisitor; // Importa a classe base que implementa a lógica do "visitante".
import java.nio.file.attribute.BasicFileAttributes; // Importa para acessar os atributos básicos do arquivo.

// --- O "Visitante" (Visitor) ---
// Criamos uma classe que define O QUE FAZER em cada etapa da "caminhada".
// Ela herda de 'SimpleFileVisitor', que nos permite sobrescrever apenas os métodos que nos interessam.
class listAllFiles extends SimpleFileVisitor<Path> {
    
    // Sobrescreve o método que é chamado para *cada arquivo* encontrado.
    // Existem outros métodos que poderíamos sobrescrever, como:
    // - preVisitDirectory (antes de entrar em um diretório)
    // - postVisitDirectory (depois de sair de um diretório)
    // - visitFileFailed (se houver um erro ao visitar um arquivo)
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        
        // Lógica personalizada: verifica se o nome do arquivo termina com ".java".
        if(file.getFileName().toString().endsWith(".java")){
            // Se sim, imprime uma mensagem específica.
            System.out.println("Java File: " + file.getFileName());
        } else {
            // Se não, imprime uma mensagem genérica.
            System.out.println("Other File: " + file.getFileName());
        }
        
        // Retorna 'CONTINUE' para dizer ao 'walkFileTree' para continuar a caminhada.
        // Se retornássemos 'TERMINATE', a busca pararia imediatamente.
        return FileVisitResult.CONTINUE;
    }
}

// --- O "Executor" ---
public class SimpleFileVisitor01 {
    // O método main lança IOException porque o 'walkFileTree' pode falhar
    // (ex: falta de permissão para ler um diretório).
    public static void main(String[] args) throws IOException {
        
        // Define o ponto de partida da caminhada.
        // "." (ponto) significa "o diretório atual" (onde o programa está sendo executado).
        Path path = Paths.get(".");
        
        // 
        // Inicia a "caminhada pela árvore de arquivos" (walkFileTree).
        // Este método percorre *recursivamente* todos os arquivos e subdiretórios
        // a partir do 'path' inicial.
        // 1º argumento: 'path' (Onde começar a caminhada).
        // 2º argumento: 'new listAllFiles()' (O "visitante" - o objeto que define
        //               o que fazer quando encontrar um arquivo ou diretório).
        Files.walkFileTree(path, new listAllFiles());
    }
}