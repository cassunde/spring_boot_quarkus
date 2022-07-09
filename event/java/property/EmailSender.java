package property;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.CompletableFuture;

public class EmailSender implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

        CompletableFuture.runAsync(()->{

            System.out.println("Comecando a enviar email");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Order order = (Order) propertyChangeEvent.getNewValue();
            System.out.println(order);

        });
    }
}
