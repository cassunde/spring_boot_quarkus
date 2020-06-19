package br.com.cassunde.amqp.consumer.taok.amqp.rabbit;

import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Target({ ElementType.PARAMETER, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface RabbitListenerConfiguration {
    Class<? extends Object> type();
    String queue();
}
