package com.hr.springintegration.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.router.HeaderValueRouter;
import org.springframework.integration.router.PayloadTypeRouter;
import org.springframework.integration.transformer.HeaderEnricher;
import org.springframework.integration.transformer.support.HeaderValueMessageProcessor;
import org.springframework.integration.transformer.support.StaticHeaderValueMessageProcessor;

import com.hr.springintegration.dto.Student;
import com.hr.springintegration.dto.Teacher;

@Configuration
@EnableIntegration
public class MessagingWithHeaderValueRouterConfig {

	final String HEADER_KEY = "header-key";
	
	
	/**
	 * Redirect to channels based on the payload type
	 * 
	 * @return
	 */
	@Bean
	@ServiceActivator(inputChannel = "com.hr.common.channel")
	public PayloadTypeRouter addPayloadTypeRouter()
	{
		final PayloadTypeRouter router = new PayloadTypeRouter();
		router.setChannelMapping(Teacher.class.getName(), "com.hr.teacher.channel");
		router.setChannelMapping(Student.class.getName(), "com.hr.student.channel");
		return router;
	}
	
	
	
	/**
	 * Add header value in the request for each channel
	 * 
	 * @return
	 */
	@Bean
	@Transformer(inputChannel = "com.hr.teacher.channel", outputChannel = "com.hr.router.channel")
	public HeaderEnricher headerEnricherForTeacher()
	{
		final Map<String, HeaderValueMessageProcessor<String>> headers = new HashMap<>();
		headers.put(HEADER_KEY, new StaticHeaderValueMessageProcessor<String>("teacher"));
		return new HeaderEnricher(headers);
	}
	
	@Bean
	@Transformer(inputChannel = "com.hr.student.channel", outputChannel = "com.hr.router.channel")
	public HeaderEnricher headerEnricherForStudent()
	{
		final Map<String, HeaderValueMessageProcessor<String>> headers = new HashMap<>();
		headers.put(HEADER_KEY, new StaticHeaderValueMessageProcessor<String>("student"));
		return new HeaderEnricher(headers);
	}
	
	/**
	 * Define the header value router to map the messages to the corresponding channels based on the HEADER_KEY header's value.
	 * 
	 * @return
	 */
	@Bean
	@ServiceActivator(inputChannel = "com.hr.router.channel")
	public HeaderValueRouter headerValueRouter()
	{
		final HeaderValueRouter router =  new HeaderValueRouter(HEADER_KEY);
		router.setChannelMapping("teacher", "teacher.channel");
		router.setChannelMapping("student", "student.channel");
		return router;
	}
	
	
	
}
