import java.util.Scanner;

public class Main {
    public static String findLongestIncreasingString(String string) {
        if (string.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        result.append(string.charAt(0));

        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) > result.charAt(result.length() - 1)) {
                result.append(string.charAt(i));
            }
        }
        return result.toString();
    }

    // Sử dụng 1 vòng lặp duyệt qua từng phần tử của chuỗi với độ dài n, mỗi ký tự xét 1 lần
    //    => Độ phức tạp O(n)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập chuỗi: ");
        String string = scanner.nextLine();
        System.out.println(findLongestIncreasingString(string));
        scanner.close();
    }
}
