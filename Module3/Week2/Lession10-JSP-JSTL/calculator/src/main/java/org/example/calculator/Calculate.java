package org.example.calculator;

public class Calculate {
    public static double calculate(double operand1, double operand2, String operator) {
        double result = 0;
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    throw new ArithmeticException("Không thể chia cho 0!");
                }
                break;
            default:
                throw new IllegalArgumentException("Phép toán không hợp lệ");
        }
        return result;
    }
}
