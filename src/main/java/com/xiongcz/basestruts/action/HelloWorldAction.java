package com.xiongcz.basestruts.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xiongcz.basestruts.model.MessageStore;

public class HelloWorldAction extends ActionSupport {
    private MessageStore messageStore;

    public String execute() {
        messageStore = new MessageStore() ;

        return SUCCESS;
    }

    public MessageStore getMessageStore() {
        return messageStore;
    }
}
