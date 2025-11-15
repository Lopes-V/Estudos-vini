package NewIO;

import java.io.IOException; // Importa para tratar exceções de Entrada/Saída (I/O).
import java.nio.file.Files; // Importa a classe Files, com métodos estáticos para interagir com arquivos.
import java.nio.file.Path; // Importa a interface Path, que representa um caminho de arquivo.
import java.nio.file.Paths; // Importa a classe Paths, usada para criar objetos Path.
import java.nio.file.attribute.PosixFileAttributeView; // Importa a "Visão" que permite *modificar* atributos POSIX.
import java.nio.file.attribute.PosixFileAttributes; // Importa a interface para *ler* atributos POSIX (somente leitura).
import java.nio.file.attribute.PosixFilePermission; // Importa a enumeração das permissões POSIX (ex: OWNER_READ, GROUP_WRITE).
import java.nio.file.attribute.PosixFilePermissions; // Importa a classe utilitária para converter e manipular permissões POSIX.
import java.util.Set; // Importa a interface Set, usada para armazenar a coleção de permissões.

public class PosixFileAttributesTest01 {
    // O método main lança IOException, pois a leitura/escrita de atributos de arquivo
    // pode falhar (ex: arquivo não existe, falta de permissão).
    public static void main(String[] args) throws IOException {
        
        // Cria um objeto Path para o arquivo.
        // Nota: O "first:" visto na imagem é uma "inlay hint" (dica) da IDE (como IntelliJ),
        // indicando o nome do parâmetro. O código real digitado é apenas:
        // Paths.get("/home/william/dev/file.txt")
        Path path = Paths.get("/home/william/dev/file.txt");

        // --- 1. Leitura das Permissões ---
        
        // Lê os atributos POSIX do arquivo (modo somente leitura).
        PosixFileAttributes posixFileAttributes = Files.readAttributes(path, PosixFileAttributes.class);
        
        // Imprime o 'Set' (conjunto) das permissões *atuais* do arquivo.
        // A saída será algo como: [OWNER_WRITE, OWNER_READ, GROUP_READ, OTHERS_READ]
        System.out.println(posixFileAttributes.permissions());

        // --- 2. Modificação das Permissões ---
        
        // Obtém a "Visão" (View) dos atributos POSIX.
        // Diferente de 'PosixFileAttributes', a 'View' permite a *modificação*.
        PosixFileAttributeView fileAttributeView = Files.getFileAttributeView(path, PosixFileAttributeView.class);

        // Cria um novo 'Set' de permissões usando a string no formato "rwx".
        // "rw-rw-rw-" significa: Dono(rw-), Grupo(rw-) e Outros(rw-).
        // Nota: O "perms:" visto na imagem também é uma "inlay hint" da IDE.
        Set<PosixFilePermission> posixFilePermissions = PosixFilePermissions.fromString("rw-rw-rw-");

        // Define (aplica) as novas permissões (criadas acima) ao arquivo.
        // Isso efetivamente executa um "chmod 666" no arquivo.
        fileAttributeView.setPermissions(posixFilePermissions);

        // --- 3. Verificação da Modificação ---
        
        // Lê os atributos novamente (agora usando a 'View') e imprime as permissões
        // *atualizadas* para confirmar a mudança.
        // A saída agora deve refletir as novas permissões, ex:
        // [OWNER_WRITE, OWNER_READ, GROUP_WRITE, GROUP_READ, OTHERS_WRITE, OTHERS_READ]
        System.out.println(fileAttributeView.readAttributes().permissions());
    }
}
