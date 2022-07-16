package sawant.mihir.springbootkafkademo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import sawant.mihir.springbootkafkademo.model.Product;

import java.util.logging.Logger;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = Logger.getLogger(KafkaConsumer.class.toString());

    @KafkaListener(topics = "First-Topic", groupId = "myGroup")
    public void subscribeMessage(String message){
        LOGGER.info(String.format("----------> Message %s is Consumed <----------", message));
    }
    /*
        JSON Message i.e. the Product Payload Consumer.
     */
    @KafkaListener(topics = "product-json-topic", groupId = "myGroup")
    public void subscribeJsonMessage(Message<Product> jsonMessage){
        LOGGER.info(String.format("----------> Message %s is Consumed <----------", jsonMessage.getPayload()));
    }


}
