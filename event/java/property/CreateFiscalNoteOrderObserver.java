package property;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CreateFiscalNoteOrderObserver implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Create final Note");
        Order order = convert(evt.getNewValue());
        System.out.println(order.getAmount());
    }

    public <T> T convert(Object obj){
        return (T) obj;
    }
}
