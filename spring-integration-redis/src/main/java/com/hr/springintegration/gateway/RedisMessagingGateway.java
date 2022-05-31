package com.hr.springintegration.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface RedisMessagingGateway {

	@Gateway(requestChannel = "input.channel")
	<S> void sendMessage(final S message);
	
}
