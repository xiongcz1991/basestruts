package com.xiongcz.basestruts.action;

import com.opensymphony.xwork2.ActionSupport;
import com.xiongcz.basestruts.model.User;


public class RegisterAction extends ActionSupport {
    //private User user = new User();
    private User user ;
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public void validate() {
        if(user.getFirstName().length()==0){
            addFieldError("user.firstName","姓氏不能为空！");
        }
        if(user.getLastName().length()==0){
            addFieldError("user.lastName","名字不能为空！");
        }

    }
}
