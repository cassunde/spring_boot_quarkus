package property;

public class OrderObservableConfiguration {

    private OrderObservable orderObservable;

    public OrderObservableConfiguration() {

        EmailSender emailSender =  new EmailSender();
        FiscalNoteCreator fiscalNoteCreator = new FiscalNoteCreator();

        this.orderObservable = new OrderObservable();
        orderObservable.addObserver(emailSender);
        orderObservable.addObserver(fiscalNoteCreator);
    }

    public void fire(Order order){
        this.orderObservable.fire(order);
    }
}
