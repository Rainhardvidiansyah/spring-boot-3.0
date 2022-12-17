package com.table.relationship.exception;

public class UserNotFoundException extends RuntimeException{

    static final String Message = "USER NOT FOUND";

    public UserNotFoundException() {
        super(Message);
    }
}
