package com.xiongcz.basestruts.model;

public class User {
    String firstName;
    String lastName;
    String email;


    public String getFirstName() {
        System.out.println("getfirstName:"+firstName);
        return firstName;
    }

    public void setFirstName(String firstName) {
        System.out.println("setfirstName:"+firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        System.out.println("getlastName:"+lastName);
        return lastName;
    }

    public void setLastName(String lastName) {
        System.out.println("setLastName:"+lastName);
        this.lastName = lastName;
    }

    public String getEmail() {
        System.out.println("getemail:"+email);
        return email;
    }

    public void setEmail(String email) {
        System.out.println("setemail:"+email);
        this.email = email;
    }
}
