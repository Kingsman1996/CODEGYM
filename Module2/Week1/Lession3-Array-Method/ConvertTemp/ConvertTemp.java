import java.util.Scanner;

public class ConvertTemp {
    public static double celsiusToFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (5.0 / 9) * (fahrenheit - 32);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose which temperature to convert: ");
        System.out.println("1. Fahrenheit");
        System.out.println("2. Celsius");
        System.out.println("0. Exit");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter the temperature in Fahrenheit: ");
                double fahrenheit = sc.nextDouble();
                System.out.print(fahrenheit + " fahrenheit equivalent to ");
                System.out.println(fahrenheitToCelsius(fahrenheit) + " celsius");
                break;
            case 2:
                System.out.println("Enter the temperature in Celsius: ");
                double celsius = sc.nextDouble();
                System.out.print(celsius + " celsius equivalent to ");
                System.out.println(celsiusToFahrenheit(celsius)+ " fahrenheit");
                break;
            default:
                System.out.println("No choice");
        }
    }
}
