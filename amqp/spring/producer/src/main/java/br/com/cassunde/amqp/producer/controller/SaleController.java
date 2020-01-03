package br.com.cassunde.amqp.producer.controller;

import br.com.cassunde.amqp.producer.model.Sale;
import br.com.cassunde.amqp.producer.service.SaleShipper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleShipper saleShipper;

    @GetMapping
    public ResponseEntity index(){

        return ResponseEntity.ok("{\"message\":\"OK\"}");
    }

    @PostMapping
    public ResponseEntity send(){

        Sale sale = new Sale("TV 23", new BigDecimal("1500"),1);
        saleShipper.send(sale);

        return ResponseEntity.ok(sale);
    }
}
