package com.intuit.twitter.twitterservice.Entity;

import javax.persistence.*;

/**
 * Created by ajesh on 9/17/17.
 */

@Entity @Table(name = "tweet_likes")
public class TweetLike {
    @Id
    @GeneratedValue
    private long likeId;

    @OneToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tweet_Id")
    private Tweet tweet;

    public long getLikeId() {
        return likeId;
    }

    public void setLikeId(long likeId) {
        this.likeId = likeId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }
}
