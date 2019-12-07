package br.com.cassunde.cep.controller;

import br.com.cassunde.cep.model.CepResponse;
import br.com.cassunde.cep.repository.CepRepository;
import br.com.cassunde.cep.service.CepService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/ceps")
public class IndexController {

    @Inject
    CepRepository cepRepository;

    @Inject
    CepService cepService;

    @GET
    @Path("/{cep}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCep(@PathParam("cep") String cep){

        CepResponse cepFound = cepService.getCep(cep);
        cepRepository.persist(cepFound);

        return Response.status(200).entity(cepFound).build();
    }
}
