package org.malex.producer.controller;

import org.malex.producer.dto.Job;
import org.malex.producer.publisher.JsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class JsonMessageController {

    private JsonProducer jsonProducer;

    public JsonMessageController(JsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Job job) {
        jsonProducer.sendJsonMessage(job);
        return ResponseEntity.ok("Json message sent to MRabbitMQ...");
    }
}
