package property;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.CompletableFuture;

public class SendEmailOrderObserver implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        CompletableFuture.runAsync(()->{
            try {
                Thread.sleep(5000);
                System.out.println("Disparar email para cliente");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
