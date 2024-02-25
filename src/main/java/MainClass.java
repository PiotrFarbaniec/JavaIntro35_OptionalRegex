import java.time.LocalDate;

public class MainClass {
    static String birthDate = "1988-04-23";

        public static void main(String[] args) {
            AgeAnalysis date = new AgeAnalysis(LocalDate.parse(birthDate));
            System.out.println(date.getAge());
            System.out.println(date.getDayOfBorn());
            System.out.println(date.getWeekOfYear());
        }
    }