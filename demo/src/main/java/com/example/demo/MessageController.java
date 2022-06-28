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

    @GetMapping("/messages/{id2}")
    Message one(@PathVariable Integer id2) {

        return messageService.findMessageById2(id2);

    }

    @PutMapping("/messages/{id2}")
    Message replaceMessage(@RequestBody Message newMessage, @PathVariable Integer id2) {

        return messageService.updateMessageById2(newMessage);

    }

    @DeleteMapping("/messages/{id2}")
    void deleteMessage(@PathVariable Integer id2) {
        messageService.deleteMessageById2(id2);
    }
}