package br.com.cassunde.cep.service;

import br.com.cassunde.cep.model.CepResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/v1/cep")
@RegisterRestClient
public interface CepService {

    @GET
    @Path("{cep}")
    @Produces("application/json")
    CepResponse getCep(@PathParam("cep") String cep);
}
