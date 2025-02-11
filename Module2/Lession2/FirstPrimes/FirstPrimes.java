import java.util.Scanner;

public class FirstPrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of first primes: ");
        int number = sc.nextInt();
        if (number == 1) {
            System.out.println("First prime number is 2");
        } else if (number < 1) {
            System.out.println("Invalid number");
        } else {
            int count = 1;
            int prime = 3;
            boolean isPrime = true;
            System.out.print(number + " first primes: " + 2 + ", ");
            while (count < number) {
                for (int i = 2; i <= Math.sqrt(prime); i++) {
                    if (prime % i == 0) {
                        isPrime = false;
                        break;
                    } else {
                        isPrime = true;
                    }
                }
                if (isPrime) {
                    count++;
                    System.out.print(prime + ", ");
                }
                prime++;
            }
        }
    }
}
