package br.com.devcave.springcloud.eureka.apiclient.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "api-server")
public interface ApiServerClient {

    @GetMapping("/test")
    String getTest();
}
