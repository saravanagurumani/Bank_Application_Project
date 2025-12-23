package com.example.BankApplication.registration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handlingRuntime(RuntimeException runtime)
    {
        return  new ResponseEntity<>(runtime.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity<Map<String, String>> handleException(MethodArgumentNotValidException e)
    {
        Map<String, String> map = new HashMap<>();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();

        for(FieldError error : fieldErrors)
        {
            map.put(error.getField(), error.getDefaultMessage());
        }

        return new ResponseEntity<>(map, HttpStatus.NOT_ACCEPTABLE);
    }

}
