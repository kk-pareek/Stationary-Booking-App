package com.example.admin_service.exceptions;
public class AdminNotFoundException extends RuntimeException {

    private String message;

    public AdminNotFoundException(String message) {
        this.message=message;
    }



    @Override
    public String getMessage() {
        return message;
    }
}
