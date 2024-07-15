package DataHora.data;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ChronoUnitTest01 {
    public static void main(String[] args) {
        LocalDateTime aniversario = LocalDateTime.of(2001, 8, 15, 5, 0, 0);
        LocalDateTime agora = LocalDateTime.now();
        System.out.println(ChronoUnit.DAYS.between(aniversario, agora));
        System.out.println(ChronoUnit.WEEKS.between(aniversario, agora));
        System.out.println(ChronoUnit.MONTHS.between(aniversario, agora));
        System.out.println(ChronoUnit.YEARS.between(aniversario, agora));
    }
}
