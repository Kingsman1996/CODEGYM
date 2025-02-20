
public class FizzBuzzTranslate {
    private static final String INVALID = "Số không hợp lệ";
    private static final String BUZZ = "Buzz";
    private static final String FIZZ = "Fizz";
    private static final String FIZZ_BUZZ = "FizzBuzz";

    public static String getNumberType(int number) {
        if (number <= 0 || number >= 99) {
            return INVALID;
        }
        if (isFizzBuzz(number)) {
            return FIZZ_BUZZ;
        } else if (isBuzz(number)) {
            return BUZZ;
        } else if (isFizz(number)) {
            return FIZZ;
        } else {
            return getNumberSpell(number);
        }
    }

    private static boolean isFizz(int number) {
        return String.valueOf(number).contains("3") || number % 3 == 0;
    }

    private static boolean isBuzz(int number) {
        return String.valueOf(number).contains("5") || number % 5 == 0;
    }

    private static boolean isFizzBuzz(int number) {
        return (number % 3 == 0 && number % 5 == 0) ||
                (String.valueOf(number).contains("3") && String.valueOf(number).contains("5"));
    }

    public static String getNumberSpell(int number) {
        String numberStr = String.valueOf(number);
        StringBuilder result = new StringBuilder();
        for (char digit : numberStr.toCharArray()) {
            result.append(spellANumber(Character.getNumericValue(digit))).append(" ");
        }
        return result.toString().trim();
    }

    public static String spellANumber(int number) {
        String spellNumber = "";
        switch (number) {
            case 1:
                spellNumber = "one";
                break;
            case 2:
                spellNumber = "two";
                break;
            case 4:
                spellNumber = "four";
                break;
            case 6:
                spellNumber = "six";
                break;
            case 7:
                spellNumber = "seven";
                break;
            case 8:
                spellNumber = "eight";
                break;
            case 9:
                spellNumber = "nine";
        }
        return spellNumber;
    }
}