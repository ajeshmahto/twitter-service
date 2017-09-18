package com.intuit.twitter.twitterservice.repository;

import com.intuit.twitter.twitterservice.Entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

/**
 * Created by ajesh on 9/17/17.
 */
public interface TweetRepository extends JpaRepository<Tweet, Long>{
    @Query(value="SELECT * FROM tweet t where t.user_id = :userId" , nativeQuery=true)
    Collection<Tweet> findTweet(@Param("userId") Long id);
}
