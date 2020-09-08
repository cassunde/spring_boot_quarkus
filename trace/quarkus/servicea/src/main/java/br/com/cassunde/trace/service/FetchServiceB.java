package br.com.cassunde.trace.service;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import java.util.List;

@RegisterRestClient(configKey="fetchServiceB")
public interface FetchServiceB {

    @GET
    List<String> getServices();
}
