package com.teamhub.admincomejen.entities;

public class EnterpriseResponse {
    private String message;
    private Object object;

    public EnterpriseResponse() {
    }

    public EnterpriseResponse(String message, Object object) {
        this.message = message;
        this.object = object;
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
