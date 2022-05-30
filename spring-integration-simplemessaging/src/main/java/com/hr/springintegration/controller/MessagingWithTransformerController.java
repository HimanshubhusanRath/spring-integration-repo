package com.hr.springintegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.springintegration.dto.User;
import com.hr.springintegration.gateway.MessagingWithTransformerGateway;

@RestController
@RequestMapping("/transform")
public class MessagingWithTransformerController {

	@Autowired
	private MessagingWithTransformerGateway gateway;
	
	@PostMapping
	public String greet(@RequestBody final User user)
	{
		return gateway.sendMessage(user);
	}
	
	@PostMapping("/enrich-header")
	public String enrichHeader(@RequestBody final User user)
	{
		return gateway.sendMessageWithEnrichHeader(user);
	}
}
