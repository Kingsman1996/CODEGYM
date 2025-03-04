import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void writeProductToFile(String path, Product newProduct) throws IOException {
        List<Product> productList = readDataFromFile(path);
        productList.add(newProduct);
        try (FileOutputStream fos = new FileOutputStream(path);
             DataOutputStream dos = new DataOutputStream(fos)) {
            for (Product product : productList) {
                dos.writeUTF(product.getId());
                dos.writeUTF(product.getName());
                dos.writeDouble(product.getPrice());
                dos.writeUTF(product.getDescription());
                dos.writeUTF(product.getManufacturer());
            }
        }
    }

    public static List<Product> readDataFromFile(String path) throws IOException {
        List<Product> productList = new ArrayList<>();
        File file = new File(path);
        if (!file.exists() || file.length() == 0) {
            return productList;
        }
        try (FileInputStream fis = new FileInputStream(path);
             DataInputStream dis = new DataInputStream(fis)) {
            while (true) {
                try {
                    String readId = dis.readUTF();
                    String readName = dis.readUTF();
                    double readPrice = dis.readDouble();
                    String readDescription = dis.readUTF();
                    String readManufacturer = dis.readUTF();
                    productList.add(new Product(readId, readName, readPrice, readDescription, readManufacturer));
                } catch (EOFException e) {
                    break;
                }
            }
        }
        return productList;
    }

    public static Product getProductById(String id, List<Product> productList) {
        boolean found = false;
        Product foundedProduct = null;
        for (Product item : productList) {
            if (item.getId().equals(id)) {
                foundedProduct = item;
                found = true;
            }
        }
        if (!found) {
            throw new NoSuchElementException("Product not found");
        } else {
            return foundedProduct;
        }
    }

    private static void showAllProducts(String filePath) throws IOException {
        try {
            List<Product> productList = readDataFromFile(filePath);
            for (Product product : productList) {
                System.out.println(product);
            }
        } catch (NoSuchElementException e) {
            System.out.println("No product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String filePath = "C:\\Users\\ASUS\\Desktop\\CODEGYM\\Module2\\Week4\\Lession17 - BinaryFile\\ProductToFile\\src\\products.txt";
        System.out.println("Enter product amout: ");
        int productAmount = sc.nextInt();
        sc.nextLine();
        if (productAmount > 0) {
            for (int i = 0; i < productAmount; i++) {
                System.out.println("Enter product ID: ");
                String productID = sc.nextLine();
                System.out.println("Enter product name: ");
                String productName = sc.nextLine();
                System.out.println("Enter product description: ");
                String productDescription = sc.nextLine();
                System.out.println("Enter product manufacturer: ");
                String productManufacturer = sc.nextLine();
                System.out.println("Enter product price: ");
                double productPrice = sc.nextDouble();
                sc.nextLine();
                Product inputProduct = new Product(productID, productName, productPrice, productDescription, productManufacturer);
                writeProductToFile(filePath, inputProduct);
            }
        }
        System.out.println("Showing all products: ");
        showAllProducts(filePath);
    }
}
