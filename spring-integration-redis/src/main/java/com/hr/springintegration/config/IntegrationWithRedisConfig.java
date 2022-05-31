package com.hr.springintegration.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.redis.inbound.RedisQueueMessageDrivenEndpoint;

@Configuration
@EnableIntegration
public class IntegrationWithRedisConfig {
	
	@Value("${redis.queue.name}")
	private String redisQueueName;
	
	@Value("${redis.channel.name}")
	private String redisChannelName;

	@Bean
	JedisConnectionFactory jedisConnectionFactory()
	{
		return new JedisConnectionFactory();
	}
	
	/**
	 * Endpoint responsible for consuming messages from the given redis queue in the given channel
	 * 
	 * @return
	 */
	@Bean
	public RedisQueueMessageDrivenEndpoint redisConsumerEndpoint()
	{
		final RedisQueueMessageDrivenEndpoint endpoint = new RedisQueueMessageDrivenEndpoint(redisQueueName, jedisConnectionFactory());
		endpoint.setOutputChannelName(redisChannelName);
		return endpoint;
	}
	
	
}
