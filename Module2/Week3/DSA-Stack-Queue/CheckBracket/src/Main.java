public class Main {
    public static void main(String[] args) {
        String[] inputs = {"()", "(1+2", "1+2)","(())"};
        for (String input : inputs) {
            System.out.println(input + " : " + CheckBracket.checkBracket(input));
        }
    }
}
