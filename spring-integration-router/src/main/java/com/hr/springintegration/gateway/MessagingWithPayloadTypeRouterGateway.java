package com.hr.springintegration.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface MessagingWithPayloadTypeRouterGateway {

	@Gateway(requestChannel = "com.hr.input.channel")
	<T> void sendMessage(final T request);
	
}
