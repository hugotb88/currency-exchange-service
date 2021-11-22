package com.microservicesrest.microservices.currencyexchangeservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementing Circuit Breaker Controller pattern using Resilience4j (Netflix Hystrix)
 */
@RestController
public class CircuitBreakerController {

    @GetMapping("/sample-api")
    public String sampleApi(){
        return "Sample API";
    }

}
