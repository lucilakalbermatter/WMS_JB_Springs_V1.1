package com.example.WMS_JB_Springs_V10.model;

import java.util.List;

public abstract class User {

    protected String name = "Anonymous";
    protected boolean isAuthenticated = false;

    //Constructor
    public User(String userName) {
        this.name = userName;
    }

    public String getName() {
        return this.name;
    }

    public abstract boolean authenticate(String username);

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    //The isNamed method will return true if the name passed to the method equals the this.name property.
    public boolean isNamed(String name) {
        if (name.equals(this.name)) {
            return true;
        } else {
            return false;
        }
    }

    public abstract void greet();

    public abstract void bye(List<String> actions);

    @Override
    public String toString() {
        return getName();
    }

}


