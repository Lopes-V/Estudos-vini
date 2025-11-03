package NewIO;

import java.io.IOException; // Importa a classe para tratamento de exceções de Entrada/Saída.
import java.nio.file.DirectoryStream; // Importa a interface usada para iterar sobre o conteúdo de um diretório.
import java.nio.file.Files; // Importa a classe Files, que contém métodos estáticos para operações com arquivos/diretórios.
import java.nio.file.Path; // Importa a interface Path, que representa um caminho no sistema de arquivos.
import java.nio.file.Paths; // Importa a classe Paths, usada para criar objetos Path.

public class DirectoryStream01 {
    public static void main(String[] args) {
        
        // Cria um objeto Path que representa o diretório atual.
        // O "." (ponto) é um atalho que significa "o diretório onde este programa está sendo executado".
        Path dir = Paths.get(".");

        // Abre um "stream" (fluxo) para o diretório.
        // O 'DirectoryStream' não é como um Stream da API de Streams do Java 8 (não tem map, filter, etc.),
        // mas é um objeto iterável (Iterable).
        //
        // O try-with-resources garante que o 'stream' (que é um recurso do sistema)
        // seja fechado automaticamente ao final do bloco.
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            
            // Itera sobre cada entrada (seja um arquivo ou um subdiretório)
            // encontrada dentro do 'stream' (ou seja, dentro do diretório 'dir').
            for (Path path : stream) {
                
                // Imprime apenas o nome do arquivo ou subdiretório (ex: "pom.xml", "src", "file.txt")
                // e não o caminho completo (ex: "./pom.xml").
                System.out.println(path.getFileName());
            }
        } catch (IOException e) {
            // Captura possíveis erros de I/O, como falha ao ler o diretório
            // (por exemplo, se o diretório não existir ou por falta de permissão).
            e.printStackTrace(); // Imprime os detalhes do erro no console.
        }  
    }
}