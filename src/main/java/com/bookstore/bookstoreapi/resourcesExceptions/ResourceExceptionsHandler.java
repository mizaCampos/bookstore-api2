package com.bookstore.bookstoreapi.resourcesExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bookstore.bookstoreapi.exceptions.ObjectNotFoundException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletRequest;

@ControllerAdvice //todas exceptions vai vir pra ca
public class ResourceExceptionsHandler {
    
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, ServletRequest request){
        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value() ,e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}