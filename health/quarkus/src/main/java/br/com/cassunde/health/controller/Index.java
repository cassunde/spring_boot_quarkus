package br.com.cassunde.health.controller;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class Index {

    @Getter
    public Response index(){
        return Response.status(Response.Status.OK).entity("OK").build();
    }
}
