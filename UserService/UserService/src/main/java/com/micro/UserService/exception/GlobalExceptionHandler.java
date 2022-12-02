package com.micro.UserService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APiResponce> handlerResourenotFound(ResourceNotFoundException re){
        APiResponce responce = APiResponce.builder().message(re.getMessage()).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<APiResponce>(responce,HttpStatus.NOT_FOUND);
    }
}
