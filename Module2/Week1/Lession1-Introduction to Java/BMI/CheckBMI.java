import java.util.Scanner;

public class CheckBMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chiều cao theo đơn vị mét: ");
        float height = sc.nextFloat();
        System.out.println("Nhập cân nặng theo đơn vị kg: ");
        float weight = sc.nextFloat();
        float bmi = weight / (height * height);
        if (bmi < 18.5) {
            System.out.println("BMI: "+bmi+ " => Gầy");
        } else if (bmi >= 18.5 && bmi < 25) {
            System.out.println("BMI: "+bmi+ " => Cân đối");
        } else if (bmi >= 25 && bmi < 30) {
            System.out.println("BMI: "+bmi+ " => Hơi béo");
        } else {
            System.out.println("BMI: "+bmi+ " => Béo phì");
        }
    }
}
