package br.com.devcave.springcloud.eureka.apiserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiServerController {

    @GetMapping("/test")
    public String getTestValue(){
        return "test-value";
    }
}
