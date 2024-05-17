package DataHora.data;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class LocalTimeTest01 {
    public static void main(String[] args) {
        LocalTime tempo = LocalTime.of(23, 59, 59);
        LocalTime tempoAgora = LocalTime.now();
        System.out.println(tempo);
        System.out.println(tempoAgora);
        System.out.println(tempo.getHour());
        System.out.println(tempo.getMinute());
        System.out.println(tempo.get(ChronoField.CLOCK_HOUR_OF_AMPM));
        System.out.println(tempo.MIN);
        System.out.println(tempo.MAX);

    }
}
