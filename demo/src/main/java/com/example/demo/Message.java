package com.example.demo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Message {
    
    private @Id @GeneratedValue Long id;
    private String headline;
    private String text;
    private String hyperlink;
    private String author;

    Message() {}

    Message(String headline, String text, String hyperlink, String author) {

        this.headline = headline;
        this.text = text;
        this.hyperlink = hyperlink;
        this.author = author;
    }

    public Long getId() {
        return this.id;
    }

    public String getHeadline() {
        return this.headline;
    }

    public String getText() {
        return this.text;
    }

    public String getHyperlink() {
        return this.hyperlink;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setHyperlink(String hyperlink) {
        this.hyperlink = hyperlink;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
        return true;
        if (!(o instanceof Message))
        return false;
        Message message = (Message) o;
        return Objects.equals(this.id, message.id) && Objects.equals(this.headline, message.headline)
            && Objects.equals(this.text, message.text) && Objects.equals(this.hyperlink, message.hyperlink) 
            && Objects.equals(this.author, message.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.headline, this.text, this.hyperlink, this.author);
    }

    @Override
    public String toString() {
        return "Message{" + "id=" + this.id + ", headline='" + this.headline + '\'' + ", text='" 
        + this.text + '\'' + ", hyperlink='" + this.hyperlink + '\'' + ", author='" + this.author + '}';
    }
}