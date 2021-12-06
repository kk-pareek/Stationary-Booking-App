package com.example.admin_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdminExceptionController {
    @ExceptionHandler
    public ResponseEntity<String> adminNotFoundHandler(AdminNotFoundException adminNotFoundException){
        return new ResponseEntity<>(adminNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }


}
