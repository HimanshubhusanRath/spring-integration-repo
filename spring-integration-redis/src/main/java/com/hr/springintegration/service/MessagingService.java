package com.hr.springintegration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.redis.outbound.RedisQueueOutboundChannelAdapter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

@Service
public class MessagingService {

	@Value("${redis.queue.name}")
	private String redisQueueName;
	
	@Autowired
	private JedisConnectionFactory jedisConnectionFactory;
	
	/**
	 * Sends message to Redis queue
	 * 
	 * @param message
	 * @throws MessagingException
	 */
	@ServiceActivator(inputChannel = "input.channel")
	public void serveMessage(final Message<String> message) throws MessagingException
	{
		System.out.println("Sending message to Redis queue..");
		final RedisQueueOutboundChannelAdapter redisAdapter = new RedisQueueOutboundChannelAdapter(redisQueueName, jedisConnectionFactory);
		redisAdapter.setSerializer(new JdkSerializationRedisSerializer());
		redisAdapter.handleMessage(message);
	}
	
	/**
	 * Receives message from Redis queue
	 * 
	 * @param message
	 */
	@ServiceActivator(inputChannel = "redis.receiver.channel")
	public void readMessage(final Message<?> message)
	{
		System.out.println("Message from Redis queue >>> "+message.getPayload());
	}
}
