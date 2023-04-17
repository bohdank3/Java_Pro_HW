package task_4;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Створюємо список продуктів
        List<Product> products = new ArrayList<>();
        products.add(new Product("Book", 100, true, LocalDateTime.now().minusDays(2)));
        products.add(new Product("Pen", 5, false, LocalDateTime.now().minusDays(1)));
        products.add(new Product("Book", 200, false, LocalDateTime.now().minusHours(5)));
        products.add(new Product("Book", 150, true, LocalDateTime.now()));

        // Отримуємо трі останні додані продукти
        List<Product> lastThreeAddedProducts = getLastThreeAddedProducts(products);
        System.out.println("Last Three Added Products:");
        for (Product product : lastThreeAddedProducts) {
            System.out.println("Type: " + product.getType() +
                    ", Price: " + product.getPrice() +
                    ", Date Added: " + product.getDateAdded());
        }
    }

    public static List<Product> getLastThreeAddedProducts(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getDateAdded).reversed())
                .limit(3)
                .toList();
    }
}
