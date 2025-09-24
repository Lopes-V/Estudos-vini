package Exercicios;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class ExerciciosChronoUnit {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        SimpleDateFormat sDF = new SimpleDateFormat();
        Locale localeBR = new Locale("pt","BR");
        DateTimeFormatter formatterBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("Data exemplo: (ZZ/XX/YY)");
        System.out.println("Insira a o ano que sua avó nasceu: ");
        String tempo = sc.nextLine();
        LocalDate avoD = LocalDate.parse(tempo,formatterBR);
        System.out.println("Insira a sua data de nascimento: ");
        tempo = sc.nextLine();
        LocalDate usuD = (LocalDate.parse(tempo, formatterBR));
        Period diferenca = Period.between(avoD, usuD);
        System.out.printf("A diferença entre as datas é de: %d anos, %d meses e %d dias.%n",
                diferenca.getYears(),
                diferenca.getMonths(),
                diferenca.getDays());
    }
}
