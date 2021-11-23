package com.microservicesrest.microservices.currencyexchangeservice.controllers;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Implementing Circuit Breaker Controller pattern using Resilience4j (Netflix Hystrix)
 */
@RestController
public class CircuitBreakerController {

    //Logger
    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);


    @GetMapping("/sample-api")
//    @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
    @RateLimiter(name="default") // in 10s i want only allow 2 calls
    @Bulkhead(name = "default")
    public String sampleApi(){
//        logger.info("Sample API call received");
//        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);
//        return forEntity.getBody();
        return "Sample-API";
    }

    //Method to hardcoded response
    public String hardcodedResponse(Exception ex){
        return "fallback-response";
    }

}
