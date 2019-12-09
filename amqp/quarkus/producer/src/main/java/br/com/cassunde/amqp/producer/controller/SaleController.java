package br.com.cassunde.amqp.producer.controller;

import br.com.cassunde.amqp.producer.model.Sale;
import br.com.cassunde.amqp.producer.service.SaleShipper;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;

@Path("/sales")
public class SaleController {

    @Inject
    SaleShipper saleShipper;

    @GET
    public Response index() {

        return Response.status(200).entity("{\"message\":\"OK\"}").build();
    }

    @POST
    public Response send() {

        Sale sale = new Sale("TV 23", new BigDecimal("1500"),1);

        saleShipper.send();

        return Response.status(200).entity("{\"message\":\"OK\"}").build();
    }
}
