package task5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PasswordValidationTest {

    @Test
    void shouldReturnTrueForPasswordPatternsAsGiven() {
        //given
        String[] password = {"mojeNowe9haslo", "mojeInnehaslo4", "haslo5zapasowE"};
        boolean[] expResults = {true, true, true};

        //when
        PasswordValidation [] validation = {
                new PasswordValidation(password[0]),
                new PasswordValidation(password[1]),
                new PasswordValidation(password[2])
        };
        boolean[] actResults = {
                validation[0].isStrongPassword(),
                validation[1].isStrongPassword(),
                validation[2].isStrongPassword()
        };

        //then
        Assertions.assertArrayEquals(expResults, actResults);
    }

    @Test
    void shouldReturnFalseForPasswordPatternsAsGiven() {
        //given
        String[] password = {"mojeHaslo21logowania", "mojeHaslo", "hasloZapasowe2021"};
        boolean[] expResults = {false, false, false};

        //when
        PasswordValidation [] validation = {
                new PasswordValidation(password[0]),
                new PasswordValidation(password[1]),
                new PasswordValidation(password[2])
        };
        boolean[] actResults = {
                validation[0].isStrongPassword(),
                validation[1].isStrongPassword(),
                validation[2].isStrongPassword()
        };

        //then
        Assertions.assertArrayEquals(expResults, actResults);
    }

}