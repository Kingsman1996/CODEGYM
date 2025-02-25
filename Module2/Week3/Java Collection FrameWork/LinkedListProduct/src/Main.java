public class Main {
    public static void main(String[] args) {
        ProductManager pm = new ProductManager();
        pm.addProduct(new Product("Hang B", 123, 8));
        pm.addProduct(new Product("Hang C", 789, 37));
        pm.addProduct(new Product("Hang A", 456, 15));
        System.out.println(pm.toString());
        pm.sortHighToLowPrice();
        System.out.println(pm.toString());
        pm.sortLowToHighPrice();
        System.out.println(pm.toString());
        pm.renameProduct(8, "Hang VIP");
        pm.removeProduct(15);
        System.out.println(pm.toString());
    }
}
