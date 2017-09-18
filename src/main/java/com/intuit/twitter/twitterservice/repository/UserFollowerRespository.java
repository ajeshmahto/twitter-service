package com.intuit.twitter.twitterservice.repository;

import com.intuit.twitter.twitterservice.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ajesh on 9/18/17.
 */
@Repository
public interface UserFollowerRespository extends JpaRepository<User, Long> {


}
