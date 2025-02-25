import java.util.LinkedList;
import java.util.Queue;

public class DemergingGender {
    public static void main(String[] args) {
        Person[] persons = {
                new Person("Linh", "Nữ"),
                new Person("An", "Nam"),
                new Person("Huyen", "Nữ"),
                new Person("Bao", "Nam"),
                new Person("Mai", "Nữ"),
                new Person("Tung", "Nam")};
        Queue<Person> females = new LinkedList<>();
        Queue<Person> males = new LinkedList<>();
        for (Person each : persons) {
            if (each.getGender().equals("Nữ")) {
                females.add(each);
            }
            if (each.getGender().equals("Nam")) {
                males.add(each);
            }
        }
        Queue<Person> sortedPersons = new LinkedList<>();
        while (!females.isEmpty()) {
            sortedPersons.add(females.remove());
        }
        while (!males.isEmpty()) {
            sortedPersons.add(males.remove());
        }
        while (!sortedPersons.isEmpty()) {
            System.out.println(sortedPersons.remove().getName());
        }
    }
}
