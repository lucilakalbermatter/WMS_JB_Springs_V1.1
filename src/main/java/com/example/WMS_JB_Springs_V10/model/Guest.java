package com.example.WMS_JB_Springs_V10.model;

import java.util.List;

public class Guest extends User{

    public Guest(String userName) {
        super(userName);
    }

    @Override
    public boolean authenticate(String password) {
        return false;
    }

    @Override
    public void greet() {
        System.out.printf("Hello, %s%n " +
                "Welcome to our Warehouse Database.%n " +
                "If you don't find what you are looking for,%n " +
                "please ask one of our staff members to assist you.%n", getName());
    }

    @Override
    public void bye(List<String> actions) {
        System.out.println("Thank you for your visit " + getName());
    }


}
