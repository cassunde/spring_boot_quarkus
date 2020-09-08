package br.com.cassunde.trace.resource;

import br.com.cassunde.trace.service.FetchServiceB;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class IndexResource {

    @Inject
    @RestClient
    private FetchServiceB fetchServiceB;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
        return Response.ok(fetchServiceB.getServices()).build();
    }
}