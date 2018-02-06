package br.com.devcave.springcloud.eureka.apiclient.controller;

import br.com.devcave.springcloud.eureka.apiclient.client.ApiServerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApiClientController {

    @Autowired
    private ApiServerClient apiServerClient;

    @GetMapping("/get-from-server")
    public String getFromServer(){
        return apiServerClient.getTest();
    }
}
