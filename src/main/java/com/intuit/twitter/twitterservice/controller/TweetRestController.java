package com.intuit.twitter.twitterservice.controller;

import com.intuit.twitter.twitterservice.Entity.Response;
import com.intuit.twitter.twitterservice.Entity.Tweet;
import com.intuit.twitter.twitterservice.Entity.User;
import com.intuit.twitter.twitterservice.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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
    public ResponseEntity<List<Response>>  getTweetsByUser(@RequestBody User user  ,
                                                           @RequestParam(value="size", required=false, defaultValue="100") Short size,
                                                           @RequestParam(value="page", required=false, defaultValue="0")Short page
    ){
        Response response = new Response();
        Pageable pageable = new PageRequest(page, size, null);

        try {
            List<Tweet> tweets ;
            tweets = tweetRepository.findTweet(user.getUserId(), pageable);
            response.setResponse(tweets);
            response.setStatus("success");

            return new ResponseEntity(response,HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            response.setStatus("failed");
            response.setResponse(e.getMessage());
            return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
        }


    }

    //@PostMapping("/getTopTweets")
    //public ResponseEntity

}
