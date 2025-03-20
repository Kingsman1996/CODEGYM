import java.util.Scanner;

public class CountPassed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int students;
        do {
            System.out.println("Enter the number of students: ");
            students = sc.nextInt();
            if (students < 1 || students > 30) {
                System.out.println("Value must be between 1 and 30");
            }
        } while (students > 30 || students < 1);
        int count = 0;
        for (int i = 0; i < students; i++) {
            System.out.println("Enter student " + (i + 1) + " grade: ");
            int grade = sc.nextInt();
            while (grade > 10){
                System.out.println("Grade must be a number between 0 and 10");
                grade = sc.nextInt();
            }
            if (grade >= 5) {
                count++;
            }
        }
        System.out.println("Total number of students passed: " + count);
    }
}
