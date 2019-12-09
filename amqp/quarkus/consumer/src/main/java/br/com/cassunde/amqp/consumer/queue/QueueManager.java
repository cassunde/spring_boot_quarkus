package br.com.cassunde.amqp.consumer.queue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.*;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Dependent
public class QueueManager<T> {

    @Inject
    QueueConsumer<T> queueConsumer;

    public void consumer(String queue, Class<T> valueType) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setHost("127.0.0.1");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(queue, false, false, false, null);

        ObjectMapper json = new ObjectMapper();

        queueConsumer.of(channel, valueType);
        channel.basicConsume(queue, true, queueConsumer);
    }
}
