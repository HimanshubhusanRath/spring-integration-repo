package com.hr.springintegration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageSelector;
import org.springframework.integration.filter.MessageFilter;
import org.springframework.messaging.Message;

import com.hr.springintegration.dto.Teacher;

@Configuration
@EnableIntegration
public class MessagingWithFiltersConfig {


	/**
	 * Allows only the payload type as 'Teacher'
	 * 
	 * @return
	 */
	@Bean
	@Filter(inputChannel = "com.hr.filter.channel")
	public MessageFilter messageFilter()
	{
		final MessageFilter filter = new MessageFilter(new MessageSelector() {
			
			@Override
			public boolean accept(Message<?> message) {
				if(message.getPayload() instanceof Teacher)
				{
					System.out.println("Request is allowed...");
					return true;
				}
				else
				{
					System.out.println("Request is not allowed !!!");
					return false;
				}
			}
		});
		
		filter.setOutputChannelName("teacher.channel");
		return filter;
	}

	
}
