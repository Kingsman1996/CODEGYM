import java.util.Scanner;

public class NamNhuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập năm");
        int year = sc.nextInt();
        boolean isLeap;
        if (year % 4 == 0) {
            if (year % 400 == 0) {
                isLeap = true;
            } else if (year % 100 == 0) {
                isLeap = false;
            } else {
                isLeap = true;
            }
        } else {
            isLeap = false;
        }
        if (isLeap) {
            System.out.println("Năm " + year + " là năm nhuận");
        } else {
            System.out.println("Năm " + year + " không là năm nhuận");
        }
    }
}
