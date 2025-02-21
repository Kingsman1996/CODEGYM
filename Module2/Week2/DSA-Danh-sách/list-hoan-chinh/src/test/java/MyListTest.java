
class MyListTest {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i, "" + i);
        }
        System.out.println(list.toString());
    }
}