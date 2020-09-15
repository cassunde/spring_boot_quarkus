package br.com.cassunde.trace.servicea.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "fetchServiceB", url = "http://localhost:8081")
public interface FetcherServiceB {
    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    List<String> getServices();
}