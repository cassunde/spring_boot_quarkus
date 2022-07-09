package property;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FiscalNoteCreator implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        System.out.println("Comecando a criar uma nota fiscal");
        Order order = (Order) propertyChangeEvent.getNewValue();
        System.out.println(order);
    }
}
