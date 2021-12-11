package com.microservicesrest.microservices.currencyexchangeservice.controllers;

import com.microservicesrest.microservices.currencyexchangeservice.daos.CurrencyExchangeRepository;
import com.microservicesrest.microservices.currencyexchangeservice.pojos.CurrencyExchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from,
                                                  @PathVariable String to){

        logger.info("retrieveExchangeValue with {} to {}", from, to );

        CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);

        if(currencyExchange == null){
            throw new RuntimeException("Unable to find data for: " + from + " to:" + to);
        }

        return currencyExchange;
    }

}
