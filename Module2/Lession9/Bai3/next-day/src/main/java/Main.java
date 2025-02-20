import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ngày: ");
        int inputDay = scanner.nextInt();
        System.out.print("Nhập tháng: ");
        int inputMonth = scanner.nextInt();
        System.out.print("Nhập năm: ");
        int inputYear = scanner.nextInt();
        int[] nextDay = NextDayCalculator.getNextDay(inputDay, inputMonth, inputYear);
        System.out.println("Ngày tiếp theo là: " + nextDay[0] + "/" + nextDay[1] + "/" + nextDay[2]);
        scanner.close();
    }
}
