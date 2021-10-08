package com.academy.devDojo.SpringBoot.handler;

import com.academy.devDojo.SpringBoot.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> badRequestException(BadRequestException bre){
    return new ResponseEntity<BadRequestExceptionDetails>(BadRequestExceptionDetails
            .builder()
            .title("Bad Request, please check the documentation")
            .details(bre.getMessage())
            .status(HttpStatus.BAD_REQUEST.value())
            .developerMessage(bre.getClass().getName()).build(), HttpStatus.BAD_REQUEST);
    }

}
