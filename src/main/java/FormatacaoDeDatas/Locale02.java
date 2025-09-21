package FormatacaoDeDatas;

import java.util.Locale;

public class Locale02 {
    public static void main(String[] args) {
        // Imprime a localidade padrão configurada no sistema operacional
        System.out.println(Locale.getDefault());

        // Obtém arrays de códigos de país e idioma conforme o padrão ISO
        String[] isoCountry = Locale.getISOCountries(); // Códigos de país ISO 3166-1 alpha-2 (ex: BR, US)
        String[] isoLanguages = Locale.getISOLanguages(); // Códigos de idioma ISO 639-1 (ex: pt, en)

        // Loop para iterar e imprimir todos os códigos de idioma ISO
        for (String isolanguages : isoLanguages){
            System.out.print(isolanguages + " ");
        }
        System.out.println(); // Quebra de linha para separar as saídas

        // Loop para iterar e imprimir todos os códigos de país ISO
        for (String isoCountrys : isoCountry){
            System.out.print(isoCountrys + " ");
        }
    }
}