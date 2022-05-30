package com.hr.springintegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hr.springintegration.gateway.MessagingWithRecipientListRouterGateway;

@RestController
@RequestMapping("/message")
public class MessagingWithRecipientListRouterController {

	@Autowired
	private MessagingWithRecipientListRouterGateway gateway;
	
	@GetMapping("/greet")
	public void addStudent(@RequestParam("msg") final String msg)
	{
		gateway.sendMessageToMultipleChannels(msg);
	}
}
