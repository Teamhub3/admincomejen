package com.teamhub.admincomejen.services;

public class EnterpriseNotFoundException extends RuntimeException {
    public EnterpriseNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}

