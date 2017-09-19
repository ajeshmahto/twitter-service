package com.intuit.twitter.twitterservice.repository;

import com.intuit.twitter.twitterservice.Entity.Tweet;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by ajesh on 9/17/17.
 */
public interface TweetRepository extends JpaRepository<Tweet, Long>{
    @Query(value="SELECT t FROM Tweet t where t.user.userId IN  (SELECT uf.userId FROM  User u JOIN u.userFollowing uf where u.userId = :userId ) OR t.user.userId = :userId ") //
    List<Tweet> findTweet(@Param("userId") Long id  , Pageable pageRequest);


}




// @Query(value="SELECT * FROM tweet t where t.user_id in (SELECT  f.follower_id from user_follower f where f.user_id = :userId ) or t.user_id = :userId " , nativeQuery=true) //