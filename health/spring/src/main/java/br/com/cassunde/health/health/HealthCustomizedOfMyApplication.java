package br.com.cassunde.health.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class HealthCustomizedOfMyApplication implements HealthIndicator {

    @Override
    public Health health() {
        if(LocalDateTime.now().getMinute() % 2 == 0){
            return Health.down().withDetail("Horário Errado", String.class).build();
        }
        return Health.up().build();
    }
}
