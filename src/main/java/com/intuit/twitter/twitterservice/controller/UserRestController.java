package com.intuit.twitter.twitterservice.controller;

import com.intuit.twitter.twitterservice.Entity.User;
import com.intuit.twitter.twitterservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ajesh on 9/17/17.
 */

@RestController
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/saveUser")
    public void saveUser(@RequestBody User user){

        userRepository.save(user);

    }



}
