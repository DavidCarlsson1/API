package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/messages")
    List<Message> all() {

        return messageService.findAllMessages();

    }

    @PostMapping("/messages")
    Message newMessage(@RequestBody Message newMessage) {

        return messageService.saveMessage(newMessage);

    }

    @GetMapping("/messages/{id}")
    Message one(@PathVariable Long id) {

        return messageService.findMessageById(id);

    }

    @PutMapping("/messages/{id}")
    Message replaceMessage(@RequestBody Message newMessage, @PathVariable Long id) {

        return messageService.updateMessageById(newMessage);

    }

    @DeleteMapping("/messages/{id}")
    void deleteMessage(@PathVariable Long id) {
        messageService.deleteMessageById(id);
    }
}