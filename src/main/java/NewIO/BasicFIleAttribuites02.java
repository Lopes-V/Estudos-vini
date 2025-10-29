package NewIO;

import java.io.IOException; // Importa a classe para tratamento de exceções de Entrada/Saída.
import java.nio.file.Files; // Importa a classe Files, que contém métodos estáticos para operações com arquivos (ler, escrever, etc.).
import java.nio.file.Path; // Importa a interface Path, que representa um caminho no sistema de arquivos.
import java.nio.file.Paths; // Importa a classe Paths, usada para criar objetos Path.
import java.nio.file.attribute.BasicFileAttributeView; // Importa a "Visão" (View) que permite MODIFICAR atributos básicos do arquivo.
import java.nio.file.attribute.BasicFileAttributes; // Importa a interface que permite LER atributos básicos do arquivo (somente leitura).
import java.nio.file.attribute.FileTime; // Importa a classe que representa um carimbo de data/hora (timestamp) de um arquivo.

public class BasicFIleAttribuites02 {
    // O método main declara 'throws IOException' porque as operações de leitura/escrita
    // de atributos de arquivo podem falhar (ex: arquivo não encontrado).
    public static void main(String[] args) throws IOException {
        
        // 1. LEITURA DE ATRIBUTOS
        
        // Cria um objeto Path para o arquivo "novo_path.txt" dentro da pasta "pasta2".
        // (Assume-se que este arquivo e pasta já existem).
        Path path = Paths.get("pasta2/novo_path.txt");

        // Lê os atributos básicos do arquivo de forma "bulk" (todos de uma vez).
        // 'BasicFileAttributes' é uma interface de *leitura* (read-only).
        BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);

        // Extrai os carimbos de data/hora do objeto de atributos.
        FileTime creationTime = basicFileAttributes.creationTime(); // Hora de criação
        FileTime lastModifiedTime = basicFileAttributes.lastModifiedTime(); // Hora da última modificação
        FileTime lastAccessTime = basicFileAttributes.lastAccessTime(); // Hora do último acesso

        // Imprime os valores antes de qualquer modificação.
        System.out.println("Before Modification:");
        System.out.println("Creation Time: " + creationTime);
        System.out.println("Last Modified Time: " + lastModifiedTime);
        System.out.println("Last Access Time: " + lastAccessTime);

        System.out.println("--------------------"); // Separador visual

        // 2. MODIFICAÇÃO DE ATRIBUTOS

        // Obtém uma "Visão" (View) dos atributos básicos.
        // Diferente de 'BasicFileAttributes' (leitura), a 'View' permite *modificar* os atributos.
        BasicFileAttributeView fileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);

        // Cria um novo 'FileTime' com o horário exato de agora (horário atual do sistema).
        FileTime newCreationTime = FileTime.fromMillis(System.currentTimeMillis());

        // Modifica os carimbos de data/hora do arquivo.
        // A assinatura do método é: setTimes(lastModifiedTime, lastAccessTime, createTime)
        fileAttributeView.setTimes(lastModifiedTime, newCreationTime, creationTime);
        // Análise da linha acima:
        // - 1º param (Last Modified): Está sendo setado para o valor *original* (lastModifiedTime).
        // - 2º param (Last Access): Está sendo setado para o valor *atual* (newCreationTime).
        // - 3º param (Creation Time): Está sendo setado para o valor *original* (creationTime).
        // Resultado: Apenas o "Last Access Time" será alterado para o horário atual.

        
        // 3. RELEITURA DOS ATRIBUTOS para verificar a mudança.
        
        // Precisamos ler os atributos novamente para ver as alterações.
        // Nota: Chamar readAttributes() três vezes seguidas é ineficiente.
        // O ideal seria chamar fileAttributeView.readAttributes() uma vez e salvar em uma variável.
        
        // Lê novamente os atributos (agora atualizados) usando a 'View'.
        creationTime = fileAttributeView.readAttributes().creationTime();
        lastModifiedTime = fileAttributeView.readAttributes().lastModifiedTime();
        lastAccessTime = fileAttributeView.readAttributes().lastAccessTime();

        // Imprime os valores após a modificação.
        System.out.println("After Modification:");
        System.out.println("Creation Time: " + creationTime); // (Deve estar igual ao original)
        System.out.println("Last Modified Time: " + lastModifiedTime); // (Deve estar igual ao original)
        System.out.println("Last Access Time: " + lastAccessTime); // (Deve estar com o horário atual)
    } 
}