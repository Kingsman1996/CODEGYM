import java.util.List;

public class RandomListFacade {
    public void printRandomEvenList(int size, int min, int max) {
        List<Integer> numberList = new RandomList().generateList(size, min, max);
        numberList = new ListFilter().filterOdd(numberList);
        new ListPrinter().printList(numberList);
    }
}
