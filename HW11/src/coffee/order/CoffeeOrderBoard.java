package coffee.order;

import java.util.ArrayList;


public class CoffeeOrderBoard {
    private ArrayList<Order> orders;

    public CoffeeOrderBoard() {
        orders = new ArrayList<>();
    }

    public void add(String name) {
        int orderNumber = orders.size() + 1;
        Order order = new Order(orderNumber, name);
        orders.add(order);
    }
    public Order deliver(){
        if(orders.isEmpty()){
            System.out.println("Больше заказов нет");
            return  null;
        }else{
            Order nextOrder = orders.get(0);
            orders.remove(0);
            System.out.println("Следуйщий  заказ номер " + nextOrder.getOrderNumber() + " Для " +  nextOrder.getCustomName());
            return nextOrder;
        }

    }

    public void deliver(int orderNumber){
        if(orders.isEmpty()){
            System.out.println("Заказов нет");
        }else{
            for (Order order : orders) {
                if (order.getOrderNumber() == orderNumber) {
                    System.out.println("Вы выбрали заказ номер " + order.getOrderNumber() + " Для " +  order.getCustomName());
                    orders.remove(order);
                    break;
                }
            }
        }
    }

    public void draw() {
        System.out.println("=============");
        System.out.println("Num | Name");

        for (int i = 0; i < orders.size(); i++) {
            System.out.println(orders.get(i).getOrderNumber() + " | " + orders.get(i).getCustomName());
        }
    }

    @Override
    public String toString() {
        return "CoffeeOrderBoard{" +
                "orders=" + orders +
                '}';
    }
}
