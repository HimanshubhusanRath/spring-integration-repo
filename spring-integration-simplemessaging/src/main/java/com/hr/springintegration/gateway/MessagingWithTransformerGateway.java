package com.hr.springintegration.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import com.hr.springintegration.dto.User;

@MessagingGateway
public interface MessagingWithTransformerGateway {

	@Gateway(requestChannel = "com.hr.input.channel")
	String sendMessage(final User user);
	
}
