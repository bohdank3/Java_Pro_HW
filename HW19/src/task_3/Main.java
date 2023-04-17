package task_3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        // Створюємо список продуктів
        List<Product> products = new ArrayList<>();
        products.add(new Product("Book", 100, true));
        products.add(new Product("Pen", 5, false));
        products.add(new Product("Book", 200, false));
        products.add(new Product("Book", 150, true));

        // Отримуємо найдешевший продукт категорії "Book"
        try {
            Product cheapestBook = getCheapestBook(products, "Book");
            System.out.println("Cheapest Book:");
            System.out.println("Type: " + cheapestBook.getType() + ", Price: " + cheapestBook.getPrice());
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Product getCheapestBook(List<Product> products, String type) {
        return products.stream()
                .filter(product -> type.equals(product.getType()))
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("Продукт " + type + " не знайдено"));
    }
}

