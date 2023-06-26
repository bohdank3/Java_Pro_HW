package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        Cart cart = context.getBean(Cart.class);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить товар в корзину");
            System.out.println("2. Удалить товар из корзины");
            System.out.println("3. Выйти из программы");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Введите ID товара для добавления в корзину:");
                    int productId = scanner.nextInt();
                    Product productToAdd = productRepository.getProductById(productId);
                    if (productToAdd != null) {
                        cart.addProduct(productToAdd);
                        System.out.println("Товар успешно добавлен в корзину.");
                    } else {
                        System.out.println("Товар с указанным ID не найден.");
                    }
                    break;
                case 2:
                    System.out.println("Введите ID товара для удаления из корзины:");
                    int productToRemoveId = scanner.nextInt();
                    cart.removeProduct(productToRemoveId);
                    System.out.println("Товар успешно удален из корзины.");
                    break;
                case 3:
                    System.out.println("Программа завершена.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Некорректный выбор действия.");
            }

            System.out.println("Текущий состав корзины:");
            for (Product product : cart.getProducts()) {
                System.out.println(product.getId() + ": " + product.getName() + " - $" + product.getPrice());
            }
            System.out.println();
        }
    }
}