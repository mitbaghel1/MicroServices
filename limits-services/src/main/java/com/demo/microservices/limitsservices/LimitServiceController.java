package com.demo.microservices.limitsservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitServiceController {

	@Autowired
	private Configuration configuration;
	
	@GetMapping("/limits")
	public LimitService getLimitServiceData()
	{
		return new LimitService(configuration.getMinimum(), configuration.getMaximum());
	}
}
