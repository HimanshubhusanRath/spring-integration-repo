Below Router types are described in the project
------------
1. Payload Type Router:
   - The router is configured on the type of payload in the message.
   - Different output/target channels can be configured for different payload types.
3. Header Value Router:
   - The router is configured on a particular header parameter's value.
   - Different output/target channels can be configured for different values of this parameter.
5. Recipient List Router:
   - The router is configured with a list of recipient channels (target/output channels)
   - So, the message is passed to all these channels at the same time.


**Note: Router is defined using @ServiceActivator annotation.**


Filters
---------
- Filters are defined by using @Filter
- These can be used to either allow the messages to go further in the flow or drop messages based on certain conditions. 
- The condition checking can be done on the headers as well as the payload data.
