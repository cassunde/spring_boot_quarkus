package property;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class OrderObservable {

    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    public void addObserver(PropertyChangeListener propertyChangeListener){
        changeSupport.addPropertyChangeListener(propertyChangeListener);
    }

    public void removeObserver(PropertyChangeListener propertyChangeListener){
        changeSupport.removePropertyChangeListener(propertyChangeListener);
    }

    public void fire(Order order){
        changeSupport.firePropertyChange("Update Status", null, order);
    }
}
