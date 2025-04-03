package org.example.product.service;

import org.example.product.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    void add(Product product);

    void updateProduct(int id, String name, double price, String description, String manufacturer);

    void delete(int id);

    List<Product> searchByName(String name);

    Product getById(int id);
}
