package com.example.JPAEXAMINATION1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class MyExecptionHandler {


    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleInvalidArguments(MethodArgumentNotValidException exceptions) {
        Map<String, String> errorlist = new HashMap<>();

        exceptions.getBindingResult()
                .getFieldErrors()
                .forEach(e -> errorlist.put(e.getField(), e.getDefaultMessage()));

        return errorlist;
    }

}
