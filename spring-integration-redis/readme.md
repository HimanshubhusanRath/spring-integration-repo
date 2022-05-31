Project Flow
-----------

Sending message to Redis:
  1. Initially, we push message to a Channel ('input.channel')
  2. From this channel, message is pushed to Redis queue ('redis-intgr-queue')

Recieving message from Redis:
  1. A consumer end point with channel ('redis.receiver.channel') is configured as the redis consumer endpoint which reads message from the above Redis queue. 
  2. So, once a message is pushed to the redis queue, the same message is read from the queue and becomes available on this channel. 
  3. Once this message is available on the channel, our application gets the message from this channel.

