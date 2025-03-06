public class Main {
    public static void main(String args[]) {
        String[] accounts = new String[]{
                "123abc_", "_abc123", "______", "123456",
                "abcdefgh", ".@", "12345", "1234_", "abcde"};
        for (String item : accounts) {
            boolean isValid = Validator.validateAccount(item);
            System.out.println(item + " is valid: " + isValid);
        }
    }
}
