package com.baitap.service;

import com.baitap.model.Product;

import java.util.*;

public class ProductService implements IProductService {
    private static final Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "Laptop", 1000000));
        productMap.put(2, new Product(2, "Tablet", 500000));
        productMap.put(3, new Product(3, "Phone", 200000));
        productMap.put(4, new Product(4, "Watch", 80000));
        productMap.put(5, new Product(5, "Headphone", 50000));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void delete(int id) {
        productMap.remove(id);
    }
}
