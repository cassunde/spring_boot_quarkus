package br.com.cassunde.amqp.producer.service;

import br.com.cassunde.amqp.producer.model.Sale;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaleShipper {

    @Autowired
    private RabbitTemplate template;

    public void send(Sale sale){

        template.convertAndSend("sales", sale.toString());
    }
}
