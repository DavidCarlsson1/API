package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;


interface MessageRepository extends MongoRepository<Message, String> {

    Message findByMessageId(long id);

    Message deleteMessageById(long id);
    
}