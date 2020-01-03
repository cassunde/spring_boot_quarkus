package br.com.cassunde.amqp.producer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SaleConsumer {

    @RabbitListener(queues = "sales")
    public void listen(String sale) {

        System.out.println("Message read from sales : " + sale);
    }
}