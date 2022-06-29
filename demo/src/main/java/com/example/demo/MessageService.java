package com.example.demo;

import java.util.List;

public interface MessageService {

    List<Message> findAllMessages();

    Message saveMessage(Message message);

    Message findMessageById2(Integer id);

    void deleteMessageById2(Integer id);

    Message updateMessageById2(Message message);

}