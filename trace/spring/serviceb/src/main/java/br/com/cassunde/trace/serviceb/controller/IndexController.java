package br.com.cassunde.trace.serviceb.controller;

import com.sun.tools.javac.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/hello")
    public ResponseEntity serivesEnables(){
        return ResponseEntity.ok(List.of("Example 1","Example 2"));
    }
}