package sawant.mihir.springbootkafkademo.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = Logger.getLogger(KafkaConsumer.class.toString());

    @KafkaListener(topics = "First-Topic", groupId = "myGroup")
    public void subscribeMessage(String message){
        LOGGER.info(String.format("----------> Message %s is Consumed <----------", message));
    }


}
