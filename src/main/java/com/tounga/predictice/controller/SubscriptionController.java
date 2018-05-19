package com.tounga.predictice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscriptionController {

	
	@RequestMapping(value = "/test", method = RequestMethod.GET)	
	public String test (){		
		return "OK";
	}
}
