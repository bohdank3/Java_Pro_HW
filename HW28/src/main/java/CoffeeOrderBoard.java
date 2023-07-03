
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.ArrayList;

public class CoffeeOrderBoard {
    private static final Logger logger = LoggerFactory.getLogger(CoffeeOrderBoard.class);

    private List<Order> orders;
    private int lastOrderNumber;

    public CoffeeOrderBoard() {
        logger.info("Initializing CoffeeOrderBoard");
        orders = new ArrayList<>();
        lastOrderNumber = 0;
    }

    public void add(Order order) {
        logger.info("Добавление нового заказа: {}", order);
        lastOrderNumber++;
        order.setOrderNumber(lastOrderNumber);
        orders.add(order);
    }

    public void deliver() {
        if (orders.isEmpty()) {
            logger.info("Нет заказов на доставку");
            return;
        }

        Order nextOrder = orders.get(0);
        logger.info("Доставка заказа: {}", nextOrder);
        orders.remove(nextOrder);
    }

    public void deliver(int orderNumber) {
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                logger.info("Доставка заказа: {}", order);
                orders.remove(order);
                return;
            }
        }
        logger.error("Заказ не найден с номером заказа: {}", orderNumber);
    }

    public void draw() {
        logger.info("Текущая очередь заказов:");
        logger.info("===============");
        logger.info("Num | Name");
        for (Order order : orders) {
            logger.info("{} | {}", order.getOrderNumber(), order.getCustomerName());
        }
        logger.info("===============");
    }
}