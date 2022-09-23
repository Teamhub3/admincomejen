package com.teamhub.admincomejen.entities;

public class TransactionResponse {
    private String message;
    private Object object;

    public TransactionResponse(String message, Object object) {
        this.message = message;
        this.object = object;
    }

    public TransactionResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
