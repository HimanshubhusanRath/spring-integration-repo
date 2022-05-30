package com.hr.springintegration.service;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

@Service
public class MessagingWithRouterService {

	@ServiceActivator(inputChannel = "teacher.channel")
	public Message<?> serveTeacher(final Message<String> message) throws MessagingException {
		System.out.println("------ Teacher Channel ------");
		System.out.println(message.getPayload());
		return message;
	}
	
	@ServiceActivator(inputChannel = "student.channel")
	public Message<?> serveStudent(final Message<String> message) throws MessagingException {
		System.out.println("------ Student Channel ------");
		System.out.println(message.getPayload());
		return message;
	}

}
