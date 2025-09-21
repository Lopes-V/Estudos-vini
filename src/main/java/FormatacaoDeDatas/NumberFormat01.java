package FormatacaoDeDatas;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormat01 {
    public static void main(String[] args) {
        NumberFormat[] numberFormats = new NumberFormat[3]; // Array para armazenar 3 formatadores de número
        Locale localiItaly = Locale.ITALY; // Define a localidade para a Itália
        Locale localiJP = Locale.JAPAN;     // Define a localidade para o Japão

        // Obtém e armazena diferentes instâncias de formatadores de número genéricos
        numberFormats[0] = NumberFormat.getInstance(); // Formatador de número padrão do sistema
        numberFormats[1] = NumberFormat.getInstance(localiItaly); // Formatador de número para a Itália
        numberFormats[2] = NumberFormat.getInstance(localiJP);    // Formatador de número para o Japão

        double valor = 10_000_000.2130; // Valor numérico a ser formatado

        // Itera sobre cada formatador no array
        for (NumberFormat numberFormat : numberFormats){
            // Formata e imprime o valor numérico, de acordo com a localidade
            System.out.println(numberFormat.format(valor));
        }
    }
}