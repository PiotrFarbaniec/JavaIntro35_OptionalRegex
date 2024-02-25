package task4;

import java.util.List;

public class MainClass {
    static String text = "342, 5.34, 756, 1.234e+07, 7.234243E-02, 6.09, 3457, 87, 1.0001, 3, 5";
    public static void main(String[] args) {
        NumbersValidation validate2 = new NumbersValidation(text);
        List integerList = validate2.getIntegerNumbers();
        List decimalList = validate2.getDecimalNumbers();
        List scientList = validate2.getScientificNumbers();

        System.out.println(integerList);
        System.out.println(decimalList);
        System.out.println(scientList);
    }
}