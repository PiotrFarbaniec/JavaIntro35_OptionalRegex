package task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UrlValidationTest {

    @Test
    void shouldReturnTrueForCorrectUrlAddress() {
        //given
        String[] urlAddress = {
                "http://www.onet.pl",
                "https://mail.google.com",
                "http://wiadomosci.onet.pl",
                "http://onet.pl",
                "http://www.test.eu",
                "https://google.de"};
        boolean[] expResult = {true, true, true, true, true, true};

        //when
        boolean [] actResult = {
                UrlValidation.isUrlCorrect(urlAddress[0]),
                UrlValidation.isUrlCorrect(urlAddress[1]),
                UrlValidation.isUrlCorrect(urlAddress[2]),
                UrlValidation.isUrlCorrect(urlAddress[3]),
                UrlValidation.isUrlCorrect(urlAddress[4]),
                UrlValidation.isUrlCorrect(urlAddress[5])};

        //then
        Assertions.assertArrayEquals(expResult, actResult);
    }

    @Test
    void shouldReturnFalseForNotCorrectAddress() {
        //given
        String[] urlAddress = {
                "//www.onet.pl",
                "https//mail.google.com",
                "http: wiadomosci.onet",
                "http:// onet.pl"};
        boolean[] expResult = {false, false, false, false};

        //when
        boolean [] actResult = {
                UrlValidation.isUrlCorrect(urlAddress[0]),
                UrlValidation.isUrlCorrect(urlAddress[1]),
                UrlValidation.isUrlCorrect(urlAddress[2]),
                UrlValidation.isUrlCorrect(urlAddress[3])};

        //then
        Assertions.assertArrayEquals(expResult, actResult);
    }
}