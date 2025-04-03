package org.example.product.service;

import org.example.product.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Laptop Dell", 1500, "Laptop cao cấp", "Dell"));
        products.add(new Product(2, "iPhone 15", 1200, "Smartphone mới nhất", "Apple"));
        products.add(new Product(3, "Samsung Galaxy S23", 1100, "Smartphone Android", "Samsung"));
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void updateProduct(int id, String name, double price, String description, String manufacturer) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.setName(name);
                p.setPrice(price);
                p.setDescription(description);
                p.setManufacturer(manufacturer);
                break;
            }
        }
    }


    @Override
    public void delete(int id) {
        products.removeIf(product -> product.getId() == id);
    }

    @Override
    public Product getById(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

}
