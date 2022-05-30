package com.hr.springintegration.service;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import com.hr.springintegration.dto.User;

@Service
public class MessagingWithTransformerService {

	@ServiceActivator(inputChannel = "com.hr.objecttojson.channel", outputChannel = "com.hr.jsontoobject.channel")
	public Message<?> serveMessage(final Message<String> message) throws MessagingException {
		System.out.println("------ Message in JSON format ------");
		System.out.println(message.getPayload());
		return message;
	}

	@ServiceActivator(inputChannel = "com.hr.output.channel")
	public void convertJsonToObject(final Message<?> message) throws MessagingException {
		MessageChannel replyChannel = (MessageChannel) message.getHeaders().getReplyChannel();
		MessageBuilder.fromMessage(message);
		System.out.println("------ Message is OBJECT format ------");
		System.out.println(message.getPayload());
		// Prepare the message for sending to the reply channel
		final User user = (User) message.getPayload();
		final Message<?> result = MessageBuilder.withPayload("Hello customer, Your message is : " + user.toString()).build();
		replyChannel.send(result);
	}
}
