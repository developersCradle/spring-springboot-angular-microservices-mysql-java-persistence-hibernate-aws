package com.in28minutes.microservices.currency_exchange_service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeRepository repository;

	@Autowired
	private Environment environment;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExhangeValue(
			@PathVariable String from,
			@PathVariable String to) {
		
		String port = environment.getProperty("local.server.port");
		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
		currencyExchange.setEnvironment(port);
		
		if (currencyExchange == null) {
			throw new RuntimeException("Unable to Find data for " + from + " to " + to );
		}
		
		return currencyExchange;
		
	}
}
