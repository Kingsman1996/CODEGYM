import java.util.Scanner;
public class CountChar {
    public static void main(String[] args) {
        String string = "CodegymHanoiDanangHoChiMinh";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char character = sc.next().charAt(0);
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == character) {
                count++;
            }
        }
        System.out.println(count);
    }
}
