package Dates;

import java.util.Date;

public class Date01 {
    public static void main(String[] args) {
        Date d = new Date(1758468334831L);
        d.setTime(d.getTime() + 3_600_000);
        System.out.println(d);
    }
}
// Date é representado por milisegundos desde 1970;
// Date não é bom utilizar pq pode ser trocado por uma nova forma de Date