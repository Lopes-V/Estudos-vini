package FormatacaoDeDatas;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormat02 {
    public static void main(String[] args) {
        NumberFormat[] numberFormats = new NumberFormat[3]; // Array para armazenar 3 formatadores de número
        Locale localiItaly = Locale.ITALY; // Define a localidade para a Itália
        Locale localiJP = Locale.JAPAN;     // Define a localidade para o Japão

        // Obtém e armazena diferentes instâncias de formatadores de moeda
        numberFormats[0] = NumberFormat.getCurrencyInstance(); // Formatador para a localidade padrão do sistema
        numberFormats[1] = NumberFormat.getCurrencyInstance(localiItaly); // Formatador específico para a Itália (€)
        numberFormats[2] = NumberFormat.getCurrencyInstance(localiJP);    // Formatador específico para o Japão (¥)

        double valor = 10_000_000.2130; // Valor numérico a ser formatado

        // Itera sobre cada formatador no array
        for (NumberFormat numberFormat : numberFormats){
            // Imprime o número máximo de casas decimais para cada localidade
            System.out.println(numberFormat.getMaximumFractionDigits());
            // Formata e imprime o valor como moeda, de acordo com a localidade
            System.out.println(numberFormat.format(valor));
        }
    }
}