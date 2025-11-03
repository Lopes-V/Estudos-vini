package NewIO;

import java.io.IOException;
import java.nio.file.FileVisitResult; // Importa o enum que controla o fluxo da "caminhada" (CONTINUE, TERMINATE, etc.)
import java.nio.file.Files; // Importa a classe Files para usar o 'walkFileTree'
import java.nio.file.Path; // Importa a interface Path
import java.nio.file.Paths; // Importa a classe Paths
import java.nio.file.SimpleFileVisitor; // Importa a classe "visitante" que vamos estender
import java.nio.file.attribute.BasicFileAttributes; // Importa os atributos do arquivo

// CORREÇÃO: O nome da classe foi alterado para 'ListAllFiles' (padrão Java CamelCase)
// Esta classe define O QUE FAZER em cada etapa da "caminhada" pela árvore de diretórios.
class ListAllFiles extends SimpleFileVisitor<Path> {

    // 

    // 1. CHAMADO AO VISITAR UM ARQUIVO
    // É chamado para cada *arquivo* encontrado.
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        // CORREÇÃO: Adicionado este print.
        // O método original estava vazio, mas o nome da classe ("ListAllFiles")
        // sugere que deveríamos listar os arquivos encontrados.
        System.out.println("  Arquivo: " + file.getFileName());
        
        // Retorna CONTINUE para prosseguir com a "caminhada".
        return FileVisitResult.CONTINUE;
    }

    // 2. CHAMADO ANTES DE VISITAR UM DIRETÓRIO
    // É chamado *antes* de entrar em um diretório.
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        // Imprime o nome do diretório que estamos prestes a "entrar".
        System.out.println("Entrando no diretório: " + dir.getFileName());
        
        // Retorna CONTINUE para permitir a entrada no diretório.
        // Se retornássemos SKIP_SUBTREE, este diretório (e tudo dentro dele) seria pulado.
        return FileVisitResult.CONTINUE;
    }

    // 3. CHAMADO QUANDO A VISITA AO ARQUIVO FALHA
    // É chamado se a visita a um *arquivo* falhar (ex: falta de permissão).
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        // Imprime uma mensagem de erro informando qual arquivo falhou e o motivo.
        System.err.println("Falha ao acessar o arquivo: " + file.getFileName() + " | Erro: " + exc.getMessage());
        
        // Retorna CONTINUE para que a "caminhada" prossiga, ignorando este erro.
        // Se retornássemos TERMINATE, a "caminhada" inteira pararia.
        return FileVisitResult.CONTINUE;
    }

    // 4. CHAMADO DEPOIS DE VISITAR UM DIRETÓRIO
    // É chamado *depois* de visitar um diretório e todo o seu conteúdo.
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        // 'exc' será nulo a menos que ocorra um erro de I/O *durante* a visita ao diretório.
        if (exc != null) {
            // Se ocorreu um erro (ex: não foi possível ler o conteúdo do diretório), imprime.
            System.err.println("Erro após visitar o diretório: " + dir.getFileName() + " | Erro: " + exc.getMessage());
        }
        
        System.out.println("Saindo do diretório: " + dir.getFileName()); // (Linha adicionada para clareza)
        
        // Retorna CONTINUE para prosseguir para o próximo item no diretório "pai".
        return FileVisitResult.CONTINUE;
    }
}

public class SimpleFileVisitor02 {
    public static void main(String[] args) throws IOException {
        // Define o diretório inicial da "caminhada" (assumindo que "pasta" existe).
        Path path = Paths.get("pasta");
        
        // Inicia a "caminhada" (walk) recursiva pela árvore de arquivos.
        // O 2º argumento é a instância do nosso "visitante" (a classe que define o que fazer).
        // CORREÇÃO: Usando o nome da classe corrigido (ListAllFiles).
        Files.walkFileTree(path, new ListAllFiles());
    }
}