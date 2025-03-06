import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String CLASS_NAME = "^[CAP]\\d{4}[GHIK]$";

    public static boolean isValidClassName(String className) {
        Pattern pattern = Pattern.compile(CLASS_NAME);
        Matcher matcher = pattern.matcher(className);
        return matcher.matches();
    }
}
