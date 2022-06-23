package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Message> findAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public Message findMessageById(Long id) {
        return messageRepository.findByMessageId(id);
    }

    @Override
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public void deleteMessageById(Long id) {
        messageRepository.deleteMessageById(id);
    }

    @Override
    public Message updateMessageById(Message message) {
        Optional<Message> messageDb = this.messageRepository.findById(message.getId());

        if (messageDb.isPresent()) {
            Message messageUpdate = messageDb.get();
            messageUpdate.setId(message.getId());
            messageUpdate.setHeadline(message.getHeadline());
            messageUpdate.setText(message.getText());
            messageUpdate.setHyperlink(message.getHyperlink());
            messageUpdate.setAuthor(message.getAuthor());
            messageRepository.save(messageUpdate);
            return messageUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + message.getId());
        }
    }
}