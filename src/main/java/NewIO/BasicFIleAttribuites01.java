package NewIO;

// --- Importações Necessárias ---
// O antigo File: A classe de I/O original do Java.
import java.io.File;
// Necessária para lidar com erros em operações de I/O (ex: arquivo não encontrado).
import java.io.IOException;
// O principal utilitário da Nova I/O (NIO.2), usado para manipular arquivos.
import java.nio.file.Files;
// A interface que representa o caminho (o endereço) de um arquivo/diretório.
import java.nio.file.Path;
// A classe "fábrica" para criar objetos Path.
import java.nio.file.Paths;
// Classe do NIO.2 para representar datas/horas de atributos de arquivo.
import java.nio.file.attribute.FileTime;
// Classes do Java Time (java.time) para manipulação moderna de datas.
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class BasicFIleAttribuites01 {
    // O método main lança IOException porque as operações de arquivo podem falhar.
    public static void main(String[] args) throws IOException {

        // --- Comentários Didáticos sobre Atributos de Arquivo ---
        // BasicFileAttributes: Conjunto de atributos comuns a todos os SOs (tamanho, datas, se é diretório/arquivo).
        // DosFileAttributes: Atributos específicos do Windows (ex: oculto, somente leitura).
        // PosixFileAttributes: Atributos específicos de sistemas Linux/Unix/Mac (ex: dono, permissões rwx).
        
        
        // --- 1. Preparando a Data ---
        
        // Criamos uma data/hora no passado (agora menos 10 dias) para simular
        // a modificação de um arquivo mais antigo.
        LocalDateTime date = LocalDateTime.now().minusDays(10);


        // --- 2. Usando a API Antiga: java.io.File ---
        
        // Definimos o caminho usando a classe File.
        // CUIDADO: Se a pasta 'pasta2' não existir, este código vai FALHAR aqui,
        // pois 'createNewFile()' só cria o arquivo, não os diretórios pais.
        File file = new File("pasta2/novo.txt");
        
        // Tentamos criar o arquivo no disco. Retorna true se foi criado com sucesso.
        boolean isCreated = file.createNewFile();
        
        // Tentamos alterar o atributo de Última Modificação.
        // Precisamos converter o nosso LocalDateTime para o formato Epoch Millis (milissegundos desde 1/1/1970).
        long epochMillis = date.toInstant(ZoneOffset.UTC).toEpochMilli();
        boolean isModificad = file.setLastModified(epochMillis);
        
        // Nota: Esta API (java.io.File) é mais antiga e menos poderosa para manipular atributos.


        // --- 3. Usando a Nova API: java.nio.file.Files e Path ---

        // Definimos o caminho usando a API moderna Path. Mais flexível e poderosa.
        Path path = Paths.get("pasta2/novo_path.txt");
        
        // Criamos o arquivo. A classe Files oferece métodos utilitários poderosos.
        // Assim como createNewFile(), este método falhará se 'pasta2' não existir.
        Files.createFile(path);
        
        // O NIO.2 usa a classe FileTime para representar datas/horas de arquivo.
        // Convertemos nosso objeto 'date' (LocalDateTime) para o tipo FileTime.
        FileTime fileTime = FileTime.from(date.toInstant(ZoneOffset.UTC));
        
        // Alteramos o atributo de Última Modificação usando o método específico do NIO.2.
        // Este método é preferível ao setLastModified() da API antiga.
        Files.setLastModifiedTime(path, fileTime);


        // --- 4. Verificando Permissões Básicas (Atributos Booleanos) ---

        // Os métodos 'isWritable', 'isReadable' e 'isExecutable' são utilitários
        // que verificam se o sistema operacional permite as respectivas ações
        // naquele Path, levando em conta as permissões do usuário que executa o programa.

        // Verifica se o programa pode ESCREVER (modificar) o arquivo.
        System.out.println(Files.isWritable(path));
        // Verifica se o programa pode LER o conteúdo do arquivo.
        System.out.println(Files.isReadable(path));
        // Verifica se o programa pode EXECUTAR o arquivo (relevante para scripts/executáveis).
        System.out.println(Files.isExecutable(path));
        
        // O resultado destas três linhas dependerá do seu SO e das permissões do arquivo criado.
        // Normalmente, serão todos 'true' para um arquivo recém-criado pelo próprio usuário.
    } 
}