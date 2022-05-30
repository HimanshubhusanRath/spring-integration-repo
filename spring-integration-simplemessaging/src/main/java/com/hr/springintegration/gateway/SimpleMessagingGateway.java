package com.hr.springintegration.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface SimpleMessagingGateway {

	@Gateway(requestChannel = "hr.simplemessage.channel")
	String sendMessage(final String message);
	
}
