package br.com.cassunde.cep.service;

import br.com.cassunde.cep.model.CepResponse;
import br.com.cassunde.cep.repository.CepRepository;
import org.eclipse.microprofile.faulttolerance.Fallback;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.client.ClientBuilder;

@Dependent
public class CepService {

    @Inject
    CepRepository cepRepository;

    @Fallback(fallbackMethod="other")
    public CepResponse getCep(String cep){

        return ClientBuilder.newClient()
                .target("https://api.postmon.com.br/v1/cep/"+cep)
                .request()
                .get()
                .readEntity(CepResponse.class);
    }

    public CepResponse other(String cep) throws RuntimeException {

        CepResponse cepFoundDatabase = cepRepository.findById(cep);

        if( cepFoundDatabase != null ){

            return cepFoundDatabase;
        }

        throw  new RuntimeException("Cep not found");
    }
}
