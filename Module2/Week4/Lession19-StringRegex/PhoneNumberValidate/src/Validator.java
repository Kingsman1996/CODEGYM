import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static String PHONE_NUMBER_REGEX = "^\\(\\d{2}\\)-\\(0\\d{9}\\)$";

    public static boolean validatePhoneNumber(String phoneNumber) {
        Pattern p = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher m = p.matcher(phoneNumber);
        return m.matches();
    }
}
