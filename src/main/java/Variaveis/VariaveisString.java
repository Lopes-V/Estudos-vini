package Variaveis;

import java.util.Scanner;

public class VariaveisString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = "Vinicius";
        System.out.println(n.getBytes());
        System.out.println(n.chars());
        System.out.println(n.length());
        System.out.println(n.replace(n,"MACHO ALFA"));
        System.out.println(n.endsWith("a"));
        System.out.println(n.formatted()); //???
        String[] palavras = n.split(" ");
        System.out.println(palavras);
        System.out.println(n.split("i"));

        StringBuilder sB = new StringBuilder(); //String Builder
        System.out.println(n.substring(0, 6));
        sB.append(" ");
        System.out.println(sB);
        System.out.println(sB.capacity());
        System.out.println(sB.reverse());
        n.formatted();
        n.intern();

        StringBuffer stringBuffer = new StringBuffer(); //String Buffer
        stringBuffer.append("nome");
        stringBuffer.ensureCapacity(6);
        System.out.println(stringBuffer.length());
    }
}
