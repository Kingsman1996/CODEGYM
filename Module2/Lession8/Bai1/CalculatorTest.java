
public class CalculatorTest {
    public static final char ADDITION = '+';
    public static final char SUBTRACTION = '-';
    public static final char MULTIPLICATION = '*';
    public static final char DIVISION = '/';

    boolean testCalculateAdd() {
        int firstOperand = 1;
        int secondOperand = 1;
        char operator = ADDITION;
        int expected = 2;
        int result = Calculator.calculate(firstOperand, secondOperand, operator);
        return result == expected;
    }

    boolean testCalculateSub() {
        int firstOperand = 2;
        int secondOperand = 1;
        char operator = SUBTRACTION;
        int expected = 1;
        int result = Calculator.calculate(firstOperand, secondOperand, operator);
        return result == expected;
    }

    boolean testCalculateMul() {
        int firstOperand = 2;
        int secondOperand = 2;
        char operator = MULTIPLICATION;
        int expected = 4;
        int result = Calculator.calculate(firstOperand, secondOperand, operator);
        return result == expected;
    }

    boolean testCalculateDiv() {
        int firstOperand = 6;
        int secondOperand = 3;
        char operator = DIVISION;
        int expected = 2;
        int result = Calculator.calculate(firstOperand, secondOperand, operator);
        return result == expected;
    }

    void testCalculateDivByZero() {
        int firstOperand = 2;
        int secondOperand = 0;
        char operator = DIVISION;
        Calculator.calculate(firstOperand, secondOperand, operator);
    }

    void testCalculateWrongOperator() {
        int firstOperand = 2;
        int secondOperand = 0;
        char operator = '=';
        Calculator.calculate(firstOperand, secondOperand, operator);
    }

    public static void main(String[] args) {
        CalculatorTest test = new CalculatorTest();
        System.out.println(test.testCalculateAdd());
        System.out.println(test.testCalculateSub());
        System.out.println(test.testCalculateMul());
        System.out.println(test.testCalculateDiv());
        test.testCalculateWrongOperator();
        test.testCalculateDivByZero();
    }
}
