package property;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CreateFiscalNoteOrderObserver implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Create final Note");
        System.out.println(evt.getNewValue());
    }
}
