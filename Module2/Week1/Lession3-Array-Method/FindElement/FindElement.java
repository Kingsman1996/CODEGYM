import java.util.Scanner;

public class FindElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] studentNames = {"Christian", "Michael", "Camila", "Sienna", "Tanya",
                "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        System.out.println("Enter student name: ");
        String inputName = sc.nextLine();
        for (int i = 0; i < studentNames.length; i++) {
            if (inputName.equalsIgnoreCase(studentNames[i])) {
                System.out.println("found " + studentNames[i] + " at index " + i);
                break;
            }
        }
        System.out.println("Student name not found");
    }
}
