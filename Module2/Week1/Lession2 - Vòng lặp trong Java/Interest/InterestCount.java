import java.util.Scanner;

public class InterestCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the investment amount: ");
        double investmentAmount = sc.nextDouble();
        System.out.print("Enter the interest rate: ");
        double interestRate = sc.nextDouble();
        System.out.print("Enter the number of months: ");
        int month = sc.nextInt();
        double totalAmount = 0;
        for (int i = 0; i < month; i++) {
            totalAmount += investmentAmount * (interestRate / 100) / 12 * month;
        }
        System.out.println("The total amount is: " + totalAmount);
    }
}
