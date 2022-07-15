package sawant.mihir.springbootkafkademo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic myFirstTopic(){
        TopicBuilder topic = TopicBuilder.name("First-Topic");
        return topic.build();
    }
}
