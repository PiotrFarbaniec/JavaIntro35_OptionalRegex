package task5;

import java.util.regex.Pattern;

public class PasswordValidation {
    private String password;

    public PasswordValidation(String password) {
        this.password = password;
    }

    private Pattern passwordPattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)(?!.*(2021|21)).{7,}$");

    public boolean isStrongPassword() {
        return passwordPattern.matcher(password).matches();
    }
}

