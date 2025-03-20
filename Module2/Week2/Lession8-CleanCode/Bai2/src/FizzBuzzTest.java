public class FizzBuzzTest {
    boolean testFizz3() {
        int number = 3;
        String expected = "Fizz";
        String result = FizzBuzz.fizzBuzz(number);
        return result.equals(expected);
    }

    boolean testFizz6() {
        int number = 6;
        String expected = "Fizz";
        String result = FizzBuzz.fizzBuzz(number);
        return result.equals(expected);
    }

    boolean testBuzz5() {
        int number = 5;
        String expected = "Buzz";
        String result = FizzBuzz.fizzBuzz(number);
        return result.equals(expected);
    }

    boolean testBuzz10() {
        int number = 10;
        String expected = "Buzz";
        String result = FizzBuzz.fizzBuzz(number);
        return result.equals(expected);
    }

    boolean testFizzBuzz15() {
        int number = 15;
        String expected = "FizzBuzz";
        String result = FizzBuzz.fizzBuzz(number);
        return result.equals(expected);
    }

    boolean testFizzBuzz30() {
        int number = 30;
        String expected = "FizzBuzz";
        String result = FizzBuzz.fizzBuzz(number);
        return result.equals(expected);
    }
    public static void main(String[] args) {
        FizzBuzzTest test = new FizzBuzzTest();
        System.out.println(test.testFizz3());
        System.out.println(test.testFizz6());
        System.out.println(test.testBuzz5());
        System.out.println(test.testBuzz10());
        System.out.println(test.testFizzBuzz15());
    }
}
