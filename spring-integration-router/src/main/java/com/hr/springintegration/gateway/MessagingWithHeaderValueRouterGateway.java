package com.hr.springintegration.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface MessagingWithHeaderValueRouterGateway {

	@Gateway(requestChannel = "com.hr.common.channel")
	<T> void sendMessage(final T request);
	
}
