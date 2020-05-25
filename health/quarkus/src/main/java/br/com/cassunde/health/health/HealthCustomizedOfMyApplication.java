package br.com.cassunde.health.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;

@Liveness
@ApplicationScoped
public class HealthCustomizedOfMyApplication implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        if(LocalDateTime.now().getMinute() % 2 == 0){
            return HealthCheckResponse.down("Horário Errado");
        }
        return HealthCheckResponse.up("HealthCustomizedOfMyApplication");
    }
}
