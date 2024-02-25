package task2;

import java.util.regex.Pattern;

public class PeselValidation {
    static boolean isPeselValid(String peselNumber) {
        return Pattern.matches("\\d{11}", peselNumber);
    }
}