package task_1;

import task_1.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Створюємо список продуктів
        List<Product> products = new ArrayList<>();
        products.add(new Product("Book", 200));
        products.add(new Product("Book", 300));
        products.add(new Product("Pen", 5));
        products.add(new Product("Book", 150));

        // Отримуємо всі продукти, категорія яких "Book" та ціна більша 250
        String filteredProducts = getFilteredProducts(products, "Book", 199);

        // Виводимо результат
        System.out.println(filteredProducts);
    }

    public static String getFilteredProducts(List<Product> products, String type, double price) {
        List<String> filteredProductInfo = products.stream()
                .filter(product -> type.equals(product.getType()) && product.getPrice() > price)
                .map(product -> product.getType() + ": " + product.getPrice())
                .collect(Collectors.toList());
        return String.join(", ", filteredProductInfo);
    }
}