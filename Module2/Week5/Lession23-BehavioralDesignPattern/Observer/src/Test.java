import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Subject sub = new Subject();
        new HexObserver(sub);
        new OctObserver(sub);
        new BinObserver(sub);
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        sub.setState(scan.nextInt());
        scan.close();
        System.out.println("\n");
    }
}