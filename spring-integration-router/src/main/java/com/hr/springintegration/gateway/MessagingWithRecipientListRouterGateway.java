package com.hr.springintegration.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface MessagingWithRecipientListRouterGateway {

	@Gateway(requestChannel = "com.hr.multichannel")
	<T> void sendMessageToMultipleChannels(final T request);
	
}
