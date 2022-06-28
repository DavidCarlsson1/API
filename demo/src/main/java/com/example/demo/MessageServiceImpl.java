package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Message> findAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public Message findMessageById2(Integer id) {
        return messageRepository.findById2(id);
    }

    @Override
    public Message saveMessage(Message message) {
        System.out.println("1");
        Message messageDb = this.messageRepository.findFirstByOrderById2Desc();
        System.out.println("2");
        if ((messageDb != null) && (messageDb.getId2() != null)) {
            message.setId2(messageDb.getId2() + 1);
            System.out.println("3");
        } else {
            message.setId2(1);
            System.out.println("4");
        }

        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime myDateObj = LocalDateTime.now();
        String formattedDate = myDateObj.format(myFormatObj);
        message.setPublishingDate(formattedDate);

        return messageRepository.save(message);
    }

    @Override
    public void deleteMessageById2(Integer id) {
        messageRepository.deleteMessageById2(id);
    }

    @Override
    public Message updateMessageById2(Message message) {
        Message messageUpdate = this.messageRepository.findById2(message.getId2());

        if (messageUpdate != null) {
            messageUpdate.setId(message.getId());
            messageUpdate.setId2(message.getId2());
            messageUpdate.setHeadline(message.getHeadline());
            messageUpdate.setText(message.getText());
            messageUpdate.setHyperlink(message.getHyperlink());
            messageUpdate.setAuthor(message.getAuthor());
            messageUpdate.setStartDate(message.getStartDate());
            messageUpdate.setEndDate(message.getEndDate());
            messageUpdate.setPublishingDate(message.getPublishingDate());
            messageRepository.save(messageUpdate);
            return messageUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + message.getId2());
        }
    }
}