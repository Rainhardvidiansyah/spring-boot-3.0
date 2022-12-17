package com.table.relationship.exception;

public class TransactionTypesUnknownException extends RuntimeException{

    static final String MESSAGE = "TRANSACTION TYPES IS UNKNOWN";

    public TransactionTypesUnknownException() {
        super(MESSAGE);
    }
}
