package com.hr.springintegration.service;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

@Service
public class SimpleMessagingService {

	@ServiceActivator(inputChannel = "hr.simplemessage.channel")
	public void serveMessage(final Message<String> message) throws MessagingException
	{
		MessageChannel replyChannel = (MessageChannel) message.getHeaders().getReplyChannel();
		// Prepare the message for sending to the reply channel
		MessageBuilder.fromMessage(message);
		final Message<String> result = MessageBuilder.withPayload("Hello customer, Your message is : "+message.getPayload()).build();
		replyChannel.send(result);
	}
}
