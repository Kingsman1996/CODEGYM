import java.util.Scanner;

public class CountDay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tháng: ");
        byte month = sc.nextByte();
        String day = "";
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day = "31";
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                day = "30";
                break;
            case 2:
                day = "28 hoặc 29";
                break;
            default:
                day = "";
        }
        if (day.equals("")) {
            System.out.println("Tháng không hợp lệ");
        } else {
            System.out.println("Tháng"+" "+month+" "+"có"+" "+day +" "+"ngày");
        }
    }
}
