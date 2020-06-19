package br.com.cassunde.amqp.consumer.taok.amqp.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.jboss.logging.Logger;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Dependent
public class QueueManager {

    @Inject
    Event<RabbitMessage> event;

    Logger logger = Logger.getLogger(QueueManager.class);

    public <T> void consumer(String queue, Class<T> valueType) {

        try {

            //TODO create a producer using properties
            ConnectionFactory factory = new ConnectionFactory();
            factory.setUsername("guest");
            factory.setPassword("guest");
            factory.setHost("127.0.0.1");

            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            //TODO using log4j
            logger.infof("Listener configured to queue: %s", queue);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                sendMessage(message,delivery.getEnvelope().getRoutingKey(), valueType);
            };

            channel.queueDeclare(queue, false, false, false, null);
            channel.basicConsume(queue, true, deliverCallback, consumerTag -> { });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String message, String queue, Class<? extends Object> valueType){
        RabbitMessage rabbitMessage = new RabbitMessage(message);
        event.select(getTypeBinding(queue, valueType)).fire(rabbitMessage);
    }

    private TypeBinding getTypeBinding(String queue, Class<? extends Object> valueType) {
        return new TypeBinding() {
            public String queue() {
                return queue;
            }
            public Class<? extends Object> type() {
                return valueType;
            }
        };
    };
}
