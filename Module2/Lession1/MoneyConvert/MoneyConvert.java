import java.util.Scanner;
public class MoneyConvert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số tiền theo đơn vị đô la Mỹ");
        double dollar = sc.nextDouble();
        double vnd = dollar * 25000;
        System.out.println(dollar+" đô la bằng "+vnd+" VND");
    }
}
