package com.intuit.twitter.twitterservice.Entity;

import javax.persistence.*;
import java.util.*;

/**
 * Created by ajesh on 9/17/17.
 */
@Entity @Table(name = "tweet")
public class Tweet {
    @Id
    @GeneratedValue
    @Column(name = "tweet_Id", unique = true)
    private long tweetId;
    private String tweetContent;
    private Date createdDate;
    private long noOfLikes;


    @ManyToOne(optional=false, fetch = FetchType.LAZY) @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tweet")
    private Set<TweetLike> tweetLikes = new HashSet<>();

    public long getTweetId() {
        return tweetId;
    }

    public void setTweetId(long tweetId) {
        this.tweetId = tweetId;
    }

    public String getTweetContent() {
        return tweetContent;
    }

    public void setTweetContent(String tweetContent) {
        this.tweetContent = tweetContent;
    }
    @Temporal(TemporalType.DATE)
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public long getNoOfLikes() {
        return noOfLikes;
    }

    public void setNoOfLikes(long noOfLikes) {
        this.noOfLikes = noOfLikes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Set<TweetLike> getTweetLikes() {
        return tweetLikes;
    }

    public void setTweetLikes(Set<TweetLike> tweetLikes) {
        this.tweetLikes = tweetLikes;
    }
}