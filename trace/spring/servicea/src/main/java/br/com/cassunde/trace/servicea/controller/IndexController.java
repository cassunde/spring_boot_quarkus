package br.com.cassunde.trace.servicea.controller;

import br.com.cassunde.trace.servicea.service.FetcherServiceB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FetcherServiceB fetcherServiceB;

    @GetMapping("/")
    public ResponseEntity index(){

        logger.info("Hello!! Service A");
        return ResponseEntity.ok(fetcherServiceB.getServices());
    }
}
