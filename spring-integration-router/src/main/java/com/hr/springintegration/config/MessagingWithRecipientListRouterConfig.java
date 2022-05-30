package com.hr.springintegration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.router.RecipientListRouter;

@Configuration
@EnableIntegration
public class MessagingWithRecipientListRouterConfig {


	@Bean
	@ServiceActivator(inputChannel = "com.hr.multichannel")
	public RecipientListRouter recipientListRouter()
	{
		final RecipientListRouter router = new RecipientListRouter();
		router.addRecipient("teacher.channel");
		router.addRecipient("student.channel");
		return router;
	}

	
}
