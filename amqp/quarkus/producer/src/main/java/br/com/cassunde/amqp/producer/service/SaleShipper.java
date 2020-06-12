package br.com.cassunde.amqp.producer.service;

import br.com.cassunde.amqp.producer.model.Sale;
import br.com.cassunde.amqp.producer.model.Tax;
import br.com.cassunde.amqp.producer.util.QueueManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class SaleShipper {

    @Inject
    QueueManager queueManager;

    public void send(Sale sale){

        try {

            ObjectMapper json = new ObjectMapper();
            String jsonSale = json.writeValueAsString(sale);

            queueManager.send("sales",jsonSale);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
