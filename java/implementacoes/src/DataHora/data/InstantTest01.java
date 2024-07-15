package DataHora.data;

import java.time.Instant;
import java.time.LocalDateTime;

public class InstantTest01 {
    public static void main(String[] args) {
        Instant now = Instant.now(); //guarda os nano segundos desde 1970
        System.out.println(now);
        System.out.println(LocalDateTime.now());
        System.out.println(now.getEpochSecond());
        System.out.println(now.ofEpochSecond(5, 0));
        System.out.println(now.ofEpochSecond(5, 1_000_000_000));
        System.out.println(now.ofEpochSecond(5, -1_000_000_000));
    }
}
