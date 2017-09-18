package com.intuit.twitter.twitterservice.Entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by ajesh on 9/17/17.
 */

@Entity @Table(name = "user")
public class User {

    @Id @Column(name = "user_id", unique = true)
    private Long userId;
    private String name;
    private String email;



    private String phone;
    private String passwordHash;



    @OneToMany( fetch=FetchType.LAZY)
    @JoinTable(name="USER_FOLLOWER",
            joinColumns={@JoinColumn(name="user_id")},
            inverseJoinColumns={@JoinColumn(name="followerId")})
    @JoinColumn(name="user_id" , updatable=false, insertable = false)
    private List<User> userFollower;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL , mappedBy = "user")
    private Collection<Tweet> tweets;

    public List<User> getUserFollower() {
        return userFollower;
    }

    public void setUserFollower(List<User> userFollower) {
        this.userFollower = userFollower;
    }

    public Collection<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(Collection<Tweet> tweets) {
        this.tweets = tweets;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}

