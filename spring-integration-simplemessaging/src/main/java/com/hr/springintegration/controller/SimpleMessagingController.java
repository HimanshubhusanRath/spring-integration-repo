package com.hr.springintegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hr.springintegration.gateway.SimpleMessagingGateway;

@RestController
@RequestMapping("/message")
public class SimpleMessagingController {

	@Autowired
	private SimpleMessagingGateway gateway;
	
	@GetMapping("/hello")
	public String greet(@RequestParam("msg") final String message)
	{
		return gateway.sendMessage(message);
	}
}
