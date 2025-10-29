package NewIO; // Define o pacote da classe.

import java.io.IOException; // Importa para tratar exceções de Entrada/Saída.
import java.nio.file.Files; // Importa a classe principal para interações com arquivos (criar, ler atributos, etc.).
import java.nio.file.Path; // Importa a interface que representa um caminho de arquivo.
import java.nio.file.Paths; // Importa a classe 'Paths' para criar objetos 'Path'.
import java.nio.file.attribute.DosFileAttributeView; // Importa a "Visão" que permite *modificar* atributos específicos do DOS/Windows.
import java.nio.file.attribute.DosFileAttributes; // Importa a interface que permite *ler* atributos específicos do DOS/Windows (como 'oculto' ou 'somente leitura').

public class DosFileAttribuites01 {
    // O método main lança IOException, pois operações de I/O (Entrada/Saída),
    // como criar arquivos ou ler/definir atributos, podem falhar.
    public static void main(String[] args) throws IOException {
        
        // Define o caminho para o arquivo "novo_path.txt" dentro da "pasta".
        Path path = Paths.get("pasta/novo_path.txt");
        
        // Verifica se o arquivo *não* existe. Se não existir, ele é criado.
        // Isso é crucial, pois não podemos ler/modificar atributos de um arquivo inexistente.
        if(Files.notExists(path)) Files.createFile(path);
        
        // --- Leitura dos Atributos ---
        
        // Lê os atributos específicos do DOS (Windows) do arquivo.
        // 'DosFileAttributes' é uma interface de *leitura*.
        DosFileAttributes dosFileAttributes = Files.readAttributes(path, DosFileAttributes.class);
        
        // Imprime o estado atual do atributo "oculto" (hidden). (Provavelmente 'false' para um arquivo novo).
        System.out.println("É oculto? " + dosFileAttributes.isHidden());
        // Imprime o estado atual do atributo "somente leitura" (read-only). (Provavelmente 'false').
        System.out.println("É somente leitura? " + dosFileAttributes.isReadOnly());

        System.out.println("--- Modificando ---");

        // --- Modificação dos Atributos ---

        // Obtém a "Visão" (View) dos atributos DOS.
        // 'DosFileAttributeView' é a interface que permite *modificar* os atributos.
        DosFileAttributeView fileAttributeView = Files.getFileAttributeView(path, DosFileAttributeView.class);
        
        // Define o atributo "oculto" do arquivo como 'true'.
        fileAttributeView.setHidden(true);
        // Define o atributo "somente leitura" do arquivo como 'true'.
        fileAttributeView.setReadOnly(true);

        // --- Verificação da Modificação ---
        
        // Lê novamente os atributos (usando a 'View') para confirmar as mudanças.
        // (Nota: Chamar readAttributes() duas vezes é um pouco ineficiente,
        // poderíamos salvar o resultado em uma variável, mas funciona para o exemplo).
        
        // Imprime o novo estado do atributo "oculto". (Deve ser 'true').
        System.out.println("É oculto? " + fileAttributeView.readAttributes().isHidden());
        // Imprime o novo estado do atributo "somente leitura". (Deve ser 'true').
        System.out.println("É somente leitura? " + fileAttributeView.readAttributes().isReadOnly());
    }
}