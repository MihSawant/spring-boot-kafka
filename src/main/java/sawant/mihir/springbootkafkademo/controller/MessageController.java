package sawant.mihir.springbootkafkademo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sawant.mihir.springbootkafkademo.kafka.JsonKafkaProducer;
import sawant.mihir.springbootkafkademo.kafka.KafkaProducer;
import sawant.mihir.springbootkafkademo.model.Product;

@RestController
public record MessageController(KafkaProducer kafkaProducer, JsonKafkaProducer jsonKafkaProducer) {



    // http://localhost:8080/kafka-api/publish/sample-message
    @PostMapping("/kafka-api/publish/{message}")
    public ResponseEntity<String> messagePublish(@PathVariable String message){
        var responseMessage = "Published Message: "+message;
        kafkaProducer.publishSomething(message);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(responseMessage);
    }

    // http://localhost:8080/kafka-api/publish/json/Product
    @PostMapping("/kafka-api/publish/json")
    public ResponseEntity<Product> jsonMessagePublish(@RequestBody Product product){
     jsonKafkaProducer.publishJsonMessage(product);
     return ResponseEntity.status(HttpStatus.ACCEPTED)
             .body(product);
    }

}
