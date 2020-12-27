import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {
    LocalDateTime fromLocalDateTime;
    LocalDateTime toLocalDateTime;
    public Gigasecond(LocalDate localDate) {
        this.fromLocalDateTime = localDate.atTime(0,0,0);
        this.toLocalDateTime = fromLocalDateTime.plusSeconds(1_000_000_000);
    }
    public Gigasecond(LocalDateTime localDateTime) {
        this.fromLocalDateTime = localDateTime;
        this.toLocalDateTime = fromLocalDateTime.plusSeconds(1_000_000_000);
    }
    LocalDateTime getDateTime() { return toLocalDateTime; }
}