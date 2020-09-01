package br.com.cassunde.trace.serviceb.controller;

import com.sun.tools.javac.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/service/enables")
    public ResponseEntity serivesEnables(){
        logger.info("Hello B !!");
        return ResponseEntity.ok(List.of("Example 1","Example2"));
    }
}