package property;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Order order = new Order("Mattheus", BigDecimal.TEN, Order.Status.PENDING);
        OrderObservableConfiguration orderObserverConfiguration = new OrderObservableConfiguration();
        orderObserverConfiguration.fire(order);

        Thread.sleep(10000);
    }
}
