import java.util.Collections;
import java.util.LinkedList;

public class ProductManager {
    private LinkedList<Product> products;

    public ProductManager() {
        products = new LinkedList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void renameProduct(int id, String newName) {
        for (Product item : products) {
            if (item.getId() == id) {
                item.setName(newName);
            }
        }
    }

    public void removeProduct(int id) {
        products.removeIf(product -> product.getId() == id);
    }

    public Product getProduct(String name) {
        for (Product item : products) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public void sortLowToHighPrice() {
        Collections.sort(products, new LowToHighPrice());
    }

    public void sortHighToLowPrice() {
        Collections.sort(products, new HighToLowPrice());
    }

    @Override
    public String toString() {
        String output = "";
        for (Product item : products) {
            output += item.toString() + "\n";
        }
        return output;
    }
}
