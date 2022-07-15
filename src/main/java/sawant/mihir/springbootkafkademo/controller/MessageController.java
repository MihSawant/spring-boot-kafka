package sawant.mihir.springbootkafkademo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sawant.mihir.springbootkafkademo.kafka.KafkaProducer;

@RestController
public record MessageController(KafkaProducer kafkaProducer) {

    public MessageController(KafkaProducer kafkaProducer){
        this.kafkaProducer = kafkaProducer;
    }


    // http://localhost:8080/kafka-api/publish/sample-message
    @PostMapping("/kafka-api/publish/{message}")
    public ResponseEntity<String> messagePublish(@PathVariable String message){
        var responseMessage = "Published Message: "+message;
        kafkaProducer.publishSomething(message);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(responseMessage);
    }

}
