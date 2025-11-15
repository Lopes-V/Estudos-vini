package FormatacaoDeDatas;

// Importa a classe para formatação de números.
import java.text.NumberFormat;
// Importa a classe para representar uma região/cultura específica.
import java.util.Locale;

public class NumberFormat02 {
    // Método principal, o ponto de entrada do programa.
    public static void main(String[] args) {
        // Declara e inicializa um array para armazenar 3 instâncias de formatadores de número.
        NumberFormat[] numberFormats = new NumberFormat[3];
        
        // Cria um objeto Locale para a Itália usando a constante pré-definida.
        Locale localiItaly = Locale.ITALY;
        // Cria um objeto Locale para o Japão usando a constante pré-definida.
        Locale localiJP = Locale.JAPAN;

        // --- Obtém e armazena as instâncias dos formatadores de MOEDA ---
        // O método getCurrencyInstance() cria um formatador específico para valores monetários.

        // Posição 0: Obtém um formatador de moeda para a localidade PADRÃO do sistema (pt-BR -> Real, R$).
        numberFormats[0] = NumberFormat.getCurrencyInstance();
        // Posição 1: Obtém um formatador de moeda específico para a localidade da Itália (-> Euro, €).
        numberFormats[1] = NumberFormat.getCurrencyInstance(localiItaly);
        // Posição 2: Obtém um formatador de moeda específico para a localidade do Japão (-> Iene, ¥).
        numberFormats[2] = NumberFormat.getCurrencyInstance(localiJP);

        // Declara uma variável do tipo double para ser formatada.
        double valor = 10_000_000.2130;

        // Inicia um loop "for-each" para percorrer cada formatador no array.
        for (NumberFormat numberFormat : numberFormats) {
            // Imprime o número máximo de casas decimais que a moeda da localidade utiliza.
            // Ex: Real e Euro usam 2 casas decimais. O Iene japonês não usa casas decimais (usa 0).
            System.out.println(numberFormat.getMaximumFractionDigits());
            
            // Formata o valor numérico como uma String de moeda, aplicando o símbolo monetário (R$, €, ¥),
            // os separadores corretos e o número de casas decimais adequado para cada localidade.
            System.out.println(numberFormat.format(valor));
        }
        
        // Saída esperada (em duas linhas por iteração):
        // 2                  (casas decimais para o Real)
        // R$ 10.000.000,21   (Formato Brasileiro)
        // 2                  (casas decimais para o Euro)
        // € 10.000.000,21    (Formato Italiano)
        // 0                  (casas decimais para o Iene)
        // ￥10,000,000        (Formato Japonês, arredondado)
    }
}