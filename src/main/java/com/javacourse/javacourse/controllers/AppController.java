package com.javacourse.javacourse.controllers;

import com.javacourse.javacourse.exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AppController {

    @GetMapping("/app")
    public String index() {
        int a = 100/0;
        return "ok 200";
    }

    @GetMapping("/app2")
    public String getNumberFormatException() throws NumberFormatException {
            throw new NumberFormatException("Number format exception");
//        System.out.println(value);
//        return "ok 200";
    }

    @GetMapping("/app3")
    public String getNullPointerException() throws NullPointerException {
        throw new NullPointerException("Null pointer exception");
    }

    @GetMapping("/app4")
    public String getUserNotFoundException() throws UserNotFoundException {
        throw new UserNotFoundException("No user Exception");
        /*
        In case of using Optional:
        User user = service.findById(id).orElseThrow(() -> new UserNotFoundException("No user found with id " + id));
        */
    }
}