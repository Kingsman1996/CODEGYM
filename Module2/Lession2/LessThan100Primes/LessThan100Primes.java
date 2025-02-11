public class LessThan100Primes {
    public static void main(String[] args) {
        int number = 2;
        boolean isPrime = true;
        while (number < 100) {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                } else {
                    isPrime = true;
                }
            }
            if (isPrime) {
                System.out.print(number + ", ");
            }
            number++;
        }
    }
}
