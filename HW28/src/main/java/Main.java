
public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();

        Order order1 = new Order("Bohdan");
        coffeeOrderBoard.add(order1);

        Order order2 = new Order("Serhio");
        coffeeOrderBoard.add(order2);

        Order order3 = new Order("Artem");
        coffeeOrderBoard.add(order3);

        Order order4 = new Order("teacher");
        coffeeOrderBoard.add(order4);

        coffeeOrderBoard.draw();

        coffeeOrderBoard.deliver();

        coffeeOrderBoard.draw();

        coffeeOrderBoard.deliver(3);

        coffeeOrderBoard.draw();
    }
}