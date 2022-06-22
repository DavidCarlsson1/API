package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MessageController {

    private final MessageRepository repository;

    MessageController(MessageRepository repository) {

        this.repository = repository;

    }

    @GetMapping("/messages")
    List<Message> all() {

        return repository.findAll();

    }

    @PostMapping("/messages")
    Message newMessage(@RequestBody Message newMessage) {

        return repository.save(newMessage);

    }

    @GetMapping("/messages/{id}")
    Message one(@PathVariable Long id) {

        return repository.findById(id)
            .orElseThrow(() -> new MessageNotFoundException(id));

    }

    @PutMapping("/messages/{id}")
    Message replaceMessage(@RequestBody Message newMessage, @PathVariable Long id) {

        return repository.findById(id)
            .map(message -> {
                message.setHeadline(newMessage.getHeadline());
                message.setText(newMessage.getText());
                message.setHyperlink(newMessage.getHyperlink());
                message.setAuthor(newMessage.getAuthor());
                return repository.save(message);
            })
            .orElseGet(() -> {
                newMessage.setId(id);
                return repository.save(newMessage);
            });
    }

    @DeleteMapping("/messages/{id}")
    void deleteMessage(@PathVariable Long id) {
        repository.deleteById(id);
    }
}