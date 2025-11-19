package FormatacaoDeDatas;

// Importa a classe Locale, usada para representar uma região geográfica, política ou cultural.
import java.util.Locale;

public class Locale02 {
    // Método principal, o ponto de entrada da aplicação.
    public static void main(String[] args) {
        // Obtém e imprime a localidade (Locale) padrão da JVM (Java Virtual Machine).
        // Geralmente, essa configuração é herdada do sistema operacional. Ex: pt_BR para Português do Brasil.
        System.out.println(Locale.getDefault());

        // O método estático getISOCountries() retorna um array de Strings com todos os códigos de país
        // de 2 letras definidos pelo padrão ISO 3166. Ex: "BR", "US", "JP".
        String[] isoCountry = Locale.getISOCountries();
        
        // O método estático getISOLanguages() retorna um array de Strings com todos os códigos de idioma
        // de 2 letras definidos pelo padrão ISO 639. Ex: "pt", "en", "es".
        String[] isoLanguages = Locale.getISOLanguages();

        // Inicia um loop 'for-each' para percorrer o array de códigos de idiomas.
        for (String isolanguages : isoLanguages){
            // Imprime cada código de idioma seguido de um espaço, mantendo tudo na mesma linha.
            System.out.print(isolanguages + " ");
        }
        // Imprime uma quebra de linha para que a próxima saída comece em uma nova linha.
        System.out.println();

        // Inicia um loop 'for-each' para percorrer o array de códigos de países.
        for (String isoCountrys : isoCountry){
            // Imprime cada código de país seguido de um espaço, mantendo tudo na mesma linha.
            System.out.print(isoCountrys + " ");
        }
    }
}