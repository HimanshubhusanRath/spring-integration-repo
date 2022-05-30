package com.hr.springintegration.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.json.JsonToObjectTransformer;
import org.springframework.integration.json.ObjectToJsonTransformer;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
import org.springframework.integration.transformer.HeaderEnricher;
import org.springframework.integration.transformer.support.HeaderValueMessageProcessor;
import org.springframework.integration.transformer.support.StaticHeaderValueMessageProcessor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hr.springintegration.dto.User;

@Configuration
@EnableIntegration
public class MessagingWithTransformerConfig {

	@Bean
	@Transformer(inputChannel = "com.hr.before.header.enrich.channel", outputChannel = "com.hr.input.channel")
	public HeaderEnricher headerEnricher()
	{
		final Map<String, HeaderValueMessageProcessor<String>> headers = new HashMap<>();
		headers.put("header-1", new StaticHeaderValueMessageProcessor<String>("Test Header - 1"));
		headers.put("header-2", new StaticHeaderValueMessageProcessor<String>("Test Header - 2"));
		return new HeaderEnricher(headers);
	}
	
	@Bean
	@Transformer(inputChannel = "com.hr.input.channel", outputChannel = "com.hr.objecttojson.channel")
	public ObjectToJsonTransformer objectToJsonTransformer()
	{
		return new ObjectToJsonTransformer(getMapper());
	}
	
	@Bean
	@Transformer(inputChannel = "com.hr.jsontoobject.channel", outputChannel = "com.hr.output.channel")
	public JsonToObjectTransformer jsonToObjectTransformer()
	{
		return new JsonToObjectTransformer(User.class);
	}
	
	@Bean
	public Jackson2JsonObjectMapper getMapper() {
		return new Jackson2JsonObjectMapper(new ObjectMapper());
	}
	
	
}
