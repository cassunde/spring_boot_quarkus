package br.com.cassunde.amqp.consumer.service;

import br.com.cassunde.amqp.consumer.model.Persona;
import br.com.cassunde.amqp.consumer.model.Persona2;
import br.com.cassunde.amqp.consumer.model.Sale;
import io.quarkus.rabbit.client.RabbitListenerConfiguration;
import io.quarkus.rabbit.client.RabbitMessage;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;

@Dependent
public class SaleConsumer {

    public void listen(@Observes @RabbitListenerConfiguration(queue = "vendor", type = Persona.class) RabbitMessage rabbitMessage){
        System.out.println("Message read from vendor : " + rabbitMessage.now());
    }

    public void listenOther(@Observes @RabbitListenerConfiguration(queue = "sales", type = Sale.class) RabbitMessage rabbitMessage){
        System.out.println("Message read from sales : " + rabbitMessage.now());
    }

    public void listenOtherX(@Observes @RabbitListenerConfiguration(queue = "persona2", type = Persona2.class) RabbitMessage rabbitMessage){
        System.out.println("Message read from persona2 : " + rabbitMessage.now());
    }
}
