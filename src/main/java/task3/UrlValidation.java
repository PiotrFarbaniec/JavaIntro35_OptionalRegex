package task3;

import java.util.regex.Pattern;

public class UrlValidation {
    private static String pattern = "^(http|https)(://)(www\\.)?[a-zA-Z0-9@:%._\\+~#?&//=]{2,256}\\.(com|pl)?";

    static boolean isUrlCorrect(String url) {
        return Pattern.matches(pattern, url);
    }
}
