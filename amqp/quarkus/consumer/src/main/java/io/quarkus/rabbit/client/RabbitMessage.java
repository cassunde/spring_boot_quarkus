package io.quarkus.rabbit.client;

public class RabbitMessage<T> {

    T object;

    public RabbitMessage(T object) {
        this.object = object;
    }

    public T now(){
        return object;
    }
}
