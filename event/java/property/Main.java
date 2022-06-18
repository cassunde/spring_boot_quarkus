package property;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        /*
        * Classe que representa um ordem de compra
        * */
        Order order = new Order("José", BigDecimal.TEN);

        /*
        * Classe que vai representar um Observable da Order, aqui vamos inicia-lo passando o estado inicial da ordem
        * */
        OrderObservable orderObservable =  new OrderObservable(order);

        /*
        * Registrando quem tem o interesse de saber com uma alteração
        * */
        SendEmailOrderObserver sendEmailOrderObserver = new SendEmailOrderObserver();
        CreateFiscalNoteOrderObserver createFiscalNoteOrderObserver = new CreateFiscalNoteOrderObserver();
        orderObservable.addObserver(sendEmailOrderObserver);
        orderObservable.addObserver(createFiscalNoteOrderObserver);

        /*
        * Altera o estado da ordem de pagamento
        * */
        order.updateStatus("DONE");

        /*
        * Dispara a alteração
        * */
        orderObservable.sendNotification(order);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
