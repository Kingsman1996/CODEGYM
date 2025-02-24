class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> integerList = new MyList<>();
        for (int i = 0; i < 5; i++) {
            integerList.add(i + 1);
        }
        System.out.println("element 1: " + integerList.get(1));
        System.out.println("element 2: " + integerList.get(2));
        System.out.println("element 4: " + integerList.get(4));
        System.out.println("element 6: " + integerList.get(-1));
    }
}