import java.util.ArrayList;
import java.util.Collections;

public class ProductManager {
    private ArrayList<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
    }

    public void addProduct(String name, int id, int price) {
        products.add(new Product(name, id, price));
    }

    public void renameProduct(String newName, int id) {
        for (Product item : products) {
            if (item.getId() == id) {
                item.setName(newName);
            }
        }
    }

    public void removeProduct(int id) {
        products.removeIf(item -> item.getId() == id);
    }


    public Product getProductByName(String name) {
        for (Product item : products) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public Product getProductById(int id) {
        for (Product item : products) {
            if (item.getId() == id) {
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
