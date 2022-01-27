package com.example.WMS_JB_Springs_V10.model;

import java.util.ArrayList;
import java.util.List;

public class Employee extends User {

    private String password;
    private List<Employee> headOf;

    //Constructor
    public Employee(String userName, String password, List<Employee> headOf) {
        super(userName);
        this.password = password;
        this.headOf = new ArrayList<Employee>();
    }

    public Employee(String userName, String password) {
        super(userName);
        this.password = password;
    }

    //GetPassword
    public String getPassword() {
        return password;
    }

    @Override
    public boolean authenticate(String password) {
        this.isAuthenticated = password.equals(this.password);
        return this.isAuthenticated();
    }

    //The order method will print the name of the item and amount ordered by the user when they place an order
    public void order(String item, int amount) {
        System.out.println("You order of the item " + item + " an amount of " + amount);
    }

    @Override
    public void greet() {
        System.out.println("Hello, " + super.getName() + " ! \n If you experience a problem with the system, \n please contact technical support.");
    }

    @Override
    public void bye(List<String> actions) {
        System.out.printf("\nThank you for your visit, %s!\n", this.name);
        listSessionActions(actions);
    }


    private void listSessionActions(List<String> actions) {
        int counter = 0;
        for (String myList : actions) {
            if (actions.size() > 0) {
                counter = counter + 1;
                System.out.println(counter + "." + myList);
            } else {
                System.out.println("In this session you have not done anything.");
            }
        }
    }
}




