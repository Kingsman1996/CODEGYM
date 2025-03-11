import java.util.HashSet;
import java.util.Set;

public class Client {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(12);
        numbers.add(45);
        numbers.add(30);
        numbers.add(7);
        int maxNumber = new CollectionUtilsAdapter().findMax(numbers);
        System.out.println("Số lớn nhất: " + maxNumber);
    }
}
