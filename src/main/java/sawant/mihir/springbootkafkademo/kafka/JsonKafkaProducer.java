package sawant.mihir.springbootkafkademo.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import sawant.mihir.springbootkafkademo.model.Product;

import java.util.logging.Logger;

@Service
public class JsonKafkaProducer {
    private static final Logger LOGGER = Logger.getLogger(JsonKafkaProducer.class.toString());

    private final KafkaTemplate<String, Product> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, Product> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishJsonMessage(Product product){
        Message<Product> productMessage = MessageBuilder.withPayload(product)
                .setHeader(KafkaHeaders.TOPIC, "myGroup")
                .build();

        kafkaTemplate.send(productMessage);
        LOGGER.info(String.format("Published %s data", product));
    }
}
