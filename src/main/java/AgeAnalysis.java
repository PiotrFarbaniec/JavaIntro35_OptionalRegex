import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.WeekFields;

public class AgeAnalysis {
    private LocalDate birthDate;
    private final LocalDate today;

    public AgeAnalysis(LocalDate birthDate) {
        this.birthDate = birthDate;
        this.today = LocalDate.now();
    }

    public int getAge() {
        return today.getYear() - birthDate.getYear();
    }

    public DayOfWeek getDayOfBorn() {
        return birthDate.getDayOfWeek();
    }

    public int getWeekOfYear() {
        return birthDate.get(WeekFields.ISO.weekOfYear());
    }
}