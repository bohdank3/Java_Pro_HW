package org.example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    public ProductRepository() {

        products = new ArrayList<>();
        products.add(new Product(1, "Кофе", 10.0));
        products.add(new Product(2, "Чай", 20.0));
        products.add(new Product(3, "Пиченюхи ", 30.0));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }
}

