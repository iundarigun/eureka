package br.com.devcave.springcloud.eureka.apiserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ApiServerController {

    @GetMapping("/test")
    public String getTestValue(){
        log.info("M=getTestValue");
        return "test-value";
    }
}
