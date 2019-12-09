package br.com.cassunde.amqp.producer.service;

import br.com.cassunde.amqp.producer.model.Sale;
import br.com.cassunde.amqp.producer.util.QueueManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.enterprise.context.Dependent;
import java.math.BigDecimal;

@Dependent
public class SaleShipper {

    public void send(){

        try {

            ObjectMapper json = new ObjectMapper();
            String jsonSale = json.writeValueAsString(new Sale("TV", new BigDecimal("1500"),1));
            System.out.println(jsonSale);
            new QueueManager().send("sales",jsonSale);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
