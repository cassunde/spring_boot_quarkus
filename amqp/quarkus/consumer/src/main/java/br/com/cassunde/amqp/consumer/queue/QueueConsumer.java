package br.com.cassunde.amqp.consumer.queue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.*;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.io.IOException;
import java.io.Serializable;

@Dependent
public class QueueConsumer<T> implements Consumer, Serializable {

    @Inject
    Event<T> event;

    private Class<T> valueType;
    private Channel channel;

    public QueueConsumer of(Channel channel, Class<T> valueType) {
        this.channel = channel;
        this.valueType = valueType;

        return this;
    }

    @Override
    public void handleConsumeOk(String s) {

    }

    @Override
    public void handleCancelOk(String s) {

    }

    @Override
    public void handleCancel(String s) throws IOException {

    }

    @Override
    public void handleShutdownSignal(String s, ShutdownSignalException e) {

    }

    @Override
    public void handleRecoverOk(String s) {

    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

        ObjectMapper json = new ObjectMapper();
        String mensagem = new String(body, "UTF-8");
        event.fire(json.readValue(mensagem, valueType));
    }
}
