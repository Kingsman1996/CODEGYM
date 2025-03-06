public class Main {
    public static void main(String[] args) {
        String[] classNames = {"C0223G", "A0323K", "M0318G", "P0323A"};
        for (String item : classNames) {
            boolean isValid = Validator.isValidClassName(item);
            System.out.println(item + " ---> " + isValid);
        }
    }
}
