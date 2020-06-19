package br.com.cassunde.amqp.consumer.taok.amqp.rabbit;

public class RabbitMessage<T> {

    T object;

    public RabbitMessage(T object) {
        this.object = object;
    }

    public T now(){
        return object;
    }
}
