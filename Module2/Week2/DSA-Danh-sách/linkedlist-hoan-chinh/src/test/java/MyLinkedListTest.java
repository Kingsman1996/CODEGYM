public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList();
        list.addFirst(1);
        list.addFirst(5);
        list.addFirst(2);
        list.addFirst(3);
        System.out.println(list.toString());
    }
}
