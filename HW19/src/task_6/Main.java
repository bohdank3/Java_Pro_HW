package task_6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Створюємо список продуктів
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Book", 100, false, LocalDate.of(2022, 1, 1)));
        products.add(new Product(2, "Toy", 150, true, LocalDate.of(2022, 10, 10)));
        products.add(new Product(3, "Book", 200, true, LocalDate.of(2021, 12, 31)));
        products.add(new Product(4, "Toy", 120, false, LocalDate.of(2022, 3, 15)));

        // Групуємо продукти за типом
        Map<String, List<Product>> groupedProducts = groupProductsByType(products);

        // Виводимо результат
        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println("Type: " + entry.getKey());
            System.out.println("Products: " + entry.getValue());
            System.out.println("-----");
        }
    }

    public static Map<String, List<Product>> groupProductsByType(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType, Collectors.toList()));
    }
}