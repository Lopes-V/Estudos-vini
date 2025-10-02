package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher04 {
    public static void main(String[] args) {
        // \d = Todos od dígitos
        // \D = Tudo o que não for dígito
        // \s = Espaços em branco \t \n \f \r
        // \S = Todos os caracteres excluindo os brancos
        // \w = a-Z A-Z, todos os digitos, _
        // \W = Tudo que não for incluso no \w
        // []
        String regex = "0[xX][0-9a-fA-F]";
        String texto = "12 0X 0X 0XFFABC 0X109 0X1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        System.out.println("Texto:  "+ texto);
        System.out.println("Indice: 0123456789");
        System.out.println("Regex:   "+ regex);
        System.out.println("Posicoes encontradas");
        while (matcher.find()) {
            System.out.print(matcher.start()+"  "+matcher.group()+"\n");
        }
    }
}