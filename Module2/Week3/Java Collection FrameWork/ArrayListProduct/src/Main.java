public class Main {
    public static void main(String[] args) {
        Product[] products = new Product[3];
        products[0] = new Product("Hang 2", 5, 9999);
        products[1] = new Product("Hang 3", 11, 7777);
        products[2] = new Product("Hang 1", 3, 8888);
        ProductManager pm = new ProductManager();
        for (Product item : products) {
            pm.addProduct(item.getName(), item.getId(), item.getPrice());
            System.out.println("Added: " + pm.getProductById(item.getId()));
        }
        System.out.println("Sorted low to high price: ");
        pm.sortLowToHighPrice();
        System.out.println(pm.toString());
        System.out.println("Sorted high to low price: ");
        pm.sortHighToLowPrice();
        System.out.println(pm.toString());
        String oldName = pm.getProductById(11).getName();
        pm.renameProduct("Hang 7", 11);
        String newName = pm.getProductById(11).getName();
        System.out.println("Renamed " + oldName + " to " + newName);
        System.out.println("Removing " + newName);
        pm.removeProduct(11);
        System.out.println("Product List:" + "\n" + pm.toString());
    }
}
