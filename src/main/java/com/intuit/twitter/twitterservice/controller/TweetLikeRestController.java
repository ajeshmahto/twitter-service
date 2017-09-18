package com.intuit.twitter.twitterservice.controller;

import com.intuit.twitter.twitterservice.Entity.TweetLike;
import com.intuit.twitter.twitterservice.repository.TweetLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ajesh on 9/17/17.
 */

@RestController
public class TweetLikeRestController {

    @Autowired
    private TweetLikeRepository tweetLikeRepository;
    @PostMapping("/doTweetLike")
    public void likeTweet(@RequestBody TweetLike tweetLike){

        tweetLikeRepository.save(tweetLike);

    }
}
