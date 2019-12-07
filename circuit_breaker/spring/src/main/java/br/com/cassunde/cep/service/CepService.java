package br.com.cassunde.cep.service;

import br.com.cassunde.cep.model.CepResponse;
import br.com.cassunde.cep.repository.CepRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class CepService {

    @Autowired
    private CepRepository cepRepository;

    @HystrixCommand(fallbackMethod = "getCepFallback")
    public CepResponse getCep(@PathVariable("cep") String cep){

        return new RestTemplate().getForObject("https://api.postmon.com.br/v1/cep/{cep}", CepResponse.class, cep);
    }

    public CepResponse getCepFallback(String cep) {

        Optional<CepResponse> cepResponseOptional = cepRepository.findById(cep);

        if(cepResponseOptional.isPresent()){

            return cepResponseOptional.get();
        }

        throw new RuntimeException("Cep Not Found");
    }
}
