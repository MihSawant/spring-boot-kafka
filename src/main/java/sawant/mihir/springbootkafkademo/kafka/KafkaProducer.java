package sawant.mihir.springbootkafkademo.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class KafkaProducer {
    private static final Logger LOGGER = Logger.getLogger(KafkaProducer.class.toString());
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishSomething(String message){
        kafkaTemplate.send("First-Topic", message);
        LOGGER.info(String.format("Message %s Sent", message));
    }
}
