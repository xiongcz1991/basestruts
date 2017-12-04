package com.xiongcz.basestruts.model;

public class MessageStore {
    String message;

    public MessageStore() {
        this.message = "hello world";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
