public class Main {
    public static void main(String[] args) {
        String[] inputs = {"CodeedoC", "CodeGym", "HanoiionaH"};
        for (String item : inputs) {
            if (CheckPalindrome.checkPalindrome(item)) {
                System.out.println(item + " is Palindrome");
            } else {
                System.out.println(item + " is not a palindrome");
            }
        }
    }
}
