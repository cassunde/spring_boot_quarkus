package property;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class OrderObservable {

    private PropertyChangeSupport changeSupport;

    private String news;
    private Order order;

    public OrderObservable() {
        this.changeSupport = new PropertyChangeSupport(this);
    }

    public OrderObservable(Order order) {
        this.order = new Order(order.getClient(), order.getAmount());
        this.changeSupport = new PropertyChangeSupport(this);
    }

    public void addObserver(PropertyChangeListener observer){
        this.changeSupport.addPropertyChangeListener(observer);
    }

    public void removeObserver(PropertyChangeListener observer){
        this.changeSupport.removePropertyChangeListener(observer);
    }

    public void sendNotification(Order order){
        this.changeSupport.firePropertyChange("news", this.order, order);
        this.news = news;
    }
}
