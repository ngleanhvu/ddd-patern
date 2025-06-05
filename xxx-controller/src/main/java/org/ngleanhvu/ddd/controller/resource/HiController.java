package org.ngleanhvu.ddd.controller.resource;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.ngleanhvu.ddd.application.service.event.EventApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@RestController
@RequestMapping("/hello")
public class HiController {

    @Autowired
    private EventApplicationService eventApplicationService;

    @RateLimiter(name = "backendA", fallbackMethod = "fallbackHello")
    @GetMapping("/hi")
    public String hi() {
        return eventApplicationService.sayHi("Vu"); 
    }

    public String fallbackHello(Throwable throwable) {
        return "Too many requests";
    }

    @RateLimiter(name = "backendB", fallbackMethod = "fallbackHello")
    @GetMapping("/hi/v1")
    public String hiv1() {
        return eventApplicationService.sayHi("Vu");
    }

    @GetMapping("/circuit/breaker")
    @CircuitBreaker(name = "checkRandom", fallbackMethod = "fallbackCircuitBreaker")
    public String circuitBreaker() {
        RestTemplate restTemplate = new RestTemplate();
        int productId = new Random().nextInt(20)+1;
        String url = "https://fakestoreapi.com/products/"+productId;
        return restTemplate.getForObject(url, String.class);
    }

    public String fallbackCircuitBreaker(Throwable throwable) {
        return "Service error";
    }
}