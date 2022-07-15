# Spring Boot Kafka Demo

This is a simple demo project using the Apache-Kafka service for Messaging between two components or services,
like Producer-Consumer or Publisher-Subscriber style. So Here Producer is a service or component which produces
new data and Consumer is a component which is going to Consume the data which is published by the Producer, But
Producer does not send the data directly to the Consumer, rather it publishes the data to a Server (Message Broker)
so that when the Consumer tries to consume the data or access the data, it will only be accessed through the Broker
or an Agent which holds the data. Kafka has an entire ecosystem with many small components that make up the
**Kafka-Service**
To know more, please visit the official site: https://kafka.apache.org/
