package task4;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumbersValidation {
    private String text;
    private String[] number;
    public NumbersValidation(String text) {
        this.text = text;
        this.number = getSplitText();
    }

    private Pattern splitPattern = Pattern.compile("\\,\\s");
    private Pattern intPattern = Pattern.compile("\\d{1,}");
    private Pattern decPattern = Pattern.compile("\\d{1,}\\.\\d{1,}");
    private Pattern scientPattern = Pattern.compile("\\d{1,}\\.\\d{1,}(e|E){1}(\\+|\\-){1}\\d{1,}");
    private Matcher matchingNumbers;


    public List getIntegerNumbers() {
        List<String> numbersList = new ArrayList<>();
        for (int i = 0; i < number.length; i++) {
            matchingNumbers = intPattern.matcher(number[i]);
            if (matchingNumbers.matches()) {
                numbersList.add(number[i]);
            }
        }
        return numbersList;
    }

    public List getDecimalNumbers() {
        List<String> numbersList = new ArrayList<>();
        for (int i = 0; i < number.length; i++) {
            matchingNumbers = decPattern.matcher(number[i]);
            if (matchingNumbers.matches()) {
                numbersList.add(number[i]);
            }
        }
        return numbersList;
    }

    public List getScientificNumbers() {
        List<String> numbersList = new ArrayList<>();
        for (int i = 0; i < number.length; i++) {
            matchingNumbers = scientPattern.matcher(number[i]);
            if (matchingNumbers.matches()) {
                numbersList.add(number[i]);
            }
        }
        return numbersList;
    }

    private String[] getSplitText() {
        String[] splitText = splitPattern.split(text);
        return splitText;
    }
}