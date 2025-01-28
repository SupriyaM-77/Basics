package com.example.SpringData.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Handler {
    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<Object>handleNotFoundException
            (NotFoundException notFoundException){
        Exception exception=new Exception
                (notFoundException.getMessage(),
                        notFoundException.getCause(),
                        HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(exception,HttpStatus.NOT_FOUND);
    }


}
