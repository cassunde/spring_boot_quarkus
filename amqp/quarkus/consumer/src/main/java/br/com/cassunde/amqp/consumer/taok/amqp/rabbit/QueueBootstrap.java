package br.com.cassunde.amqp.consumer.taok.amqp.rabbit;

import io.quarkus.runtime.StartupEvent;
import org.reflections.Reflections;
import org.reflections.scanners.MethodParameterScanner;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;

public class QueueBootstrap {

    @Inject
    QueueManager managerQueue;

    public void beginListener(@Observes StartupEvent ev){

        //TODO increase this find package base of the application
        Reflections reflections = new Reflections("br.com.cassunde", new MethodParameterScanner());

        Set<Method> pathParamMethods = reflections.getMethodsWithAnyParamAnnotated(RabbitListenerConfiguration.class);
        for (Method pathParamMethod : pathParamMethods) {
            for (Annotation[] annotationRow : pathParamMethod.getParameterAnnotations()) {
                for (Annotation annotation : annotationRow) {
                    if(annotation instanceof RabbitListenerConfiguration){
                        RabbitListenerConfiguration rabbitListenerConfiguration = (RabbitListenerConfiguration) annotation;
                        managerQueue.consumer(rabbitListenerConfiguration.queue(), rabbitListenerConfiguration.type());
                    }
                }
            }
        }
    }
}
