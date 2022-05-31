package com.hr.springintegration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hr.springintegration.dto.User;
import com.hr.springintegration.gateway.RedisMessagingGateway;

@RestController
@RequestMapping("/redis")
public class RedisMessagingController {

	@Autowired
	private RedisMessagingGateway gateway;
	
	@PostMapping("/push")
	public void push(@RequestBody final User user)
	{
		gateway.sendMessage(user);
	}
	
	@GetMapping("/send")
	public void send(@RequestParam("msg") final String message)
	{
		gateway.sendMessage(message);
	}
}
