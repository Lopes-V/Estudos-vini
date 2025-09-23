package FormatacaoDeDatas;

// Importa a classe para formatação de números, que é sensível à localização (locale).
import java.text.NumberFormat;
// Importa a classe para representar uma região/cultura específica.
import java.util.Locale;

public class NumberFormat01 {
    // Método principal, o ponto de entrada do programa.
    public static void main(String[] args) {
        // Declara e inicializa um array para armazenar 3 instâncias de formatadores de número.
        NumberFormat[] numberFormats = new NumberFormat[3];
        
        // Cria um objeto Locale para a Itália usando a constante pré-definida Locale.ITALY.
        Locale localiItaly = Locale.ITALY;
        // Cria um objeto Locale para o Japão usando a constante pré-definida Locale.JAPAN.
        Locale localiJP = Locale.JAPAN;

        // --- Obtém e armazena as instâncias dos formatadores ---

        // Posição 0: Obtém um formatador de número para a localidade PADRÃO do sistema (no seu caso, pt-BR).
        numberFormats[0] = NumberFormat.getInstance();
        // Posição 1: Obtém um formatador de número específico para a localidade da Itália.
        numberFormats[1] = NumberFormat.getInstance(localiItaly);
        // Posição 2: Obtém um formatador de número específico para a localidade do Japão.
        numberFormats[2] = NumberFormat.getInstance(localiJP);

        // Declara uma variável do tipo double. Os underscores (_) são para facilitar a leitura e são ignorados pelo compilador.
        double valor = 10_000_000.2130;

        // Inicia um loop "for-each" para percorrer cada formatador ('numberFormat') dentro do array 'numberFormats'.
        for (NumberFormat numberFormat : numberFormats) {
            // Para cada formatador, o método format() converte o valor numérico em uma String,
            // aplicando as regras de formatação daquela localidade específica (separadores de milhar e decimal).
            System.out.println(numberFormat.format(valor));
        }
        // Saída esperada:
        // 10.000.000,213  (Formato Brasileiro - padrão do sistema)
        // 10.000.000,213  (Formato Italiano - usa os mesmos separadores que o Brasil)
        // 10,000,000.213  (Formato Japonês - usa separadores invertidos em relação ao Brasil)
    }
}