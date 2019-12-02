package br.com.cassunde.cep.controller;

import br.com.cassunde.cep.model.CepResponse;
import br.com.cassunde.cep.repository.CepRepository;
import br.com.cassunde.cep.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping("v1/ceps")
public class IndexController {

    @Autowired
    private CepService cepService;

    @Autowired
    private CepRepository cepRepository;

    @GetMapping(value = "/{cep}")
    public ResponseEntity<CepResponse> getCep(@PathVariable  String cep){

        CepResponse response = cepRepository.save(cepService.getCep(cep));

        return ResponseEntity.ok(response);
    }

}
