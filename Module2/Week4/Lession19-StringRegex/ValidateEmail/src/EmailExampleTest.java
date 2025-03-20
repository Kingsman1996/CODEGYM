public class EmailExampleTest {
    public static void main(String[] args) {
        String[] emails = new String[]{
                "a@gmail.com", "ab@yahoo.com", "abc@hotmail.com", "@gmail.com", "ab@gmail.", "@#abc@gmail.com"
        };
        for (String email : emails) {
            boolean isvalid = Validator.validateEmail(email);
            System.out.println(email + " is valid: " + isvalid);
        }
    }
}
