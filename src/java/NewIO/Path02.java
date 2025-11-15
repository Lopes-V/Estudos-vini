// Definimos o pacote (package) onde esta classe reside.
// Pacotes organizam nosso código, evitando conflito de nomes.
package NewIO;

// Agora, vamos importar as classes que precisamos.
// É como dizer ao Java quais ferramentas da "biblioteca" vamos usar.

// 1. Precisamos desta classe para lidar com possíveis erros de Entrada/Saída (I/O).
//    Operações de arquivo (ler, escrever, criar) podem falhar.
import java.io.IOException;

// 2. Esta é a classe "faz-tudo" do Novo I/O (NIO.2).
//    Usamos ela para CRIAR, DELETAR, COPIAR, MOVER arquivos e diretórios.
import java.nio.file.Files;

// 3. Esta interface representa um "caminho" (path) no sistema de arquivos.
//    Pode ser um arquivo OU um diretório. É um conceito mais moderno que a velha classe java.io.File.
import java.nio.file.Path;

// 4. Esta é uma classe "fábrica" (factory) que usamos para CONSTRUIR objetos Path.
import java.nio.file.Paths;

/**
 * Classe de exemplo para demonstrar a criação de diretórios com Java NIO.2.
 * * @author Seu Professor
 */
public class Path02 {

    /**
     * Método principal (main) - O ponto de entrada do nosso programa.
     *
     * @param args Argumentos de linha de comando (não usados aqui).
     * @throws IOException Veja, estamos "avisando" ao Java que este método PODE
     * lançar uma IOException. Por quê? Porque `Files.createDirectory`
     * pode falhar (ex: pasta já existe, falta de permissão).
     * Em um código real, preferimos usar um bloco try-catch.
     */
    public static void main(String[] args) throws IOException {

        // --- Passo 1: Definir o Caminho (Path) ---

        // Aqui, usamos a classe 'Paths' (com 's' no final) e seu método estático 'get'.
        // Estamos criando um objeto 'Path' que REPRESENTA o caminho "pasta".
        //
        // IMPORTANTE: Esta linha, sozinha, NÃO cria nada no disco!
        // Ela apenas cria um "endereço" ou "ponteiro" em memória.
        // Como não começa com "C:/" ou "/", este é um caminho RELATIVO.
        // Ou seja, será "pasta" dentro do diretório onde o programa for executado.
        Path pasta = Paths.get("pasta");

        // --- Passo 2: Executar a Ação (Criar o Diretório) ---

        // Agora sim, usamos a classe 'Files' (com 's') para operar no sistema de arquivos.
        // Chamamos o método 'createDirectory' e passamos o 'Path' que criamos.
        //
        // Este comando TENTA criar o diretório "pasta" no disco.
        //
        // ATENÇÃO, TURMA:
        // 1. Se o diretório "pasta" JÁ EXISTIR, este método falhará e lançará uma 'FileAlreadyExistsException'.
        // 2. Este método SÓ cria o diretório final. Se você tentasse criar "pasta/subpasta"
        //    e "pasta" não existisse, ele falharia. Para isso, usaríamos o 'Files.createDirectories()' (no plural).
        Path pastaDirectory = Files.createDirectory(pasta);

        // Se o código chegou até aqui sem lançar uma exceção, o diretório foi criado!
        // A variável 'pastaDirectory' guarda o Path para o diretório recém-criado.
        System.out.println("Diretório criado com sucesso em: " + pastaDirectory.toAbsolutePath());
    }
}