package coffee.order;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        board.add("KK");
        System.out.println(board);

        board.add("KK2");
        board.add("KK3");
        board.add("KK6");

        System.out.println(board);
        board.deliver();

        board.deliver(4);
        board.draw();


    }
}