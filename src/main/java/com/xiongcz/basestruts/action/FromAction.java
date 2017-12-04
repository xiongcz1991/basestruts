package com.xiongcz.basestruts.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xiongcz.basestruts.model.MessageStore;

public class FromAction extends ActionSupport {
    MessageStore messageStore;
    String username;
    @Override
    public String execute() throws Exception {
        messageStore = new MessageStore();
        if ("joker".equals(username)){
            messageStore.setMessage(messageStore.getMessage()+" "+username);
        }

        return SUCCESS;
    }

    public MessageStore getMessageStore() {
        return messageStore;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
