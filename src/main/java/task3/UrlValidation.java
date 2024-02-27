package task3;

import java.util.regex.Pattern;

public class UrlValidation {
    private static String pattern = "^(http|https)(://)(www\\.)?[a-zA-Z.]{2,256}\\.[a-z]{2,6}";

    static boolean isUrlCorrect(String url) {
        return Pattern.matches(pattern, url);
    }
}
