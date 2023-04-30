import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Створюємо список продуктів
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Book", 300, true, LocalDateTime.of(2022, 1, 1, 0, 0)));
        products.add(new Product(2, "Pen", 10, false, LocalDateTime.of(2022, 2, 1, 0, 0)));
        products.add(new Product(3, "Book", 200, true, LocalDateTime.of(2022, 3, 1, 0, 0)));
        products.add(new Product(4, "Pencil", 5, false, LocalDateTime.of(2022, 4, 1, 0, 0)));
        products.add(new Product(5, "Book", 400, true, LocalDateTime.of(2022, 5, 1, 0, 0)));
        products.add(new Product(2, "Book", 10, true, LocalDateTime.of(2022, 2, 1, 0, 0)));


        // Отримуємо всі продукти, категорія яких "Book" та ціна більша 250
        String filteredProducts = getFilteredProducts(products, "Book", 199).toString();
        System.out.println(filteredProducts);

        // Отримуємо всі продукти категорії "Book" зі знижкою 10%
        List<Product> discountedProducts = getDiscountedProducts(products, "Book");
        System.out.println("Discounted Products:");
        discountedProducts.forEach(product -> System.out.println("Type: " + product.getType() + ", Price: " + product.getPrice()));

        // Отримуємо найдешевший продукт категорії "Book"
        try {
            Product cheapestBook = getCheapestBook(products, "Book");
            System.out.println("Cheapest Book:");
            System.out.println("Type: " + cheapestBook.getType() + ", Price: " + cheapestBook.getPrice());
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        // Отримуємо трі останні додані продукти
        List<Product> lastThreeAddedProducts = getLastThreeAddedProducts(products);
        System.out.println("Last Three Added Products:");
        for (Product product : lastThreeAddedProducts) {
            System.out.println("Type: " + product.getType() +
                    ", Price: " + product.getPrice() +
                    ", Date Added: " + product.getDateAdded());
        }

        // Отримуємо всі продукти, категорія яких "Book" та ціна меньша 75
        String filteredProductsAnotherTask = getFilteredProductsAnotherMethod(products, "Book", 75);
        System.out.println("Book that price is less than 75:");
        System.out.println(filteredProductsAnotherTask);


        // Групуємо продукти за типом
        Map<String, List<Product>> groupedProducts = groupProductsByType(products);

        for (Map.Entry<String, List<Product>> entry : groupedProducts.entrySet()) {
            System.out.println("Type: " + entry.getKey());
            System.out.println("Products: " + entry.getValue());
            System.out.println("-----");
        }
    }


    public static List<Product> getFilteredProducts(List<Product> products, String type, double price) {
        return products.stream()
                .filter(product -> product.getType().equals(type) && product.getPrice() > price)
                .collect(Collectors.toList());
    }

    public static List<Product> getDiscountedProducts(List<Product> products, String type) {
        return products.stream().filter(product -> type.equals(product.getType()) && product.hasDiscount()).peek(Product::applyDiscount).toList();
    }

    public static Product getCheapestBook(List<Product> products, String type) {
        return products.stream()
                .filter(product -> type.equals(product.getType()))
                .min(Comparator.comparingDouble(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("Продукт " + type + " не знайдено"));
    }

    public static List<Product> getLastThreeAddedProducts(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getDateAdded).reversed())
                .limit(3)
                .toList();
    }


    public static String getFilteredProductsAnotherMethod(List<Product> products, String type, double price) {
        List<String> filteredProductInfo = products.stream()
                .filter(product -> type.equals(product.getType()) && product.getPrice() <= price)
                .map(product -> product.getType() + ": " + product.getPrice())
                .collect(Collectors.toList());
        return String.join(", ", filteredProductInfo);
    }

    public static Map<String, List<Product>> groupProductsByType(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getType, Collectors.toList()));
    }
}