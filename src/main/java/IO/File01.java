// Importa a classe File para manipulação de arquivos e diretórios.
import java.io.File;
// Importa a classe IOException para tratar erros de entrada/saída.
import java.io.IOException;
// Importa classes do pacote java.time para lidar com datas e horas de forma moderna.
import java.time.Instant;
import java.time.ZoneId;

public class File01 {
    public static void main(String[] args) {
        // Cria um objeto File que representa o arquivo "file.txt".
        // Isso ainda NÃO cria o arquivo no disco, apenas cria uma representação dele em memória. 📝
        File file = new File("file.txt");
        try {
            // Tenta criar o arquivo fisicamente no disco.
            // Retorna 'true' se o arquivo foi criado, 'false' se ele já existia.
            boolean isCreated = file.createNewFile();
            System.out.println("Criado: " + isCreated);

            // 🧐 A seguir, várias maneiras de inspecionar o arquivo:
            // Obtém o caminho usado para criar o objeto File (pode ser relativo).
            System.out.println("Caminho (Path): " + file.getPath());
            // Obtém o caminho completo desde a raiz do sistema de arquivos.
            System.out.println("Caminho Absoluto: " + file.getAbsolutePath());
            // Verifica se o objeto File aponta para um diretório.
            System.out.println("É diretório: " + file.isDirectory());
            // Verifica se o objeto File aponta para um arquivo.
            System.out.println("É arquivo: " + file.isFile());
            // Verifica se o arquivo está marcado como oculto pelo sistema operacional.
            System.out.println("Está oculto: " + file.isHidden());

            // 📅 Obtém a data da última modificação do arquivo.
            // file.lastModified() retorna um 'long' (milisegundos desde 01/01/1970).
            // O restante da linha converte esse número para uma data e hora legível,
            // usando o fuso horário padrão da máquina.
            System.out.println("Última modificação: " + Instant.ofEpochMilli(file.lastModified()).atZone(ZoneId.systemDefault()).toLocalDateTime());

            // Verifica se o arquivo realmente existe no disco antes de tentar deletá-lo.
            if (file.exists()) {
                // Tenta deletar o arquivo do disco. 🗑️
                // Retorna 'true' se o arquivo foi deletado com sucesso.
                boolean isDeleted = file.delete();
                System.out.println("Deletado: " + isDeleted);
            }
        } catch (IOException e) {
            // Captura possíveis erros de I/O (Input/Output), como falta de permissão,
            // e os relança como uma exceção não verificada.
            throw new RuntimeException(e);
        }
    }
}