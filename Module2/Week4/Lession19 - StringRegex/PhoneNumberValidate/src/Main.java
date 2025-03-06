public class Main {
    public static void main(String[] args) {
        String[] phoneNumbers = {
                "(84)-(0978489648)", "(a8)-(22222222)",
                "(84)-(22b22222)", "(84)-(9978489648)"};
        for (String item : phoneNumbers) {
            boolean isValid = Validator.validatePhoneNumber(item);
            System.out.println(item + " ---> " + isValid);
        }
    }
}
