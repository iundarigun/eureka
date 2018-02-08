package br.com.devcave.springcloud.eureka.apiclient.controller;

import br.com.devcave.springcloud.eureka.apiclient.client.ApiServerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


@RestController
public class ApiClientController {

    @Autowired
    private ApiServerClient apiServerClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/get-from-server-by-feign")
    public String getFromServerByFeign() {
        return apiServerClient.getTest();
    }

    @GetMapping("/get-from-server-by-rest-template")
    public String getFromServerByRestTemplate() {
        String result = restTemplate.getForObject(
                "http://api-server/test", String.class);

        return result;
    }

    @GetMapping("/get-from-server-by-discovery-client")
    public String getFromServerByDiscoveryClient() {
        RestTemplate restTemplate = new RestTemplate();

        URI uri = discoveryClient.getInstances("api-server").get(0).getUri();

        ResponseEntity<String> exchange =
                restTemplate.exchange(
                        uri.toString().concat("/test"),
                        HttpMethod.GET,
                        null,
                        String.class);

        String result = exchange.getBody();

        return result;
    }
}
