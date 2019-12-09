package br.com.cassunde.amqp.consumer.queue;

import br.com.cassunde.amqp.consumer.model.Sale;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class QueueStart {

    @Inject
    QueueManager<Sale> manager;

    void onStart(@Observes StartupEvent ev) {

        try {

            manager.consumer("sales", Sale.class);
        }catch (Exception e){

            e.printStackTrace();
        }
    }

    public void receive(@Observes Sale sale){

        System.out.println(sale);
    }
}
