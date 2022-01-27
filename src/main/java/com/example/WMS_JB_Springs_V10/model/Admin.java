package com.example.WMS_JB_Springs_V10.model;

import java.util.List;

public class Admin extends Employee {

    public Admin(String userName, String password, List<Employee> headOf) {
        super(userName, password, headOf);
    }

    public Admin(String userName, String password) {
        super(userName, password);
    }

    public void greet(){
        System.out.println("Hello, " + super.getName() + " ! \n Welcome to the Admin Panel. \n With higher authority comes higher responsibility" );
    }
}
