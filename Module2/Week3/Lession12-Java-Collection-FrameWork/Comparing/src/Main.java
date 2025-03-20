import java.util.*;

public class Main {
    public static void main(String[] args) {
        Student[] studentArray = new Student[4];
        studentArray[0] = new Student("Kien", 30, "HT");
        studentArray[1] = new Student("Nam", 26, "HN");
        studentArray[2] = new Student("Anh", 38, "HT");
        studentArray[3] = new Student("Tung", 38, "HT");
        List<Student> studentList = Arrays.asList(studentArray);
        Collections.sort(studentList);
        for (Student each : studentList) {
            System.out.println(each.toString());
        }
        AgeComparing ageComparing = new AgeComparing();
        Collections.sort(studentList, ageComparing);
        System.out.println("So sanh theo tuoi: ");
        for (Student each : studentList) {
            System.out.println(each.toString());
        }
    }
}
