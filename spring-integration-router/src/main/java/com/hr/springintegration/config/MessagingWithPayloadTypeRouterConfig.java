package com.hr.springintegration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.router.PayloadTypeRouter;

import com.hr.springintegration.dto.Student;
import com.hr.springintegration.dto.Teacher;

@Configuration
@EnableIntegration
public class MessagingWithPayloadTypeRouterConfig {

	@Bean
	@ServiceActivator(inputChannel = "com.hr.input.channel")
	public PayloadTypeRouter payloadTypeRouter()
	{
		final PayloadTypeRouter router = new PayloadTypeRouter();
		router.setChannelMapping(Teacher.class.getName(), "teacher.channel");
		router.setChannelMapping(Student.class.getName(), "student.channel");
		return router;
	}
}
