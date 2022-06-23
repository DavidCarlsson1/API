package com.example.demo;

import java.util.List;

public interface MessageService {

    List<Message> findAllMessages();

    Message findMessageById(Long id);

    Message saveMessage(Message message);

    void deleteMessageById(Long id);

    Message updateMessageById(Message message);

}