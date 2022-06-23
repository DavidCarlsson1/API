package com.example.demo;

class MessageNotFoundException extends RuntimeException {

    MessageNotFoundException(Integer id) {
        super("Could not find message " + id);
    }
}