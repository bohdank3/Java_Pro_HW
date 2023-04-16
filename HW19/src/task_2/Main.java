package task_2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Створюємо список продуктів
        List<Product> products = new ArrayList<>();
        products.add(new Product("Book", 100, true));
        products.add(new Product("Pen", 5, false));
        products.add(new Product("Book", 200, false));
        products.add(new Product("Book", 150, true));

        // Отримуємо всі продукти категорії "Book" зі знижкою 10%
        List<Product> discountedProducts = getDiscountedProducts(products, "Book");

        // Виводимо результат
        System.out.println("Discounted Products:");
        discountedProducts.forEach(product -> System.out.println("Type: " + product.getType() + ", Price: " + product.getPrice()));
    }

    public static List<Product> getDiscountedProducts(List<Product> products, String type) {
        return products.stream()
                .filter(product -> type.equals(product.getType()) && product.hasDiscount())
                .peek(Product::applyDiscount)
                .toList();
    }
}