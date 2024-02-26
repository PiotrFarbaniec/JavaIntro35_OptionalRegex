package task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PeselValidationTest {

    @Test
    void shouldReturnTrueIfContainsElevenNumbersOnly() {
        //given
        String peselNumber = "98112667479";

        //when
        boolean isValid = PeselValidation.isPeselValid(peselNumber);

        //then
        Assertions.assertTrue(isValid);
    }

    @Test
    void shouldReturnFalseIfContainOtherSignsThanNumbers() {
        //given
        String peselNumber = "981a2667479";

        //when
        boolean isValid = PeselValidation.isPeselValid(peselNumber);

        //then
        Assertions.assertFalse(isValid);
    }

    @Test
    void shouldReturnFalseIfContainLessThanElevenNumbers() {
        //given
        String peselNumber = "9811266747";

        //when
        boolean isValid = PeselValidation.isPeselValid(peselNumber);

        //then
        Assertions.assertFalse(isValid);
    }

    @Test
    void shouldReturnFalseIfContainMoreThanElevenNumbers() {
        //given
        String peselNumber = "981126674799";

        //when
        boolean isValid = PeselValidation.isPeselValid(peselNumber);

        //then
        Assertions.assertFalse(isValid);
    }
}