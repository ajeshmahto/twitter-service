package com.intuit.twitter.twitterservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ajesh on 9/17/17.
 */
@RestController
public class WelcomeController {

    @GetMapping("/")
    public String home(){
        return "Welcome to twitter service";
    }
}
