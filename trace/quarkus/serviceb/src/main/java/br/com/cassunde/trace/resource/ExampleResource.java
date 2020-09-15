package br.com.cassunde.trace.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/hello")
public class ExampleResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
        List services = new ArrayList<>();
        services.add("Exemplo 1");
        services.add("Exemplo 2");
        return Response.ok(services).build();
    }
}