# Spring Boot Kafka Demo

This is a simple demo project using the Apache-Kafka service for Messaging between two components or services,
like Producer-Consumer or Publisher-Subscriber style. So Here Producer is a service or component which produces
new data and Consumer is a component which is going to Consume the data which is published by the Producer, But
Producer does not send the data directly to the Consumer, rather it publishes the data to a Server (Message Broker)
so that when the Consumer tries to consume the data or access the data, it will only be accessed through the Broker
or an Agent which holds the data. Kafka has an entire ecosystem with many small components that make up the
**Kafka-Service**
To know more, please visit the official site: https://kafka.apache.org/

Before we start working with the project, we will have to configure the Producer and Consumer, and 
we could easily do it by specifying certain properties in the application.properties file
like the Producer and Consumer _groupId_ _servers_, _key and value serializers and deserializers_.
Here Spring Boot makes our life easy so instead of implementing all the config code ourselves, the Framework
does all the work for us.

Next we are going to create a **_Topic_** using the TopicBuilder class, provide a name and add mark it as a Bean.

We First create a Producer in order to publish some message, **KafkaTemplate** can be used to publish the message
and it has _send()_ method which takes two args: topicName and the message to publish. This is a very nice utility
that we can use which spring-boot provides and it is auto-configured by spring and so we can directly inject it.