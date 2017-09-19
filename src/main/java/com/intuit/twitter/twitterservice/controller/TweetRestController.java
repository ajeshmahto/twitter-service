package com.intuit.twitter.twitterservice.controller;

import com.intuit.twitter.twitterservice.Entity.Tweet;
import com.intuit.twitter.twitterservice.Entity.User;
import com.intuit.twitter.twitterservice.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by ajesh on 9/17/17.
 */

@RestController
public class TweetRestController {

    @Autowired
    private TweetRepository tweetRepository;


    @PostMapping("/createTweet")
    public void saveTweet(@RequestBody Tweet tweet){

        tweetRepository.save(tweet);
    }



    @PostMapping("/getTweetsByUser")
    public ResponseEntity<Collection<Tweet>>  getTweetsByUser(@RequestBody User user){
        Collection<Tweet> tweets ;
        tweets = tweetRepository.findTweet(user.getUserId());

        return new ResponseEntity<>(tweets,HttpStatus.ACCEPTED);

    }

    //@PostMapping("/getTopTweets")
    //public ResponseEntity

}
