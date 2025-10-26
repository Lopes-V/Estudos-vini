// Define o pacote onde a classe está localizada.
package Tresourcebuldle;

// Importa a classe Locale, que representa uma região geográfica, política ou cultural específica.
import java.util.Locale;
// Importa a classe ResourceBundle, usada para carregar recursos (como textos) específicos de um Locale.
import java.util.ResourceBundle;

public class ResourceBoundle01 {
    public static void main(String[] args) {
        // Imprime o Locale (idioma e país) padrão da sua máquina (JVM).
        // Ex: pt_BR (Português do Brasil), en_US (Inglês dos EUA).
        System.out.println(Locale.getDefault());

        // Carrega o arquivo de propriedades "messages" para o Locale português do Brasil (pt_BR).
        // O Java procurará por um arquivo chamado "messages_pt_BR.properties" no classpath.
        // Se não encontrar, buscará por "messages_pt.properties" e, por último, "messages.properties" (padrão).
        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", new Locale("pt","BR"));

        // Verifica se a chave "sasa" existe no arquivo de propriedades carregado.
        boolean sasa = resourceBundle.containsKey("sasa");
        // Imprime o resultado da verificação (true ou false).
        System.out.println(sasa);

        // --- Seção em Português ---
        // Busca a string associada à chave "Hello" no arquivo "messages_pt_BR.properties" e a imprime.
        System.out.println(resourceBundle.getString("Hello"));
        // Busca a string associada à chave "Good.Morning" e a imprime.
        System.out.println(resourceBundle.getString("Good.Morning"));

        // --- Seção em Inglês ---
        // Agora, carrega o arquivo de propriedades "messages" para o Locale inglês dos EUA (en_US).
        // A variável 'resourceBundle' é reaproveitada para apontar para este novo conjunto de traduções.
        // O Java procurará por "messages_en_US.properties", "messages_en.properties" e depois "messages.properties".
        resourceBundle = ResourceBundle.getBundle("messages", new Locale("en","US"));

        // Busca e imprime a string da chave "Hello" do arquivo em inglês.
        System.out.println(resourceBundle.getString("Hello"));
        // Busca e imprime a string da chave "Good.Morning" do arquivo em inglês.
        System.out.println(resourceBundle.getString("Good.Morning"));

        // Tenta buscar a string para a chave "hi".
        // IMPORTANTE: Se a chave "hi" não existir nos arquivos "messages_en_US.properties"
        // ou no arquivo padrão "messages.properties", esta linha lançará uma exceção do tipo
        // java.util.MissingResourceException, e o programa irá parar.
        System.out.println(resourceBundle.getString("hi"));
    }
}