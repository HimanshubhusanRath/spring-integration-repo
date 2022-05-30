package com.hr.springintegration.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface MessagingWithFiltersGateway {

	@Gateway(requestChannel = "com.hr.filter.channel")
	<T> void sendMessage(final T request);
	
}
