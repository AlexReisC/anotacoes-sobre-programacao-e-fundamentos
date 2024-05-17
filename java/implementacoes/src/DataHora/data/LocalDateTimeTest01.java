package DataHora.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeTest01 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDate date = LocalDate.parse("2021-03-24");
        LocalTime time = LocalTime.parse("10:50:00");
        System.out.println(date);
        System.out.println(time);

        LocalDateTime ldt1 = date.atTime(time);
        System.out.println(ldt1);
        LocalDateTime ldt2 = time.atDate(date);
        System.out.println(ldt2);
    }
}
