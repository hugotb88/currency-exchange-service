package com.microservicesrest.microservices.currencyexchangeservice.daos;

import com.microservicesrest.microservices.currencyexchangeservice.pojos.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

    //Custom Method
    CurrencyExchange findByFromAndTo (String from, String to);
}
