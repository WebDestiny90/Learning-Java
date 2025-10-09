import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime after = now.plusMinutes(5);

        var formatter = DateTimeFormatter.ofPattern("EEEE yyyy-MMMM-dd HH:mm:ss");
        var format = now.format(formatter);
        var epo = LocalDateTime.parse(format,formatter);
        var epoch = epo.toEpochSecond(ZoneOffset.UTC);
        System.out.println(now.format(formatter));
        System.out.println(after.format(formatter));
        System.out.println(epoch);
    }
}